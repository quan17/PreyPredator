import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class Graph {
	public static JPanel chartPanel(Population population, int simuLength,Animal[] animalEco, FoodSource[] foodSourceEco){
		String chartTitle = "Result";
	    String xAxisLabel = "Weeks";
	    String yAxisLabel = "Population";
	    
	    XYDataset dataset = createDataSet(population, simuLength,animalEco,foodSourceEco);
	    
	    JFreeChart chart = ChartFactory.createXYLineChart(chartTitle,
	            xAxisLabel, yAxisLabel, dataset);
	 
	    return new ChartPanel(chart);  
	}
	
	public static XYDataset createDataSet(Population population, int simuLength,Animal[] animalEco, FoodSource[] foodSourceEco){
		XYSeriesCollection dataset = new XYSeriesCollection();
		
		for (int i = 0; i < Ecosystem.numOfAnimals; i++){
			XYSeries series = new XYSeries(animalEco[i].getName());
			
			for (int j = 0; j <= simuLength; j++){
				series.add(j, population.getAnimal(i+1, j));
			}
			dataset.addSeries(series);
		}
		
	 
	    return dataset;
	}
}
