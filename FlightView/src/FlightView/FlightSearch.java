package FlightView;

import java.awt.AWTException;
import java.util.ArrayList;
//import java.awt.Robot;
//import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightSearch {
	 private String departAP;
     private String arriveAP;
     private String departDate;
     private String arriveDate;
     //private int stopNum;
       public FlightSearch(String departAP, String arriveAP, String departDate, String arriveDate)
       {
    	   this.departAP=departAP;
    	   this.arriveAP=arriveAP;
    	   this.departDate=departDate;
    	   this.arriveDate=arriveDate;
    	   //this.stopNum=stopNum;
       }
       public List<FlightResult> FlightSearchResult() throws InterruptedException, AWTException
       {
    	   List<FlightResult> resultList=new ArrayList<FlightResult>();
    	   //setDriver("Chrome");
    	   //System.setProperty("webdriver.chrome.driver", "D:\\selenium-2.45.0\\chromedriver.exe");
    	   //System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Downloads\\chromedriver_win32\\chromedriver.exe");
   		//WebDriver wd=new ChromeDriver();
    	   WebDriver wd=new FirefoxDriver();
   		wd.manage().window().setPosition(new Point(0,0));
   		wd.manage().window().setSize(new Dimension(1024,768));
   		
    	  // WebDriver wd=new FirefoxDriver();
   		WebDriverWait wait=new WebDriverWait(wd,60);
   		
   		//goto homepage
   		wd.get("http://www.priceline.com/");
   		Thread.sleep(1500);
   		//change to flights
   		
   		wd.findElement(By.linkText("Flights")).click();
   		
   		Thread.sleep(1500);
   		//input airports
   		WebElement departBox=wd.findElement(By.id("air-loc-from"));
   		WebElement destBox=wd.findElement(By.id("air-loc-to"));
   		departBox.sendKeys(departAP);
   		destBox.sendKeys(arriveAP);
   		Thread.sleep(1000);
   		//input dates
   		WebElement departDateBox=wd.findElement(By.id("departure-from"));
   		WebElement returnDateBox=wd.findElement(By.id("return-date"));
   		departDateBox.sendKeys(departDate);
   		returnDateBox.sendKeys(arriveDate);
   		//Robot r = new Robot();
   		//r.keyPress(KeyEvent.VK_ESCAPE);
   		//r.keyRelease(KeyEvent.VK_ESCAPE);
   		Thread.sleep(1000);
   		WebElement closeBtn=wd.findElement(By.cssSelector(".ui-datepicker-close"));
   		closeBtn.click();
   		Thread.sleep(500);
   		
   		//submit
   		WebElement submitBtn=wd.findElement(By.id("air-submit-btn"));
   		submitBtn.click();
   		
   		//get result
   		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".dollar")));
   		Thread.sleep(2000);
   		List<WebElement> prices=wd.findElements(By.cssSelector(".dollar"));
   		//List<WebElement> descrips=wd.findElements(By.xpath("//div[@class='stops']|//div[contains(text(),'Total Time']"));
   		List<WebElement> descrips=wd.findElements(By.xpath("//*[contains(text(),'Total Time')]/.."));
   	    
   	    //add search results into a list
   	    int n=prices.size();
   	    for(int i=0;i<n;i++)
   	    {
   	    FlightResult fr=new FlightResult();
   	    fr.setarriveAP(arriveAP);
   	    fr.setdepartAP(departAP);
   	    fr.setarriveDate(arriveDate);
   	    fr.setdepartDate(departDate);
   	    String price=prices.get(i).getText().substring(1).replace(",", "");
   	    //String descrip=descrips.get(i).getText();
   	    String descrip=descrips.get(i).getText().replace("\n", " ");
   	    //fr.setPrice(Double.parseDouble(price));
   	    fr.setPrice(price);
   	   
   	    //fr.setdescrip("test");
   	    fr.setdescrip(descrip);
   	    //System.out.println(fr.getPrice());
   	    //System.out.println(fr.getdescrip());
   	    resultList.add(fr);
   	    }
   	    wd.quit();
   	    return resultList;
       }
       
       private void setDriver(String browser)
       {
    	   if(browser=="Chrome")
    	   {
    		   System.setProperty("webdriver.chrome.driver", "D:\\selenium-2.45.0\\chromedriver.exe");
    	   }
    	   if(browser=="Firefox")
    	   {
    		   
    	   }
    	   if(browser=="IE")
    	   {
    		   
    	   }
       }
      
       
}
