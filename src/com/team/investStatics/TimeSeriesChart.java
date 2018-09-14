package com.team.investStatics;
import java.text.SimpleDateFormat;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.Date;
import org.jfree.chart.ChartPanel;
import java.util.List;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYDataset;
import org.jfree.chart.ChartFactory;
import java.awt.Font;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.ValueAxis;
public class TimeSeriesChart {
    private SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	
    private static Set<String> productsSet=new HashSet<String>();
	//存储项目的初始投资金额
    private static Map<String,Double> initMoney=new HashMap<String,Double>();
  //存储项目的初始投资时间
    private static Map<String,Date>initTime =new HashMap<String,Date>();
    //初始投资时间
    private static Date initDay;
    //存储收益的值
    private static Map<Date,Double> incomes=new HashMap<Date,Double>();
      //存储投资的值
    private static Map<Date,Double> invest=new HashMap<Date,Double>();
    //存储收益率
    private static Map<Date,Double> interests=new HashMap<Date,Double>();
    
    ChartPanel panel;
    //绘制
	public ChartPanel drawIncomeGraph(List<InvestRecord>records)
	{     
                 XYDataset dataSet= collectIncomeData(records);
                 JFreeChart chart =ChartFactory.createTimeSeriesChart("投资图","日期","收益",dataSet,true,true,true);
		        XYPlot xyPlot=chart.getXYPlot();
		        //获取时间轴
		        DateAxis dateAxis=(DateAxis)xyPlot.getDomainAxis();
		        dateAxis.setDateFormatOverride(new SimpleDateFormat("yyyy/MM/dd"));
		        panel=new ChartPanel(chart,true);
		        //标题字体
		        dateAxis.setLabelFont(new Font("黑体",Font.BOLD,14));
		        dateAxis.setTickLabelFont(new Font("宋体",Font.BOLD,12));
		        //获取“值”轴
		        ValueAxis rangeAxis=xyPlot.getRangeAxis();
		        rangeAxis.setLabelFont(new Font("黑体",Font.BOLD,15));
		        chart.getLegend().setItemFont(new Font("宋体",Font.BOLD,15));
		        chart.getTitle().setFont(new Font("宋体",Font.BOLD,20));
		        return panel;
	}
	private XYDataset collectIncomeData(List<InvestRecord>records)
	{
		for(int i=0;i<records.size();i++)
		{
			InvestRecord investRecord=records.get(i);
			String id =records.get(i).getProductName();
			if(!productsSet.contains(id))
			{
				productsSet.add(id);
				initMoney.put(id, investRecord.getAmounts());
				initTime.put(id, InvestRecord.formatDate(investRecord.getDate()));
			}
		}
		
	}
