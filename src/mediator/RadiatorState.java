package mediator;

import util.Subject;

public interface RadiatorState
{
  void turnUp(Radiator radiator);
  void turnDown(Radiator radiator);
  int getPower(Radiator radiator);
}
