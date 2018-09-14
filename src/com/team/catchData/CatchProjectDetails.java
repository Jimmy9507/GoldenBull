package com.team.catchData;
import java.io.IOException;
import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import com.team.util.ProductDetail;
public class CatchProjectDetails {
     //网络数据所在的初始化URL地址
	private static String basePath="http://list.lu.com/list/transfer-p2p"+
     "?minMoney=&maxMoney=&minDays=&maxDays=&minRate=&maxRate=&mode=&tradingMode="+
		"&isCx=&currentPage=1&orderCondition=&isShared=&canRealized=&productCategoryEnum=";
	//当前所处的页面的标号
	  private static int CurrentPage=1;
	  //当前所处的页面的URL
	  private static String srcPath;
	  

/**
  从一组URL中获取所有关键数据并返回
*
*
*
*
*/
public static ArrayList<ProductDetail> catchHTMLContents()
throws IOException
{
        ArrayList<ProductDetail> productDetails=new ArrayList<ProductDetail>();
        		while(true)
        		{
        			srcPath=basePath.replace("CurrentPage=1","CurrentPage="+CurrentPage++);
        		
	Document document=Jsoup.connect(srcPath).get();
	int size=document.getElementsByClass("product-name").size();
	if(size>0)
	{//项目名
		Elements productNames=document.getElementsByClass("product-name");
	     //收益率
	    Elements interestRates=document.getElementsByClass("interest-rate");
	    //剩余期限
	    Elements investPeriods=document.getElementsByClass("invest-periods");
	    //起投金额
	Elements productAmounts=document.getElementsByClass("product-amounts");
	    for(int i=0;i<productNames.size();i++)
	    	{String productName=productNames.get(i).child(0).text();
	    	String productId=productNames.get(i).child(0).text();
	        String interestRate=interestRates.get(i).child(1).text();
	        String investPeriod=investPeriods.get(i).child(1).text();
	        String productAmount=productAmounts.get(i).child(0).text();
	        ProductDetail productDetail=new ProductDetail(productName,interestRate,investPeriod,productAmount,productId);
            productDetails.add(productDetail);
}}
	else 
		break;}
	return productDetails;
}}