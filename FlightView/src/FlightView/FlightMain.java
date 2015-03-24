package FlightView;

import java.awt.AWTException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class FlightMain {

	public static void main(String[] args) throws InterruptedException, AWTException, ParseException {
		// TODO Auto-generated method stub
		//singleCheck();
		Possibilities possibility=new Possibilities();
		possibility.getValues();
		String[][] combinations=possibility.init(possibility.departAP,possibility.destAP,possibility.earliestdepartDate,possibility.latestdepartDate,possibility.earliestarriveDate,possibility.latestarriveDate);
		int n=combinations.length;
		System.out.print(n);
		for(int i=0;i<n;i++)
		{
			FlightSearch search1=new FlightSearch(combinations[i][0], combinations[i][1], combinations[i][2], combinations[i][3]);
		
		//FlightSearch search1=new FlightSearch("SFO", "PEK", "03/24/15", "03/31/15");
		
		List<FlightResult> result=search1.FlightSearchResult();
		for(FlightResult fr:result)
		{
			System.out.println(fr.getdepartDate()+","+fr.getarriveDate()+","+fr.getPrice()+","+fr.getdescrip());
			//System.out.println(fr.getPrice());
		}
		}
		
		System.exit(0);

	}
	
	
	 
}
