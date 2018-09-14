package com.team.util;
import jxl.Workbook;
import jxl.Sheet;
import com.team.investStatics.InvestRecord;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.IOException;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WritableCell;
import jxl.CellType;
import jxl.write.Label;
public class ExcelTools {
     //关于投资记录的list
	 private static List<InvestRecord>investRecords=new ArrayList<InvestRecord>();
	  //Excels中存储的列数
	  private static final int COLUMN_AMOUNT=4;
	  private static List<InvestRecord> readFromExcel(String filePath)throws BiffException,IOException
	  {
		  File targetFile=new File(filePath);
		  if(targetFile.exists()&&targetFile.isFile())
		  { //获取工作簿对象
			  Workbook document=Workbook.getWorkbook(targetFile);
			//获取工作薄对象里的工作表对象
			  Sheet sheet=document.getSheet(0);
			  int rows=sheet.getRows();
		  
		  for(int line=1;line <rows;line++)
		  {
			  InvestRecord record=new InvestRecord();
			  record.setDate(sheet.getCell(0,line).getContents());
	          record.setOperation(sheet.getCell(1,line).getContents());	
	          record.setAmounts(sheet.getCell(2,line).getContents());
	          record.setProductName(sheet.getCell(3,line).getContents());
		      investRecords.add(record);
		    }}
	  
	return investRecords;
	  }
	  private static void writeToExcel(String filePath,List<InvestRecord> investRecords)
	  throws BiffException,IOException,WriteException
	  {   
		  File targetFile=new File(filePath);
		  if(targetFile.exists()&&targetFile.isFile())
		  {
			  Workbook rDocument=Workbook.getWorkbook(targetFile);
			  WritableWorkbook wDocument=Workbook.createWorkbook(targetFile,rDocument);
			  WritableSheet wSheet=wDocument.getSheet(0);
			  int rows=wSheet.getRows();
			  for(int row=0;row<investRecords.size();row++)
			  {    
				  for(int col=0;col<COLUMN_AMOUNT;col++)
				  {
					  WritableCell wCell=wSheet.getWritableCell(col,row);
					  if(wCell.getType()==CellType.LABEL)
					  {
						  Label label=(Label)wCell;
					    switch (col)
					    {
					    case 0:
					    	label.setString(investRecords.get(row).getDate());
					    	break;
					    case 1:
					    	label.setString(investRecords.get(row).getOperation());
					    	break;
					    case 2:
					    	label.setString(investRecords.get(row).getAmounts());
					    case 3:
					    	label.setString(investRecords.get(row).getProductName());
					    }
					  }
					  
				  }
				  
			  }
			  wDocument.write();
			  wDocument.close();
			  rDocument.close();
		  }
		  
	  }
}
