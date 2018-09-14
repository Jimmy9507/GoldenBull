package com.team.investStatics;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
public class InvestRecord {
    String  date;
    String productName;
    String operation;
    double amounts;
    public static SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
    public InvestRecord(String date,String operation,double amounts,String productName)
    { 
    	  this.date=date;
    	  this.productName=productName;
    	  this.operation=operation;
    	  this.amounts=amounts;
    }
    public InvestRecord()
    {
    	
    }
    public String getDate()
    {
    	return date;
    }
    public String getProductName()
    {
    	return productName;
    }
    public String getOperation()
    {
    	return operation;
    }
    public double getAmounts()
    {  return amounts;
    }
    public void setDate(String date)
    {  
    	this.date=date;
    }
    public void setProductName(String productName)
    {    this.productName=productName;
    }
    public void setOperation(String operation)
    {
    	this.operation=operation;
    }
    public void setAmounts(double amounts)
    {
    	this.amounts=amounts;
    }
    
    public static Date formatDate(String s)
    {
    	Date date=null;
    	s=s.substring(0,4)+"-"+s.substring(4-6)+"-"+s.substring(6,8);
       try {
    	   date =sdf.parse(s);
       }
       catch(ParseException e){
    	   System.out.println("日期格式错误");
       }
       return date;
    }
    
}
