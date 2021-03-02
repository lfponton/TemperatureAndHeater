package view.heater;

import core.ViewHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import view.temperature.TemperatureViewModel;


public class HeaterViewController
{
  @FXML private Label powerLabel;

  private ViewHandler viewHandler;
  private HeaterViewModel heaterViewModel;

  public  void init(ViewHandler viewHandler, HeaterViewModel heaterViewModel) {
    this.viewHandler = viewHandler;
    this.heaterViewModel = heaterViewModel;

    powerLabel.textProperty().bind(heaterViewModel.getRadiatorPowerProperty());
  }

  public void onUpButton(ActionEvent actionEvent) {
    heaterViewModel.getRadiator().turnUp();
  }

  public void onDownButton(ActionEvent actionEvent) {
    heaterViewModel.getRadiator().turnDown();
  }

  public void onBackButton(ActionEvent actionEvent) {
    viewHandler.openTemperatureView();
  }
}
