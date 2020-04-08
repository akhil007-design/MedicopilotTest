package Test.java.TestCases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Test.java.MasterClsPkg.MasterActions;
import Test.java.ExcelReaderCls.ExcelSheetReader;
import Test.java.MasterClsPkg.MasterActions;
import Test.java.MasterClsPkg.executionReport;
import Test.java.MasterClsPkg.screnshotcls;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Hashtable;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
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
public class Dataprovider1
{
	

	public static String path;
	public static int ExecutionTestCaseNo;
	public String TestcaseID;
	public String TestcaseStatus;
	public String Broswer;
	public static String SwitchCaseActionName1;

	
	@Test(dataProvider="getData")
    public void instanceDbProvider(Hashtable<String,String> myData1) throws Exception 
	{
		
		String path1=new File(".").getAbsolutePath();
   	     path1=path1.substring(0,path1.length()-2);
		 path=path1;
		 String PropertiesFile =path+"\\src\\Test\\java\\ObjectRepository\\Medicopilot.properties";
		 Properties prop=new Properties();
		 FileInputStream finp=new FileInputStream(PropertiesFile);
	     prop.load(finp);
		 String DriverPath=prop.getProperty("DriverPath");
		 System.out.println("Value of path in Test "+path);
		String TestCase = myData1.get("TestCase");
		String RunStatus= myData1.get("RunStatus");
		String Browser1 = myData1.get("Browser");
		System.out.println(TestCase);
		System.out.println(RunStatus);
		System.out.println(Browser1);
        
	    System.out.println("Driver path for azure"+DriverPath);
	    
	    
					if(RunStatus.equalsIgnoreCase("Y"))
					{WebDriver webDriver = null;
					int q=1;
					System.out.println("final2hkh");
					Medicopilot.TestCaseName=TestCase;
					System.out.println("TestcaseName"+Medicopilot.TestCaseName);
					System.out.println(RunStatus+"------------"+Medicopilot.TestCaseName);
					System.out.println("Path22"+path);
					System.out.println("final3");
					SwitchCaseActionName1=Browser1;
					System.out.println("ds"+SwitchCaseActionName1);
					switch(SwitchCaseActionName1)
							{
					case "Chrome":
						{	
							System.out.println("Driver path for azure"+DriverPath);
						System.setProperty("webdriver.chrome.driver",path+DriverPath);
						webDriver = new ChromeDriver();  
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
					break;
					case "Mozilla":
					{
						System.setProperty("webdriver.gecko.driver",  path+"DriverPath");
						DesiredCapabilities capabilities = DesiredCapabilities.firefox(); 
				       //capabilities.setCapability("browser.privatebrowsing.autostart", true); 
				        FirefoxProfile firefoxProfile = new FirefoxProfile();   
				        firefoxProfile.setPreference("browser.privatebrowsing.autostart", false);
						System.out.println("Path2yyy2");
						webDriver=new FirefoxDriver(capabilities);
						webDriver.manage().timeouts().pageLoadTimeout(155, TimeUnit.SECONDS);
						  
					}
					break;
							} 
					    ExcelSheetReader workbook=new ExcelSheetReader();
					    System.out.println("final5");
						Sheet sh=workbook.getSheetName("C:\\Users\\akhils\\workspace\\MedicalCopilot\\Workbook\\HV_TestCases_Selenium.xlsx","Testcases");
						Row r; 
						int j=sh.getLastRowNum()-sh.getFirstRowNum();
						System.out.print("Webdriver value"+webDriver);
						MasterActions obj=new MasterActions(webDriver);
						System.out.println("finalsakhishet"+j);
						try
						{	
							for(int i=1;i<=j;i++)		
							{
								int stepno=1;
								MasterActions.TestCasePriorityRep=false;
								Medicopilot.TestCaseStapeNo=stepno;
								r=sh.getRow(i);
							
								//new code
								Medicopilot.TestCasePriority=r.getCell(9).toString();
							
								System.out.println("Start98"+i);
							
								if(r.getCell(0).toString().equalsIgnoreCase(Medicopilot.TestCaseName))
								{
									//System.out.println("Start : ");
									System.out.print(r.getCell(3)+"--------"+r.getCell(4)+"-------"+r.getCell(6)+"--------"+r.getCell(7)+"-------"+r.getCell(8)+"--------"+r.getCell(9)+"--------"+r.getCell(10));
									System.out.println("Demo1 cell vcalue");
									System.out.println("Demo1 cell vcalue"+r.getCell(3));
									Medicopilot.MannualTestcase=(r.getCell(11).toString());
									System.out.println("Demo2");
									if(r.getCell(10).toString().equalsIgnoreCase("N"));
										{
											screnshotcls.screshotpath="";
										}
										System.out.println("Demo3");
									//Code to call MasterAction method.
									obj.myAction(r.getCell(4).toString(), r.getCell(6).toString(),r.getCell(7).toString(), r.getCell(8).toString(),r.getCell(10).toString());
									//Code to call report function//Need durag's code
									//"   ::  Test Case Step no. is : "+
									System.out.println("Test Case Name : "+Medicopilot.TestCaseName+                 Medicopilot.TestCaseStapeNo+  "  :: Test Case Stape Status : "+Medicopilot.TestCaseStapeStatus + " :: Message "+ MasterActions.ExceptionMessage.toString()+"  :: screnshotc "+screnshotcls.screshotpath+ "Failed Details  :: "+MasterActions.ExceptionMessage);
									//Write Report
									//String ReportFile=path+prop.getProperty("ResultReport");
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
				
		
					}
	}
    @DataProvider
    public  Object[][] getData() throws IOException {
    	
        Object[][] myData = new Object[35][1];
    	try
		{
    	 String path1=new File(".").getAbsolutePath();
    	 path1=path1.substring(0,path1.length()-2);
		 path=path1;
		 System.out.println("Value of "+path);
		 String PropertiesFile =path+"\\src\\Test\\java\\ObjectRepository\\Medicopilot.properties";
		 Properties prop=new Properties();
		 FileInputStream finp=new FileInputStream(PropertiesFile);
	     prop.load(finp); 
	     String workbookname=prop.getProperty("Workbookname");
   	     String SheetName1=prop.getProperty("SheetName");
		    //String DriverPath=prop.getProperty("DriverPath");
			path1=path1+workbookname;
			//executionReport.reportHeader();
		    String WorkbookPath=path+workbookname;
		    ExcelSheetReader workbook1=new ExcelSheetReader();
		    System.out.println("Value of kkkk6");
		    Sheet sh1=workbook1.getSheetName(WorkbookPath,SheetName1);
		    int k=sh1.getLastRowNum()-sh1.getFirstRowNum();
		    System.out.println("Value of kkkk"+k);
		    ExecutionTestCaseNo=0;
	     for (int i = 0; i <= k; i++) 
		{
	    Hashtable<String,String> table=null;
        table = new Hashtable<String,String>();
	    Row r1;
			Medicopilot Med1=new Medicopilot();
			r1=sh1.getRow(i);
		
			TestcaseID=r1.getCell(0).toString();
			TestcaseStatus=r1.getCell(1).toString();
			Broswer=r1.getCell(2).toString();
			
			
			String key = "TestCase";		
			String data = TestcaseID;
			table.put(key, data);
	        
		
			key = "RunStatus";		
			data = TestcaseStatus;
		table.put(key, data);
			
			key = "Browser";		
			data =Broswer;
			
			table.put(key, data);
	        
			myData[i][0] = table;
			System.out.println("Table"+table);	 	
			
		}
	    
		//int q=1;
		//System.out.println("Execution Test Case No  ::"+Medicopilot.ExecutionTestCaseNo);
	     
		}
        catch(NoSuchElementException e)
		{
			System.out.println(e);
			
		}
    	return (myData);
    	
    }
	
	
}				 

