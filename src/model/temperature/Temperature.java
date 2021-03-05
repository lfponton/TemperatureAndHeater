package model.temperature;

public class Temperature
{
  private String id;
  private double temperature;;
  private DateTime timestamp;

  public Temperature(String id, double temperature) {
    this.id = id;
    this.temperature = temperature;
    timestamp = new DateTime();
  }

  public String getId()
  {
    return id;
  }

  public double getTemperature()
  {
    return temperature;
  }

  public String getTimestamp()
  {
    return timestamp.getTimestamp();
  }

  public String toString() {
    return String.format("Temperature %s: %.1f", id, temperature);
  }
}
