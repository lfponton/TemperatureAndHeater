package model;

public class Temperature
{
  private String id;
  private double temperature;

  public Temperature(String id, double temperature) {
    this.id = id;
    this.temperature = temperature;
  }

  public String getId()
  {
    return id;
  }

  public double getTemperature()
  {
    return temperature;
  }

  public String toString() {
    return String.format("Temperature %s: %.1f", id, temperature);
  }
}
