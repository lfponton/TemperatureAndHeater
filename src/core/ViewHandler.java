package core;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.table.TemperatureTableController;
import view.radiator.RadiatorViewController;
import view.temperature.TemperatureViewController;

import java.io.IOException;

public class ViewHandler
{
  private Stage stage;
  private Scene mainScene;
  private Scene radiatorScene;
  private Scene tableScene;
  private ViewModelFactory viewModelFactory;

  public ViewHandler(Stage stage, ViewModelFactory viewModelFactory) {
    this.viewModelFactory = viewModelFactory;
    this.stage = stage;
  }

  public void start() throws Exception {
    openTemperatureView();
    stage.show();
  }

  public void openTemperatureView() {
    FXMLLoader loader = new FXMLLoader();
    if (mainScene == null)
    {
      Parent root = getRootByPath("../view/temperature/TemperatureView.fxml", loader);
      TemperatureViewController controller = loader.getController();
      controller.init(this, viewModelFactory.getTemperatureViewModel());
      mainScene = new Scene(root);
    }
    stage.setTitle("View Temperature");
    stage.setScene(mainScene);
  }

  public void openRadiatorView() {
    FXMLLoader loader = new FXMLLoader();
    if (radiatorScene == null)
    {
      Parent root = getRootByPath("../view/radiator/RadiatorView.fxml", loader);
      RadiatorViewController controller = loader.getController();
      controller.init(this, viewModelFactory.getRadiatorViewModel());
      radiatorScene = new Scene(root);
    }
    stage.setTitle("Control Heater");
    stage.setScene(radiatorScene);
  }

  public void openTemperatureTableView() {
    FXMLLoader loader = new FXMLLoader();
    if (tableScene == null)
    {
      Parent root = getRootByPath("../view/table/TemperatureTable.fxml", loader);
      TemperatureTableController controller = loader.getController();
      controller.init(this, viewModelFactory.getTemperatureTableViewModel());
      tableScene = new Scene(root);
    }
    stage.setTitle("Temperature Chart");
    stage.setScene(tableScene);
  }

  private Parent getRootByPath(String path, FXMLLoader loader)
  {
    loader.setLocation(getClass().getResource(path));
    Parent root = null;
    try
    {
      root = loader.load();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    return root;
  }
}
