package view.chart;

import core.ViewHandler;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;

public class TemperatureChartController
{
  @FXML BarChart<Double, String> barChart;

  private TemperatureChartViewModel temperatureChartViewModel;
  private ViewHandler viewHandler;

  private XYChart.Data<String, Double> t1 = new XYChart.Data<String, Double>("t1", 0.0);
  private XYChart.Data<String, Double> t2 = new XYChart.Data<String, Double>("t2", 0.0);

  public void init(ViewHandler viewHandler, TemperatureChartViewModel temperatureChartViewModel) {
    this.viewHandler = viewHandler;
    this.temperatureChartViewModel = temperatureChartViewModel;

      t1.YValueProperty().bind(temperatureChartViewModel.getT1Property());
      t2.YValueProperty().bind(temperatureChartViewModel.getT2Property());

    XYChart.Series t1Series = new XYChart.Series();
    t1Series.setName("t1");
    t1Series.getData().add(t1);
    barChart.getData().add(t1Series);

    XYChart.Series t2Series = new XYChart.Series();
    t2Series.setName("t2");
    t2Series.getData().add(t2);
    barChart.getData().add(t2Series);
  }

}
