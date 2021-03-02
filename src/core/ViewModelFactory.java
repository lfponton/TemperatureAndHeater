package core;

import view.heater.HeaterViewModel;
import view.temperature.TemperatureViewModel;

public class ViewModelFactory
{
  private ModelFactory modelFactory;
  private TemperatureViewModel temperatureViewModel;
  private HeaterViewModel heaterViewModel;


  public ViewModelFactory(ModelFactory modelFactory) {
    this.modelFactory = modelFactory;
    this.temperatureViewModel = new TemperatureViewModel(this.modelFactory.getTemperatureModel());
    this.heaterViewModel = new HeaterViewModel(this.modelFactory.getRadiatorState());
  }

  public TemperatureViewModel getTemperatureViewModel() {
    return temperatureViewModel;
  }

  public HeaterViewModel getHeaterViewModel() {
    return heaterViewModel;
  }
}
