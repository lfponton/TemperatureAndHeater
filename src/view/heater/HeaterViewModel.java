package view.heater;

import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;
import mediator.Radiator;
import mediator.RadiatorState;

import java.beans.PropertyChangeEvent;

public class HeaterViewModel
{
  private StringProperty power;
  private RadiatorState radiatorState;
  private Radiator radiator;

  public HeaterViewModel(RadiatorState radiatorState)
  {
    this.radiatorState = radiatorState;
    this.radiator = new Radiator();
    radiator.setCurrentState(radiatorState);
    power = new SimpleStringProperty();
    this.radiator.addListener(this::updatePowerState);
  }

  public void updatePowerState(PropertyChangeEvent evt)
  {
    power.set(String.valueOf(evt.getNewValue()));
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
