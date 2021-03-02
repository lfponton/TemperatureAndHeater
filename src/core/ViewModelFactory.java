package core;

import view.temperature.TemperatureViewModel;

public class ViewModelFactory
{
  private ModelFactory modelFactory;
  private TemperatureViewModel temperatureViewModel;

  public ViewModelFactory(ModelFactory modelFactory) {
    this.modelFactory = modelFactory;
    this.temperatureViewModel = new TemperatureViewModel(this.modelFactory.getTemperatureModel());
  }

  public TemperatureViewModel getTemperatureViewModel() {
    return temperatureViewModel;
  }
}
