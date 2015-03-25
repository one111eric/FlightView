package FlightView;

import java.awt.AWTException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import FlightView.FlightSearch;
public class FlightMain {

	public static void main(String[] args) throws InterruptedException, AWTException, ParseException {
		// TODO Auto-generated method stub
		//get airport and date combinations
		Possibilities possibility=new Possibilities();
		possibility.getValues();
		String[][] combinations=possibility.init(possibility.departAP,possibility.destAP,possibility.earliestdepartDate,possibility.latestdepartDate,possibility.earliestarriveDate,possibility.latestarriveDate);
		int n=combinations.length;
		System.out.println(n+" possible date combinations");
		//get all result into a new FlightResult list
		List<FlightResult> allresult=new ArrayList<FlightResult>();
		for(int i=0;i<n;i++)
		{
			FlightSearch search1=new FlightSearch(combinations[i][0], combinations[i][1], combinations[i][2], combinations[i][3]);
			List<FlightResult> result=search1.FlightSearchResult();
		    allresult.addAll(result);
		}
		//Sort the result list by price
				Collections.sort(allresult);
		//print out all search result
		for(FlightResult fr:allresult)
		{
			System.out.println(fr.getdepartDate()+","+fr.getarriveDate()+","+fr.getPrice()+","+fr.getdescrip());
			
		}
		
		
		System.out.println("Finished!");
		System.exit(0);

	}
	
	
	 
}
