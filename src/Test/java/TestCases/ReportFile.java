package Test.java.TestCases;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Test.java.ExcelReaderCls.*;

public class ReportFile {
	public static String path;
	Sheet f;
	XSSFSheet f1;
	int noofRows;
	int noofColumn,k=0;
	String Testcase=null;
	String title=null;
	String Status,TFS_testcaseID=null;
	XSSFWorkbook fw;
	
	public void CreateFinalReport() throws IOException
	{
		 String path1=new File(".").getAbsolutePath();
		  path1=path1.substring(0,path1.length()-2);
		  System.out.println("sdsdffdffd"+path1);
		  String PropertiesFile =path1+"\\src\\Test\\java\\ObjectRepository\\Healthview.properties";
			Properties prop=new Properties();
		    FileInputStream finp=new FileInputStream(PropertiesFile);
		    prop.load(finp); 
		 String ResultReport=prop.getProperty("ResultReport");
		 String ResultReport1=prop.getProperty("ResultReport1");
		 ResultReport=path1+ResultReport;
		 ResultReport1=path1+ResultReport1;
		System.out.println("sdsd"+ResultReport);
		System.out.println("sdsd"+ResultReport1);
		ExcelSheetReader reader=new ExcelSheetReader();
	//	FileInputStream fs=new FileInputStream("C:\\Users\\ankitas\\Desktop\\ResultReport.xlsx");
		File src=new File(ResultReport);
		File dest=new File(ResultReport1);
		FileUtils.copyFile(src,dest);	
		f=  reader.getSheetName(ResultReport1, "Report");
		//f1=reader.createSheet("C:\\Users\\ankitas\\Desktop\\ResultReport.xlsx", "FinalReport");
		FileInputStream fs=new FileInputStream(ResultReport);
		fw=new XSSFWorkbook(fs);
		XSSFSheet sh = fw.createSheet("FinalReport");
		//fs.close();
		
//	    //return sh;
//		FileOutputStream fout=new FileOutputStream("C:\\Users\\ankitas\\Desktop\\ResultReport.xlsx");
//			fw.write(fout);
//		//((FileOutputStream) this.f).write(fout);	
		
		noofRows=f.getLastRowNum()-f.getFirstRowNum();
		System.out.println("Hii");
		noofColumn=f.getRow(0).getPhysicalNumberOfCells();
		System.out.println("no of colummmmm"+noofColumn);
		for(int i=1;i<=noofRows;i++)
		{
			System.out.println("Hii");
			System.out.println(Testcase+TFS_testcaseID+Status);
			System.out.println((Testcase==null && TFS_testcaseID==null && Status==null)|| (!Testcase.equals(f.getRow(i).getCell(0).getStringCellValue())||  (!Status.equals(f.getRow(i).getCell(2).getStringCellValue())
								||(!TFS_testcaseID.equals(f.getRow(i).getCell(4).getStringCellValue())))));
				//Testcase=f.getRow(i).getCell(j).getStringCellValue();
				if((Testcase==null && TFS_testcaseID==null && Status==null)|| 
						(!Testcase.equals(f.getRow(i).getCell(0).getStringCellValue())
						|| (!Status.equals(f.getRow(i).getCell(2).getStringCellValue())
								||(!TFS_testcaseID.equals(f.getRow(i).getCell(4).getStringCellValue())))))
				  {
					if((Status!=null && !Status.equals(f.getRow(i).getCell(2).getStringCellValue())) && 
							(Testcase.equals(f.getRow(i).getCell(0).getStringCellValue())) 
						    &&  (TFS_testcaseID.equals(f.getRow(i).getCell(4).getStringCellValue())))
					{
						System.out.println("Hiiiii");
						Row row=sh.getRow(k);
						boolean b=((Status.equalsIgnoreCase("Fail")) || (f.getRow(i).getCell(2).getStringCellValue().equalsIgnoreCase("Failed")));
						if(b)
						{
							row.getCell(2).setCellValue("Fail");
						}  
						else
						{
						row.getCell(2).setCellValue("Pass");
						}
							Status=f.getRow(i).getCell(2).getStringCellValue();
					
						}
				  
					else
					{
						System.out.println("HiiiiiElse");
					System.out.println("k:"+k);
					k++;
					
					Row row=sh.createRow(k);
					System.out.println("Hii1");
					for(int j=0;j<noofColumn;j++)
					{
						Object o;
						if(f.getRow(i).getCell(j).getCellType()==0)
						{
							o=f.getRow(i).getCell(j).getNumericCellValue();
						
						}
						
						else
							o=f.getRow(i).getCell(j).getStringCellValue();
						System.out.println(o.toString());
			       row.createCell(j).setCellValue(o.toString());
			      
			     //  System.out.println("Hii12");
//			       Testcase=f.getRow(i).getCell(0).getStringCellValue();
//			       Status=f.getRow(i).getCell(2).getStringCellValue();
//			       TFS_testcaseID=f.getRow(i).getCell(4).getStringCellValue();
			       
					}
					
				       
				}
				  }		  		
				System.out.println(i);
				Testcase=f.getRow(i).getCell(0).getStringCellValue();
			       Status=f.getRow(i).getCell(2).getStringCellValue();
			       TFS_testcaseID=f.getRow(i).getCell(4).getStringCellValue();
			}

	  // fw.write(fout);
		fs.close();
		
//	    //return sh;
		FileOutputStream fout=new FileOutputStream(ResultReport);
			fw.write(fout);
	   
	}
	public static void main(String args[])  
	{
		ReportFile f=new ReportFile();
		try {
			f.CreateFinalReport();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	}
	

