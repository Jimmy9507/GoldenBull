package com.team.catchData;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.util.List;
import java.io.IOException;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Document;
import org.jsoup.Jsoup;
import com.team.util.ProductDetail;
import com.team.window.MainWindow;
public class FilterProducts {
	private static  String baseUrl= "https://list.lu.com/list/transfer-p2p"
			+ "?minMoney=&maxMoney=&minDays=&maxDays=&minRate=&maxRate=&mode=&tradingMode="
			+ "&isCx=&currentPage=&orderCondition=&isShared=&canRealized=&productCategoryEnum=";
	/**
 * 提供给外部的接口，传入相关参数并获取网页内容
 * pageNumber页数
 * minMoney金额上限
 * maxMoney金额下限
 * minDays日期下限
 * maxDays日期上限
 * minRate利润下限
 * maxRate利润上限
 * throws IOException
 */
public static List<ProductDetail> getFilterContents(int pageNumber,int minMoney,
		int maxMoney,int minDays,int maxDays,double minRate,double maxRate)
throws IOException
{
	String url=getFilterURL(pageNumber,minMoney,maxMoney,minDays,maxDays,minRate,maxRate);
return getContentsFromURL(url);
}
public static String getFilterURL(int pageNumber,int minMoney,int maxMoney,int minDays,int maxDays,double minRate,double maxRate)
{
      if(pageNumber<0){
    	  JOptionPane.showMessageDialog(MainWindow.window,"非法页数输入，请重新确认您的筛选条件");
      return null;}
      if(minMoney<0||maxMoney<0)
    	  {JOptionPane.showMessageDialog(MainWindow.window,"非法金额输入，请重新确认您的筛选条件");
      return null;}
      if(minRate<0||maxRate<0)
      {
    	  JOptionPane.showMessageDialog(MainWindow.window,"非法利率输入，请重新确认您的筛选条件");
    	  return null;
      }
      if(minDays<0||maxDays<0)
      {
    	  JOptionPane.showMessageDialog(MainWindow.window, "非法投资天数输入，请重新确认您的筛选条件");
      return null;
      }
      String sPageNumber=pageNumber==0 ? "" : pageNumber+"";
      String sMinMoney=minMoney==0 ? "0" :minMoney+"";
      String sMaxMoney=maxMoney==0 ?"" :maxMoney+"";
      String sMinRate=(minRate/1.0)==0.0 ? "0" :minRate/100.0+"";
      String sMaxRate=(maxRate/1.0)==0.0 ?"" : maxRate/100.0+"";
      String sMinDay=minDays==0 ? "0" : minDays+"";
      String sMaxDay=maxDays==0 ? "": maxDays+"";
      
      String[]parts=baseUrl.split("&currentPage=");
      String url=parts[0]+"&currentPage="+sPageNumber+parts[1];
      parts=url.split("minMoney=&maxMoney=");
       url=parts[0]+"minMoney="+sMinMoney+"&maxMoney="+sMaxMoney+parts[1];
      parts=url.split("minDays=&maxDays=");
      url=parts[0]+"minDays="+sMinDay+"&maxDays="+sMaxDay+parts[1];
      parts=url.split("minRate=&maxRate=");
      url=parts[0]+"minRate="+sMinRate+"&maxRate="+sMaxRate+parts[1];
      
      return url;
}
public static List<ProductDetail> getContentsFromURL(String url){
	if(url==null)
		return null;
	List<ProductDetail> productDetails=new ArrayList<ProductDetail>();
	Document document=null;
	try{
	document=Jsoup.connect(url).timeout(5000).get();
	}
	catch(IOException e)
	{JOptionPane.showMessageDialog(MainWindow.window,"项目信息拉取失败，请检查网络连接");
	}
//项目名
	Elements productNames=document.getElementsByClass("product-name");
//收益率	
	Elements interestRates=document.getElementsByClass("interest-rate");
//产品金额
	Elements productAmounts=document.getElementsByClass("product-amount");
//投资期限
	Elements investPeriods=document.getElementsByClass("invest-period");
	for(int i=0;i<productNames.size();i++)
	{
		String productName=productNames.get(i).child(0).text();
		String productId=productNames.get(i).child(0).attr("href").split("/list/")[1];
		String interestRate=interestRates.get(i).child(1).text();
		String productAmount=productAmounts.get(i).child(1).text();
	    String investPeriod=investPeriods.get(i).child(1).text();
      ProductDetail productDetail=new ProductDetail(productName,investPeriod,productAmount,interestRate,productId);
      productDetails.add(productDetail);   
	}
	return productDetails;
}
	
	
	
	
}

