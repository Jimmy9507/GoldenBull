package com.team.rush;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.team.catchData.FilterProducts;
import com.team.util.ProductDetail;
public class Rush extends Thread{
	  List<ProductDetail> rushProductsDetails=new ArrayList<ProductDetail>();
	static int rMinDays;
	static int rMaxDays;
	static int rMinPrice;
	static int rMaxPrice;
	static double rMinRate;
	static double rMaxRate;
	public Rush(String minPrice,String maxPrice,String minDays,
			String maxDays,String minRate,String maxRate)
	{  super();
         
           rMinDays=minDays.equals("")?0:Integer.parseInt(minDays);
           rMaxDays=maxDays.equals("")?0:Integer.parseInt(maxDays);
           rMinPrice=minPrice.equals("")?0:Integer.parseInt(minPrice);
           rMaxPrice=maxPrice.equals("")?0:Integer.parseInt(maxPrice);
           rMinRate=minRate.equals("")?0:Double.parseDouble(minRate);
           rMaxRate=maxRate.equals("")?0:Double.parseDouble(maxRate);
	}
	
           public void run()
           {
        	   int pageNumber=1;
        	   while(true)
		       {try{
        		   rushProductsDetails=FilterProducts.getFilterContents(1, rMinPrice,rMaxPrice, rMinDays, 
				  rMaxDays, rMinRate, rMaxRate);
             if(rushProductsDetails.size()==0)
             {  
            JOptionPane.showMessageDialog(null, "没有找到相关信息的产品！");
              break;
              }
             else 
             { Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+
        	    		 FilterProducts.getFilterURL(pageNumber, rMinPrice, rMaxPrice, rMinDays, 
        	        			  rMaxDays, rMinRate, rMaxRate));
        	        
        	     break;
        	     }
		       }
		       
        	   catch(IOException e)
		       {
        		   JOptionPane.showMessageDialog(null, "网络连接错误！");
		       }
		       }
		       super.run();
}
}
