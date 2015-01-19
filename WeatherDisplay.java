import javax.swing.*;
import javax.swing.event.*;

import java.awt.*;
import java.awt.event.*;

import org.jfree.chart.*;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.*;
import org.jfree.ui.*;
import org.jfree.data.category.*;

import java.util.*;

public class WeatherDisplay extends JFrame {
	
	
	// Uses Jfreechart for charts 
	String[] x;
	Double[] y;
	
	ArrayList<ArrayList<String>> outerData = new ArrayList<ArrayList<String>>();

	public WeatherDisplay() {
		super("Weather Data Display");
		
		JPanel chartPanel = createChartPanel();
		add(chartPanel, BorderLayout.CENTER);
		setSize(500,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		outerData = URLGet.GetArrayList();
	}
	

          
	private JPanel createChartPanel(){
		
		String chartTitle = "Time vs Temperature";
		String xAxislabel = "Time";
		String yAxislabel = "Temperature";
		
		
		CategoryDataset data = createDataset(outerData);
		
		JFreeChart chart = ChartFactory.createLineChart(chartTitle,
	            xAxislabel, yAxislabel, data);
	 
	    return new ChartPanel(chart);
	}
	
	private CategoryDataset createDataset(ArrayList<ArrayList<String>> outerData) {
		
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		
		String series1 = "Temperature";
		
		int timeSize = outerData.get(0).size();
		int tempSize = outerData.get(1).size();
		
	
		for (int i=0; i < tempSize; i++)
		{
			y[i] = Double.parseDouble(outerData.get(1).get(i));
			System.out.println(y[i]);
		}
	
		for (int j=0; j < timeSize; j++)
		{
			dataset.addValue(y[j], series1, outerData.get(0).get(j));
		}
			
		return dataset;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new WeatherDisplay();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		
	}
}

