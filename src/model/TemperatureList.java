package model;

import java.util.ArrayList;
import java.util.List;

public class TemperatureList
{
  private List<Temperature> temperatureList;

  public TemperatureList() {
    this.temperatureList = new ArrayList<>();
  }

  public void addTemperature (Temperature temperature) {
    temperatureList.add(temperature);
  }

  public Temperature getLastTemperature(String id) {
    if (temperatureList.size() < 1) {
      return null;
    }
    if (id == null) {
      return temperatureList.get(temperatureList.size() - 1);
    }
    for (int i = temperatureList.size() - 1; i >= 0; i--) {
      if (id.equals(temperatureList.get(i).getId())) {
        return temperatureList.get(i);
      }
    }
    return null;
  }
}
