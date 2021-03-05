package core;

import external.ExternalTemperature;
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

    ExternalTemperature externalTemperature = new ExternalTemperature(10,
        modelFactory.getTemperatureModel());

    Thread t1 = new Thread(new Thermometer("t1", 10, 1, externalTemperature,
        modelFactory.getTemperatureModel(), viewModelFactory.getRadiatorViewModel().getRadiator()));
    Thread t2 = new Thread(new Thermometer("t2", 10, 7, externalTemperature,
        modelFactory.getTemperatureModel(), viewModelFactory.getRadiatorViewModel().getRadiator()));
    Thread t0 = new Thread(externalTemperature);

    t0.setDaemon(true);
    t1.setDaemon(true);
    t2.setDaemon(true);

    t0.start();
    t1.start();
    t2.start();
  }
}
