package model;

import java.util.ArrayList;
import java.util.List;

public class TemperatureList
{
  private List<Temperature> indoorTemperatureList;
  private List<Temperature> outdoorTemperatureList;

  public TemperatureList() {
    this.indoorTemperatureList = new ArrayList<>();
    this.outdoorTemperatureList = new ArrayList<>();
  }

  public void addIndoorTemperature(Temperature temperature) {
    indoorTemperatureList.add(temperature);
  }

  public void addOutdoorTemperature(Temperature temperature) {
    outdoorTemperatureList.add(temperature);
  }

  public Temperature getLastIndoorTemperature(String id) {
    if (indoorTemperatureList.size() < 1) {
      return null;
    }
    if (id == null) {
      return indoorTemperatureList.get(indoorTemperatureList.size() - 1);
    }
    for (int i = indoorTemperatureList.size() - 1; i >= 0; i--) {
      if (id.equals(indoorTemperatureList.get(i).getId())) {
        return indoorTemperatureList.get(i);
      }
    }
    return null;
  }

  public Temperature getLatOutdoorTemperature() {
    if (outdoorTemperatureList.size() < 1) {
      return null;
    }
    else {
      return outdoorTemperatureList.get(outdoorTemperatureList.size() - 1);
    }
  }
}
