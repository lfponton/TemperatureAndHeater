package mediator;

import util.Subject;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Radiator implements Subject
{
  private PropertyChangeSupport support = new PropertyChangeSupport(this);
  private RadiatorState currentState;

  public void setCurrentState(RadiatorState currentState)
  {
    this.currentState = currentState;
  }

  public void turnUp() {
    currentState.turnUp(this);
    support.firePropertyChange("up", null, getPower());
  }

  public void turnDown() {
    currentState.turnDown(this);
    support.firePropertyChange("down", null, getPower());
  }

  public int getPower() {
    return currentState.getPower(this);
  }

  @Override public void addListener(PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(listener);
    support.firePropertyChange("initial", null, getPower());
  }
}
