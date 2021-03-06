package view.radiator;

import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;
import mediator.radiator.Radiator;
import mediator.radiator.RadiatorState;

import java.beans.PropertyChangeEvent;

public class RadiatorViewModel
{
  private StringProperty power;
  private RadiatorState radiatorState;
  private Radiator radiator;

  public RadiatorViewModel(RadiatorState radiatorState)
  {
    this.radiatorState = radiatorState;
    this.radiator = new Radiator();
    radiator.setCurrentState(radiatorState);
    power = new SimpleStringProperty();
    this.radiator.addListener(this::updatePowerState);
  }

  public void updatePowerState(PropertyChangeEvent evt)
  {
    power.set(String.valueOf("Power Level: " + evt.getNewValue()));
  }

  public StringProperty getRadiatorPowerProperty()
  {
    return power;
  }

  public Radiator getRadiator()
  {
    return radiator;
  }
}
