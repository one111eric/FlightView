package FlightView;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FlightMain {

	public static void main(String[] args) throws InterruptedException, AWTException {
		// TODO Auto-generated method stub
		//singleCheck();
		
		System.out.print("abc");
		FlightSearch search1=new FlightSearch("SFO", "PEK", "03/22/15", "03/27/15");
		
		List<FlightResult> result=search1.FlightSearchResult();
		for(FlightResult fr:result)
		{
			System.out.println(fr.getPrice()+","+fr.getdescrip());
			
		}
		System.exit(0);

	}
	
	
	 
}
