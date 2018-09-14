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
 * ������
 * @author hjm
 *
 */
public class MainWindow {
	//�в���������
     public static JFrame window=new JFrame("�в���");
    //�в��������
     private static JTabbedPane tab;
     //ƽ��½����ģ�����
     private static JPanel pingAn=new JPanel();
     //����ģ�����
     private static JPanel jingDong=new JPanel();
     //����ģ�����
     private static JPanel showPart= new JPanel();
     private static JLabel periodLabel=new JLabel("ʣ������");
     private static JLabel amountLabel=new JLabel("ת���۸�");
     private static JLabel productLabel=new JLabel("��Ŀ����");
     //Ͷ�����������
     JTextField minPeriodField=new JTextField(4);
     JTextField maxPeriodField=new JTextField(4);
     //ת���۸������
    JTextField minPriceField=new JTextField(4);
    JTextField maxPriceField=new JTextField(4);
    //�����������
      JTextField minRateField=new JTextField(4);
      JTextField maxRateField=new JTextField(4);
      //��Ŀ��Ϣ

      private static int minDays=0;
      private static int maxDays=0;
      private static int minPrice=0;
      private static int maxPrice=0;
      private static double minRate=0.0;
      private static double maxRate=0.0;
      //����һ�����JTable
      private static JTable investTable=new JTable();
      //����һ������ģ��
      private static DefaultTableModel mTableModel;
      //����ҳ��
      private static int currentPage=1;
      //һ��װ��Ŀ��Ϣ��ArrayList
      public static List<ProductDetail>productDetails=new ArrayList<ProductDetail>();
     //һ��JRadioButton��list
     private static ArrayList<JRadioButton>jRadioButtons=new ArrayList<JRadioButton>();
     //һ��JButton��list
     private static ArrayList<JButton>jButtons=new ArrayList<JButton>();
     //һ��JLabel��list
     private static ArrayList<JLabel>jLabels=new ArrayList<JLabel>();
     //һ����ʾ�������ݵ�jPanel
     private static JPanel investShowPart=new JPanel();
     //һ������JRadioButton�ļ�����
     private  static MyJRadioButtonsListener jRadioButtonListener=new MyJRadioButtonsListener();
     //һ������JButton�ļ�����
       private JButtonsListener jButtonsListener=new JButtonsListener();
       //һ����������JButton�ļ�����
       private RushButtonListener rushButtonListener=new RushButtonListener();
       //����������������JButton��list
       private static List<JButton>jButtonsInRush=new ArrayList<JButton>();
       //����������������JTextField��list
       private static List<JTextField>jTextFieldsInRush=new ArrayList<JTextField>();
       //��������ͳ��ҳ���JButton��list
       private static List<JButton>buttonsGroup=new ArrayList<JButton>(); 
       //��������ͳ��ҳ���²���JPanel��
       private static JPanel investShowPanel=new JPanel();
       //�������水ť��ļ�����
     private static ButtonsGroupListener buttonsGroupListener=new ButtonsGroupListener();
        //���ڱ��ļ�����
     private static MyTableListener myTableListener=new MyTableListener();
     //���ڵĴ�С��λ��
     private static final int  WINDOW_X;
     private static final int  WINDOW_Y;
     private static final int  WINDOW_WIDTH;
     private static final int  WINDOW_HEIGHT;
     //ѡ���С��λ��
     private static final int TAB_X;
     private static final int TAB_Y;
     private static final int TAB_WIDTH;
     private static final int TAB_HEIGHT;
     //½����ҳ���ϲ���С��λ��
     private static final int SELECTPART_X;
     private static final int SELECTPART_Y;
     private static final int SELECTPART_WIDTH;
     private static final int SELECTPART_HEIGHT;
     //½����ҳ���в���С��λ��
     private static final int DETAILSPART_X;
     private static final int DETAILSPART_Y;
     private static final int DETAILSPART_WIDTH;
     private static final int DETAILSPART_HEIGHT;
     //½����ҳ���²���С��λ��
     private static final int CHANGEPAGE_X;
     private static final int CHANGEPAGE_Y;
     private static final int CHANGEPAGE_WIDTH;
     private static final int CHANGEPAGE_HEIGHT;
     //��ʾ��Ŀ������
     private static final int MAX_LINE_SIZE=10;
     //�����Ի���Ĵ�С��λ��
     private static final int RUSHPART_X;
     private static final int RUSHPART_Y;
     private static final int RUSHPART_WIDTH;
     private static final int RUSHPART_HEIGHT;
     //����ͳ���ϲ���ť�Ĵ�С��λ��
     private static final int INVESTBUTTON_X;
     private static final int INVESTBUTTON_Y;
     private static final int INVESTBUTTON_WIDTH;
     private static final int INVESTBUTTON_HEIGHT;
     //����ͳ���в��Ĵ�С��λ��
     private static final int INVESTTABLE_X;
     private static final int INVESTTABLE_Y;
     private static final int INVESTTABLE_WIDTH;
     private static final int INVESTTABLE_HEIGHT;
     //����ͳ���²��Ĵ�С��λ��
     private static final int SHOWPART_X;
     private static final int SHOWPART_Y;
     private static final int SHOWPART_WIDTH;
     private static final int SHOWPART_HEIGHT;
     static{
    	 //���ڴ�С
    	 WINDOW_WIDTH=Toolkit.getDefaultToolkit().getScreenSize().width/2+120;
    	 WINDOW_HEIGHT=Toolkit.getDefaultToolkit().getScreenSize().height/2+120;
    	 WINDOW_X=WINDOW_WIDTH/2-100;
    	 WINDOW_Y=WINDOW_HEIGHT/2-100;
    	 //ѡ���С
    	 TAB_WIDTH=WINDOW_WIDTH;
    	 TAB_HEIGHT=WINDOW_HEIGHT;
    	 TAB_X=0;
    	 TAB_Y=0;
    	 //½����ҳ���ϲ���С��λ��
    	 SELECTPART_X=0;
    	 SELECTPART_Y=0;
    	 SELECTPART_HEIGHT=(int)(WINDOW_HEIGHT*(3/(10.0)));
    	 SELECTPART_WIDTH=WINDOW_WIDTH;
    	 //½����ҳ���в���С��λ��
    	 DETAILSPART_X=0;
    	 DETAILSPART_Y=SELECTPART_HEIGHT;
    	 DETAILSPART_WIDTH=WINDOW_WIDTH;
    	 DETAILSPART_HEIGHT=(int)(WINDOW_HEIGHT*(6/10.0));
    	 //½����ҳ���²���С��λ��
    	 CHANGEPAGE_X=0;
    	 CHANGEPAGE_Y=SELECTPART_HEIGHT+DETAILSPART_HEIGHT;
    	 CHANGEPAGE_WIDTH=WINDOW_WIDTH;
    	 CHANGEPAGE_HEIGHT=(int)(WINDOW_HEIGHT*(1/10.0));
    	 //�����Ի���Ĵ�С��λ�õ�����
    	 RUSHPART_X=WINDOW_X;
    	 RUSHPART_Y=WINDOW_Y;
    	 RUSHPART_WIDTH=WINDOW_WIDTH/3;
    	 RUSHPART_HEIGHT=WINDOW_HEIGHT/3;
         //����ͳ��ģ���ϲ���С��λ��
    	 INVESTBUTTON_X=0;
    	 INVESTBUTTON_Y=0;
    	 INVESTBUTTON_WIDTH=WINDOW_X;
    	 INVESTBUTTON_HEIGHT=(int)(WINDOW_HEIGHT*(2/10.0));
    	 //����ͳ��ģ���в���С��λ��
    	 INVESTTABLE_X=0;
    	 INVESTTABLE_Y=0;
    	 INVESTTABLE_WIDTH=WINDOW_WIDTH;
    	 INVESTTABLE_HEIGHT=(int)(WINDOW_HEIGHT*(4/10.0));
         //����ͳ��ģ���²���С��λ��
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
         //���Ƶ�һ��tab��ƽ��½�������Ĳ��� 
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
     //����½����ҳ��
  void drawFirstTabbedPane()
  {
	  Box firstTabbedPane=Box.createVerticalBox();
	  //����½����ҳ����ϲ�
	  drawFirstTop(firstTabbedPane);
	  //����½����ҳ����в�
	  drawFirstMiddle(firstTabbedPane);
//	  //����½����ҳ����²�
	  drawFirstBottom(firstTabbedPane);
	  tab.add("½������p2p",firstTabbedPane);
     
  }
  void drawSecondTabbedPane()
  {
	  Box secondTabbedPane=Box.createVerticalBox();
	  //���ư�ť����;
	  
	 Box investButtonPane=Box.createHorizontalBox();
	 secondTabbedPane.add(investButtonPane);
	  addButtonsGroupInInvestPane(investButtonPane,"����","����","����","ɾ��","����ͳ��ͼ","Ͷ��ͳ��ͼ","����ͳ��ͼ");
      secondTabbedPane.add(investButtonPane);
	   //���Ʊ�񲿷֣�
       JScrollPane investPane=new JScrollPane();
       investPane.getViewport().setLayout(null);
       investPane.getViewport().setBackground(Color.WHITE);
       investTable=createTable();
       investPane.getViewport().add(investTable);
       secondTabbedPane.add(investPane);
       
	  //����ͼ����;
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
         Object title[]=new Object[]{"����","����","���","���ڱ��"};
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
    	 //��BOX�������ô�С
    	 selectPart.setBounds(SELECTPART_X,SELECTPART_Y,SELECTPART_WIDTH,SELECTPART_HEIGHT);
    	 //����Ͷ������ɸѡ���
    	 JPanel selectByInvestPeriod=new JPanel();
    	 selectByInvestPeriod.setLayout(new FlowLayout(FlowLayout.LEFT));
    	 selectByInvestPeriod.setBackground(Color.WHITE);
    	 addChoice(1,selectByInvestPeriod,"Ͷ������:","����","12��������","12~18����","18~24����","24��������");
    	 selectPart.add(selectByInvestPeriod);
    	 //����Ͷ�ʽ��ɸѡ���
    	 JPanel selectByProductAmount=new JPanel();
    	 selectByProductAmount.setLayout(new FlowLayout(FlowLayout.LEFT));
    	 selectByProductAmount.setBackground(Color.WHITE);
    	 addChoice(2,selectByProductAmount,"Ͷ�ʽ��:","����","5ǧ����","5ǧ~1��","1��~3��","3������");
    	 selectPart.add(selectByProductAmount);
    	 //����������ɸѡ���
    	 JPanel selectByInterestRate=new JPanel();
    	 selectByInterestRate.setLayout(new FlowLayout(FlowLayout.LEFT));
    	 selectByInterestRate.setBackground(Color.WHITE);
    	 addChoice(3,selectByInterestRate,"�����ʣ�");
    	 selectPart.add(selectByInterestRate);
    	 //����������ɸѡ��ť
    	 JPanel selectButtonPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
    	 JButton rushButton=new JButton("����");
    	 JButton selectButton=new JButton("ɸѡ");
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
      * Ϊÿһ��ɸѡ���������ѡ��
      * @param flag  ɸѡ���Եı�ʶ
      * @param jPanel ���ı�ʶ
      * @param Names ��ѡ����������
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
    	 jPanel.add(new JLabel("����-"));
    	 jPanel.add(maxPeriodField);
    	 jPanel.add(new JLabel("����"));
    	 break;
     case 2:
    	 jPanel.add(minPriceField);
    	 jPanel.add(new JLabel("��Ԫ-"));
    	 jPanel.add(maxPriceField);
    	 jPanel.add(new JLabel("��Ԫ"));
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
     //½����ҳ����в�
     void drawFirstMiddle(Box box)
     {   Box detailsPart=Box.createVerticalBox();
     detailsPart.setBounds(DETAILSPART_X,DETAILSPART_Y,DETAILSPART_WIDTH,DETAILSPART_HEIGHT);
    	 JPanel detailsPanel=new JPanel();
    	 detailsPanel.setBackground(Color.WHITE);
    	 GridBagLayout gb=new GridBagLayout();
    	 detailsPanel.setLayout(gb);
    	 GridBagConstraints gbc=new GridBagConstraints();
    	 //��Ӳ���
    	 addDetailSubView(detailsPanel,gb,gbc);
         //���£���ʾ����ʼ��ǩ
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
        JLabel nameLabel=new JLabel("��Ŀ��");
        jPanel.add(nameLabel, gbc);
        gbc.gridx=1;
        gbc.gridy=0;
        JLabel amountLabel=new JLabel("Ͷ�ʼ۸�");
        jPanel.add(amountLabel, gbc);
    	gbc.gridx=2;
    	gbc.gridy=0;
    	JLabel periodLabel=new JLabel("Ͷ������");
    	jPanel.add(periodLabel, gbc);
    	gbc.gridx=3;
    	gbc.gridy=0;
    	JLabel rateLabel=new JLabel("������");
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
            JButton investbutton=new JButton("Ͷ��");
            jButtons.add(investbutton);
    	     investbutton.addActionListener(jButtonsListener);
    	     jPanel.add(investbutton, gbc);
    	}
    	
     }
     //����½�������²�
     void drawFirstBottom(Box box)
     {
    	 JPanel pagePanel=new JPanel();
    	 pagePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
    	 JButton previousButton=new JButton("��һҳ");
    	 previousButton.addActionListener(jButtonsListener);
    	 jButtons.add(previousButton);
    	 pagePanel.add(previousButton);
    	 JButton nextButton=new JButton("��һҳ");
    	 nextButton.addActionListener(jButtonsListener);
    	 jButtons.add(nextButton);
    	 pagePanel.add(nextButton);
    	 box.add(pagePanel);
     }
     //���а�ť�ļ�����
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
    		    	//����ı�����������Ƿ�Ϸ�
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
    		    		System.out.println("���ݻ�ȡʧ�ܣ�");
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
    		    		System.out.println("��ȡ����ʧ�ܣ�");
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
    		    		System.out.println("��ȡ����ʧ�ܣ�");
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
     
    
     //�������水ť�ļ�����
     public class ButtonsGroupListener implements ActionListener{
    	    
    	 
     }
      //���ļ�����
     public class MyTableListener implements ActionListener
     {
    	public void actionPerformed(ActionEvent e)
    	{  int id;
    		switch( id=buttonsGroup.indexOf((JButton)e.getSource())
    		{case 0:
    			FileDialog fileImportDialog=new FileDialog(window,"��ѡ����Ҫ������ļ�",FileDialog.LOAD);
              fileImportDialog.setVisible(true);
    			String selectedFile=fileImportDialog.getDirectory()+fileImportDialog.getFile();
    			try 
    			{
    			
    			}
    		
    	}
     }
     
     //��ѡ��ť�ļ�����
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
{  //���»�ȡ����Ŀ��Ϣ
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
		System.out.println("��ҳ��ȡʧ�ܣ�");
	}
	
   }
   private void showRushDialog()
	{
		Dialog dialog=new Dialog(window,"��������������",true);
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
	     addPanelInRush(dialogBox,pricePanelInRush,"Ͷ�ʽ�","��Ԫ-","��Ԫ");
	     addPanelInRush(dialogBox,periodPanelInRush,"Ͷ�����ޣ�","����-","����");
	     addPanelInRush(dialogBox,ratePanelInRush,"������: ","%-","%");
		  JButton rushButton=new JButton("��ʼ����");
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