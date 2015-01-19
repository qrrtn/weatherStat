import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class WeatherGUI extends JFrame {
	
	String dateChosen, day, month, year, code;
	public WeatherGUI() {
		
		// set size, position, icon, and title for the JFrame
		setTitle("Weather Data Application");
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dim = tk.getScreenSize();
		setSize(500,150);
		setLocation(new Point(dim.width/4, dim.height/4));
		Container contentPane = this.getContentPane();
	
		// Add date panel
		DropDownBox dropdownbox = new DropDownBox();
		contentPane.add(dropdownbox, BorderLayout.NORTH);
		
		// Add airport panel
		DropDownAirport dropdownbox2 = new DropDownAirport();
		contentPane.add(dropdownbox2, BorderLayout.CENTER);
		
		// Add submit button
		JButton submit = new JButton("Submit");
		contentPane.add(submit, BorderLayout.SOUTH);
		
		// Action listener for submit button
		submit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				
				day = DropDownBox.getDay();
				month = DropDownBox.getMonth();
				year = DropDownBox.getYear();
				code = DropDownAirport.code();
				
				System.out.println(day);
				System.out.println(month);
				System.out.println(year);
				System.out.println(code);
				
				URLGet url = new URLGet(day,month,year,code);
				
				System.out.println(URLGet.GetArrayList());
				
				WeatherDisplay chart = new WeatherDisplay();
				chart.setVisible(true);
				}
		});
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Create frame for panels, set is as true.
		JFrame dropdown = new WeatherGUI();
		dropdown.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		dropdown.setVisible(true);	
		

		
	}

}
