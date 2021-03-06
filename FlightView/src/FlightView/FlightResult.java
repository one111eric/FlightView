package FlightView;

public class FlightResult implements Comparable<FlightResult>{
	private String price;
	private String departDate;
	private String arriveDate;
	private String departAP;
	private String arriveAP;
	private String descrip;
 
	public FlightResult(String price, String departDate,String arriveDate, String departAP, String arriveAP, String descrip)
	{
		this.price=price;
		this.departAP=departAP;
		this.arriveAP=arriveAP;
		this.departDate=departDate;
		this.arriveDate=arriveDate;
		this.descrip=descrip;
		
	}
	public FlightResult()
	{
		
	}
	public void setPrice(String price)
	{ 
		this.price=price;
	}
	public String getPrice()
	{ 
		return price;
	}
	public void setdepartDate(String departDate)
	{
		this.departDate=departDate;
	}
	public String getdepartDate()
	{
		return departDate;
	}
	public void setarriveDate(String arriveDate)
	{
		this.arriveDate=arriveDate;
	}
	public String getarriveDate()
	{
		return arriveDate;
	}
	public void setdepartAP(String departAP)
	{
		this.departAP=departAP;
	}
	public String getdepartAP()
	{
		return departAP;
	}
	public void setarriveAP(String arriveAP)
	{
		this.arriveAP=arriveAP;
	}
	public String getarriveAP()
	{
		return arriveAP;
	}
	public void setdescrip(String descrip)
	{
		this.descrip=descrip;
	}
	public String getdescrip()
	{
		return descrip;
	}
	@Override
	public int compareTo(FlightResult fr) {
		// TODO Auto-generated method stub
		return Double.compare(Double.parseDouble(price),Double.parseDouble(fr.price));
	}
	
}
