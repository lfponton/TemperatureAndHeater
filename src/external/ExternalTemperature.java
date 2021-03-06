package external;

import mediator.temperature.TemperatureModel;

public class ExternalTemperature implements Runnable
{
  private double externalTemperature;
  private TemperatureModel temperatureModel;

  public ExternalTemperature(double t, TemperatureModel model) {
    externalTemperature = t;
    temperatureModel = model;
  }

  /**
   * Calculating the external temperature.
   * Values are only valid if the temperature is being measured
   * approximately every 10th second.
   *
   * @param t0  the last measured external temperature
   * @param min a lower limit (may temporally be deceeded)
   * @param max an upper limit (may temporally be exceeded)
   * @return an updated external temperature
   */
  public double externalTemperature(double t0, double min, double max)
  {
    double left = t0 - min;
    double right = max - t0;
    int sign = Math.random() * (left + right) > left ? 1 : -1;
    t0 += sign * Math.random();
    return t0;
  }

  public double getExternalTemperature()
  {
    return externalTemperature;
  }

  @Override public void run()
  {
    while (true)
    {
      externalTemperature = externalTemperature(externalTemperature, -20, 20);
      System.out.println("Outdoor Temperature: " + externalTemperature);
      temperatureModel.addOutdoorTemperature(externalTemperature);

      try
      {
        Thread.sleep(10000);
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
  }
}
