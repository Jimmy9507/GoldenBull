package com.team.catchData;
import java.io.IOException;
import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import com.team.util.ProductDetail;
public class CatchProjectDetails {
     //�����������ڵĳ�ʼ��URL��ַ
	private static String basePath="http://list.lu.com/list/transfer-p2p"+
     "?minMoney=&maxMoney=&minDays=&maxDays=&minRate=&maxRate=&mode=&tradingMode="+
		"&isCx=&currentPage=1&orderCondition=&isShared=&canRealized=&productCategoryEnum=";
	//��ǰ������ҳ��ı��
	  private static int CurrentPage=1;
	  //��ǰ������ҳ���URL
	  private static String srcPath;
	  

/**
  ��һ��URL�л�ȡ���йؼ����ݲ�����
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
	{//��Ŀ��
		Elements productNames=document.getElementsByClass("product-name");
	     //������
	    Elements interestRates=document.getElementsByClass("interest-rate");
	    //ʣ������
	    Elements investPeriods=document.getElementsByClass("invest-periods");
	    //��Ͷ���
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