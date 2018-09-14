package com.team.window;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;

import com.team.catchData.FilterProducts;
import com.team.rush.Rush;
import com.team.util.ProductDetail;
/**
 * 主界面
 * @author hjm
 *
 */
public class MainWindow {
	//招财蛙软件框架
     public static JFrame window=new JFrame("招财蛙");
    //招财蛙面板器
     private static JTabbedPane tab;
     //平安陆金所模块面板
     private static JPanel pingAn=new JPanel();
     //京东模块面板
     private static JPanel jingDong=new JPanel();
     //收益模块面板
     private static JPanel showPart= new JPanel();
     private static JLabel periodLabel=new JLabel("剩余期限");
     private static JLabel amountLabel=new JLabel("转换价格");
     private static JLabel productLabel=new JLabel("项目名称");
     //投资期限输入框
     JTextField minPeriodField=new JTextField(4);
     JTextField maxPeriodField=new JTextField(4);
     //转换价格输入框
    JTextField minPriceField=new JTextField(4);
    JTextField maxPriceField=new JTextField(4);
    //收益率输入框
      JTextField minRateField=new JTextField(4);
      JTextField maxRateField=new JTextField(4);
      //项目信息

      private static int minDays=0;
      private static int maxDays=0;
      private static int minPrice=0;
      private static int maxPrice=0;
      private static double minRate=0.0;
      private static double maxRate=0.0;
      //定义一个表格JTable
      private static JTable investTable=new JTable();
      //定义一个数据模型
      private static DefaultTableModel mTableModel;
      //定义页数
      private static int currentPage=1;
      //一个装项目信息的ArrayList
      public static List<ProductDetail>productDetails=new ArrayList<ProductDetail>();
     //一个JRadioButton的list
     private static ArrayList<JRadioButton>jRadioButtons=new ArrayList<JRadioButton>();
     //一个JButton的list
     private static ArrayList<JButton>jButtons=new ArrayList<JButton>();
     //一个JLabel的list
     private static ArrayList<JLabel>jLabels=new ArrayList<JLabel>();
     //一个显示收益数据的jPanel
     private static JPanel investShowPart=new JPanel();
     //一个关于JRadioButton的监听器
     private  static MyJRadioButtonsListener jRadioButtonListener=new MyJRadioButtonsListener();
     //一个关于JButton的监听器
       private JButtonsListener jButtonsListener=new JButtonsListener();
       //一个抢购框中JButton的监听器
       private RushButtonListener rushButtonListener=new RushButtonListener();
       //关于在抢购窗口中JButton的list
       private static List<JButton>jButtonsInRush=new ArrayList<JButton>();
       //关于在抢购窗口中JTextField的list
       private static List<JTextField>jTextFieldsInRush=new ArrayList<JTextField>();
       //关于收益统计页面的JButton的list
       private static List<JButton>buttonsGroup=new ArrayList<JButton>(); 
       //关于收益统计页面下部的JPanel的
       private static JPanel investShowPanel=new JPanel();
       //关于收益按钮里的监听器
     private static ButtonsGroupListener buttonsGroupListener=new ButtonsGroupListener();
        //关于表格的监听器
     private static MyTableListener myTableListener=new MyTableListener();
     //窗口的大小和位置
     private static final int  WINDOW_X;
     private static final int  WINDOW_Y;
     private static final int  WINDOW_WIDTH;
     private static final int  WINDOW_HEIGHT;
     //选项卡大小和位置
     private static final int TAB_X;
     private static final int TAB_Y;
     private static final int TAB_WIDTH;
     private static final int TAB_HEIGHT;
     //陆金所页面上部大小和位置
     private static final int SELECTPART_X;
     private static final int SELECTPART_Y;
     private static final int SELECTPART_WIDTH;
     private static final int SELECTPART_HEIGHT;
     //陆金所页面中部大小和位置
     private static final int DETAILSPART_X;
     private static final int DETAILSPART_Y;
     private static final int DETAILSPART_WIDTH;
     private static final int DETAILSPART_HEIGHT;
     //陆金所页面下部大小和位置
     private static final int CHANGEPAGE_X;
     private static final int CHANGEPAGE_Y;
     private static final int CHANGEPAGE_WIDTH;
     private static final int CHANGEPAGE_HEIGHT;
     //显示项目的行数
     private static final int MAX_LINE_SIZE=10;
     //抢购对话框的大小和位置
     private static final int RUSHPART_X;
     private static final int RUSHPART_Y;
     private static final int RUSHPART_WIDTH;
     private static final int RUSHPART_HEIGHT;
     //收益统计上部按钮的大小和位置
     private static final int INVESTBUTTON_X;
     private static final int INVESTBUTTON_Y;
     private static final int INVESTBUTTON_WIDTH;
     private static final int INVESTBUTTON_HEIGHT;
     //收益统计中部的大小和位置
     private static final int INVESTTABLE_X;
     private static final int INVESTTABLE_Y;
     private static final int INVESTTABLE_WIDTH;
     private static final int INVESTTABLE_HEIGHT;
     //收益统计下部的大小和位置
     private static final int SHOWPART_X;
     private static final int SHOWPART_Y;
     private static final int SHOWPART_WIDTH;
     private static final int SHOWPART_HEIGHT;
     static{
    	 //窗口大小
    	 WINDOW_WIDTH=Toolkit.getDefaultToolkit().getScreenSize().width/2+120;
    	 WINDOW_HEIGHT=Toolkit.getDefaultToolkit().getScreenSize().height/2+120;
    	 WINDOW_X=WINDOW_WIDTH/2-100;
    	 WINDOW_Y=WINDOW_HEIGHT/2-100;
    	 //选项卡大小
    	 TAB_WIDTH=WINDOW_WIDTH;
    	 TAB_HEIGHT=WINDOW_HEIGHT;
    	 TAB_X=0;
    	 TAB_Y=0;
    	 //陆金所页面上部大小和位置
    	 SELECTPART_X=0;
    	 SELECTPART_Y=0;
    	 SELECTPART_HEIGHT=(int)(WINDOW_HEIGHT*(3/(10.0)));
    	 SELECTPART_WIDTH=WINDOW_WIDTH;
    	 //陆金所页面中部大小和位置
    	 DETAILSPART_X=0;
    	 DETAILSPART_Y=SELECTPART_HEIGHT;
    	 DETAILSPART_WIDTH=WINDOW_WIDTH;
    	 DETAILSPART_HEIGHT=(int)(WINDOW_HEIGHT*(6/10.0));
    	 //陆金所页面下部大小和位置
    	 CHANGEPAGE_X=0;
    	 CHANGEPAGE_Y=SELECTPART_HEIGHT+DETAILSPART_HEIGHT;
    	 CHANGEPAGE_WIDTH=WINDOW_WIDTH;
    	 CHANGEPAGE_HEIGHT=(int)(WINDOW_HEIGHT*(1/10.0));
    	 //抢购对话框的大小和位置的设置
    	 RUSHPART_X=WINDOW_X;
    	 RUSHPART_Y=WINDOW_Y;
    	 RUSHPART_WIDTH=WINDOW_WIDTH/3;
    	 RUSHPART_HEIGHT=WINDOW_HEIGHT/3;
         //收益统计模块上部大小和位置
    	 INVESTBUTTON_X=0;
    	 INVESTBUTTON_Y=0;
    	 INVESTBUTTON_WIDTH=WINDOW_X;
    	 INVESTBUTTON_HEIGHT=(int)(WINDOW_HEIGHT*(2/10.0));
    	 //收益统计模块中部大小和位置
    	 INVESTTABLE_X=0;
    	 INVESTTABLE_Y=0;
    	 INVESTTABLE_WIDTH=WINDOW_WIDTH;
    	 INVESTTABLE_HEIGHT=(int)(WINDOW_HEIGHT*(4/10.0));
         //收益统计模块下部大小和位置
    	 SHOWPART_X=0;
    	 SHOWPART_Y=0;
    	 SHOWPART_WIDTH=WINDOW_WIDTH;
    	 SHOWPART_HEIGHT=(int)(WINDOW_HEIGHT*(4/10.0));
     }
     private void initView()
     {
    	 window.setBounds(WINDOW_X,WINDOW_Y,WINDOW_WIDTH+20,WINDOW_HEIGHT+50);
         window.setLayout(null);
         window.getContentPane().setBackground(Color.WHITE);
         
         tab=new JTabbedPane();
         tab.setBounds(TAB_X,TAB_Y,TAB_WIDTH,TAB_HEIGHT);
         //绘制第一个tab（平安陆金所）的布局 
         drawFirstTabbedPane();
         
         
         drawSecondTabbedPane();
//      
//         
         
         window.add(tab);
         window.setVisible(true);
         window.setResizable(false);
         
     }
     
