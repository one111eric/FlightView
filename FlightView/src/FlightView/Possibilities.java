package FlightView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Possibilities {
	public String departAP;
	public String destAP;
	public String earliestdepartDate;
	public String latestdepartDate;
	public String earliestarriveDate;
	public String latestarriveDate;
	public Possibilities()
	{
		
	}
	public String[][] init(String departAP,String destAP,String earliestdepartDate,String latestdepartDate,String earliestarriveDate,String latestarriveDate) throws ParseException
	{
		
		DateFormat format=new SimpleDateFormat("MM/dd/yy",Locale.US);
		Date departDate1=format.parse(earliestdepartDate);
		Date departDate2=format.parse(latestdepartDate);
		Date arriveDate1=format.parse(earliestarriveDate);
		Date arriveDate2=format.parse(latestarriveDate);
		int diff1=(int) TimeUnit.DAYS.convert(departDate2.getTime()-departDate1.getTime(),TimeUnit.MILLISECONDS);
		int diff2=(int) TimeUnit.DAYS.convert(arriveDate2.getTime()-arriveDate1.getTime(),TimeUnit.MILLISECONDS);
		int compNum=(diff1+1)*(diff2+1);
		int aday=1000*60*60*24;
		//two dimensional array for possible combinations
		String combinations[][]=new String[compNum][4];
		//for(int n=0;n<compNum;n++)
		int n=0;
		for(int j=0;j<=diff2;j++)
		{
		   for(int i=0;i<=diff1;i++)
		   {
			combinations[n][0]=departAP;
			combinations[n][1]=destAP;
			combinations[n][2]=format.format(departDate1.getTime()+aday*i);
			combinations[n][3]=format.format(arriveDate1.getTime()+aday*j);
			n++;
		   }
		}
	    return combinations;		//System.out.println(date);
	}
	public void getValues()
	{
		Scanner input=new Scanner(System.in);
		System.out.println("Please enter departing airport:");
		this.departAP=input.nextLine();
		System.out.println("Please enter arriving airport:");
		this.destAP=input.nextLine();
		System.out.println("Please enter the earliest leaving date(MM/DD/YY):");
		this.earliestdepartDate=input.nextLine();
		System.out.println("Please enter the latest leaving date(MM/DD/YY):");
		this.latestdepartDate=input.nextLine();
		System.out.println("Please enter the earliest returning date(MM/DD/YY):");
		this.earliestarriveDate=input.nextLine();
		System.out.println("Please enter the latest returning date(MM/DD/YY):");
		this.latestarriveDate=input.nextLine();
		input.close();
	}
	
    
}
