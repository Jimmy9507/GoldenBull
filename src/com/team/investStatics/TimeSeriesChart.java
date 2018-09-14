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
	//�洢��Ŀ�ĳ�ʼͶ�ʽ��
    private static Map<String,Double> initMoney=new HashMap<String,Double>();
  //�洢��Ŀ�ĳ�ʼͶ��ʱ��
    private static Map<String,Date>initTime =new HashMap<String,Date>();
    //��ʼͶ��ʱ��
    private static Date initDay;
    //�洢�����ֵ
    private static Map<Date,Double> incomes=new HashMap<Date,Double>();
      //�洢Ͷ�ʵ�ֵ
    private static Map<Date,Double> invest=new HashMap<Date,Double>();
    //�洢������
    private static Map<Date,Double> interests=new HashMap<Date,Double>();
    
    ChartPanel panel;
    //����
	public ChartPanel drawIncomeGraph(List<InvestRecord>records)
	{     
                 XYDataset dataSet= collectIncomeData(records);
                 JFreeChart chart =ChartFactory.createTimeSeriesChart("Ͷ��ͼ","����","����",dataSet,true,true,true);
		        XYPlot xyPlot=chart.getXYPlot();
		        //��ȡʱ����
		        DateAxis dateAxis=(DateAxis)xyPlot.getDomainAxis();
		        dateAxis.setDateFormatOverride(new SimpleDateFormat("yyyy/MM/dd"));
		        panel=new ChartPanel(chart,true);
		        //��������
		        dateAxis.setLabelFont(new Font("����",Font.BOLD,14));
		        dateAxis.setTickLabelFont(new Font("����",Font.BOLD,12));
		        //��ȡ��ֵ����
		        ValueAxis rangeAxis=xyPlot.getRangeAxis();
		        rangeAxis.setLabelFont(new Font("����",Font.BOLD,15));
		        chart.getLegend().setItemFont(new Font("����",Font.BOLD,15));
		        chart.getTitle().setFont(new Font("����",Font.BOLD,20));
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