     public static void main(String args[])throws IOException
     {
    	 MainWindow app=new MainWindow() ;
    	 app.initView();
    	  productDetails=FilterProducts.getFilterContents(currentPage,minPrice,maxPrice,
    			  minDays,maxDays,minRate,maxRate);
        updateLabels();
     }
     //绘制陆金所页面
  void drawFirstTabbedPane()
  {
	  Box firstTabbedPane=Box.createVerticalBox();
	  //绘制陆金所页面的上部
	  drawFirstTop(firstTabbedPane);
	  //绘制陆金所页面的中部
	  drawFirstMiddle(firstTabbedPane);
//	  //绘制陆金所页面的下部
	  drawFirstBottom(firstTabbedPane);
	  tab.add("陆金所：p2p",firstTabbedPane);
     
  }
  void drawSecondTabbedPane()
  {
	  Box secondTabbedPane=Box.createVerticalBox();
	  //绘制按钮部分;
	  
	 Box investButtonPane=Box.createHorizontalBox();
	 secondTabbedPane.add(investButtonPane);
	  addButtonsGroupInInvestPane(investButtonPane,"导入","导出","增加","删除","收益统计图","投资统计图","收益统计图");
      secondTabbedPane.add(investButtonPane);
	   //绘制表格部分；
       JScrollPane investPane=new JScrollPane();
       investPane.getViewport().setLayout(null);
       investPane.getViewport().setBackground(Color.WHITE);
       investTable=createTable();
       investPane.getViewport().add(investTable);
       secondTabbedPane.add(investPane);
       
	  //绘制图表部分;
       investShowPanel.setBounds(SHOWPART_X,SHOWPART_Y,SHOWPART_WIDTH,SHOWPART_HEIGHT);
       investShowPanel.setBackground(Color.WHITE);
       
  }
     void addButtonsGroupInInvestPane(Box box,String ...names)
     {
    	for(int i=0;i<names.length;i++)
    	{ JButton button= new JButton(names[i]);
   	  button.addActionListener(buttonsGroupListener);
   	  buttonsGroup.add(button);
   	  box.add(button);
   	  }
     }
     private static JTable createTable()
     {
         Object title[]=new Object[]{"日期","操作","金额","日期编号"};
         mTableModel=new DefaultTableModel(null,title);
     	 mTableModel.addActionListener(myTableModelListener);
    	 investTable=new JTable(mTableModel);
    	 investTable.setBounds(INVESTTABLE_X,INVESTTABLE_Y,INVESTTABLE_WIDTH,INVESTTABLE_HEIGHT);
    	 return investTable;
     }
   	 
    	 
     }
     void drawFirstTop(Box box)
     {
   
    	 Box selectPart=Box.createVerticalBox();
    	 //对BOX对象设置大小
    	 selectPart.setBounds(SELECTPART_X,SELECTPART_Y,SELECTPART_WIDTH,SELECTPART_HEIGHT);
    	 //创建投资期限筛选面板
    	 JPanel selectByInvestPeriod=new JPanel();
    	 selectByInvestPeriod.setLayout(new FlowLayout(FlowLayout.LEFT));
    	 selectByInvestPeriod.setBackground(Color.WHITE);
    	 addChoice(1,selectByInvestPeriod,"投资期限:","不限","12个月以下","12~18个月","18~24个月","24个月以上");
    	 selectPart.add(selectByInvestPeriod);
    	 //创建投资金额筛选面板
    	 JPanel selectByProductAmount=new JPanel();
    	 selectByProductAmount.setLayout(new FlowLayout(FlowLayout.LEFT));
    	 selectByProductAmount.setBackground(Color.WHITE);
    	 addChoice(2,selectByProductAmount,"投资金额:","不限","5千以下","5千~1万","1万~3万","3万以上");
    	 selectPart.add(selectByProductAmount);
    	 //创建收益率筛选面板
    	 JPanel selectByInterestRate=new JPanel();
    	 selectByInterestRate.setLayout(new FlowLayout(FlowLayout.LEFT));
    	 selectByInterestRate.setBackground(Color.WHITE);
    	 addChoice(3,selectByInterestRate,"收益率：");
    	 selectPart.add(selectByInterestRate);
    	 //创建抢购和筛选按钮
    	 JPanel selectButtonPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
    	 JButton rushButton=new JButton("抢购");
    	 JButton selectButton=new JButton("筛选");
    	 jButtons.add(selectButton);
    	 selectButtonPanel.add(selectButton);
    	 selectButton.addActionListener(jButtonsListener);
    	 selectButtonPanel.add(rushButton);
    	 rushButton.addActionListener(jButtonsListener);
    	 jButtons.add(rushButton);
    	 selectPart.add(selectButtonPanel);
    	
    	 box.add(selectPart);
     }
     /**
      * 为每一个筛选属性添加子选项
      * @param flag  筛选属性的标识
      * @param jPanel 面板的标识
      * @param Names 子选项名的名称
      */
     private void addChoice(int flag,JPanel jPanel,String ...Names)
     {ButtonGroup buttonGroup=new ButtonGroup();
     jPanel.add(new JLabel(Names[0]));
     for(int i=1;i<Names.length;i++)
     {
        JRadioButton investPeriodButton=new JRadioButton(Names[i]);
        investPeriodButton.setBackground(Color.WHITE);
        investPeriodButton.addActionListener(jRadioButtonListener);
        if(i==1)
        	investPeriodButton.setSelected(true);
        jRadioButtons.add(investPeriodButton); 
       buttonGroup.add(investPeriodButton);
       jPanel.add(investPeriodButton);
        
     }
     switch(flag)
     {
     case 1:
    	 jPanel.add(minPeriodField);
    	 jPanel.add(new JLabel("个月-"));
    	 jPanel.add(maxPeriodField);
    	 jPanel.add(new JLabel("个月"));
    	 break;
     case 2:
    	 jPanel.add(minPriceField);
    	 jPanel.add(new JLabel("万元-"));
    	 jPanel.add(maxPriceField);
    	 jPanel.add(new JLabel("万元"));
         break;    
     case 3:
    	 jPanel.add(minRateField);
    	 jPanel.add(new JLabel("%-"));
    	 jPanel.add(maxRateField);
    	 jPanel.add(new JLabel("%"));
      break;
      default:
    	  break;
     }
   
     }
     //陆金所页面的中部
     void drawFirstMiddle(Box box)
     {   Box detailsPart=Box.createVerticalBox();
     detailsPart.setBounds(DETAILSPART_X,DETAILSPART_Y,DETAILSPART_WIDTH,DETAILSPART_HEIGHT);
    	 JPanel detailsPanel=new JPanel();
    	 detailsPanel.setBackground(Color.WHITE);
    	 GridBagLayout gb=new GridBagLayout();
    	 detailsPanel.setLayout(gb);
    	 GridBagConstraints gbc=new GridBagConstraints();
    	 //添加布局
    	 addDetailSubView(detailsPanel,gb,gbc);
         //更新（显示）初始标签
    	 updateLabels();
    	 detailsPart.add(detailsPanel);
    	 box.add(detailsPart);
     } 
     void addDetailSubView(JPanel jPanel,GridBagLayout gb, GridBagConstraints gbc)
     {  gbc.weightx=1;
        gbc.fill=GridBagConstraints.NONE;
        gbc.anchor=GridBagConstraints.WEST;
        gbc.gridx=0;
        gbc.gridy=0;
        JLabel nameLabel=new JLabel("项目名");
        jPanel.add(nameLabel, gbc);
        gbc.gridx=1;
        gbc.gridy=0;
        JLabel amountLabel=new JLabel("投资价格");
        jPanel.add(amountLabel, gbc);
    	gbc.gridx=2;
    	gbc.gridy=0;
    	JLabel periodLabel=new JLabel("投资期限");
    	jPanel.add(periodLabel, gbc);
    	gbc.gridx=3;
    	gbc.gridy=0;
    	JLabel rateLabel=new JLabel("收益率");
    	jPanel.add(rateLabel, gbc);
    	for(int line=0;line<MAX_LINE_SIZE;line++)
    	{	JLabel productName=new JLabel();
    	    JLabel productAmount=new JLabel();
    	    JLabel interestRate=new JLabel();
    	    JLabel investPeriod=new JLabel();
    	    gbc.gridx=0;
    	    gbc.gridy=line%MAX_LINE_SIZE+1;
    	    jPanel.add(productName, gbc);
    	    jLabels.add(productName);
    	    gbc.gridx=1;
    	    gbc.gridy=line%MAX_LINE_SIZE+1;
    	    jPanel.add(productAmount, gbc);
    	    jLabels.add(productAmount);
    	    gbc.gridx=2;
    	    gbc.gridy=line%MAX_LINE_SIZE+1;
    	    jPanel.add(interestRate, gbc);
    	    jLabels.add(interestRate);
    	    gbc.gridx=3;
    	    gbc.gridy=line%MAX_LINE_SIZE+1;
    	    jPanel.add(investPeriod,gbc);
    	    jLabels.add(investPeriod);
    	    gbc.gridx=4;
    	    gbc.gridy=line%MAX_LINE_SIZE+1;
            JButton investbutton=new JButton("投资");
            jButtons.add(investbutton);
    	     investbutton.addActionListener(jButtonsListener);
    	     jPanel.add(investbutton, gbc);
    	}
    	
     }
     //绘制陆金所的下部
     void drawFirstBottom(Box box)
     {
    	 JPanel pagePanel=new JPanel();
    	 pagePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
    	 JButton previousButton=new JButton("上一页");
    	 previousButton.addActionListener(jButtonsListener);
    	 jButtons.add(previousButton);
    	 pagePanel.add(previousButton);
    	 JButton nextButton=new JButton("下一页");
    	 nextButton.addActionListener(jButtonsListener);
    	 jButtons.add(nextButton);
    	 pagePanel.add(nextButton);
    	 box.add(pagePanel);
     }
     //所有按钮的监听器
     public class JButtonsListener implements ActionListener
     {
    	 public void actionPerformed(ActionEvent e)
    	 {
    		    int id;
    		    String name;
    		    switch( id=jButtons.indexOf((JButton)e.getSource())){
    		    case 0:
    		            
    		    		productDetails.clear();
    		    		currentPage=1;
    		    	//检测文本框里的输入是否合法
    		    	if(!minPeriodField.getText().equals(""))
    		    	{
    		    		minDays=Integer.parseInt(minPeriodField.getText());
    		    	}
    		    	if(!maxPeriodField.getText().equals(""))
    		    	{
    		    		maxDays=Integer.parseInt(maxPeriodField.getText());
    		    	}
    		    	if(!minPriceField.getText().equals(""))
    		    	{
    		    		minPrice=Integer.parseInt(minPriceField.getText());
    		    	}
    		    	if(!maxPriceField.getText().equals(""))
    		    	{
    		    		maxPrice=Integer.parseInt(maxPriceField.getText());
    		    	}
    		    	if(!minRateField.getText().equals(""))
    		    	{
    		    		minRate=Double.parseDouble(minRateField.getText());   		
    		    	}
    		    	if(!maxRateField.getText().equals(""))
    		    	{
    		    		maxRate=Double.parseDouble(maxRateField.getText());
    		    	}
    		    	try{
    		    	
    		    	productDetails=FilterProducts.getFilterContents(currentPage,minPrice,maxPrice,
    		    			minDays,maxDays,minRate,maxRate);
    		    	printAll(productDetails);
    		    	updateLabels();
    		    	}
    		    	catch(IOException e1)
    		    	{
    		    		System.out.println("数据获取失败！");
    		    	}
    		    	break;		    	
    		    case 1:
    		    	showRushDialog();
    		    	break;
    		    case 2:
    		    name=jLabels.get(4*0).getText();
    		    	goToWebSite(name);
    		    	break;
    		    case 3:
    		    name=jLabels.get(4*1).getText();
    		    	goToWebSite(name);
    		    	break;
    		    case 4:
    		    	 name=jLabels.get(4*2).getText();
    		    	goToWebSite(name);
    		    	break;
    		    case 5:
    		    	 name=jLabels.get(4*3).getText();
    		    	goToWebSite(name);
    		    	break;
    		    case 6:
    		    name=jLabels.get(4*4).getText();
    		    	goToWebSite(name);
    		    	break;
    		    case 7:
    		    	 name=jLabels.get(4*5).getText();
    		    	goToWebSite(name);
    		    	break;
    		    case 8:
    		    	 name=jLabels.get(4*6).getText();
    		    	goToWebSite(name);
    		    	break;
    		    case 9:
    		    	 name=jLabels.get(4*7).getText();
    		    	goToWebSite(name);
    		    	break;
    		    case 10:
    		    name=jLabels.get(4*8).getText();
    		    	goToWebSite(name);
    		    	break;
    		    case 11:
    		    	 name=jLabels.get(4*9).getText();
    		    	goToWebSite(name);
    		    	break;
    		    case 12:
    		    	currentPage=currentPage>1?currentPage--:1;
    		    	try{
    		    		productDetails.clear();
    		    		productDetails=FilterProducts.getFilterContents(currentPage,minPrice,maxPrice,
    		    				minDays,maxDays,minRate,maxRate);
    		   
    		    	}
    		    	catch(IOException e2)
    		    	{
    		    		System.out.println("获取数据失败！");
    		    	}
    		    	if(productDetails.size()==0)
    		    	{
    		    		jButtons.get(13).setEnabled(false);
    		    	}
    		    	else
    		    	updateLabels();
    		    	break;
    		    case 13:
    		    	++currentPage;
    		    	try{
    		    		productDetails.clear();
    		    		productDetails=FilterProducts.getFilterContents(currentPage,minPrice,maxPrice,
    		    				minDays,maxDays,minRate,maxRate);
    		   
    		    	}
    		    	catch(IOException e2)
    		    	{
    		    		System.out.println("获取数据失败！");
    		    	}
    		    	if(productDetails.size()==0)
    		    	{
    		    		jButtons.get(13).setEnabled(false);
    		    	}
    		    	else
    		    		printAll(productDetails);
    		    		updateLabels();
    		    	updateLabels();
    		    	break;
    		    	default:
    		    	break;}
    	 }
    		    	
    	 }
     
    
     //管理收益按钮的监听器
     public class ButtonsGroupListener implements ActionListener{
    	    
    	 
     }
      //表格的监听器
     public class MyTableListener implements ActionListener
     {
    	public void actionPerformed(ActionEvent e)
    	{  int id;
    		switch( id=buttonsGroup.indexOf((JButton)e.getSource())
    		{case 0:
    			FileDialog fileImportDialog=new FileDialog(window,"请选择你要导入的文件",FileDialog.LOAD);
              fileImportDialog.setVisible(true);
    			String selectedFile=fileImportDialog.getDirectory()+fileImportDialog.getFile();
    			try 
    			{
    			
    			}
    		
    	}
     }
     
     //复选按钮的监听器
public static class MyJRadioButtonsListener implements ActionListener
   {
	   public void actionPerformed(ActionEvent e)
	   {  int id;
	     switch(id=jRadioButtons.indexOf((JRadioButton)e.getSource()))
	   { case 0:
		   minDays=0;
		   maxDays=0;
		   break;
	   case 1:
		   minDays=0;
		   maxDays=360;
		   break;
	   case 2:
	       minDays=360;
		   maxDays=540;
		   break;
	   case 3:
		   minDays=540;
	       maxDays=720;
	       break;
	   case 4:
		   minDays=720;
		   maxDays=0;
		   break;
	   case 5:
		   minPrice=0;
		   maxPrice=0;
		   break;
	   case 6:
		   minPrice=0;
		   maxPrice=5000;
		   break;
	   case 7:
		   minPrice=5000;
		   maxPrice=10000;
		   break;
	   case 8:
		   minPrice=10000;
		   maxPrice=30000;
		   break;
	   case 9:
		   minPrice=30000;
		   maxPrice=0;
		   break;
	 default:
			   break;
			   }
	   
	   
	   }
   }
private static void updateLabels()
{  //更新获取的项目信息
	 if(productDetails.size()==0)
		 for(int line =0;line<MAX_LINE_SIZE;line++)
		 {
			 jLabels.get(4*line).setText("");
			 jLabels.get(4*line+1).setText("");
			 jLabels.get(4*line+2).setText("");
		     jLabels.get(4*line+3).setText("");
		     jButtons.get(line+2).setVisible(false);
		 }
	 else

	 for(int line=0;line<MAX_LINE_SIZE;line++)
		{ProductDetail  productDetail = productDetails.get(line);
	   jLabels.get(4*line).setText(productDetail.getProductName());
	   jLabels.get(line*4+1).setText(productDetail.getMinimumMoney());
	   jLabels.get(line*4+2).setText(productDetail.getInvestPeriod());
	   jLabels.get(line*4+3).setText(productDetail.getInterestRate());
	   jButtons.get(line+2).setVisible(true);
}
}
 private void goToWebSite(String name)
   {     for(ProductDetail i:productDetails)
	    try{
	    	if(name==i.getProductName())
	    	 Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+"https://list.lu.com/list/"+i.getProductId());
	     }
	catch(IOException e1)
	{
		System.out.println("网页获取失败！");
	}
	
   }
   private void showRushDialog()
	{
		Dialog dialog=new Dialog(window,"请设置抢购条件",true);
	    dialog.setBounds(RUSHPART_X,RUSHPART_Y,RUSHPART_WIDTH,RUSHPART_HEIGHT); 
	    dialog.addWindowListener(new WindowAdapter(){
	    public void windowClosing(WindowEvent e)
	    {
	    	dialog.dispose();
	    }
	    });
		Box dialogBox=Box.createVerticalBox();
	     JPanel pricePanelInRush=new JPanel(new FlowLayout(FlowLayout.LEFT));
	     JPanel periodPanelInRush=new JPanel(new FlowLayout(FlowLayout.LEFT));
	     JPanel ratePanelInRush=new JPanel(new FlowLayout(FlowLayout.LEFT));
	     addPanelInRush(dialogBox,pricePanelInRush,"投资金额：","万元-","万元");
	     addPanelInRush(dialogBox,periodPanelInRush,"投资期限：","个月-","个月");
	     addPanelInRush(dialogBox,ratePanelInRush,"收益率: ","%-","%");
		  JButton rushButton=new JButton("开始抢购");
		  jButtonsInRush.add(rushButton);
		  dialogBox.add(rushButton);
		rushButton.addActionListener(rushButtonListener);
		dialog.add(dialogBox);
		dialog.setVisible(true);
	}
	 private void addPanelInRush(Box box,JPanel jPanel,String ...names)
	 {
		 JLabel jLabel1=new JLabel(names[0]);
		 JTextField jTextField1=new JTextField(4);
         jTextFieldsInRush.add(jTextField1);
		 JLabel jLabel2=new JLabel(names[1]);
		 JTextField jTextField2=new JTextField(4);
          jTextFieldsInRush.add(jTextField2);
		 JLabel jLabel3=new JLabel(names[2]);
        jPanel.add(jLabel1);
        jPanel.add(jTextField1);
        jPanel.add(jLabel2);
        jPanel.add(jTextField2);
        jPanel.add(jLabel3);
        box.add(jPanel);
	 }
	 
	 public  class RushButtonListener implements ActionListener
	 {
	         public void actionPerformed(ActionEvent e)
	         {
	        	 int id;
	        	 switch(id =jButtonsInRush.indexOf((JButton)e.getSource()))
	        	 {	case 0:
	        		String rushMinPrice=jTextFieldsInRush.get(0).getText();
	        		String rushMaxPrice=jTextFieldsInRush.get(1).getText();
	                String rushMinDay=jTextFieldsInRush.get(2).getText();
	                String rushMaxDay=jTextFieldsInRush.get(3).getText();
	                String rushMinRate=jTextFieldsInRush.get(4).getText();
	                String rushMaxRate=jTextFieldsInRush.get(5).getText();
	            Rush rush=new Rush(rushMinPrice,rushMaxPrice,rushMinDay,rushMaxDay,rushMinRate,rushMaxRate);
	                
	            rush.run();
	            break;
	        	 }
}
	 }
	 void printAll(List<ProductDetail> pd)
	 {  
		 for(int i=0;i<pd.size();i++)
		 { 
			 ProductDetail p=pd.get(i);
			 System.out.println(p.getProductName());
			 System.out.println(p.getMinimumMoney());
			 System.out.println(p.getInvestPeriod());	 
			 System.out.println(p.getInterestRate());
		 }
		 
	 }
	 
}