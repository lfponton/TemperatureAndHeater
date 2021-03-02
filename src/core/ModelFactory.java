package core;

import mediator.Power2State;
import mediator.RadiatorState;
import mediator.TemperatureModel;
import mediator.TemperatureModelManager;

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
