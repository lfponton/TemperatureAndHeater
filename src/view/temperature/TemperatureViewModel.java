package view.temperature;

import javafx.application.Platform;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import mediator.TemperatureModel;
import model.Temperature;

import java.beans.PropertyChangeEvent;

public class TemperatureViewModel
{
  private StringProperty temperature1, temperature2, outdoorTemperature;
  private TemperatureModel temperatureModel;

  public TemperatureViewModel(TemperatureModel temperatureModel) {
    this.temperatureModel = temperatureModel;
    this.temperature1 = new SimpleStringProperty();
    this.temperature2 = new SimpleStringProperty();
    this.outdoorTemperature = new SimpleStringProperty();
    this.temperatureModel.addListener(this::updateTemperature);
  }

  private void updateTemperature(PropertyChangeEvent evt)
  {
    Platform.runLater(() -> {
      if (evt.getPropertyName().equals("IndoorTemperatureChange"))
      {
        Temperature newIndoorTemperature = (Temperature) evt.getNewValue();
        if (newIndoorTemperature.getId().equals("t1"))
        {
          temperature1.setValue(newIndoorTemperature.toString());
        }
        else
        {
          temperature2.setValue(newIndoorTemperature.toString());
        }
      }
      if (evt.getPropertyName().equals("OutdoorTemperatureChange"))
      {
        outdoorTemperature.setValue(((Temperature) evt.getNewValue()).toString());
      }
    });
  }

  public StringProperty getTemperature1() {
    return temperature1;
  }
  public StringProperty getTemperature2() {
    return temperature2;
  }
  public StringProperty getOutdoorTemperature() { return  outdoorTemperature; }

}
