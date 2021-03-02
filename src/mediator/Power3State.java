package mediator;

public class Power3State implements RadiatorState
{
  private static final int power = 3;

  public Power3State(Radiator radiator) {
    Thread thread = new Thread(() -> {
      try
      {
        Thread.sleep(2000);
      } catch (InterruptedException e) {
      }
      radiator.turnDown();
    });
    thread.setDaemon(true);
    thread.start();
  }

  @Override public void turnUp(Radiator radiator)
  {

  }

  @Override public void turnDown(Radiator radiator)
  {
    Thread.currentThread().interrupt();
    radiator.setCurrentState(new Power2State());
  }

  @Override public int getPower(Radiator radiator)
  {
    return power;
  }
}
