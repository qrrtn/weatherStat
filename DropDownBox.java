import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class DropDownBox extends JPanel 
{
	private JComboBox dateBox, monthBox, yearBox, airport;
	private JLabel label;
	static int DD, MM, YY;
	String[] monthName = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
	
	private JLabel airportlabel;
	String airportName;
	
public DropDownBox()
{	
	
	// Create panel
	JPanel panel = new JPanel();
	BoxLayout layout = new BoxLayout (panel, BoxLayout.X_AXIS);
	panel.setLayout(layout);
	
	// Create label and combo box for date
	label = new JLabel("Select Date");
	dateBox = new JComboBox();
	
	// Add date ( 1 - 31)
	for (int i=1; i<32; i++)
	{
		dateBox.addItem(i);
	}
	
	// Add (month)
	monthBox = new JComboBox();
	
	
	for (int i=0; i<12; i++)
	{
		String current = monthName[i];
		monthBox.addItem(current);
	}
	
	// Add year starting 2000
	yearBox = new JComboBox();
	
	for (int i=2000; i<2015; i++)
	{
		yearBox.addItem(i);
	}
	

	
	// Action listener for all the combo boxes
	dateBox.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent event) {
			
			JComboBox dateBox = (JComboBox) event.getSource();
			
			Object date = dateBox.getSelectedItem();
			DD = (Integer) date;
			
		}
	});
	
	monthBox.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent event) {
			
			JComboBox monthBox = (JComboBox) event.getSource();
			
			Object month = monthBox.getSelectedItem();
			
			for (int i = 0; i < 12; i++)
			{
				if (month == monthName[i])
				{
					MM = i+1;
				}
			}
			
		}
	});
	
	yearBox.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent event) {
			
			JComboBox yearBox = (JComboBox) event.getSource();
			Object year = yearBox.getSelectedItem();
			YY = (Integer) year;
			
		}
	});
	
	add (label);
	add (dateBox);
	add (monthBox);
	add (yearBox);
	
}

public static String getDay() {
	
	String day;
	
	if (DD < 10)
	{
		day = "0" + Integer.toString(DD);
	}
	else
		day = Integer.toString(DD);
	
	return day;
}

public static String getMonth() {
	
	String month;
	
	if (MM < 10)
	{
		month = "0" + Integer.toString(MM);
	}
	else
		month = Integer.toString(MM);
	
	return month;
}

public static String getYear() {
	
	String year = Integer.toString(YY);
	
	return year;
}

public static String date() {
	
	String date; 
	if (DD < 10 && MM < 10)
	{
		date =  "O"+ Integer.toString(DD) + "0" + Integer.toString(MM) + Integer.toString(YY);
	}
	else 
		date = Integer.toString(DD) + Integer.toString(MM) + Integer.toString(YY);
	
	return date;
}
}