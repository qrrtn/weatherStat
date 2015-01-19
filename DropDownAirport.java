import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class DropDownAirport extends JPanel {
	
	private JComboBox airport;
	private JLabel airportlabel;
	static String airportCode;
	
	public DropDownAirport() {
		
		// Create label and combobox for airport icao code
		airportlabel = new JLabel("Select Airport");
		
		airport = new JComboBox();
		airport.addItem("London Heathrow Airport");
		airport.addItem("Manchester Airport");
		airport.addItem("Edinburgh Airport");
		
		airport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				
				JComboBox airport = (JComboBox) event.getSource();
				Object airportName = airport.getSelectedItem();
				
				if (airportName == "London Heathrow Airport")
				{
					airportCode = "EGLL";
				}
				else if (airportName == "Manchester Airport")
				{
					airportCode = "EGCC";
				}
				else
					airportCode = "EGPH";
				
			}
		});
		
		add (airportlabel);
		add (airport);
	}
	
public static String code() {
	
	return airportCode;
}
}
