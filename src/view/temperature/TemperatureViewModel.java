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
  private StringProperty temperature1, temperature2;
  private TemperatureModel temperatureModel;

  public TemperatureViewModel(TemperatureModel temperatureModel) {
    this.temperatureModel = temperatureModel;
    this.temperature1 = new SimpleStringProperty();
    this.temperature2 = new SimpleStringProperty();
    this.temperatureModel.addListener(this::updateTemperature);
  }

  private void updateTemperature(PropertyChangeEvent evt)
  {
    Platform.runLater(() -> {
      Temperature newTemperature = (Temperature) evt.getNewValue();
      if (newTemperature.getId().equals("t1"))
      {
        temperature1.setValue(newTemperature.toString());
      }
      else {
        temperature2.setValue(newTemperature.toString());
      }
    });
  }

  public StringProperty getTemperature1() {
    return temperature1;
  }
  public StringProperty getTemperature2() {
    return temperature2;
  }

}
