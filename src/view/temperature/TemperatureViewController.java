package view.temperature;

import core.ViewHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class TemperatureViewController
{
  @FXML private Label temperature1Label1;
  @FXML private Label temperature1Label2;

  private ViewHandler viewHandler;
  private TemperatureViewModel temperatureViewModel;

  public void init(ViewHandler viewHandler, TemperatureViewModel temperatureViewModel)
  {
    this.viewHandler = viewHandler;
    this.temperatureViewModel = temperatureViewModel;

    temperature1Label1.textProperty().bind(temperatureViewModel.getTemperature1());
    temperature1Label2.textProperty().bind(temperatureViewModel.getTemperature2());
  }
}
