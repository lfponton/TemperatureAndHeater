package core;

import view.chart.TemperatureChartViewModel;
import view.heater.HeaterViewModel;
import view.temperature.TemperatureViewModel;

public class ViewModelFactory
{
  private ModelFactory modelFactory;
  private TemperatureViewModel temperatureViewModel;
  private HeaterViewModel heaterViewModel;
  private TemperatureChartViewModel temperatureChartViewModel;


  public ViewModelFactory(ModelFactory modelFactory) {
    this.modelFactory = modelFactory;
    this.temperatureViewModel = new TemperatureViewModel(this.modelFactory.getTemperatureModel());
    this.heaterViewModel = new HeaterViewModel(this.modelFactory.getRadiatorState());
    this.temperatureChartViewModel = new TemperatureChartViewModel(this.modelFactory.getTemperatureModel());
  }

  public TemperatureViewModel getTemperatureViewModel() {
    return temperatureViewModel;
  }

  public HeaterViewModel getHeaterViewModel() {
    return heaterViewModel;
  }

  public TemperatureChartViewModel getTemperatureChartViewModel() {
    return temperatureChartViewModel;
  }
}
