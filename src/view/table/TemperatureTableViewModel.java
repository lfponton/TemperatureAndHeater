package view.table;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import mediator.temperature.TemperatureModel;
import model.temperature.Temperature;

import java.beans.PropertyChangeEvent;

public class TemperatureTableViewModel
{
  private TemperatureModel temperatureModel;
  private ObservableList<Temperature> temperatures;

  public TemperatureTableViewModel(TemperatureModel temperatureModel)
  {
    this.temperatureModel = temperatureModel;
    temperatures = FXCollections.observableArrayList();
    this.temperatureModel.addListener(this::updateTemperatureTable);
  }

  public void updateTemperatureTable(PropertyChangeEvent evt)
  {
    if (evt.getPropertyName().equals("IndoorTemperatureChange"))
    {
      temperatures.add((Temperature) evt.getNewValue());
      }
  }

  public ObservableList<Temperature> getTemperatures()
  {
    return temperatures;
  }
}
