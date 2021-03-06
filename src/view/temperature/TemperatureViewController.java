package view.temperature;

import core.ViewHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class TemperatureViewController
{
  @FXML private Label temperature1Label;
  @FXML private Label temperature2Label;
  @FXML private Label outdoorTemperatureLabel;
  @FXML private Label warningLabel1;
  @FXML private Label warningLabel2;

  private ViewHandler viewHandler;
  private TemperatureViewModel temperatureViewModel;

  public void init(ViewHandler viewHandler, TemperatureViewModel temperatureViewModel)
  {
    this.viewHandler = viewHandler;
    this.temperatureViewModel = temperatureViewModel;

    temperature1Label.textProperty().bind(temperatureViewModel.getTemperature1());
    temperature2Label.textProperty().bind(temperatureViewModel.getTemperature2());
    outdoorTemperatureLabel.textProperty().bind(temperatureViewModel.getOutdoorTemperature());
    warningLabel1.textProperty().bind(temperatureViewModel.getWarning1());
    warningLabel2.textProperty().bind(temperatureViewModel.getWarning2());
  }

  public void onControlRadiatorButton(ActionEvent actionEvent)
  {
    viewHandler.openRadiatorView();
  }

  public  void onViewTableButton(ActionEvent actionEvent)
  {
    viewHandler.openTemperatureTableView();
  }
}
