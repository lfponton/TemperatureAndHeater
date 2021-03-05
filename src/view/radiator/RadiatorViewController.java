package view.radiator;

import core.ViewHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class RadiatorViewController
{
  @FXML private Label powerLabel;

  private ViewHandler viewHandler;
  private RadiatorViewModel radiatorViewModel;

  public  void init(ViewHandler viewHandler, RadiatorViewModel radiatorViewModel) {
    this.viewHandler = viewHandler;
    this.radiatorViewModel = radiatorViewModel;

    powerLabel.textProperty().bind(radiatorViewModel.getRadiatorPowerProperty());
  }

  public void onUpButton(ActionEvent actionEvent) {
    radiatorViewModel.getRadiator().turnUp();
  }

  public void onDownButton(ActionEvent actionEvent) {
    radiatorViewModel.getRadiator().turnDown();
  }

  public void onBackButton(ActionEvent actionEvent) {
    viewHandler.openTemperatureView();
  }
}
