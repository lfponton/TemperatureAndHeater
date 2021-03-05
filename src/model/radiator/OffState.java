package model.radiator;

import mediator.radiator.Radiator;
import mediator.radiator.RadiatorState;

public class OffState implements RadiatorState
{
  private static final int power = 0;

  @Override public void turnUp(Radiator radiator)
  {
    radiator.setCurrentState(new Power1State());
  }

  @Override public void turnDown(Radiator radiator)
  {

  }

  @Override public int getPower(Radiator radiator)
  {
    return power;
  }
}
