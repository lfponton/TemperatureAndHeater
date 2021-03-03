package mediator;

import model.Temperature;
import model.TemperatureList;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class TemperatureModelManager implements TemperatureModel
{
  private TemperatureList temperatureList;
  private PropertyChangeSupport support;

  public TemperatureModelManager() {
    temperatureList = new TemperatureList();
    support = new PropertyChangeSupport(this);
  }

  @Override public void addTemperature(String id, double indoorTemperature)
  {
    Temperature t = new Temperature(id, indoorTemperature);
    Temperature old = getLastInsertedIndoorTemperature(null);
    this.temperatureList.addIndoorTemperature(t);

    support.firePropertyChange("IndoorTemperatureChange", old, t);

  }

  @Override public void addOutdoorTemperature(double outdoorTemperature)
  {
    Temperature t = new Temperature("t0", outdoorTemperature);
    this.temperatureList.addOutdoorTemperature(t);
    support.firePropertyChange("OutdoorTemperatureChange", null, t);
  }

  @Override public Temperature getLastInsertedIndoorTemperature(String id)
  {
    return temperatureList.getLastIndoorTemperature(id);
  }

  @Override public Temperature getLatInsertedOutdoorTemperature()
  {
    return temperatureList.getLatOutdoorTemperature();
  }

  @Override public void addListener(PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(listener);
  }
}
