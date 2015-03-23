package FlightView;

import java.util.Scanner;

public class Possibilities {
	private String departAP;
	private String destAP;
	private String earliestdepartDate;
	private String latestdepartDate;
	private String earliestarriveDate;
	private String latestarriveDate;
	public Possibilities()
	{
		
	}
	public void init(String departAP,String destAP,String earliestdepartDate,String latestdepartDate,String earliestarriveDate,String latestarriveDate)
	{
		
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
		System.out.println("Please enter the latest returning date(MM/DD/YY)");
		this.latestarriveDate=input.nextLine();
		input.close();
	}
	
    
}
