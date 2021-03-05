package core;

import view.table.TemperatureTableViewModel;
import view.radiator.RadiatorViewModel;
import view.temperature.TemperatureViewModel;

public class ViewModelFactory
{
  private ModelFactory modelFactory;
  private TemperatureViewModel temperatureViewModel;
  private RadiatorViewModel radiatorViewModel;
  private TemperatureTableViewModel temperatureTableViewModel;


  public ViewModelFactory(ModelFactory modelFactory) {
    this.modelFactory = modelFactory;
    this.temperatureViewModel = new TemperatureViewModel(this.modelFactory.getTemperatureModel());
    this.radiatorViewModel = new RadiatorViewModel(this.modelFactory.getRadiatorState());
    this.temperatureTableViewModel = new TemperatureTableViewModel(this.modelFactory.getTemperatureModel());
  }

  public TemperatureViewModel getTemperatureViewModel() {
    return temperatureViewModel;
  }

  public RadiatorViewModel getRadiatorViewModel() {
    return radiatorViewModel;
  }

  public TemperatureTableViewModel getTemperatureTableViewModel() {
    return temperatureTableViewModel;
  }
}
