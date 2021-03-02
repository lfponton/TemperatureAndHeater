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

  @Override public void addTemperature(String id, double temperature)
  {
    Temperature t = new Temperature(id, temperature);
    Temperature old = getLastInsertedTemperature(null);
    this.temperatureList.addTemperature(t);
    support.firePropertyChange("TemperatureChange", old, t);
  }

  @Override public Temperature getLastInsertedTemperature(String id)
  {
    return temperatureList.getLastTemperature(id);
  }

  @Override public void addListener(PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(listener);
  }
}
