package core;

import model.radiator.Power2State;
import mediator.radiator.RadiatorState;
import mediator.temperature.TemperatureModel;
import mediator.temperature.TemperatureModelManager;

public class ModelFactory
{
  private TemperatureModel temperatureModel;
  private RadiatorState radiatorState;
  public TemperatureModel getTemperatureModel() {
    if (temperatureModel == null) {
      temperatureModel = new TemperatureModelManager();
    }
    return temperatureModel;
  }

  public RadiatorState getRadiatorState() {
    if (radiatorState == null) {
      radiatorState = new Power2State();
    }
    return radiatorState;
  }
}
