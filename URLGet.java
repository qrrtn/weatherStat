/** 
 * URLget.java
 * 
 * Example code from Big Java by Cay Horstmann page 906
 * This class gets html from the dcs web page and 
 * displays to console
 * 
 */

import java.io.*;
import java.net.*;
import java.util.*;
import java.lang.String.*;

public class URLGet  {
	
	String urlString;
	List<String> dataValues = new ArrayList<String>();
	static ArrayList<ArrayList<String>> outerList = new ArrayList<ArrayList<String>>();
	
	public URLGet (String day, String month, String year, String airportcode) 
	{
		urlString = "http://www.wunderground.com/history/airport/" + airportcode + "/" + year + "/" + month + "/" + day + "/DailyHistory.html?HideSpecis=1&format=1";
		System.out.println("Reading data from " + urlString );
	
		try 
		{
		// Open connection
		URL u = new URL(urlString);
		URLConnection connection = u.openConnection();
		
		// Ensure page exists
		HttpURLConnection httpConnection = (HttpURLConnection) connection;
		int code = httpConnection.getResponseCode();
		String message = httpConnection.getResponseMessage();
		System.out.println(code + " " + message);
		if (code != HttpURLConnection.HTTP_OK)
			return;
		
		// Response from server
		InputStream instream = connection.getInputStream();
		Scanner in = new Scanner(instream);
		
		// Skip the first two line in file;
		in.nextLine();
		in.nextLine();
		
		String input;
		String[] values2;
		
		//Read all the values into an array list
		while (in.hasNext())
		{
			
			input = in.nextLine();
			values2 = input.split(",");
	
			dataValues.addAll(Arrays.asList(values2));
			
		}
		
		// Separate the values by column (Time, Temperature, ...., Date UTC)
		// By declaring two nested Array List (List inside another list)
		// Handle missing item
		int i = 0;
		int k = 0;
		int length = dataValues.size();
		while (i < length)
		{
			ArrayList<String> inner = new ArrayList<String>();
			for ( int j = k; j < length; j = j+14)
			{
				String val = dataValues.get(j);
				if (val == " ")
				{
					val = "0";
				}
				else if (val == "-9999")
				{
					val = "0";
				}
				else if (val == "-")
				{
					val = "0";
				}
				else if ( val == "N/A")
				{
					val = "0";
				}
				inner.add(val);
			}
			outerList.add(inner);
			i = i + 1;
			k = k + 1;
		 }
		
		/*
		for (int s = 0; s < 14; s++)
		{
			System.out.println(outerList.get(s));
		}
		*/
		
		}
	
		
		catch (Exception i)
		{
			
			 System.out.println(i);
		}
		
	}
	
	
	public static ArrayList<ArrayList<String>> GetArrayList() {
		
		System.out.println(outerList);
		return outerList;
	}
}