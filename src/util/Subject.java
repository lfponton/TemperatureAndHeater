package util;

import java.beans.PropertyChangeListener;

public interface Subject
{
  void addListener(PropertyChangeListener listener);
}
