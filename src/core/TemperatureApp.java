package core;

import external.Thermometer;
import javafx.application.Application;
import javafx.stage.Stage;

public class TemperatureApp extends Application
{

  @Override public void start(Stage stage) throws Exception
  {
    ModelFactory modelFactory = new ModelFactory();
    ViewModelFactory viewModelFactory = new ViewModelFactory(modelFactory);
    ViewHandler viewHandler = new ViewHandler(stage, viewModelFactory);
    viewHandler.start();

    Thread t1 = new Thread(new Thermometer("t1", 10, 1,
        modelFactory.getTemperatureModel()));
    Thread t2 = new Thread(new Thermometer("t2", 10, 7,
        modelFactory.getTemperatureModel()));
    t1.start();
    t2.start();
  }
}
