package Test.java.TestCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFHyperlink;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Hyperlink;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFHyperlink;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import Test.java.MasterClsPkg.MasterActions;
import Test.java.ExcelReaderCls.ExcelSheetReader;
import Test.java.MasterClsPkg.MasterActions;
import Test.java.MasterClsPkg.executionReport;
import Test.java.MasterClsPkg.screnshotcls;




import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import Test.java.TestCases.*;

import Test.java.Connection1.*;
import Test.java.MasterClsPkg.screnshotcls;
import Test.java.Connection1.ScriptRunner;
import Test.java.TestCases.*;
//import Test.java.ObjectRepository.*;
//import Test.java.Connection1.*;
import Test.java.MasterClsPkg.screnshotcls;
import org.testng.annotations.Test;
public class Medicopilot

{
	
	public static String IsNeedToRun2;
	public static String TestCaseName;
	public static int TestCaseStapeNo;
	public static String TestCaseStapeStatus="Pass";
	public String IsNeedToRun;
	public String IsNeedToRun1;
	public static String TestCasePriority;
	public static int ExecutionTestCaseNo;
	public static String TestCaseTitle;
	public static String FailedError;
	public static String parentWindowHandleq;
	public static String path;

	public static String MannualTestcase;
	static String SwitchCaseActionName1;
	
	
	@Test
	  public  void TestExample( ) throws Exception
	//public static void main(String[] args) throws Exception 
	{
		try
		{
			
	        String path1=new File(".").getAbsolutePath();
		    path1=path1.substring(0,path1.length()-2);
		    path=path1;
			String PropertiesFile =path+"\\src\\Test\\java\\ObjectRepository\\Medicopilot.properties";
			Properties prop=new Properties();
		    FileInputStream finp=new FileInputStream(PropertiesFile);
		    prop.load(finp); 
		    String workbookname=prop.getProperty("Workbookname");
		    String SheetName1=prop.getProperty("SheetName");
		    String DriverPath=prop.getProperty("DriverPath");
			path1=path1+workbookname;
			executionReport.reportHeader();
		    String WorkbookPath=path+workbookname; 
		    ExcelSheetReader workbook1=new ExcelSheetReader();
		    Sheet sh1=workbook1.getSheetName(WorkbookPath,SheetName1);
		    Row r1;
		    int k=sh1.getLastRowNum()-sh1.getFirstRowNum();
		    ExecutionTestCaseNo=0;
		     for (int i = 0; i <= k; i++) 
			{
				Medicopilot ecgms1=new Medicopilot();
				r1=sh1.getRow(i);
			
				
				ecgms1.IsNeedToRun=r1.getCell(1).toString();
				
				if(ecgms1.IsNeedToRun.equalsIgnoreCase("Y"))
				{
					
					ExecutionTestCaseNo=ExecutionTestCaseNo+1;
					System.out.println("ExecutionTest"+ExecutionTestCaseNo);
					
				}
				
			}
			int q=1;
			System.out.println("Execution Test Case No  ::"+Medicopilot.ExecutionTestCaseNo);
			//Above code give test case count(i.e ECGMS.ExecutionTestCaseNo) which to be execute	
			//Code to start execution of test case one by one.
		  
			for (int l = 1; l <=k; l++) 
			{
				int stepno=1;
				Medicopilot ecgms=new Medicopilot();
				//load row of "TestCaseSummry" sheet into r1
				r1=sh1.getRow(l);
				//take cell value in to "ecgms.IsNeedToRun" static string variable.
				ecgms.IsNeedToRun=r1.getCell(1).toString();
				if(ecgms.IsNeedToRun.equalsIgnoreCase("Y"))
				{WebDriver webDriver = null;
				System.out.println("df90"+k);
				Medicopilot.TestCaseName=r1.getCell(0).toString();
				System.out.println("TestcaseName"+Medicopilot.TestCaseName);
				System.out.println(ecgms.IsNeedToRun+"------------"+Medicopilot.TestCaseName);
				System.out.println("Path22"+path);	
				SwitchCaseActionName1=r1.getCell(2).toString();
				System.out.println("ds"+SwitchCaseActionName1);
				switch(SwitchCaseActionName1)
						{
				case "Chrome":
					{
						
						
						
					System.setProperty("webdriver.chrome.driver", path+DriverPath);
				
					 System.out.println("Path244"+path);
				
					 System.out.println("Path23"+path+DriverPath);
					 webDriver = new ChromeDriver(); 
					 System.out.println("Path2"+path);
					}
					break;
				case "IE":
				{
						System.setProperty("webdriver.chrome.driver", path+"DriverPath");
						
						DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
						caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
						caps.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
						//caps.setCapability(InternetExplorerDriver.FORCE_CREATE_PROCESS, true); 
						//caps.setCapability(InternetExplorerDriver.IE_SWITCHES, "-private");
						caps.setCapability("ignoreZoomSetting", true);
						caps.setCapability("ignoreProtectedModeSettings", true);
						caps.setPlatform(Platform.VISTA);
						caps.setCapability("nativeEvents", false);  
						
	

						 webDriver = new InternetExplorerDriver(caps); 
				}
						}

				System.out.print("Webdriver value1212121212");		
					 
					//Create object of ExcelSheetReader to get sheet
						ExcelSheetReader workbook=new ExcelSheetReader();
					//Loaded "Login" sheet to sh	
						
						Sheet sh=workbook.getSheetName(WorkbookPath,"Testcases");
						Row r; 
						int j=sh.getLastRowNum()-sh.getFirstRowNum();
						System.out.print("Webdriver value"+webDriver);
						MasterActions obj=new MasterActions(webDriver);
						
					
						try
						{	
							for(int i=1;i<=j;i++)		
							{
								MasterActions.TestCasePriorityRep=false;
								Medicopilot.TestCaseStapeNo=stepno;
								r=sh.getRow(i);
							
								//new code
								Medicopilot.TestCasePriority=r.getCell(9).toString();
							
								System.out.println("Start98"+i);
							
								if(r.getCell(0).toString().equalsIgnoreCase(Medicopilot.TestCaseName))
								{
								
									
									System.out.println("Start : ");
									System.out.print(r.getCell(3)+"--------"+r.getCell(4)+"-------"+r.getCell(6)+"--------"+r.getCell(7)+"-------"+r.getCell(8)+"--------"+r.getCell(9)+"--------"+r.getCell(10));
									
									System.out.println();
									Medicopilot.MannualTestcase=(r.getCell(11).toString());
							
									if(r.getCell(10).toString().equalsIgnoreCase("N"));
										{
											screnshotcls.screshotpath="";
										}
								
									//Code to call MasterAction method.
									obj.myAction(r.getCell(4).toString(), r.getCell(6).toString(),r.getCell(7).toString(), r.getCell(8).toString(),r.getCell(10).toString());
									
									
									//Code to call report function//Need durag's code
									//"   ::  Test Case Step no. is : "+
									System.out.println("Test Case Name : "+Medicopilot.TestCaseName+                 Medicopilot.TestCaseStapeNo+  "  :: Test Case Stape Status : "+Medicopilot.TestCaseStapeStatus + " :: Message "+ MasterActions.ExceptionMessage.toString()+"  :: screnshotc "+screnshotcls.screshotpath+ "Failed Details  :: "+MasterActions.ExceptionMessage);
									//Write Report
									
									String ReportFile=path+prop.getProperty("ResultReport");
								     int y=1;
										
										//if(1==y)
										//{//
											
											executionReport.executionReportDetails(ReportFile, q);
										
										q++;
										
										//}
									//String ReportFile="C:\\xl\\test1.xlsx";
									//executionReport.executionReportDetails(ReportFile, i);
								    
									//Code to get Test Case Title Name
									if(stepno==1)
										{
										Medicopilot.TestCaseTitle=r.getCell(1).toString();
										System.out.println("Test Case Title Name is :: "+Medicopilot.TestCaseTitle);
										}
								
									//Code to Decide stop test case execution based on Priority of test step
										if(MasterActions.TestCasePriorityRep==true)
										break;
										
										stepno=stepno+1;
									}
								
								}
							
							
							
						}
						
						
						catch(NoSuchElementException e)
							{
								
								 Runtime.getRuntime().exec("taskkill /F /IM IEDriverServer.exe");
								 System.out.println("Test Case Exception "+e.getMessage());
							}
							System.out.println("Done");
				
						
								
						
				}//1st if
				
			 }	//master for
			}catch(Exception e)
			{
				System.out.println(e);
				Runtime.getRuntime().exec("taskkill /F /IM IEDriverServer.exe");
			}
			//ReportFile.main(args);
		}
		
	}