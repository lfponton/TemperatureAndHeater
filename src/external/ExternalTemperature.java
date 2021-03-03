package external;

public class ExternalTemperature
{
  private double externalTemperature;

  public ExternalTemperature(double t) {
    externalTemperature = t;
  }

  public double getExternalTemperature()
  {
    return externalTemperature;
  }

  public void setExternalTemperature(double externalTemperature)
  {
    this.externalTemperature = externalTemperature;
  }
}
