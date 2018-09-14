package com.team.util;

public class ProductDetail {
   //ÏîÄ¿Ãû
	private String productName;
	private String investPeriod;
	private String productAmount;
	private String interestRate;
	private String productId;
	public ProductDetail(String productName,String investPeriod,String productAmount,
			String interestRate,String productId)
	{	super();
		this.productName=productName;
		this.investPeriod=investPeriod;
		this.productAmount=productAmount;
		this.interestRate=interestRate;
		this.productId=productId;
	}
	public String getProductName()
	{
		return productName;
	}
	public String getInvestPeriod()
	{
		return investPeriod;
	}
	public String getMinimumMoney()
	{
		return productAmount;
	}
	public String getInterestRate()
	{
		return interestRate;
	}
	public void setMinimumMoney(String minimumMoney)
	{
	  this.productAmount=minimumMoney;
	}
	public void setProductName(String productName)
	{  this.productName=productName;
	}
	public void setInvestPeriod(String investPeriod)
	{
		this.investPeriod=investPeriod;
	}
	public void setProductAmount(String productAmount)
	{
		this.productAmount=productAmount;
		
	}
	public void setInterestRate(String interestRate)
	{
		this.interestRate=interestRate;
	}
	public String getProductId()
	{
		return productId;
	}
	public String toString()
	
	{
		return "ProductDetail[productName="+productName+",interestRate="+interestRate+",investPeriod="+investPeriod
				+",minimumMoeny"+productAmount+"]";
	}
}
