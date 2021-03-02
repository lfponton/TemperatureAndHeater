package core;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.heater.HeaterViewController;
import view.temperature.TemperatureViewController;

import java.io.IOException;

public class ViewHandler
{
  private Stage stage;
  public Scene mainScene;
  public Scene heaterScene;
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

  public void openHeaterView() {
    FXMLLoader loader = new FXMLLoader();
    if (heaterScene == null)
    {
      Parent root = getRootByPath("../view/heater/HeaterView.fxml", loader);
      HeaterViewController controller = loader.getController();
      controller.init(this, viewModelFactory.getHeaterViewModel());
      heaterScene = new Scene(root);
    }
    stage.setTitle("Control Heater");
    stage.setScene(heaterScene);
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
