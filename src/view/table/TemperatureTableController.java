package view.table;

import core.ViewHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import model.temperature.Temperature;
import javafx.scene.control.TableView;


public class TemperatureTableController
{
  @FXML TableView<Temperature> tableView;

  private TemperatureTableViewModel temperatureTableViewModel;
  private ViewHandler viewHandler;

  @FXML private TableColumn<String, Temperature> idColumn;
  @FXML private TableColumn<Double, Temperature> temperatureColumn;
  @FXML private TableColumn<String, Temperature> timestampColumn;

  public void init(ViewHandler viewHandler,
      TemperatureTableViewModel temperatureTableViewModel)
  {
    this.viewHandler = viewHandler;
    this.temperatureTableViewModel = temperatureTableViewModel;
    idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
    temperatureColumn.setCellValueFactory(new PropertyValueFactory<>("temperature"));
    timestampColumn.setCellValueFactory(new PropertyValueFactory<>("timestamp"));
    tableView.setItems(temperatureTableViewModel.getTemperatures());
  }

  public void onBackButton(ActionEvent actionEvent) {
    viewHandler.openTemperatureView();
  }
}
