package view.chart;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ObservableValue;
import mediator.TemperatureModel;
import model.Temperature;

import java.beans.PropertyChangeEvent;

public class TemperatureChartViewModel
{
  private DoubleProperty t1, t2;
  private TemperatureModel temperatureModel;

  public TemperatureChartViewModel(TemperatureModel temperatureModel)
  {
    this.temperatureModel = temperatureModel;
    t1 = new SimpleDoubleProperty();
    t2 = new SimpleDoubleProperty();
    this.temperatureModel.addListener(this::updateTemperatureChart);
  }

  public void updateTemperatureChart(PropertyChangeEvent evt)
  {
    if (evt.getPropertyName().equals("IndoorTemperatureChange"))
    {
      Temperature newIndoorTemperature = (Temperature) evt.getNewValue();
      if (newIndoorTemperature.getId().equals("t1"))
      {
        t1.setValue(newIndoorTemperature.getTemperature());
      }
      else
      {
        t2.setValue(newIndoorTemperature.getTemperature());
      }
    }
  }

  public ObservableValue getT1Property()
  {
    return t1;
  }

  public ObservableValue getT2Property()
  {
    return t2;
  }
}
