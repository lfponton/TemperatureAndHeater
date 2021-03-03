package mediator;

public class Power3State implements RadiatorState
{
  private static final int power = 3;
  private Thread thread;
  public Power3State(Radiator radiator) {
    thread = new Thread(() -> {
      try
      {
        Thread.sleep(2000);
        radiator.turnDown();
      } catch (InterruptedException e) {
      }
    });
    thread.setDaemon(true);
    thread.start();
  }

  @Override public void turnUp(Radiator radiator)
  {

  }

  @Override public void turnDown(Radiator radiator)
  {
    thread.interrupt();
    radiator.setCurrentState(new Power2State());
  }

  @Override public int getPower(Radiator radiator)
  {
    return power;
  }
}
