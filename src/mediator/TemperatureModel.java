package mediator;

import model.Temperature;
import util.Subject;

public interface TemperatureModel extends Subject
{
  void addTemperature(String id, double indoorTemperature);
  void addOutdoorTemperature(double outdoorTemperature);
  Temperature getLastInsertedIndoorTemperature(String id);
  Temperature getLatInsertedOutdoorTemperature();
}
