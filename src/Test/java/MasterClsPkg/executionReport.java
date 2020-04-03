package Test.java.MasterClsPkg;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Hyperlink;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Test.java.TestCases.Medicopilot;

public class executionReport 

{
	public static void removeRow(HSSFSheet sheet, int rowIndex) 
{
	    int lastRowNum=sheet.getLastRowNum();
	    
	    System.out.println("last row"+lastRowNum);
	    if(rowIndex>=0&&rowIndex<lastRowNum){
	        sheet.shiftRows(rowIndex+1,lastRowNum, -1);
	    }
	    if(rowIndex==lastRowNum){
	        HSSFRow removingRow=sheet.getRow(rowIndex);
	        if(removingRow!=null){
	            sheet.removeRow(removingRow);
	        }
	    }
	}
	
	
	
	public static void reportHeader() throws IOException
{
String filename=Medicopilot.path+"\\xl\\ResultReport.xlsx";
		FileOutputStream fileOut=null;
		try
		{
  XSSFWorkbook book=new XSSFWorkbook();
  XSSFSheet sheet=book.createSheet("Report");
  XSSFRow rowhead=sheet.createRow(0);
  rowhead.createCell(0).setCellValue("Test case No");
  rowhead.createCell(1).setCellValue("Title");
  rowhead.createCell(2).setCellValue("Status");		
  rowhead.createCell(3).setCellValue("Screenshot");
  rowhead.createCell(4).setCellValue("TFS_TestCase_ID");
  fileOut = new FileOutputStream(filename);
  book.write(fileOut);
		}
		catch ( Exception ex ) 
		{
            System.out.println(ex);
		}
		finally
		{
			
			fileOut.close();
		}
		
		//addrows();
	}

	
	public static void executionReportDetails(String ReportFilePath,int TestCaseStepNo)
	{
	
	try
	{
	 // File dest=new File("C:\\xl\\test1.xlsx");
	  File dest=new File(ReportFilePath);
	
	  FileInputStream fin=new FileInputStream(dest);
	  
	  XSSFWorkbook mywb=new XSSFWorkbook(fin);
	
	  XSSFSheet mysh=mywb.getSheetAt(0);
	 
          XSSFRow row=mysh.createRow(TestCaseStepNo);
	  //Row myRow=mysh.getRow(i);
	  // HSSFHyperlink file_link=new HSSFHyperlink(HSSFHyperlink.LINK_FILE);
	  //XSSFHyperlink hlink=new HSSFHyperlink(HSSFHyperlink.LINK_FILE)
	   					  
	  row.createCell(0).setCellValue(Medicopilot.TestCaseName);
	  
	  row.createCell(1).setCellValue(Medicopilot.TestCaseStapeNo);
	 
	 row.createCell(2).setCellValue(Medicopilot.TestCaseStapeStatus); 
	 System.out.println("i m in fail12"+Medicopilot.TestCaseStapeNo);
	 
	
	  mysh.getRow(TestCaseStepNo).createCell(4).setCellValue(Medicopilot.FailedError);
	 // mysh.getRow(i).getCell(3).setCellValue(screnshotcls.screshotpath);
	  System.out.println("i m in fail12"+Medicopilot.FailedError);
	   CreationHelper createHelper = mywb.getCreationHelper();
	   CellStyle hlink_style = mywb.createCellStyle();
       Font hlink_font = mywb.createFont();
       hlink_font.setUnderline(Font.U_SINGLE);
       hlink_font.setColor(IndexedColors.BLUE.getIndex());
       hlink_style.setFont(hlink_font); 
	 // XSSFCell cell = mysh.createRow(1).createCell((short)0);
	   row.createCell(3).setCellValue("OpenSceenShot");
       Hyperlink link = createHelper.createHyperlink(Hyperlink.LINK_FILE);
       String path1=screnshotcls.screshotpath.replace('\\', '/');
       //System.out.println(screnshotcls.screshotpath);
       //System.out.println(path1);
       
       link.setAddress(path1);
       row.getCell(3).setHyperlink(link);
       row.getCell(3).setCellStyle(hlink_style);
       row.createCell(4).setCellValue(Medicopilot.MannualTestcase);
       System.out.println("i m in Mannaual Test case"+Medicopilot.MannualTestcase);
	   FileOutputStream fout=new  FileOutputStream(dest);
	   mywb.write(fout); 
	  
	}
	catch(NullPointerException e)
	{
		System.out.println("1 : while wrting to file : "+e);
	}
	catch(Exception e)
	{
		System.out.println("2 : while wrting to file : "+e);
	}
	
	}
}
