package view.temperature;

import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import mediator.temperature.TemperatureModel;
import model.temperature.Temperature;

import java.beans.PropertyChangeEvent;

public class TemperatureViewModel
{
  private StringProperty temperature1, temperature2, outdoorTemperature, warning1, warning2;
  private TemperatureModel temperatureModel;

  public TemperatureViewModel(TemperatureModel temperatureModel)
  {
    this.temperatureModel = temperatureModel;
    temperature1 = new SimpleStringProperty();
    temperature2 = new SimpleStringProperty();
    outdoorTemperature = new SimpleStringProperty();
    warning1 = new SimpleStringProperty();
    warning2 = new SimpleStringProperty();
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
          temperature1.setValue("Indoor " + newIndoorTemperature.toString());
        }
        else
        {
          temperature2.setValue("Indoor " + newIndoorTemperature.toString());
        }
      }
      if (evt.getPropertyName().equals("OutdoorTemperatureChange"))
      {
        outdoorTemperature.setValue(
            "Outdoor " + ((Temperature) evt.getNewValue()).toString());
      }
      if (evt.getPropertyName().equals("tooHigh"))
      {
        String id = ((Temperature) evt.getNewValue()).getId();
        if (id.equals("t1"))
        {
          warning1.setValue("WARNING: The temperature " + id + " is too high.");
        }
        else
        {
          warning2.setValue("WARNING: The temperature " + id + " is too high.");
        }
      }
      if (evt.getPropertyName().equals("tooLow"))
      {
        String id = ((Temperature) evt.getNewValue()).getId();
        if (id.equals("t1"))
        {
          warning1.setValue("WARNING: The temperature " + id + " is too low.");
        }
        else
        {
          warning2.setValue("WARNING: The temperature " + id + " is too low.");
        }
      }
      if (evt.getPropertyName().equals("normal"))
      {
        String id = ((Temperature) evt.getNewValue()).getId();
        if (id.equals("t1"))
        {
          warning1.setValue("");
        }
        else
        {
          warning2.setValue("");
        }
      }
    });
  }

  public StringProperty getTemperature1()
  {
    return temperature1;
  }

  public StringProperty getTemperature2()
  {
    return temperature2;
  }

  public StringProperty getOutdoorTemperature()
  {
    return outdoorTemperature;
  }

  public StringProperty getWarning1()
  {
    return warning1;
  }

  public StringProperty getWarning2()
  {
    return warning2;
  }
}
