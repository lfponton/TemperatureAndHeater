package mediator;

import model.Temperature;
import util.Subject;

public interface TemperatureModel extends Subject
{
  void addTemperature(String id, double temperature);
  Temperature getLastInsertedTemperature(String id);
}
