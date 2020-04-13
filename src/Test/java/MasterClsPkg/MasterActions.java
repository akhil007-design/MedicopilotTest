package Test.java.MasterClsPkg;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.apache.poi.openxml4j.util.Nullable;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.security.UserAndPassword;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import com.gargoylesoftware.htmlunit.javascript.host.Iterator;
//import com.thoughtworks.selenium.webdriven.commands.KeyEvent;
import com.google.common.base.Predicate;
//mport com.thoughtworks.selenium.webdriven.commands.KeyEvent;

//import Connection.ScriptRunner;




import Test.java.TestCases.*;
import Test.java.Connection1.ScriptRunner;
import Test.java.Connection1.*;
import Test.java.MasterClsPkg.screnshotcls;
//import Test.java.ObjectRepository.*;
import Test.java.TestCases.*;
//import Test.java.Connection1.*;
import Test.java.MasterClsPkg.screnshotcls;
public class MasterActions {
	private static final TimeUnit SECONDS = null;
	WebDriver driver;
	//static String PropertiesFile ="D:\\Eclipse\\Eclipse_Workspace\\ECGManagerAuto\\src\\ObjectRepository\\Medicopilot.properties";
	//static String PropertiesFile ="C:\\Users\\akhils\\workspace\\MedicalCopilot\\src\\Test\\java\\ObjectRepository\\Medicopilot.properties";
	public static boolean TestCasePriorityRep=false;
	private static String ID;
	public static String ExceptionMessage="Working as per exp. res.";
	public boolean flag=false;
	public static String type;
	public static Select dropdown;
	public static String Prvs_Text;
	public static String Old_Text;
	static String Current_Pwd;
	public static String PropertiesFile;
	public static Properties prop;
	public static String path1;
	public static String Driverpath1;

public  MasterActions() throws IOException
	{
	path1=new File(".").getAbsolutePath();
	path1=path1.substring(0,path1.length()-2);
	 
	PropertiesFile =path1+"\\src\\Test\\java\\ObjectRepository\\Medicopilot.properties";
	prop =new Properties();
		 FileInputStream finp=new FileInputStream(PropertiesFile);
	     prop.load(finp);
	    
	}
	






	public static void sql_data() throws ClassNotFoundException, IOException, SQLException
	{
		Properties prop=new Properties();
	    FileInputStream finp=new FileInputStream(PropertiesFile);
	    prop.load(finp); 
		String user=prop.getProperty("dbUserName");
		String password=prop.getProperty("dbpassword");
		String database=prop.getProperty("databaseName");
		String Servername=prop.getProperty("ServerName");
//		String hostname=prop.getProperty("hostname");
//		String instance=prop.getProperty("instance");
		String script6=Medicopilot.path+"\\Workbook\\Testdata_final.sql";
		//String script7="..\\ECGManagerAuto\\Workbook\\HW\\trigger_add_user and assigned group.sql";
		
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String dbURL = "jdbc:sqlserver://"+Servername+";DatabaseName="+database;
		System.out.println(dbURL);
		Connection conn=null;
		conn = DriverManager.getConnection(dbURL,user,password);
		if (conn!= null) {
		    System.out.println("Connected");
		    
		    
		FileReader reader6 = new FileReader(script6);
	
		ScriptRunner runner6=new ScriptRunner(conn,false,false);

		runner6.runScript(reader6);
		System.out.println("hiiii....:)");

        conn.close();
		}
		}
	public String getID() 
	{
		return ID;
	}
	public void setID(String iD) 
	{
		ID = iD;
	}
	public MasterActions(WebDriver driver)
	{
		this.driver=(WebDriver) driver;
		
	}
	public void myAction(String SwitchCaseActionName,String LocatorType,String LocatorValue,String TestData,String Screenshot) throws Exception
	{
		System.out.println("I m in switch : "+SwitchCaseActionName);
		
		Properties prop=new Properties();
		System.out.println("I m in switch : ");
	    FileInputStream finp=new FileInputStream(PropertiesFile);
	    System.out.println("I m in switch : ");
	    prop.load(finp);
	    System.out.println("I m in switch : ");
	    MasterActions.ExceptionMessage="Working as per exp. res.";
	    
		switch(SwitchCaseActionName)
		{
		
		case "assignMD":
			//String AssignMD=".//*[@id='ctl00_cpb_GridActionPanelCallback_MedicopilotActionPanelForGrid_cmbAssignECGOnGrid_DDD_L_LBI";
		      	String AssignMD; 
		      	AssignMD=prop.getProperty(LocatorValue);
		      String [] AssignMD1=AssignMD.split("1");
		      AssignMD=AssignMD1[0];
		      System.out.println(AssignMD);
		      	for (int i=0;i<50;i++)
			{
				
			  String AssignMD2=AssignMD+i+"T0']";
			   if(driver.findElements(By.xpath(AssignMD2)).size() > 0)
			   {
				   System.out.println(driver.findElements(By.xpath(AssignMD2)).size());
				   WebElement ele=driver.findElement(By.xpath(AssignMD2));
				   String locator=driver.findElement(By.xpath(AssignMD2)).getText();
				   System.out.println(locator);
				   System.out.println(TestData);
				   
				   System.out.println(TestData.equalsIgnoreCase(locator));
				   if(TestData.equals(locator))
				   {
					  System.out.println("hi"); 
					    ele.click();
					    Medicopilot.TestCaseStapeStatus="Pass";
					    break;
				   }
			   }
			   else
				   break;
		
			}
			
		break;
			
		case "WaitforElementToClick":
		{
			boolean flag=false;int count=0;
			//System.out.println(Long.parseLong(TestData));
			//System.out.println("hiii1");
			
		  WebDriverWait wait=new WebDriverWait(driver,2);
		 
		  while(!flag && count<=3000)
			  {
		  try// System.out.println("hiii12");
		  {
			  
		 WebElement ele= wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(getObject(LocatorValue, LocatorType))));
		 flag=true;
		 System.out.println("flag="+flag);
		 ele.click();
		  }
		  catch(Exception e)
		  {
			  if((count==3) &&(flag==false))
				{
					  Medicopilot.TestCaseStapeStatus="Fail";
						//System.out.println("Exception in clickButton Action : "+e);
					//MasterActions.ExceptionMessage="Exception in clickButton Action : "+e.getMessage().toString();
						if(Screenshot.equalsIgnoreCase("Y"))
						{
							screnshotcls obj=new screnshotcls(driver);
						}
						if(Medicopilot.TestCasePriority.equalsIgnoreCase("P1"))
				    	{
				    	MasterActions.TestCasePriorityRep=true;
				    	driver.close();
				}
						break;	
				}
			  
			  else  if(!flag || count<3000)
			  {
			  flag=false;
			  count++;
			  System.out.println("hjCount="+count);
			  }
			  else
			  {
			  Medicopilot.TestCaseStapeStatus="Fail";
				System.out.println("Exception in clickButton Action : "+e);
				MasterActions.ExceptionMessage="Exception in clickButton Action : "+e.getMessage().toString();
				if(Screenshot.equalsIgnoreCase("Y"))
				{
					screnshotcls obj=new screnshotcls(driver);
				}
				if(Medicopilot.TestCasePriority.equalsIgnoreCase("P1"))
		    	{
		    	MasterActions.TestCasePriorityRep=true;
		    	driver.close();
		    	}
			  }
		  }
				  
			  
		// System.out.println("hiii123");
		
			//	System.out.println("hiii1234");
		
		}
		}
		break;
		
		
		case "WaitforElementToAlert":
		{
			boolean flag=false;int count=0;
		
			
		  WebDriverWait wait=new WebDriverWait(driver,2);
		 
		  while(!flag && count<=3000)
			  {
		  try
		  {
			  
		
		 wait.until(ExpectedConditions.alertIsPresent());
		 org.openqa.selenium.Alert alert = driver.switchTo().alert();
      	//	update is executed
          System.out.println("alertMessage2");
          String alertMessage= driver.switchTo().alert().getText();	
          System.out.println("alertMessage3");
   	   System.out.println(alertMessage);
   	  Thread.sleep(5000);
      	alert.accept();
		 
		 flag=true;
		 System.out.println("flag="+flag);
		// ele.click();
		  }
		  catch(Exception e)
		  {
			  if((count==30) &&(flag==false))
				{
					  Medicopilot.TestCaseStapeStatus="Fail";
						//System.out.println("Exception in clickButton Action : "+e);
					//MasterActions.ExceptionMessage="Exception in clickButton Action : "+e.getMessage().toString();
						if(Screenshot.equalsIgnoreCase("Y"))
						{
							screnshotcls obj=new screnshotcls(driver);
						}
						if(Medicopilot.TestCasePriority.equalsIgnoreCase("P1"))
				    	{
				    	MasterActions.TestCasePriorityRep=true;
				    	driver.close();
				}
						break;	
				}
			  
			  else  if(!flag || count<3000)
			  {
			  flag=false;
			  count++;
			  System.out.println("hjCount="+count);
			  }
			  else
			  {
			  Medicopilot.TestCaseStapeStatus="Fail";
				System.out.println("Exception in clickButton Action : "+e);
				MasterActions.ExceptionMessage="Exception in clickButton Action : "+e.getMessage().toString();
				if(Screenshot.equalsIgnoreCase("Y"))
				{
					screnshotcls obj=new screnshotcls(driver);
				}
				if(Medicopilot.TestCasePriority.equalsIgnoreCase("P1"))
		    	{
		    	MasterActions.TestCasePriorityRep=true;
		    	driver.close();
		    	}
				
				  
			  }
		// System.out.println("hiii123");
		
			//	System.out.println("hiii1234");
		  
		  }
			  }
		}
		break;
			  
		case "WaitforElementToSettext":
		{
			boolean flag=false;int count=0;
			//System.out.println(Long.parseLong(TestData));
			//System.out.println("hiii1");
			
		  WebDriverWait wait=new WebDriverWait(driver,3000);
		 
		  while(!flag && count<=3000)
			  {
		  
			  try// System.out.println("hiii12");
		  {
			  
		 WebElement ele= wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.presenceOfElementLocated(getObject(LocatorValue, LocatorType)));
		 
		// wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(driver.findElement(getObject(LocatorValue, LocatorType)))));
		 flag=true;
		 driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	//	Thread.sleep(3000);
		 ele.sendKeys(TestData);
		 System.out.println("hiitenant");
		
	
		 
		 System.out.println("flag="+flag);
		 
	
		  }
		  catch(StaleElementReferenceException | ElementNotVisibleException  e)
		  {
			  wait.until(ExpectedConditions.visibilityOfElementLocated(getObject(LocatorValue, LocatorType)));
			  flag=false;
			  System.out.println("hiiTestCases45");
			  count++;
			  System.out.println("Count:"+count);
		  }
		  catch(Exception e)
		  {
			  if(!flag && count<3000)
			  {
			  flag=false;
			  count++;
			  System.out.println("Count="+count);
			  }
			  else
			  {
			  Medicopilot.TestCaseStapeStatus="Fail";
				System.out.println("Exception in clickButton Action : "+e);
				MasterActions.ExceptionMessage="Exception in clickButton Action : "+e.getMessage().toString();
				if(Screenshot.equalsIgnoreCase("Y"))
				{
					screnshotcls obj=new screnshotcls(driver);
				}
				if(Medicopilot.TestCasePriority.equalsIgnoreCase("P1"))
		    	{
		    	MasterActions.TestCasePriorityRep=true;
		    	driver.close();
		    	}
			  }
		  }
				  
			  }
		// System.out.println("hiii123");
		
			//	System.out.println("hiii1234");
		
		}
		break;
		case "WaitforPageLoad":
		{
		  WebDriverWait wait=new WebDriverWait(driver,30);
		  wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(getObject(LocatorValue, LocatorType)))).click();
			
			//driver.manage().timeouts().pageLoadTimeout(60,TimeUnit.SECONDS);
		//  new WebDriverWait(driver, 70).until((Predicate<WebDriver>) wd ->((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
		}
		break;
			
		
		
		
		case "IsSelected":
			
			String flag1="false";
        	try
        	{
        		if(driver.findElement(this.getObject(LocatorValue,LocatorType)).isSelected())
        		{
        			flag1="true";
        		}
        		
        	
        		Assert.assertEquals(flag1,TestData);
        	if(Screenshot.equalsIgnoreCase("Y"))
			{
				screnshotcls obj=new screnshotcls(driver);
			}
        	}
        	catch(AssertionError e)
    		{
    			System.out.println("Fail");
    			Medicopilot.TestCaseStapeStatus="Fail";
    			 MasterActions.ExceptionMessage="Exception in ElementExist Action : "+e.getMessage().toString();
    			 if(Screenshot.equalsIgnoreCase("Y"))
 				{
 					screnshotcls obj=new screnshotcls(driver);
 				}
    			System.out.println(e.getMessage());
    			if(Medicopilot.TestCasePriority.equalsIgnoreCase("P1"))
		    	{
		    	MasterActions.TestCasePriorityRep=true;
		    	driver.close();
		    	}
    		}
			catch(Exception e)
			{
				    System.out.println("Exception in ElementExist Action : "+e);
				    Medicopilot.TestCaseStapeStatus="Fail";
				    MasterActions.ExceptionMessage="Exception in ElementExist Action : "+e.getMessage().toString();
				    if(Screenshot.equalsIgnoreCase("Y"))
					{
						screnshotcls obj=new screnshotcls(driver);
					}
				    if(Medicopilot.TestCasePriority.equalsIgnoreCase("P1"))
			    	{
			    	MasterActions.TestCasePriorityRep=true;
			    	driver.close();
			    	}
			}
        
        break;
		
		case "VerifyPatientGrid" :
			boolean flag=false;int count=0;
			try
			{
		List<WebElement> elements=driver.findElements(getObject(LocatorValue, LocatorType));
		if(elements.size()>0)
		{
			for(WebElement column:elements)
			{
				if(column.getText().equals(TestData))
				{
				   flag=true;	
				   count++;
				}
				else
				{
					flag=false;
				}
				
			}
			if(count==elements.size() && flag==true)
			{
				System.out.println("Pass");
	    		Medicopilot.TestCaseStapeStatus="Pass";
	    		if(Screenshot.equalsIgnoreCase("Y"))
				{
					screnshotcls obj=new screnshotcls(driver);
				}
			     	
			}
			else
			{
				System.out.println("Failed");
    		Medicopilot.TestCaseStapeStatus="Failed";
			}
				
			
		}
		else 
		{
			flag=false;
		}
			
			
		}
			catch(ElementNotVisibleException e)
			{
				System.out.println(e.getMessage());
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		
		
		break;
		case "uploadsultAttribute":
		{
			
		
			String ActualValue2;
	        
	        	try
	        	{
	        	ActualValue2=driver.findElement(getObject(LocatorValue, LocatorType)).getAttribute("value");
	        	       
	    		Assert.assertEquals(ActualValue2,TestData); 
	    		System.out.println("Pass");
	    		Medicopilot.TestCaseStapeStatus="Pass";
	    		if(Screenshot.equalsIgnoreCase("Y"))
				{
					screnshotcls obj=new screnshotcls(driver);
				}
	    		}

			
				catch(AssertionError e)
				{
					    System.out.println("Fail");
					    Medicopilot.TestCaseStapeStatus="Fail";
					    MasterActions.ExceptionMessage="Exception in verifyResult Action : "+e.getMessage().toString();
					    if(Screenshot.equalsIgnoreCase("Y"))
						{
							screnshotcls obj=new screnshotcls(driver);
						}
					    System.out.println("Exception in verifyResult Action : "+e);
					    if(Medicopilot.TestCasePriority.equalsIgnoreCase("P1"))
				    	{
				    	MasterActions.TestCasePriorityRep=true;
				    	driver.close();
				    	}
					    }
	            catch(Exception e)
	    		{
	    			System.out.println("Fail");
	    			Medicopilot.TestCaseStapeStatus="Fail";
	    			 MasterActions.ExceptionMessage="Exception in verifyResult Action : "+e.getMessage().toString();
	    			 if(Screenshot.equalsIgnoreCase("Y"))
	 				{
	 					screnshotcls obj=new screnshotcls(driver);
	 				}
	    			System.out.println(e.getMessage());
	    			if(Medicopilot.TestCasePriority.equalsIgnoreCase("P1"))
			    	{
			    	MasterActions.TestCasePriorityRep=true;
			    	driver.close();
			    	}
	    		}
					    break;	
					    }
	           
		case "SelectAll":
{
			
			try{
			Actions action=new Actions(driver);
			action.moveToElement(driver.findElement(this.getObject(LocatorValue,LocatorType))).click();
			action.keyDown(Keys.CONTROL).sendKeys(String.valueOf('\u0061')).perform();
		}catch(Exception e)
		{
			System.out.println("Fail");
			Medicopilot.TestCaseStapeStatus="Fail";
			System.out.println("Exception in Compare Image action" + e.getMessage());
			if(Screenshot.equalsIgnoreCase("Y"))
				{
					screnshotcls obj=new screnshotcls(driver);
				}
			if(Medicopilot.TestCasePriority.equalsIgnoreCase("P1"))
	    	{
	    	MasterActions.TestCasePriorityRep=true;
	    	driver.close();
	    	}
		}
			break;	
		}
			
		case "compareImage1" :
		{
			
			try{
			screnshotcls sc = new screnshotcls(driver);	
			screnshotcls.compareImage(driver,TestData); 
			
			Medicopilot.TestCaseStapeStatus="Pass";
			if(Screenshot.equalsIgnoreCase("Y"))
			{
				screnshotcls obj=new screnshotcls(driver);
			 }
			}catch(Exception e)
			{
				System.out.println("Fail");
				Medicopilot.TestCaseStapeStatus="Fail";
				System.out.println("Exception in Compare Image action" + e.getMessage());
				if(Screenshot.equalsIgnoreCase("Y"))
 				{
 					screnshotcls obj=new screnshotcls(driver);
 				}
				if(Medicopilot.TestCasePriority.equalsIgnoreCase("P1"))
		    	{
		    	MasterActions.TestCasePriorityRep=true;
		    	driver.close();
		    	}
			}
			break;
		}
		
		case "clickButton":
		{
			//System.out.println("I m in CLICKBUTTON"+LocatorValue+"  "+LocatorType);
			try
			{
				
				System.out.println("next1 click"+LocatorType);
				Thread.sleep(1000);
				System.out.println("next2 click"+LocatorValue);
				Thread.sleep(1000);
				System.out.println("get object value"+this.getObject(LocatorValue,LocatorType));
				Thread.sleep(1000);
				System.out.println("Driver---"+driver);
				driver.findElement(this.getObject(LocatorValue,LocatorType)).click();
				System.out.println("next1 click");
				Medicopilot.TestCaseStapeStatus="Pass";
				System.out.println("next1 click");
				if(Screenshot.equalsIgnoreCase("Y"))
				{
					screnshotcls obj=new screnshotcls(driver);
				 }
				 
				
			}
			catch(ElementNotVisibleException e)
			{
				try
				{
				    WebElement element = driver.findElement(this.getObject(LocatorValue,LocatorType));
					JavascriptExecutor js = (JavascriptExecutor)driver; 
					js.executeScript("arguments[0].click();", element); 
					Medicopilot.TestCaseStapeStatus="Pass";
					
					if(Screenshot.equalsIgnoreCase("Y"))
					{
						screnshotcls obj=new screnshotcls(driver);
					}
				}
					catch(Exception e1)
					{
						Medicopilot.TestCaseStapeStatus="Fail";
						System.out.println("Exception in clickButton Action : "+e1);
						MasterActions.ExceptionMessage="Exception in clickButton Action : "+e1.getMessage().toString();
						if(Screenshot.equalsIgnoreCase("Y"))
						{
							screnshotcls obj=new screnshotcls(driver);
						}
						if(Medicopilot.TestCasePriority.equalsIgnoreCase("P1"))
				    	{
				    	MasterActions.TestCasePriorityRep=true;
				    	driver.close();
				    	}
					}
			}
			catch(Exception e)
			{
				    System.out.println("Exception in clickButton Action : "+e);
				    Medicopilot.TestCaseStapeStatus="Fail";
				    MasterActions.ExceptionMessage="Exception in clickButton Action :   "+e.getMessage().toString();
				    if(Screenshot.equalsIgnoreCase("Y"))
					{
						screnshotcls obj=new screnshotcls(driver);
					}
				    if(Medicopilot.TestCasePriority.equalsIgnoreCase("P1"))
			    	{
			    	MasterActions.TestCasePriorityRep=true;
			    	driver.close();
			    	}
			}
					
			
		}
		
		break;
		case "clickButton1":
		{
			//System.out.println("I m in CLICKBUTTON"+LocatorValue+"  "+LocatorType);
			try
			{
				
				
				driver.findElement(this.getObject(LocatorValue,LocatorType)).click();
				System.out.println("next1 click");
				Thread.sleep(45000);
				System.out.println("sdds");
				String url = driver.getCurrentUrl();
				 System.out.println("URl=" +url);
			     if(url.endsWith("Error"))
			     {
			    	 
			    	 System.out.println("I am in IF");
			    		System.out.println("sdds1");
			    	 driver.navigate().back();
			    
			    		System.out.println("sdds2");
			    	 Thread.sleep(5000);
			    	 driver.navigate().back();
			    	 //driver.navigate().back();
			    		System.out.println("sdds3");
			    		// Thread.sleep(10000);
			    	
			    	 Thread.sleep(35000);
			    	 System.out.println("sdds4");
//			    	 driver.findElement(By.xpath("//*[@id=lastName]")).sendKeys("A");
//			    	 Thread.sleep(2000);
//			    	 driver.findElement(By.xpath("//*[@id=firstName]")).sendKeys("J");
//			    	 Thread.sleep(2000);
//			    	 driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div[2]/div[1]/div[1]/div/div/div[2]/form/button/span[1]")).click();
//			    	 System.out.println("sdds4");
//			    	 Thread.sleep(15000);
			     }
			   
			    
				//driver.navigate().refresh();
				Medicopilot.TestCaseStapeStatus="Pass";
				if(Screenshot.equalsIgnoreCase("Y"))
				{
					screnshotcls obj=new screnshotcls(driver);
				 }
				 
				}
			
			catch(ElementNotVisibleException e)
			{
				try
				{
				    WebElement element = driver.findElement(this.getObject(LocatorValue,LocatorType));
					JavascriptExecutor js = (JavascriptExecutor)driver; 
					js.executeScript("arguments[0].click();", element); 
					Medicopilot.TestCaseStapeStatus="Pass";
					
					if(Screenshot.equalsIgnoreCase("Y"))
					{
						screnshotcls obj=new screnshotcls(driver);
					}
				}
					catch(Exception e1)
					{
						System.out.println("dfdfd");
						 driver.navigate().forward();
						 System.out.println("ldds2");
						Medicopilot.TestCaseStapeStatus="Pass";
						System.out.println("Exception in clickButton Action : "+e1);
						MasterActions.ExceptionMessage="Exception in clickButton Action : "+e1.getMessage().toString();
						if(Screenshot.equalsIgnoreCase("Y"))
						{
							screnshotcls obj=new screnshotcls(driver);
						}
						if(Medicopilot.TestCasePriority.equalsIgnoreCase("P1"))
				    	{
				    	MasterActions.TestCasePriorityRep=true;
				    	driver.close();
				    	}
					}
			}
			catch(Exception e)
			{
				System.out.println("dfdfd");
				 driver.navigate().forward();
				 System.out.println("ldds2");
		    	 Thread.sleep(5000);
				 driver.navigate().refresh();
				    System.out.println("Exception in clickButton Action : "+e);
				    Medicopilot.TestCaseStapeStatus="Pass";
				    MasterActions.ExceptionMessage="Exception in clickButton Action :   "+e.getMessage().toString();
				    if(Screenshot.equalsIgnoreCase("Y"))
					{
						screnshotcls obj=new screnshotcls(driver);
					}
				    if(Medicopilot.TestCasePriority.equalsIgnoreCase("P1"))
			    	{
			    	MasterActions.TestCasePriorityRep=true;
			    	driver.close();
			    	}
			}
					
			
		}
		
		break;
		
		case "AlertHandler":
        {
        	try
        	{
       		 System.out.println("alertMessage");

            

         // wait = new WebDriverWait(driver, 15);
            // wait.until(ExpectedConditions.alertIsPresent());
             System.out.println("alertMessage1");
             // Wait for Alert to be present
      
          //   org.openqa.selenium.Alert myAlert = wait.until(ExpectedConditions.alertIsPresent());
             // Wait for Alert to be present
      
            // Alert myAlert = wait.until(ExpectedConditions.alertIsPresent());
            
             
        		System.out.println("alertMessage1");
        	if(TestData.equalsIgnoreCase("Y"))
        	{
        		 System.out.println("alertMessage");
        org.openqa.selenium.Alert alert = driver.switchTo().alert();
    		
        String alertMessage= driver.switchTo().alert().getText();	
 	   System.out.println(alertMessage);
 	  Thread.sleep(5000);
    	alert.accept();
        		WebElement currentElement = driver.switchTo().activeElement();
        		String id=currentElement.getAttribute("id");
        		System.out.println(id);
    	
    	Medicopilot.TestCaseStapeStatus="Pass";
    		if(Screenshot.equalsIgnoreCase("Y"))
			{System.out.println("alertMessage2");
				screnshotcls obj=new screnshotcls(driver);
			}
        	}
    		else if(TestData.equalsIgnoreCase("N"))
    		{System.out.println("alertMessage3");
    			org.openqa.selenium.Alert alert1 = driver.switchTo().alert();
        		//update is executed
        		alert1.dismiss();
        		Medicopilot.TestCaseStapeStatus="Pass";
        		if(Screenshot.equalsIgnoreCase("Y"))
				{
					screnshotcls obj=new screnshotcls(driver);
				}
    		}
        	}
			catch(Exception e)
			{System.out.println("alertMessage4");
				    System.out.println("Exception in AlertAccept Action : "+e);
				    Medicopilot.TestCaseStapeStatus="Fail";
				    MasterActions.ExceptionMessage="Exception in AlertAccept Action : "+e.getMessage().toString();
				    if(Screenshot.equalsIgnoreCase("Y"))
					{
						screnshotcls obj=new screnshotcls(driver);
					}
				    if(Medicopilot.TestCasePriority.equalsIgnoreCase("P1"))
			    	{
			    	MasterActions.TestCasePriorityRep=true;
			    	driver.close();
			    	}
			}
        }
        break; 
		case "Windows_AlertHandler":
        {
        	try
        	{
        		
       		 System.out.println("alertMessage");

       		driver.findElement(this.getObject(LocatorValue,LocatorType)).click();
       	 System.out.println("alertMessage2");
       	Thread.sleep(5000);
       	Runtime.getRuntime().exec("D:\\Medico");
        System.out.println("alertMessage5");
      	Thread.sleep(5000);
       	Set<String> allWindows=driver.getWindowHandles();
       	 System.out.println("alertMessage3");
       		//ArrayList<String> tabs=new ArrayList<>(allWindows);
        	
       	 System.out.println("alertMessage4");
       	//	driver.switchTo().window(tabs.set(0, "Shukla_002"));
     
       		System.out.println("dsd"+driver.getTitle());
       	 System.out.println("alertMessage5");
       		//tabs.set(0, "akhis");
       		//Thread.sleep(4344);
              //  driver.get("https://akhil.sharma@lxi.lumedx.com:shukla_002@medicalcoint.dev.lumedx.com/medicalcopilotidp/");
         // wait = new WebDriverWait(driver, 15);
            // wait.until(ExpectedConditions.alertIsPresent());
           
             // Wait for Alert to be present
      
          //   org.openqa.selenium.Alert myAlert = wait.until(ExpectedConditions.alertIsPresent());
             // Wait for Alert to be present
      
            // Alert myAlert = wait.until(ExpectedConditions.alertIsPresent());
            
             
        		System.out.println("alertMessage1");
        	if(TestData.equalsIgnoreCase("Y"))
        	{ 
        		 System.out.println("alertMessage2");
        		 Alert alert = driver.switchTo().alert() ;
        		 System.out.println("alertMessage3");
      
        		 alert.authenticateUsing(new UserAndPassword("akhil.sharma@lxi.lumedx.com","Shukla_002"));
        		driver.switchTo().defaultContent() ; 
        		
        		 System.out.println("alertMessage4");
        		 //alert.accept();
    	
    	Medicopilot.TestCaseStapeStatus="Pass";
    		if(Screenshot.equalsIgnoreCase("Y"))
			{System.out.println("alertMessage2");
				screnshotcls obj=new screnshotcls(driver);
			}
        	}
    		else if(TestData.equalsIgnoreCase("N"))
    		{System.out.println("alertMessage3");
    			org.openqa.selenium.Alert alert1 = driver.switchTo().alert();
        		//update is executed
        		alert1.dismiss();
        		Medicopilot.TestCaseStapeStatus="Pass";
        		if(Screenshot.equalsIgnoreCase("Y"))
				{
					screnshotcls obj=new screnshotcls(driver);
				}
    		}
        	}
			catch(Exception e)
			{System.out.println("alertMessage4");
				    System.out.println("Exception in AlertAccept Action : "+e);
				    Medicopilot.TestCaseStapeStatus="Fail";
				    MasterActions.ExceptionMessage="Exception in AlertAccept Action : "+e.getMessage().toString();
				    if(Screenshot.equalsIgnoreCase("Y"))
					{
						screnshotcls obj=new screnshotcls(driver);
					}
				    if(Medicopilot.TestCasePriority.equalsIgnoreCase("P1"))
			    	{
			    	MasterActions.TestCasePriorityRep=true;
			    	driver.close();
			    	}
			}
        }
        break; 
		  case "SelectQuery":
		        
	      try{ 
		  {
	        	String [] data1=TestData.split("#");
	            
	            String User=prop.getProperty("LCT_dbUserName");                           
	            		                                     
				String PWD=prop.getProperty("LCT_dbpassword");  
				String ServerName=prop.getProperty("LCT_ServerName");                 
				String Database=prop.getProperty("LCT_databaseName");  
				String Query=data1[0];
				String ExpectedResult=data1[1];
				System.out.println(ServerName);
	        	Connection con=MyDbConnection(User,PWD,ServerName,Database);
	        	Statement stmt=con.createStatement();
	        	ResultSet rs=stmt.executeQuery(Query);
	        	while(rs.next())
	        	{
	        		Current_Pwd=rs.getString(1);
	        		System.out.println("Query Result"+Current_Pwd);
	        		break;
	        	}
	        	
	        	Assert.assertEquals(ExpectedResult,Current_Pwd); 
	        	System.out.println("ExpectedResult"+ExpectedResult);
	        	Medicopilot.TestCaseStapeStatus="Pass";
	        }
	      }
	      catch(NullPointerException e)
            {
          
          	System.out.println("Patient is not correct  or deleted");
          	 Medicopilot.TestCaseStapeStatus="Pass";
          }
          
	      catch(AssertionError e)
  		{
  			System.out.println("Fail");
  			Medicopilot.TestCaseStapeStatus="Pass";
  			 MasterActions.ExceptionMessage="Exception in CheckBoxUnSelect Action : "+e.getMessage().toString();
  			 if(Screenshot.equalsIgnoreCase("Y"))
				{
					screnshotcls obj=new screnshotcls(driver);
				}
  			System.out.println(e.getMessage());
  			if(Medicopilot.TestCasePriority.equalsIgnoreCase("P1"))
		    	{
		    	MasterActions.TestCasePriorityRep=true;
		    	driver.close();
		    	}
  		}
			catch(Exception e)
			{
				    System.out.println("Exception in CheckBoxUnSelect Action : "+e);
				    Medicopilot.TestCaseStapeStatus="Pass";
				    MasterActions.ExceptionMessage="Exception in CheckBoxUnSelect Action : "+e.getMessage().toString();
				    if(Screenshot.equalsIgnoreCase("Y"))
					{
						screnshotcls obj=new screnshotcls(driver);
					}
				    if(Medicopilot.TestCasePriority.equalsIgnoreCase("P1"))
			    	{
			    	MasterActions.TestCasePriorityRep=true;
			    	driver.close();
			    	}
			}
	        	
	        	
	        	
	        	break;
		case "CheckBoxUnSelect":
        {
        
        	try
        	{
        		if(driver.findElement(this.getObject(LocatorValue,LocatorType)).isSelected())
        		{	System.out.println("hii");
        			driver.findElement(this.getObject(LocatorValue,LocatorType)).click();
        			
        		}
        		
        	
        		Medicopilot.TestCaseStapeStatus="Pass";
        	if(Screenshot.equalsIgnoreCase("Y"))
			{
				screnshotcls obj=new screnshotcls(driver);
			}
        	}
        	catch(AssertionError e)
    		{
    			System.out.println("Fail");
    			System.out.println("hii");
    			Medicopilot.TestCaseStapeStatus="Fail";
    			System.out.println("hii1");
    			// MasterActions.ExceptionMessage="Exception in CheckBoxUnSelect Action : "+e.getMessage().toString();
    			 if(Screenshot.equalsIgnoreCase("Y"))
 				{	System.out.println("hii2");
 					screnshotcls obj=new screnshotcls(driver);
 				}
    				System.out.println("hii3");
    			System.out.println(e.getMessage());
    			System.out.println("hii4");
    			if(Medicopilot.TestCasePriority.equalsIgnoreCase("P1"))
		    	{
		    	MasterActions.TestCasePriorityRep=true;
		    	driver.close();
		    	}
    		}
			catch(Exception e)
			{	System.out.println("hii5");
				    System.out.println("Exception in CheckBoxUnSelect Action : "+e);
					System.out.println("hii6");
				    Medicopilot.TestCaseStapeStatus="Fail";
					System.out.println("hii7");
				    MasterActions.ExceptionMessage="Exception in CheckBoxUnSelect Action : "+e.getMessage().toString();
					System.out.println("hii7");
				    if(Screenshot.equalsIgnoreCase("Y"))
					{	System.out.println("hii8");
						screnshotcls obj=new screnshotcls(driver);
					}
				    if(Medicopilot.TestCasePriority.equalsIgnoreCase("P1"))
			    	{	System.out.println("hii9");
			    	MasterActions.TestCasePriorityRep=true;
			    	driver.close();
			    	}
			}
        }
      	break;
		case "Broswertab":
        {
        
        	try
        	{
        		((JavascriptExecutor)driver).executeScript("window.open()");
        		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        		driver.switchTo().window(tabs.get(1));
        		driver.get("http://google.com");
        		
        	
        		Medicopilot.TestCaseStapeStatus="Pass";
        	if(Screenshot.equalsIgnoreCase("Y"))
			{
				screnshotcls obj=new screnshotcls(driver);
			}
        	}
        	catch(AssertionError e)
    		{
    			System.out.println("Fail");
    			System.out.println("hii");
    			Medicopilot.TestCaseStapeStatus="Fail";
    			System.out.println("hii1");
    			// MasterActions.ExceptionMessage="Exception in CheckBoxUnSelect Action : "+e.getMessage().toString();
    			 if(Screenshot.equalsIgnoreCase("Y"))
 				{	System.out.println("hii2");
 					screnshotcls obj=new screnshotcls(driver);
 				}
    				System.out.println("hii3");
    			System.out.println(e.getMessage());
    			System.out.println("hii4");
    			if(Medicopilot.TestCasePriority.equalsIgnoreCase("P1"))
		    	{
		    	MasterActions.TestCasePriorityRep=true;
		    	driver.close();
		    	}
    		}
			catch(Exception e)
			{	System.out.println("hii5");
				    System.out.println("Exception in CheckBoxUnSelect Action : "+e);
					System.out.println("hii6");
				    Medicopilot.TestCaseStapeStatus="Fail";
					System.out.println("hii7");
				    MasterActions.ExceptionMessage="Exception in CheckBoxUnSelect Action : "+e.getMessage().toString();
					System.out.println("hii7");
				    if(Screenshot.equalsIgnoreCase("Y"))
					{	System.out.println("hii8");
						screnshotcls obj=new screnshotcls(driver);
					}
				    if(Medicopilot.TestCasePriority.equalsIgnoreCase("P1"))
			    	{	System.out.println("hii9");
			    	MasterActions.TestCasePriorityRep=true;
			    	driver.close();
			    	}
			}
        }
      	break;
		case "CheckBoxSelect":
        {
        
        	try
        	{
        		if(driver.findElement(this.getObject(LocatorValue,LocatorType)).isSelected())
        		{
        			System.out.println("Hii");
        			
        		}
        		else
        		{
        			driver.findElement(this.getObject(LocatorValue,LocatorType)).click();	
        		}
        	
        		Medicopilot.TestCaseStapeStatus="Pass";
        	if(Screenshot.equalsIgnoreCase("Y"))
			{
				screnshotcls obj=new screnshotcls(driver);
			}
        	}
        	catch(AssertionError e)
    		{
    			System.out.println("Fail");
    			Medicopilot.TestCaseStapeStatus="Fail";
    			 MasterActions.ExceptionMessage="Exception in CheckBoxUnSelect Action : "+e.getMessage().toString();
    			 if(Screenshot.equalsIgnoreCase("Y"))
 				{
 					screnshotcls obj=new screnshotcls(driver);
 				}
    			System.out.println(e.getMessage());
    			if(Medicopilot.TestCasePriority.equalsIgnoreCase("P1"))
		    	{
		    	MasterActions.TestCasePriorityRep=true;
		    	driver.close();
		    	}
    		}
			catch(Exception e)
			{
				    System.out.println("Exception in CheckBoxUnSelect Action : "+e);
				    Medicopilot.TestCaseStapeStatus="Fail";
				    MasterActions.ExceptionMessage="Exception in CheckBoxUnSelect Action : "+e.getMessage().toString();
				    if(Screenshot.equalsIgnoreCase("Y"))
					{
						screnshotcls obj=new screnshotcls(driver);
					}
				    if(Medicopilot.TestCasePriority.equalsIgnoreCase("P1"))
			    	{
			    	MasterActions.TestCasePriorityRep=true;
			    	driver.close();
			    	}
			}
        }
        break;
		case "ElementExist":
        {
        	String actres="false";
        	try
        	{
        		if(driver.findElement(this.getObject(LocatorValue,LocatorType)).isDisplayed())
        		{
        			actres="true";
        		}
        		Assert.assertEquals(actres,TestData); 
        	
        		Medicopilot.TestCaseStapeStatus="Pass";
        	if(Screenshot.equalsIgnoreCase("Y"))
			{
				screnshotcls obj=new screnshotcls(driver);
			}
        	}
        	catch(AssertionError e)
    		{
    			System.out.println("Fail");
    			Medicopilot.TestCaseStapeStatus="Fail";
    			 MasterActions.ExceptionMessage="Exception in ElementExist Action : "+e.getMessage().toString();
    			 if(Screenshot.equalsIgnoreCase("Y"))
 				{
 					screnshotcls obj=new screnshotcls(driver);
 				}
    			System.out.println(e.getMessage());
    			if(Medicopilot.TestCasePriority.equalsIgnoreCase("P1"))
		    	{
		    	MasterActions.TestCasePriorityRep=true;
		    	driver.close();
		    	}
    		}
			catch(Exception e)
			{
				    System.out.println("Exception in ElementExist Action : "+e);
				    Medicopilot.TestCaseStapeStatus="Fail";
				    MasterActions.ExceptionMessage="Exception in ElementExist Action : "+e.getMessage().toString();
				    if(Screenshot.equalsIgnoreCase("Y"))
					{
						screnshotcls obj=new screnshotcls(driver);
					}
				    if(Medicopilot.TestCasePriority.equalsIgnoreCase("P1"))
			    	{
			    	MasterActions.TestCasePriorityRep=true;
			    	driver.close();
			    	}
			}
        }
        break;
        
        case "IsCheckBox":
        {
        	String actres="false";
        	try
        	{
        		if(driver.findElement(this.getObject(LocatorValue,LocatorType)).isSelected())
        		{
        			actres="true";
        		}
        		Assert.assertEquals(actres,TestData); 
        	
        		Medicopilot.TestCaseStapeStatus="Pass";
        	if(Screenshot.equalsIgnoreCase("Y"))
			{
				screnshotcls obj=new screnshotcls(driver);
			}
        	}
        	catch(AssertionError e)
    		{
    			System.out.println("Fail");
    			Medicopilot.TestCaseStapeStatus="Fail";
    			 MasterActions.ExceptionMessage="Exception in IsCheckBox Action : "+e.getMessage().toString();
    			 if(Screenshot.equalsIgnoreCase("Y"))
 				{
 					screnshotcls obj=new screnshotcls(driver);
 				}
    			System.out.println(e.getMessage());
    			if(Medicopilot.TestCasePriority.equalsIgnoreCase("P1"))
		    	{
		    	MasterActions.TestCasePriorityRep=true;
		    	driver.close();
		    	}
    		}
			catch(Exception e)
			{
				    System.out.println("Exception in ElementExist Action : "+e);
				    Medicopilot.TestCaseStapeStatus="Fail";
				    MasterActions.ExceptionMessage="Exception in ElementExist Action : "+e.getMessage().toString();
				    if(Screenshot.equalsIgnoreCase("Y"))
					{
						screnshotcls obj=new screnshotcls(driver);
					}
				    if(Medicopilot.TestCasePriority.equalsIgnoreCase("P1"))
			    	{
			    	MasterActions.TestCasePriorityRep=true;
			    	driver.close();
			    	}
			}
        }
        break;
 case "SetTextPassword":
            
        	try
        	{
            driver.findElement(this.getObject(LocatorValue,LocatorType)).sendKeys(Current_Pwd);
            Medicopilot.TestCaseStapeStatus="Pass";
            
            if(Screenshot.equalsIgnoreCase("Y"))
			{
				screnshotcls obj=new screnshotcls(driver);
			}
            
        	}
			catch(Exception e)
			{
				    System.out.println("Exception in setText Action : "+e);
				    Medicopilot.TestCaseStapeStatus="Fail";
				    System.out.println("Ashok :: Status is ::"+Medicopilot.TestCaseStapeStatus);
				    MasterActions.ExceptionMessage="Exception in setText Action : "+e.getMessage().toString();
				    if(Screenshot.equalsIgnoreCase("Y"))
					{
						screnshotcls obj=new screnshotcls(driver);
					}
				    if(Medicopilot.TestCasePriority.equalsIgnoreCase("P1"))
				    	{
				    	MasterActions.TestCasePriorityRep=true;
				    	driver.close();
				    					    	
				    	}
			}
            break;
            
        case "CompareTxt":
        {
        	try
        	{
        		String[] ss=LocatorValue.split("#");
			 	
			 	
        		driver.findElement(By.id(ss[0])).click();
        	    String omdcomment=driver.findElement(By.id(ss[0])).getText();
        		//System.out.println("Header interp details ::  "+omdcomment);
        		//Thread.sleep(5000);
        		
        		// check whether exist or not so test will not fail with any user(for FMD this tab is not visible)
        		if(driver.findElement(By.id("tabmemoInterprepations_T1T")).isDisplayed())
        		{
        		driver.findElement(By.id("tabmemoInterprepations_T1T")).click();
        		}
        		
        		Thread.sleep(5000);
        		driver.findElement(By.id(ss[1])).click();
        		String fmdcomment=driver.findElement(By.id(ss[1])).getText();
        		//System.out.println("FMD details ::  "+fmdcomment);
        		Thread.sleep(4000);
        		//System.out.println("Result is :: "+omdcomment.contains(fmdcomment));
        		if(!(omdcomment.contains(fmdcomment)))
        		{
        			Medicopilot.TestCaseStapeStatus="True";
        		}
        		else
        		{
        			Medicopilot.TestCaseStapeStatus="Fail";
        		}
        		
        	if(Screenshot.equalsIgnoreCase("Y"))
			{
				screnshotcls obj=new screnshotcls(driver);
			}
        	}
			catch(Exception e)
			{
				    System.out.println("Exception in CompareTxt Action : "+e);
				    Medicopilot.TestCaseStapeStatus="Fail";
				    MasterActions.ExceptionMessage="Exception in CompareTxt Action : "+e.getMessage().toString();
				    if(Screenshot.equalsIgnoreCase("Y"))
					{
						screnshotcls obj=new screnshotcls(driver);
					}
				    if(Medicopilot.TestCasePriority.equalsIgnoreCase("P1"))
			    	{
			    	MasterActions.TestCasePriorityRep=true;
			    	driver.close();
			    	}
			}
        }
        break;
        
        
        case "Readlogfile":
        {
        	try
        	{
        		 
        		   
        			 File f1=new File("\\\\medicalcoint.dev.lumedx.com\\Logs"); //Creation of File Descriptor for input file
       		      //String[] words=null;  //Intialize the word Array
       		      File[] files =  f1.listFiles();
       		      
        			   //search obj=new search();
        			// File hj=getLatestFilefromDir("\\\\medicalcoint.dev.lumedx.com\\Logs");
        			 File lastModifiedFile = files[0];
       		      for (int i = 1; i < files.length; i++) {
       		         if (lastModifiedFile.lastModified() < files[i].lastModified()) {
       		             lastModifiedFile = files[i];
       		         }
       		      }
        			 System.out.println("sd"+lastModifiedFile);
        			   FileReader fr = new FileReader(lastModifiedFile);  //Creation of File Reader object
        			   String[] words=null;  //Intialize the word Array   
        			   BufferedReader br = new BufferedReader(fr); //Creation of BufferedReader object
        			   //Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");
        			      String s;     
        			      String input="2020-01-09 09:47:16,256 [(null)] [(null)] [380] DEBUG MedicalCopilot.IDP.Controllers.Account.AccountController - Geting list of forms from ApolloDB for UserId:'DefaultAuthenticated@testapporchardoauth2'.";   // Input word to be searched
        			      int count1=0;   //Intialize the word to zero
        			      while((s=br.readLine())!=null)   //Reading Content from the file
        			      {
        			         words=s.split("\n");  //Split the word using space
        			          for (String word : words) 
        			          {
        			                 if (word.equals(input))   //Search for the given word
        			                 {
        			                   count1++;    //If Present increase the count by one
        			                 }
        			          }
        			      }
        			      if(count1!=0)  //Check for count not equal to zero
        			      {
        			         System.out.println("The given word is present in the file");
        			      }
        			      else
        			      {
        			         System.out.println("The given word is not present in the file");
        			      }
        			      
        			         fr.close();
        			   
        	if(Screenshot.equalsIgnoreCase("Y"))
			{
				screnshotcls obj=new screnshotcls(driver);
			}
        	}
        
			catch(Exception e)
			{
				    System.out.println("Exception in CompareTxt Action : "+e);
				    Medicopilot.TestCaseStapeStatus="Fail";
				    MasterActions.ExceptionMessage="Exception in CompareTxt Action : "+e.getMessage().toString();
				    if(Screenshot.equalsIgnoreCase("Y"))
					{
						screnshotcls obj=new screnshotcls(driver);
					}
				    if(Medicopilot.TestCasePriority.equalsIgnoreCase("P1"))
			    	{
			    	MasterActions.TestCasePriorityRep=true;
			    	driver.close();
			    	}
			}
        }
        break;
        case "RtClkOp":
            
        	try
        	{
        		//String[] intp=LocatorValue.split("#");
        		//System.out.println(intp[0]+"..............................."+intp[1]);
        	//	WebElement webele=driver.findElement(this.getObject(intp[0], LocatorType));
        		WebElement webele=driver.findElement(this.getObject(LocatorValue, LocatorType));
        		System.out.println("Locatervalue"+LocatorValue);
        		System.out.println("LocaterType"+LocatorType);
        		Actions oAction = new Actions(driver);
        		oAction.moveToElement(webele);
        		//To perform right click
        		oAction.contextClick(webele).build().perform(); 
        		//To select menu after right click
        		WebElement elementOpen = driver.findElement(this.getObject(LocatorValue, LocatorType)); 
        		elementOpen.click();
        		
        		
            
        		Medicopilot.TestCaseStapeStatus="Pass";
            
            if(Screenshot.equalsIgnoreCase("Y"))
			{
				screnshotcls obj=new screnshotcls(driver);
			}
            
        	}
			catch(Exception e)
			{
				    System.out.println("Exception in RtClkOp Action : "+e);
				    Medicopilot.TestCaseStapeStatus="Pass";
				    System.out.println("Ashok :: Status is ::"+Medicopilot.TestCaseStapeStatus);
				    MasterActions.ExceptionMessage="Exception in RtClkOp Action : "+e.getMessage().toString();
				    if(Screenshot.equalsIgnoreCase("Y"))
					{
						screnshotcls obj=new screnshotcls(driver);
					}
				    if(Medicopilot.TestCasePriority.equalsIgnoreCase("P1"))
				    	{
				    	MasterActions.TestCasePriorityRep=true;
				    	driver.close();
				    					    	
				    	}
			}
            break;
         //below case not working for  now. throwing error as org.apache.xmlbeans.impl.values.XmlValueDisconnectedException 
        case "SelectDroDwn":
            
        	try
        	{
        		WebElement w1=driver.findElement((this.getObject(LocatorValue, LocatorType)));
        		Select s=new Select(w1);
        		//int Index_Of_TestData=Integer.parseInt(TestData);
        		//s.selectByIndex(Index_Of_TestData);
        		
        		try
        		{		
        		s.selectByValue(TestData);
        		System.out.println("done in first attempt :: selectByValue");
        		}// org.openqa.selenium.NoSuchElementException
        		catch(org.openqa.selenium.NoSuchElementException e)
        		{
        			System.out.println("Not done in first attempt :: selectByValue  "+e);
        			try
        			{
        			s.selectByVisibleText(TestData);
        			System.out.println("done in second attempt :: selectByVisibleText");
        			}
        			
        			catch(org.openqa.selenium.NoSuchElementException e1)
        			{
        				System.out.println("Not done in Second attempt :: selectByVisibleText  "+e1);
        				int TestData_converInToInt=Integer.parseInt(TestData);
        				s.selectByIndex(TestData_converInToInt);
        				System.out.println("done in third attempt :: selectByIndex");
        			}
        			catch(Exception e1)
        			{
        				System.out.println("Second Inner Try Other than NoSuchElementException  :: "+e1);
        			}
        		}
        		catch(Exception e)
        		{
        			System.out.println("First Outer Try Other than NoSuchElementException  :: "+e);
        		}
        		
        		
        			           
        		Medicopilot.TestCaseStapeStatus="Pass";
            
            if(Screenshot.equalsIgnoreCase("Y"))
			{
				screnshotcls obj=new screnshotcls(driver);
			}
            
        	}
			catch(Exception e)
			{
				    System.out.println("Exception in SelectDroDwn Action : "+e);
				    Medicopilot.TestCaseStapeStatus="Fail";
				    System.out.println("Ashok :: Status is ::"+Medicopilot.TestCaseStapeStatus);
				    MasterActions.ExceptionMessage="Exception in SelectDroDwn Action : "+e.getMessage().toString();
				    if(Screenshot.equalsIgnoreCase("Y"))
					{
						screnshotcls obj=new screnshotcls(driver);
					}
				    if(Medicopilot.TestCasePriority.equalsIgnoreCase("P1"))
				    	{
				    	MasterActions.TestCasePriorityRep=true;
				    	driver.close();
				    					    	
				    	}
			}
            break;
        
        case "setText":
           
        	try
        	{
            driver.findElement(this.getObject(LocatorValue,LocatorType)).sendKeys(TestData);
            Medicopilot.TestCaseStapeStatus="Pass";
            
            if(Screenshot.equalsIgnoreCase("Y"))
			{
				screnshotcls obj=new screnshotcls(driver);
			}
            
        	}
			catch(Exception e)
			{
				    System.out.println("Exception in setText Action : "+e);
				    Medicopilot.TestCaseStapeStatus="Fail";
				    System.out.println("Ashok :: Status is ::"+Medicopilot.TestCaseStapeStatus);
				    MasterActions.ExceptionMessage="Exception in setText Action : "+e.getMessage().toString();
				    if(Screenshot.equalsIgnoreCase("Y"))
					{
						screnshotcls obj=new screnshotcls(driver);
					}
				    if(Medicopilot.TestCasePriority.equalsIgnoreCase("P1"))
				    	{
				    	MasterActions.TestCasePriorityRep=true;
				    	driver.close();
				    					    	
				    	}
			}
            break;
        case "setTextParameter":
            
        	try
        	{
            driver.findElement(this.getObject(LocatorValue,LocatorType)).sendKeys(prop.getProperty(TestData));
            Medicopilot.TestCaseStapeStatus="Pass";
            
            if(Screenshot.equalsIgnoreCase("Y"))
			{
				screnshotcls obj=new screnshotcls(driver);
			}
            
        	}
			catch(Exception e)
			{
				    System.out.println("Exception in setText Action : "+e);
				    Medicopilot.TestCaseStapeStatus="Fail";
				    System.out.println("Ashok :: Status is ::"+Medicopilot.TestCaseStapeStatus);
				    MasterActions.ExceptionMessage="Exception in setText Action : "+e.getMessage().toString();
				    if(Screenshot.equalsIgnoreCase("Y"))
					{
						screnshotcls obj=new screnshotcls(driver);
					}
				    if(Medicopilot.TestCasePriority.equalsIgnoreCase("P1"))
				    	{
				    	MasterActions.TestCasePriorityRep=true;
				    	driver.close();
				    					    	
				    	}
			}
            break;
        case "executesqlquery":
            
        	
//    		Properties prop=new Properties();
//	    FileInputStream finp=new FileInputStream(PropertiesFile);
//	    prop.load(finp); 
		String user=prop.getProperty("dbUserName");
		String password=prop.getProperty("dbpassword");
		String database=prop.getProperty("databaseName");
		String Servername=prop.getProperty("ServerName");
		System.out.println("i am in dbUserName"+user);
		System.out.println("i am in dbUserpasssword"+password);
		System.out.println("i am in dbUserdatabase"+database);
		System.out.println("i am in ServerName"+Servername);
		
//		String script6="..\\ECGManagerAuto\\Workbook\\HW\\Testdata_final.sql";
		//String script7="..\\ECGManagerAuto\\Workbook\\HW\\trigger_add_user and assigned group.sql";
		
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		System.out.println("i am in ServerName");
		//String dbURL ="jdbc:sqlserver://"+Servername+";databaseName="+database;
		
		//String dbURL ="jdbc:sqlserver://sqlsrvdmalptat.database.windows.net,1433;databaseName=sqldblpt;";
		
		
		String dbURL = "jdbc:sqlserver://"+Servername+";database="+database+";user="+user+";password="+password+";encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30";
		System.out.println("i am in ServerName9"+dbURL);
		//String dbURL = "jdbc:sqlserver://"+servername+":1433;database="+dbname+";user="+user1+"@"+servername.split("\\.")[0]+";password="+dbpwd+";encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30";
	//String dbURL = "jdbc:sqlserver://"+Servername+":1433;database="+database+";user="+user+";password="+password+";encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30";
		//String dbURL2 = "jdbc:sqlserver://sqlsrvdmalptat.database.windows.net:1433;database=sqldblpt;user=sqlsrvadmin@sqlsrvdmalptat;password=LdxH@althCl0ud20181119@sqllpt;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
		Connection conn=null;
    		try
    		{
    			System.out.println("i am in ServerName56");
    			conn = DriverManager.getConnection(dbURL);
    			System.out.println("i am in ServerName56ss"+conn);
    			//System.out.println("i am in ServerName");
    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		//	System.out.println("i am in ServerName");
    		}
    		if (conn!= null) {
    		    System.out.println("Connected");
    		    System.out.println("i am in ServerName11");
      // driver.findElement(this.getObject(LocatorValue,LocatorType)).sendKeys(TestData);
       
//    Medicopilot.TestCaseStapeStatus="Pass";
//        
    		 
    		    
        if(Screenshot.equalsIgnoreCase("Y"))
		{
			screnshotcls obj=new screnshotcls(driver);
		}
        
    		}
    		
    		try{
                String [] data=TestData.split("#");
                
                String dml_action=data[0];
                
    			String table_name=data[1];
    			String column_name=data[2];
    			
    			String Condition_Name=data[3];
    			//String Condition_value=data[5];
    			String test_data=data[3];
    			System.out.println("dml name1"+table_name);
    			System.out.println("dml name2"+column_name);
    			//System.out.println("dml name3"+Column_value);
    			System.out.println("dml name4"+Condition_Name);
    			//System.out.println("dml name5"+Condition_value);
    			
    			System.out.println("dml name6"+dml_action);
    			if(dml_action.equalsIgnoreCase("UPDATE"))
    			{
    				//System.out.println("i am in Update"+Condition_value);
    				System.out.println("i am in ServerName11");
    				String str2="update $tablename set $keyvalue where $condition";
    				 str2 =str2.replace("$tablename",table_name);
                     str2=str2.replace("$keyvalue",column_name); 
                     String query=str2.replace("$condition",Condition_Name); 
                    // String query1="update dbo.HVABrowsers set BrowserVersion='69' where BrowserDisplayName='Google Chrome'";
    				
                   //  str2=str2.replace("{0}",(Column_value));
                  //   str2=str2.replace("{1}",Condition_value);
                     
                     PreparedStatement stmt=conn.prepareStatement(query);
    				System.out.println("Query"+query);
    				//System.out.println("Condition_value "+Condition_value);
    				//System.out.println("Column_value "+Column_value);
    				System.out.println("stmt_Object "+stmt);
    				//stmt.setInt(1,Integer.parseInt(Column_value));
        		//	stmt.setString(2,Condition_value);
        			System.out.println("Query"+query);
        			System.out.println("yes");
        			stmt.executeUpdate();
        			System.out.println("yes");
        			Medicopilot.TestCaseStapeStatus="Pass";
    			}
    			else if(dml_action.equalsIgnoreCase("INSERT"))
    			{
    				String str2="insert into $tablename $keyvalue values $testdata";
    				PreparedStatement stmt=conn.prepareStatement(str2);
    				System.out.println("Query"+table_name);
    				System.out.println("Query1"+test_data);
    				System.out.println("Query2"+column_name);
    				System.out.println("Query3"+str2);
    				str2 =str2.replace("$tablename",table_name);
                    str2=str2.replace("$keyvalue",column_name); 
                    String query=str2.replace("$testdata",Condition_Name);
                    System.out.println("Query443"+query);
    				//stmt.setString(1,table_name);
        		//	stmt.setString(2,test_data);
        		//	stmt.setString(3,column_name);
        			stmt.executeUpdate();
        			Medicopilot.TestCaseStapeStatus="Pass";
    			
    			}
    			else if(dml_action.equalsIgnoreCase("DELETE"))
    			{System.out.println("i am in ServerName12");
    				String str2="delete from $tablename where $condition";
    				System.out.println("i am in ServerName12");
    				
    				 str2 =str2.replace("$tablename",table_name);
    				 
    				 System.out.println("i am in ServerName12");
                   //  str2=str2.replace("$keyvalue",column_name); 
                     String query=str2.replace("$condition",column_name); 
                     System.out.println("Query1"+query);
    			//	String query=str2.replace("$keyname",column_name);
    				PreparedStatement stmt=conn.prepareStatement(query);
    				System.out.println("i am in ServerName12"+query);
    				//stmt.setString(1,table_name);
    				
        			//stmt.setString(2,Column_value);
        			//stmt.setString(2,Condition_value);
        			
        			stmt.executeUpdate();
        			
        			Medicopilot.TestCaseStapeStatus="Pass";
    			}
    			
    			else if(dml_action.equalsIgnoreCase("CREATE"))
    			{
    				
    				System.out.println("i am in ServerName12");
    				String str2="CREATE Table $tablename ($keyvalue)";
    				System.out.println("i am in ServerName12");
    				 str2 =str2.replace("$tablename",table_name);
    				 System.out.println("i am in ServerName12");
    				 String query=str2.replace("$keyvalue",column_name); 
                   // =str2.replace("$condition",column_name); 
                     
    			//	String query=str2.replace("$keyname",column_name);
    				PreparedStatement stmt=conn.prepareStatement(query);
    				System.out.println("i am in ServerName12"+query);
    				//stmt.setString(1,table_name);
    				
        			//stmt.setString(2,Column_value);
        			//stmt.setString(2,Condition_value);
        			
        			stmt.executeUpdate();
        			
        			Medicopilot.TestCaseStapeStatus="Pass";
    				
    			}
    				
    				
    				else 
    				System.out.println("Invalid Action!!!!!");
    			 //Medicopilot.TestCaseStapeStatus="Failed";
    			}
    			
    		 catch(NullPointerException e)
            {
          
          	System.out.println("Patient is not correct  or deleted");
          	 Medicopilot.TestCaseStapeStatus="Failed";
          }
    		
    		
    		
		catch(Exception e)
	{
			    System.out.println("Exception in setText Action : "+e);
			    
			    Medicopilot.TestCaseStapeStatus="Fail";
		    System.out.println("Ashok :: Status is ::"+Medicopilot.TestCaseStapeStatus);
		    MasterActions.ExceptionMessage="Exception in setText Action : "+e.getMessage().toString();
		    if(Screenshot.equalsIgnoreCase("Y"))
			{
			screnshotcls obj=new screnshotcls(driver);
		}
	    if(Medicopilot.TestCasePriority.equalsIgnoreCase("P1"))
		    	{
			    	MasterActions.TestCasePriorityRep=true;
			    	driver.close();
			    					    	
		    	}
    		
	}
		
   break;
            
        case "getText":
           
        	try
        	{
            String ActualValue=driver.findElement(this.getObject(LocatorValue,LocatorType)).getText();
            System.out.println("Value is \n" + ActualValue);
            Medicopilot.TestCaseStapeStatus="Pass";
            if(Screenshot.equalsIgnoreCase("Y")) 
			{
				screnshotcls obj=new screnshotcls(driver);
			}
        	}
			catch(Exception e)
			{
				    System.out.println("Exception in getText Action : "+e);
				    Medicopilot.TestCaseStapeStatus="Fail";
				    MasterActions.ExceptionMessage="Exception in getText Action : "+e.getMessage().toString();
				    if(Screenshot.equalsIgnoreCase("Y"))
					{
						screnshotcls obj=new screnshotcls(driver);
					}
				    if(Medicopilot.TestCasePriority.equalsIgnoreCase("P1"))
			    	{
			    	MasterActions.TestCasePriorityRep=true;
			    	driver.close();
			    	}
			}
            break;
            
        case "getcolor":
            
        	try
        	{ 
       String ActualValue=driver.findElement(this.getObject(LocatorValue,LocatorType)).getCssValue("color");
       Assert.assertEquals(ActualValue,TestData); 
       System.out.println("Pass");
        		
            System.out.println(ActualValue);
            Medicopilot.TestCaseStapeStatus="Pass";
        
        	
            if(Screenshot.equalsIgnoreCase("Y"))
			{
				screnshotcls obj=new screnshotcls(driver);
			}
        	}
			catch(Exception e)
			{
				    System.out.println("Exception in getText Action : "+e);
				    Medicopilot.TestCaseStapeStatus="Fail";
				    MasterActions.ExceptionMessage="Exception in getText Action : "+e.getMessage().toString();
				    if(Screenshot.equalsIgnoreCase("Y"))
					{
						screnshotcls obj=new screnshotcls(driver);
					}
				    if(Medicopilot.TestCasePriority.equalsIgnoreCase("P1"))
			    	{
			    	MasterActions.TestCasePriorityRep=true;
			    	driver.close();
			    	}
			}
            break;
            
            
        case "test":
        	System.out.println(driver.findElement(By.xpath(".//*[@id='ctl00_cpb_gridCallbackPanel_gridFilterData_DXDataRow0']/td[8]")).getAttribute("style"));
        	break;
        	
        case "verifyResult":
        	String ActualValue1;
        	try{
        if(TestData=="confirmed")
        {
        	String id=getID();
        	System.out.println(id);
        	
        	ActualValue1=driver.findElement(By.xpath(id)).getAttribute("style");
        	System.out.println("AcutlaValue"+ActualValue1);
        }   
        else{
        	
            ActualValue1=driver.findElement(this.getObject(LocatorValue,LocatorType)).getText();
        
            }
            try
    		{
    		Assert.assertEquals(ActualValue1,TestData); 
    		System.out.println("Pass");
    		Medicopilot.TestCaseStapeStatus="Pass";
    		if(Screenshot.equalsIgnoreCase("Y"))
			{
				screnshotcls obj=new screnshotcls(driver);
			}
    		}catch(AssertionError e)
    		{
    			System.out.println("Fail");
    			Medicopilot.TestCaseStapeStatus="Fail";
    			 MasterActions.ExceptionMessage="Exception in verifyResult Action : "+e.getMessage().toString();
    			 if(Screenshot.equalsIgnoreCase("Y"))
 				{
 					screnshotcls obj=new screnshotcls(driver);
 				}
    			System.out.println(e.getMessage());
    			if(Medicopilot.TestCasePriority.equalsIgnoreCase("P1"))
		    	{
		    	MasterActions.TestCasePriorityRep=true;
		    	driver.close();
		    	}
    		}
        	}
			catch(Exception e)
			{
				    System.out.println("Fail");
				    Medicopilot.TestCaseStapeStatus="Fail";
				    MasterActions.ExceptionMessage="Exception in verifyResult Action : "+e.getMessage().toString();
				    if(Screenshot.equalsIgnoreCase("Y"))
					{
						screnshotcls obj=new screnshotcls(driver);
					}
				    System.out.println("Exception in verifyResult Action : "+e);
				    if(Medicopilot.TestCasePriority.equalsIgnoreCase("P1"))
			    	{
			    	MasterActions.TestCasePriorityRep=true;
			    	driver.close();
			    	}
			}
        	
            break;
        case "verifyResultParameter":
        	String ActualValueparameter = null;
        	try{
        if(TestData=="confirmed")
        {
        	String id=getID();
        	System.out.println(id);
        	
        	ActualValue1=driver.findElement(By.xpath(id)).getAttribute("style");
        	System.out.println("AcutlaValue"+ActualValue1);
        }   
        else{
        	
        	ActualValueparameter=driver.findElement(this.getObject(LocatorValue,LocatorType)).getText();
        	TestData=prop.getProperty(TestData);
        System.out.println("sd"+TestData);    
        }
            try
    		{
    		Assert.assertEquals(ActualValueparameter,TestData); 
    		System.out.println("Pass");
    		Medicopilot.TestCaseStapeStatus="Pass";
    		if(Screenshot.equalsIgnoreCase("Y"))
			{
				screnshotcls obj=new screnshotcls(driver);
			}
    		}catch(AssertionError e)
    		{
    			System.out.println("Fail");
    			Medicopilot.TestCaseStapeStatus="Fail";
    			 MasterActions.ExceptionMessage="Exception in verifyResult Action : "+e.getMessage().toString();
    			 if(Screenshot.equalsIgnoreCase("Y"))
 				{
 					screnshotcls obj=new screnshotcls(driver);
 				}
    			System.out.println(e.getMessage());
    			if(Medicopilot.TestCasePriority.equalsIgnoreCase("P1"))
		    	{
		    	MasterActions.TestCasePriorityRep=true;
		    	driver.close();
		    	}
    		}
        	}
			catch(Exception e)
			{
				    System.out.println("Fail");
				    Medicopilot.TestCaseStapeStatus="Fail";
				    MasterActions.ExceptionMessage="Exception in verifyResult Action : "+e.getMessage().toString();
				    if(Screenshot.equalsIgnoreCase("Y"))
					{
						screnshotcls obj=new screnshotcls(driver);
					}
				    System.out.println("Exception in verifyResult Action : "+e);
				    if(Medicopilot.TestCasePriority.equalsIgnoreCase("P1"))
			    	{
			    	MasterActions.TestCasePriorityRep=true;
			    	driver.close();
			    	}
			}
        	
            break;
        case "verifyResultTenant":
        	String ActualValueT;
        	try{
        if(TestData=="confirmed")
        {
        	String id=getID();
        	System.out.println(id);
        	
        	ActualValueT=driver.findElement(By.xpath(id)).getAttribute("style");
        	System.out.println("AcutlaValue"+ActualValueT);
        }   
        else{
        	
            ActualValueT=driver.findElement(this.getObject(LocatorValue,LocatorType)).getText();
        
            }
            try
    		{
    		Assert.assertEquals(ActualValueT,prop.getProperty(TestData)); 
    		System.out.println("Pass");
    		Medicopilot.TestCaseStapeStatus="Pass";
    		if(Screenshot.equalsIgnoreCase("Y"))
			{
				screnshotcls obj=new screnshotcls(driver);
			}
    		}catch(AssertionError e)
    		{
    			System.out.println("Fail");
    			Medicopilot.TestCaseStapeStatus="Fail";
    			 MasterActions.ExceptionMessage="Exception in verifyResult Action : "+e.getMessage().toString();
    			 if(Screenshot.equalsIgnoreCase("Y"))
 				{
 					screnshotcls obj=new screnshotcls(driver);
 				}
    			System.out.println(e.getMessage());
    			if(Medicopilot.TestCasePriority.equalsIgnoreCase("P1"))
		    	{
		    	MasterActions.TestCasePriorityRep=true;
		    	driver.close();
		    	}
    		}
        	}
			catch(Exception e)
			{
				    System.out.println("Fail");
				    Medicopilot.TestCaseStapeStatus="Fail";
				    MasterActions.ExceptionMessage="Exception in verifyResult Action : "+e.getMessage().toString();
				    if(Screenshot.equalsIgnoreCase("Y"))
					{
						screnshotcls obj=new screnshotcls(driver);
					}
				    System.out.println("Exception in verifyResult Action : "+e);
				    if(Medicopilot.TestCasePriority.equalsIgnoreCase("P1"))
			    	{
			    	MasterActions.TestCasePriorityRep=true;
			    	driver.close();
			    	}
			}
            break;

        case "SP_Assertion":
        	String ActualValue21;
            String  previous11 = "PREVIOUS ECG"
    				+"\n" +"ABERRANT;";
    				//+ "\n" +"\n" +"Confirmed by: Dr OMD123 On 12 Jul 2017 2255" ;          	
            ActualValue21=driver.findElement(this.getObject(LocatorValue,LocatorType)).getText();
            try{
            	Assert.assertEquals(ActualValue21,previous11);
            }
             catch(Exception e)
            {
            	 System.out.println("exception");
             }
    		System.out.println("Previous text box values are matcghing");
            break;     
            /*try
    		{
    		
    		Medicopilot.TestCaseStapeStatus="Pass";
    		if(Screenshot.equalsIgnoreCase("Y"))
			{
				screnshotcls obj=new screnshotcls(driver);
			}
    		}catch(AssertionError e)
    		{
    			System.out.println("Fail");
    			Medicopilot.TestCaseStapeStatus="Fail";
    			 MasterActions.ExceptionMessage="Exception in verifyResult Action : "+e.getMessage().toString();
    			 if(Screenshot.equalsIgnoreCase("Y"))
 				{
 					screnshotcls obj=new screnshotcls(driver);
 				}
    			System.out.println(e.getMessage());
    			if(Medicopilot.TestCasePriority.equalsIgnoreCase("P1"))
		    	{
		    	MasterActions.TestCasePriorityRep=true;
		    	driver.close();
		    	}
    		}
		
			catch(Exception e)
			{
				    System.out.println("Fail");
				    Medicopilot.TestCaseStapeStatus="Fail";
				    MasterActions.ExceptionMessage="Exception in verifyResult Action : "+e.getMessage().toString();
				    if(Screenshot.equalsIgnoreCase("Y"))
					{
						screnshotcls obj=new screnshotcls(driver);
					}
				    System.out.println("Exception in verifyResult Action : "+e);
				    if(Medicopilot.TestCasePriority.equalsIgnoreCase("P1"))
			    	{
			    	MasterActions.TestCasePriorityRep=true;
			    	driver.close();
			    	}
			}   */      
            
            //        case "screenshot":
//        	
//        	try
//        	{
//        		
//    		 
//            File scrshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//        	
//            FileUtils.copyFile(scrshot, new File("c:\\seleniumscreenshot\\"+Medicopilot.TestCaseName.toString()+"\\"+Medicopilot.TestCaseName.toString()+"_"+"Step#"+(Medicopilot.TestCaseStapeNo-1)+".png"));
//            Medicopilot.TestCaseStapeStatus="Pass";
//        	}
//			catch(Exception e)
//			{
//				    System.out.println("Exception in screenshot Action : "+e);
//				    Medicopilot.TestCaseStapeStatus="Fail";
//				    MasterActions.ExceptionMessage="Exception in screenshot Action : "+e.getMessage().toString();
//				    if(Medicopilot.TestCasePriority.equalsIgnoreCase("P1"))
//			    	{
//			    	MasterActions.TestCasePriorityRep=true;
//			    	driver.close();
//			    	}
//			}
//            
//            break;
             
        case "IntializeBrowser":
        {
        	if(	Medicopilot.TestCasePriority.equalsIgnoreCase("IE"))
        	{
        		System.setProperty("webdriver.ie.driver", Medicopilot.path+"\\Used\\IEDirver\\64\\IEDriverServer.exe");
        		driver = new InternetExplorerDriver(); 
        	
        }
        	else
        	{
        		
            	System.setProperty("webdriver.chrome.driver", Medicopilot.path+"\\Used\\Chrome\\chromedriver.exe");
        	driver = new ChromeDriver();
        	}
        }
        break;
        case "launchBrowser":
        	
        	try
        	{
        		
        		if (driver.equals("ChromeDriver: chrome on XP (null)"))
        		{
                System.out.println(" i am in IF");
                Driverpath1=prop.getProperty("DriverPath");
        	    System.setProperty("webdriver.chrome.driver",path1+Driverpath1);
        		driver = new ChromeDriver();
        		}
        		
        		
        		System.out.println("Afterlaunch print all link--------gjj");
        		
        	System.out.println(driver);
			Thread.sleep(1000);
            driver.get(prop.getProperty(TestData));
			System.out.println("Testdata"+TestData);
            driver.manage().timeouts().pageLoadTimeout(105, TimeUnit.SECONDS);
    		driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
    		driver.manage().window().maximize();
    		driver.manage().deleteAllCookies();
    		Thread.sleep(3000);
         	System.out.println("i am in launch print all link--------");
    		
    		List<WebElement> links = driver.findElements(By.tagName("a")); 
    		System.out.println("Size of link"+links.size());
    		java.util.Iterator<WebElement> it = links.iterator();
    		
    		while(it.hasNext()){
    			String url = it.next().getAttribute("href");
    	System.out.println(url); 
    	
    	System.out.println("Afterlaunch print all link--------");
    	String currTitle=driver.getTitle();
    	System.out.println("Current Title"+ currTitle);
    	String ULRCu=driver.getCurrentUrl();
    	System.out.println("Current URL"+ULRCu);
    		}
    		if(Screenshot.equalsIgnoreCase("Y"))
			{
				screnshotcls obj=new screnshotcls(driver);
			}
    		Medicopilot.TestCaseStapeStatus="Pass";
        	}
			catch(Exception e)
			{
				    System.out.println("Exception in LaunchBrowser Action : "+e);
				    Medicopilot.TestCaseStapeStatus="Fail";
				    MasterActions.ExceptionMessage="Exception in LaunchBrowser Action : "+e.getMessage().toString();
				    if(Screenshot.equalsIgnoreCase("Y"))
					{
						screnshotcls obj=new screnshotcls(driver);
					}
				    if(Medicopilot.TestCasePriority.equalsIgnoreCase("P1"))
			    	{
			    	MasterActions.TestCasePriorityRep=true;
			    	driver.close();
			    	}
			}
    		break;
            
        case "closeBrowser":
        	final Runtime rt = Runtime.getRuntime();
        	try {
        		
        		
	        	 System.out.println("wewe2");
		        		driver.close();
		        		//System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe");
		        		//Process P1=rt.exec("C:\\killGecodriver.bat");
		       		 System.out.println("wewe2");
			        //	P1.waitFor();
		        		
		        		 System.out.println("wewe2weweew");
			   
			        	Thread.sleep(5000);	
			        	 System.out.println("wewe2");
			        	Medicopilot.TestCaseStapeStatus="Pass";
			        	if(Screenshot.equalsIgnoreCase("Y"))
						{
							screnshotcls obj=new screnshotcls(driver);
						}
	        	  	 
        		} 
				
				catch(Exception e)
				{
					    System.out.println("Exception in closeBrowser Action : "+e);
					    Medicopilot.TestCaseStapeStatus="Fail";
					    MasterActions.ExceptionMessage="Exception in closeBrowser Action : "+e.getMessage().toString();
					    if(Screenshot.equalsIgnoreCase("Y"))
						{
							screnshotcls obj=new screnshotcls(driver);
						}
					    if(Medicopilot.TestCasePriority.equalsIgnoreCase("P1"))
				    	{
				    	MasterActions.TestCasePriorityRep=true;
				    	driver.close();
				    	}
				}
            break;
            
            

            
        case "logout":
	        {
	        	try
	        	{
	        	((JavascriptExecutor)driver).executeScript("LogOut('../Login.aspx?State=Logout')");
	        	Medicopilot.TestCaseStapeStatus="Pass";
	        	if(Screenshot.equalsIgnoreCase("Y"))
				{
					screnshotcls obj=new screnshotcls(driver);
				}
	        	}
	        	catch(Exception e)
	        	{
	        		System.out.println("Exception in logout Action : "+e);
	        		Medicopilot.TestCaseStapeStatus="Fail";
	        		 MasterActions.ExceptionMessage="Exception in logout Action : "+e.getMessage().toString();
	        		 if(Screenshot.equalsIgnoreCase("Y"))
	 				{
	 					screnshotcls obj=new screnshotcls(driver);
	 				}
	        		if(Medicopilot.TestCasePriority.equalsIgnoreCase("P1"))
			    	{
			    	MasterActions.TestCasePriorityRep=true;
			    	driver.close();
			    	}
	        	}
	        }
	        break;
        
        case "SLEEP":
	        {
	        	try
	        	{
	        	long sleeptime=Long.parseLong(TestData);
	        	Thread.sleep(sleeptime);
	        	System.out.println("In sleep mode");
	        	Medicopilot.TestCaseStapeStatus="Pass";
	        	if(Screenshot.equalsIgnoreCase("Y"))
				{
					screnshotcls obj=new screnshotcls(driver);
				}
	        	} catch (NumberFormatException nfe) 
	        	{
	                System.out.println("NumberFormatException: in SLEEP Action " + nfe.getMessage());
	                Medicopilot.TestCaseStapeStatus="Pass";
	                MasterActions.ExceptionMessage="NumberFormatException: in SLEEP Action " +nfe.getMessage().toString();
	                if(Screenshot.equalsIgnoreCase("Y"))
					{
						screnshotcls obj=new screnshotcls(driver);
					}
	            }
	        	catch(Exception e)
				{
					    System.out.println("Exception in SLEEP Action : "+e);
					    Medicopilot.TestCaseStapeStatus="Pass";
					    MasterActions.ExceptionMessage="Exception in SLEEP Action : "+e.getMessage().toString();
					    if(Screenshot.equalsIgnoreCase("Y"))
						{
							screnshotcls obj=new screnshotcls(driver);
						}
					    if(Medicopilot.TestCasePriority.equalsIgnoreCase("P1"))
				    	{
				    	MasterActions.TestCasePriorityRep=true;
				    	driver.close();
				    	}
				}
	        }
	        break;
	        
	        case "TAB":
	        {
	        	try
	        	{
	        	driver.findElement(this.getObject(LocatorValue,LocatorType)).sendKeys(Keys.TAB);
	        	Medicopilot.TestCaseStapeStatus="Pass";
	        	if(Screenshot.equalsIgnoreCase("Y"))
				{
					screnshotcls obj=new screnshotcls(driver);
				}
	        	}
				catch(Exception e)
				{
					    System.out.println("Exception in TAB Action : "+e);
					    Medicopilot.TestCaseStapeStatus="Fail";
					    MasterActions.ExceptionMessage="Exception in TAB Action : "+e.getMessage().toString();
					    if(Screenshot.equalsIgnoreCase("Y"))
						{
							screnshotcls obj=new screnshotcls(driver);
						}
					    if(Medicopilot.TestCasePriority.equalsIgnoreCase("P1"))
				    	{
				    	MasterActions.TestCasePriorityRep=true;
				    	driver.close();
				    	}
				}
	        }
	        break;
	        
	        
	        case "ClrText":
	        {
	        	try
	        	{
	        	driver.findElement(this.getObject(LocatorValue, LocatorType)).clear();
	        	Medicopilot.TestCaseStapeStatus="Pass";
	        	if(Screenshot.equalsIgnoreCase("Y"))
				{
					screnshotcls obj=new screnshotcls(driver);
				}
	        	}
				catch(Exception e)
				{
					    System.out.println("Exception in ClrText Action : "+e);
					    Medicopilot.TestCaseStapeStatus="Fail";
					    MasterActions.ExceptionMessage="Exception in ClrText Action : "+e.getMessage().toString();
					    if(Screenshot.equalsIgnoreCase("Y"))
						{
							screnshotcls obj=new screnshotcls(driver);
						}
					    if(Medicopilot.TestCasePriority.equalsIgnoreCase("P1"))
				    	{
				    	MasterActions.TestCasePriorityRep=true;
				    	driver.close();
				    	}
				}
	        }
	        break;
        
	        case "SwitchToFrame":
	        {
	        	if(TestData.equalsIgnoreCase("Parent"))
	        	{
	        		//After you done with child window
	        		try
		        	{
	        		System.out.println("Current value is "+Medicopilot.parentWindowHandleq);
	        		driver.switchTo().window(Medicopilot.parentWindowHandleq);
	        		Medicopilot.TestCaseStapeStatus="Pass";
		        	if(Screenshot.equalsIgnoreCase("Y"))
					{
						screnshotcls obj=new screnshotcls(driver);
					}
		        	}
		        	
					catch(Exception e)
					{
						    System.out.println("Exception in SwitchFrame Action : "+e);
						    Medicopilot.TestCaseStapeStatus="Fail";
						    MasterActions.ExceptionMessage="Exception in SwitchFrame Action : "+e.getMessage().toString();
						    Medicopilot.FailedError=MasterActions.ExceptionMessage;
						    if(Screenshot.equalsIgnoreCase("Y"))
							{
								screnshotcls obj=new screnshotcls(driver);
							}
						    if(Medicopilot.TestCasePriority.equalsIgnoreCase("P1"))
					    	{
					    	MasterActions.TestCasePriorityRep=true;
					    	driver.close();
					    	}
					}
		        }
	        	else if(TestData.equalsIgnoreCase("Child"))
	        	{
	        		
	        		try
		        	{
	        		
	        		screnshotcls screnshotcls=new screnshotcls(driver);
	        		screnshotcls.NewWindowScreenShot();
	        		Medicopilot.TestCaseStapeStatus="Pass";
//		        	if(Screenshot.equalsIgnoreCase("Y"))
//					{
//						screnshotcls obj=new screnshotcls(driver);
//					}
		        	}
		        	
					catch(Exception e)
					{
						    System.out.println("Exception in SwitchFrame Action : "+e);
						    Medicopilot.TestCaseStapeStatus="Fail";
						    MasterActions.ExceptionMessage="Exception in SwitchFrame Action : "+e.getMessage().toString();
						    Medicopilot.FailedError=MasterActions.ExceptionMessage;
						    if(Screenshot.equalsIgnoreCase("Y"))
							{
								screnshotcls obj=new screnshotcls(driver);
							}
						    if(Medicopilot.TestCasePriority.equalsIgnoreCase("P1"))
					    	{
					    	MasterActions.TestCasePriorityRep=true;
					    	driver.close();
					    	}
					}
		        }
	        	
	        	else
	        	{
	        	try
	        	{
	        	String parentWindowHandle1 = driver.getWindowHandle();	
	        	Medicopilot.parentWindowHandleq=parentWindowHandle1;
	        	System.out.println("while first time captured value is "+Medicopilot.parentWindowHandleq);
	        	driver.switchTo().frame(prop.getProperty(LocatorValue));
	        	Medicopilot.TestCaseStapeStatus="Pass";
	        	if(Screenshot.equalsIgnoreCase("Y"))
				{
					screnshotcls obj=new screnshotcls(driver);
				}
	        	}
	        	
				catch(Exception e)
				{
					    System.out.println("Exception in SwitchFrame Action : "+e);
					    Medicopilot.TestCaseStapeStatus="Fail";
					    MasterActions.ExceptionMessage="Exception in SwitchFrame Action : "+e.getMessage().toString();
					    Medicopilot.FailedError=MasterActions.ExceptionMessage;
					    if(Screenshot.equalsIgnoreCase("Y"))
						{
							screnshotcls obj=new screnshotcls(driver);
						}
					    if(Medicopilot.TestCasePriority.equalsIgnoreCase("P1"))
				    	{
				    	MasterActions.TestCasePriorityRep=true;
				    	driver.close();
				    	}
				}
	        	}
	        	
	        	        	
	        }
	        break;

        
	        case "ActionClick":
	        {
	        	try
	        	{
	        	Actions actions = new Actions(driver);
	    		WebElement subMenu = driver.findElement(this.getObject(LocatorValue, LocatorType));
	    		actions.moveToElement(subMenu);
	    		actions.click().build().perform();
	    		Medicopilot.TestCaseStapeStatus="Pass";
	    		if(Screenshot.equalsIgnoreCase("Y"))
				{
					screnshotcls obj=new screnshotcls(driver);
				}
	        	}
				catch(Exception e)
				{
					    System.out.println("Exception in ActionClick Action : "+e);
					    Medicopilot.TestCaseStapeStatus="Fail";
					    MasterActions.ExceptionMessage="Exception in ActionClick Action : "+e.getMessage().toString();
					    if(Screenshot.equalsIgnoreCase("Y"))
						{
							screnshotcls obj=new screnshotcls(driver);
						}
					    if(Medicopilot.TestCasePriority.equalsIgnoreCase("P1"))
				    	{
				    	MasterActions.TestCasePriorityRep=true;
				    	driver.close();
				    	}
				}
	        }
	        break;
	        
	        case "ParentFrame":
	        {
	        	try
	        	{
	        	driver.switchTo().parentFrame();
	        	Medicopilot.TestCaseStapeStatus="Pass";
	        	if(Screenshot.equalsIgnoreCase("Y"))
				{
					screnshotcls obj=new screnshotcls(driver);
				}
	        	}
				catch(Exception e)
				{
					    System.out.println("Exception in ParentFrame Action : "+e);
					    Medicopilot.TestCaseStapeStatus="Fail";
					    MasterActions.ExceptionMessage="Exception in ParentFrame Action : "+e.getMessage().toString();
					    if(Screenshot.equalsIgnoreCase("Y"))
						{
							screnshotcls obj=new screnshotcls(driver);
						}
					    if(Medicopilot.TestCasePriority.equalsIgnoreCase("P1"))
				    	{
				    	MasterActions.TestCasePriorityRep=true;
				    	driver.close();
				    	}
				}
	        	        	
	        }
	        break;
	        
	        case "DropdownSelect":
	        {
	        
				//System.out.println("I m in CLICKBUTTON"+LocatorValue+"  "+LocatorType);
				try
				{
			
					try
					{
						System.out.println("Yes1");
					 dropdown=new Select(driver.findElement(this.getObject(LocatorValue,LocatorType)));
					}
					catch(Exception e)
					{
						System.out.println("Ankits inner exc :: "+e);
					}
					
					dropdown.selectByVisibleText(TestData);
				
					Medicopilot.TestCaseStapeStatus="Pass";
					if(Screenshot.equalsIgnoreCase("Y"))
					{
						screnshotcls obj=new screnshotcls(driver);
					}
					
				
				}
				catch(ElementNotVisibleException e)
				{
					try
					{
					    WebElement element = driver.findElement(this.getObject(LocatorValue,LocatorType));
						JavascriptExecutor js = (JavascriptExecutor)driver; 
						js.executeScript("arguments[0].click();", element); 
						Medicopilot.TestCaseStapeStatus="Pass";
						
						if(Screenshot.equalsIgnoreCase("Y"))
						{
							screnshotcls obj=new screnshotcls(driver);
						}
					}
						catch(Exception e1)
						{
							Medicopilot.TestCaseStapeStatus="Fail";
							System.out.println("Exception in clickButton Action : "+e1);
							MasterActions.ExceptionMessage="Exception in clickButton Action : "+e1.getMessage().toString();
							if(Screenshot.equalsIgnoreCase("Y"))
							{
								screnshotcls obj=new screnshotcls(driver);
							}
							if(Medicopilot.TestCasePriority.equalsIgnoreCase("P1"))
					    	{
					    	MasterActions.TestCasePriorityRep=true;
					    	driver.close();
					    	}
						}
				}
				catch(Exception e)
				{
					    System.out.println("Exception in clickButton Action : "+e);
					    Medicopilot.TestCaseStapeStatus="Fail";
					    MasterActions.ExceptionMessage="Exception in clickButton Action :   "+e.getMessage().toString();
					    if(Screenshot.equalsIgnoreCase("Y"))
						{
							screnshotcls obj=new screnshotcls(driver);
						}
					    if(Medicopilot.TestCasePriority.equalsIgnoreCase("P1"))
				    	{
				    	MasterActions.TestCasePriorityRep=true;
				    	driver.close();
				    	}
				}
						
				
			}
			break;
			
	        
	        case "JavascriptExecutor":
	        {
	        	try
	        	{
	        	((JavascriptExecutor)driver).executeScript(prop.getProperty(LocatorValue));
	        	Medicopilot.TestCaseStapeStatus="Pass";
	        	if(Screenshot.equalsIgnoreCase("Y"))
				{
					screnshotcls obj=new screnshotcls(driver);
				}
	        	}
				catch(Exception e)
				{
					    System.out.println("Exception in JavascriptExecutor Action : "+e);
					    Medicopilot.TestCaseStapeStatus="Fail";
					    MasterActions.ExceptionMessage="Exception in JavascriptExecutor Action : "+e.getMessage().toString();
					    if(Screenshot.equalsIgnoreCase("Y"))
						{
							screnshotcls obj=new screnshotcls(driver);
						}
					    if(Medicopilot.TestCasePriority.equalsIgnoreCase("P1"))
				    	{
				    	MasterActions.TestCasePriorityRep=true;
				    	driver.close();
				    	}
				}
	        }
	        break;
	        
	        
	        case "Mousehover":
	        {
	        	
	        	 WebElement menuOption =driver.findElement(this.getObject(LocatorValue, LocatorType));
		            Actions action1 = new Actions(driver);
		            action1.moveToElement(menuOption).build().perform();
	        	try
	        	{
	        	
	           
	            
	    		Medicopilot.TestCaseStapeStatus="Pass";
	    		if(Screenshot.equalsIgnoreCase("Y"))
				{
					screnshotcls obj=new screnshotcls(driver);
				}
	        	}
				catch(Exception e)
				{
					    System.out.println("Exception in ActionClick Action : "+e);
					    Medicopilot.TestCaseStapeStatus="Fail";
					    MasterActions.ExceptionMessage="Exception in ActionClick Action : "+e.getMessage().toString();
					    if(Screenshot.equalsIgnoreCase("Y"))
						{
							screnshotcls obj=new screnshotcls(driver);
						}
					    if(Medicopilot.TestCasePriority.equalsIgnoreCase("P1"))
				    	{
				    	MasterActions.TestCasePriorityRep=true;
				    	driver.close();
				    	}
				}
	        }
	        break;
	        
	        case "Tooltip":
	        {
	        	try
	        	{
	        		WebElement toolTipEle = driver.findElement(this.getObject(LocatorValue, LocatorType));
	        		 // Get the Tool Tip Text
	        		//Actions action = new Actions(driver);
	        		//action.moveToElement(toolTipEle);
	        		//toolTipEle.
	        		Thread.sleep(2000); 
	        		String toolTipTxt = toolTipEle.getText();
	        		    System.out.println("Exception Tool Tip Action : "+toolTipTxt);
	        		    Assert.assertEquals(toolTipTxt,TestData); 
	        		    System.out.println("Pass"+toolTipTxt);
	        		    Thread.sleep(20000);
	            		System.out.println("Pass");
	          
	    		Medicopilot.TestCaseStapeStatus="Pass";
	    		if(Screenshot.equalsIgnoreCase("Y"))
				{
					screnshotcls obj=new screnshotcls(driver);
				}
	        	}
	        	catch(NullPointerException e)
	        	{
	        		{
					    System.out.println("Exception in ActionClick Action : ");
					
					    Medicopilot.TestCaseStapeStatus="Fail";
					   
					    if(Screenshot.equalsIgnoreCase("Y"))
						{System.out.println("HiiiTestCases : ");
							screnshotcls obj=new screnshotcls(driver);
						}
					    if(Medicopilot.TestCasePriority.equalsIgnoreCase("P1"))
				    	{
				    	MasterActions.TestCasePriorityRep=true;
				    	driver.close();
				    	}
				}
	        		
	        	}
	        	
				catch(Exception e)
				{
					    System.out.println("Exception in ActionClick Action : ");
					
					    Medicopilot.TestCaseStapeStatus="Fail";
					    MasterActions.ExceptionMessage="Exception in ActionClick Action : "+e.getMessage().toString();
					
					    if(Screenshot.equalsIgnoreCase("Y"))
						{
					    	
							screnshotcls obj=new screnshotcls(driver);
						}
					    if(Medicopilot.TestCasePriority.equalsIgnoreCase("P1"))
				    	{
				    	MasterActions.TestCasePriorityRep=true;
				    	driver.close();
				    	}
				}
	        }
	        break;
	        
	        
	        case "upload":
	        {
	        	
	        	try
	        	{
	        		
	  WebElement subMenu = driver.findElement(this.getObject(LocatorValue, LocatorType));
	  
	  
	  subMenu.sendKeys(prop.getProperty("Filepath"));
	    	
	    	//Thread.sleep(10000);
	        		System.out.println("LocatorValue"+LocatorValue);	
	    	//driver.findElement(By.xpath(".//*[@id='ctl00_cpb_dxpcUpload_UploadControl_TextBox0_Input']")).click();    	
	    	System.out.println("LocatorValue"+LocatorValue);
	    	System.out.println("Locatortype"+LocatorType);
	    	//	subMenu.click();
	    		//subMenu.sendKeys("D:/Test/Test1.docx");
	    	//	StringSelection ss = new StringSelection("D:/Test/Test1.docx");
//	    	s	Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
//	    		Robot robot = new Robot();
//
//	    		robot.keyPress(java.awt.event.KeyEvent.VK_CONTROL);
//	    		robot.keyPress(java.awt.event.KeyEvent.VK_V);
//	    		robot.keyRelease(java.awt.event.KeyEvent.VK_V);
//	    		robot.keyRelease(java.awt.event.KeyEvent.VK_CONTROL);
//	    		robot.keyPress(java.awt.event.KeyEvent.VK_ENTER);
//	    		robot.keyRelease(java.awt.event.KeyEvent.VK_ENTER);
	    		Medicopilot.TestCaseStapeStatus="Pass";
    		if(Screenshot.equalsIgnoreCase("Y"))
			{
				screnshotcls obj=new screnshotcls(driver);
			}
	        	}
				catch(Exception e)
				{
					    System.out.println("Exception in ActionClick Action : "+e);
					    Medicopilot.TestCaseStapeStatus="Fail";
					    MasterActions.ExceptionMessage="Exception in ActionClick Action : "+e.getMessage().toString();
					    if(Screenshot.equalsIgnoreCase("Y"))
						{
							screnshotcls obj=new screnshotcls(driver);
						}
					    if(Medicopilot.TestCasePriority.equalsIgnoreCase("P1"))
				    	{
				    	MasterActions.TestCasePriorityRep=true;
				    	driver.close();
				    	}
				}
	        }
	        break;
	        case "upload1":
	        {
	        	
	        	boolean flag11=false;int count1=0;
	        	boolean flag2=false;int count2=0;
			//System.out.println(Long.parseLong(TestData));
			//System.out.println("hiii1");
			
	        	
		  WebDriverWait wait=new WebDriverWait(driver,800);
	        	
	        	try
	        	{
	        		
	        		for (int i=0;i<200;i++)
	        		{
	    		
	    		    
	    		 WebElement ele= wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(prop.getProperty("Upload_Publish_Content"))))); 
	    		ele.click();	
	    			
	        	/////////////////////////////////////////////////////	
	  WebElement subMenu = driver.findElement(this.getObject(LocatorValue, LocatorType));
	  subMenu.sendKeys(prop.getProperty("Filepath"));
	  Thread.sleep(5000);
	    ///////////////////////////////////PUblish Content Pack//////////////////////////////	
	//  driver.findElement(By.xpath(prop.getProperty("Publish"))).
	  
    
         WebElement ele1= wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(prop.getProperty("Publish")))));

       System.out.println("flag2="+flag2);
       ele1.click();	
	
	 //////////////////////////////Handel Alert////////////////////////////////////       		
	  System.out.println("flag2dfghdf");
	
	  wait.until(ExpectedConditions.alertIsPresent());
	   org.openqa.selenium.Alert alert = driver.switchTo().alert();	
	   System.out.println("flag2dfghdf");
       String alertMessage= driver.switchTo().alert().getText();
       System.out.println("flag2dfghdf");
	   System.out.println(alertMessage);
	   System.out.println("flag2dfghdf");
	   
  	   alert.accept();
	   ////////////////////////////////////Assertion////////////////////////////    		
	        	
  	  Thread.sleep(15000);
      String Act1="Download";
      String Act2="Upload New";
      String Act3="Delete";
      String Act4="Edit";
      String tk=driver.findElement(By.xpath(prop.getProperty("Download_publishcontent"))).getText();
      System.out.println(driver.findElement(By.xpath(prop.getProperty("Download_publishcontent"))).getText());
		Assert.assertEquals(tk,Act1); 
		System.out.println("Download link is present");

		Assert.assertEquals(driver.findElement(By.xpath(prop.getProperty("Upload_Publish_Content"))).getText(),Act2);
		System.out.println("Upload new link link is present");
		
		
		Assert.assertEquals(driver.findElement(By.xpath(prop.getProperty("Delete_Publish_Content"))).getText(),Act3);
		System.out.println("Delete link is present");
		Assert.assertEquals(driver.findElement(By.xpath(prop.getProperty("Edit_Content_Pack"))).getText(),Act4);
		System.out.println("Edit link is present");
	    	Medicopilot.TestCaseStapeStatus="Pass";
    		if(Screenshot.equalsIgnoreCase("Y"))
			{
				screnshotcls obj=new screnshotcls(driver);
			}
	        		}
	        	}
				catch(Exception e)
				{
					    System.out.println("Exception in ActionClick Action : "+e);
					    Medicopilot.TestCaseStapeStatus="Fail";
					    MasterActions.ExceptionMessage="Exception in ActionClick Action : "+e.getMessage().toString();
					    if(Screenshot.equalsIgnoreCase("Y"))
						{
							screnshotcls obj=new screnshotcls(driver);
						}
					    if(Medicopilot.TestCasePriority.equalsIgnoreCase("P1"))
				    	{
				    	MasterActions.TestCasePriorityRep=true;
				    	driver.close();
				    	}
				}
	        }
	        	
		
	        break;
	        
	        case "GVRSelectCheckbox":
	        {
	        
	        	// Grab the table
	/*        Thread.sleep(5000);
	        System.out.println("Start");
			WebElement table = driver.findElement(By.id(prop.getProperty(LocatorValue)));

			// Now get all the TR elements from the table
			List<WebElement> allRows = table.findElements(By.tagName("tr"));
			ArrayList al=new ArrayList<>();
			
			// And iterate over them, getting the cells
			for (WebElement row : allRows) 
			 {
			 List<WebElement> cells = row.findElements(By.tagName("td"));
			 for (WebElement cell : cells) 
			 {
				
				
				if(cell.getText().length()>1)
				{
					//System.out.println("Value is : "+cell.getText() +"      "+cell.getText().length());
					al.add(cell.getText());
				}
				
				
			}
			 	String[] ss=TestData.split("#");
			 	String date2=ss[1].replace("/", "-");
			 	if(al.contains(ss[0]) && (al.contains(ss[1]) ||al.contains(date2)))
				{
					System.out.println("Matching   ::   "+al);
					al.clear();
					//System.out.println("After clear    ::   "+al);
					driver.findElement(By.id(row.getAttribute("id"))).click();
					break;
				}
			 	al.clear();
			 	ss=null;
              GVRSelect(SwitchCaseActionName, LocatorType, LocatorValue, TestData, Screenshot);
		
			// System.out.println("==============================================================================");
				 
			 }*/
	        	WebElement row;
	        	flag=true;
	            try{
	            
	            
	        	row=GVRSelect(LocatorType, LocatorValue, TestData, Screenshot);
	            String str=row.getAttribute("id");
	            int len=str.length();
	            //int t=str.indexOf('9');
	           // System.out.println(t);
	            System.out.println(row);
	            String str1= str.substring(52,len);
	            System.out.println(str1);
	            String id="ctl00_cpb_gridCallbackPanel_gridFilterData_DXSelBtn";
	            id=id.concat(str1);
	            id=id.concat("_D");
	            System.out.println(id);
	            setID(id);
	            WebElement ele4=driver.findElement(By.id(id));
	            
	     	   ele4.click();
	     	  Medicopilot.TestCaseStapeStatus="Pass";
	     	   //ele4.click();
	        	
	            }
	            catch(NullPointerException e)
  	            {
	            
	            	System.out.println("Patient is not correct  or deleted");
	            	 Medicopilot.TestCaseStapeStatus="Failed";
	            }
	            
	            
	            
	            
	            
	            
	            
	       
	        }
        break;
	        case "GVRSelectpatient":
	        {
	        
	        	// Grab the table
	/*        Thread.sleep(5000);
	        System.out.println("Start");
			WebElement table = driver.findElement(By.id(prop.getProperty(LocatorValue)));

			// Now get all the TR elements from the table
			List<WebElement> allRows = table.findElements(By.tagName("tr"));
			ArrayList al=new ArrayList<>();
			
			// And iterate over them, getting the cells
			for (WebElement row : allRows) 
			 {
			 List<WebElement> cells = row.findElements(By.tagName("td"));
			 for (WebElement cell : cells) 
			 {
				
				
				if(cell.getText().length()>1)
				{
					//System.out.println("Value is : "+cell.getText() +"      "+cell.getText().length());
					al.add(cell.getText());
				}
				
				
			}
			 	String[] ss=TestData.split("#");
			 	String date2=ss[1].replace("/", "-");
			 	if(al.contains(ss[0]) && (al.contains(ss[1]) ||al.contains(date2)))
				{
					System.out.println("Matching   ::   "+al);
					al.clear();
					//System.out.println("After clear    ::   "+al);
					driver.findElement(By.id(row.getAttribute("id"))).click();
					break;
				}
			 	al.clear();
			 	ss=null;
              GVRSelect(SwitchCaseActionName, LocatorType, LocatorValue, TestData, Screenshot);
		
			// System.out.println("==============================================================================");
				 
			 }*/
	        	WebElement row;
	        	flag=true;
	            try{
	            
	            
	        	row=GVRSelect(LocatorType, LocatorValue, TestData, Screenshot);
	            
	        	row.click();
	        	 Medicopilot.TestCaseStapeStatus="Pass";
	            }
	            catch(NullPointerException e)
	            {
	            	System.out.println("Patient is not correct  or deleted");
	            	 Medicopilot.TestCaseStapeStatus="Failed";
	            }
	            
	            
	            
	            
	            
	            
	            
	       
	        }
        break;
	        case "Submit":
	        {
	        	try
	        	{
	        	driver.findElement(this.getObject(LocatorValue,LocatorType)).submit();
	        	Medicopilot.TestCaseStapeStatus="Pass";
	        	if(Screenshot.equalsIgnoreCase("Y"))
				{
					screnshotcls obj=new screnshotcls(driver);
				}
	        	}
				catch(Exception e)
				{
					    System.out.println("Exception in Submit Action : "+e);
					    Medicopilot.TestCaseStapeStatus="Fail";
					    MasterActions.ExceptionMessage="Exception in TAB Action : "+e.getMessage().toString();
					    if(Screenshot.equalsIgnoreCase("Y"))
						{
							screnshotcls obj=new screnshotcls(driver);
						}
					    if(Medicopilot.TestCasePriority.equalsIgnoreCase("P1"))
				    	{
				    	MasterActions.TestCasePriorityRep=true;
				    	driver.close();
				    	}
				}
	        }
	        
	        	
	        	break;
        	
case "GVRADTSelect":
{
	WebElement row;
	// Grab the table
/*        Thread.sleep(5000);
System.out.println("Start");
WebElement table = driver.findElement(By.id(prop.getProperty(LocatorValue)));

// Now get all the TR elements from the table
List<WebElement> allRows = table.findElements(By.tagName("tr"));
ArrayList al=new ArrayList<>();

// And iterate over them, getting the cells
for (WebElement row : allRows) 
 {
 List<WebElement> cells = row.findElements(By.tagName("td"));
 for (WebElement cell : cells) 
 {
	
	
	if(cell.getText().length()>1)
	{
		//System.out.println("Value is : "+cell.getText() +"      "+cell.getText().length());
		al.add(cell.getText());
	}
	
	
}
 	String[] ss=TestData.split("#");
 	String date2=ss[1].replace("/", "-");
 	if(al.contains(ss[0]) && (al.contains(ss[1]) ||al.contains(date2)))
	{
		System.out.println("Matching   ::   "+al);
		al.clear();
		//System.out.println("After clear    ::   "+al);
		driver.findElement(By.id(row.getAttribute("id"))).click();
		break;
	}
 	al.clear();
 	ss=null;
  GVRSelect(SwitchCaseActionName, LocatorType, LocatorValue, TestData, Screenshot);

// System.out.println("==============================================================================");
	 
 }*/
       String name;
	 row=GVRSelect(LocatorType, LocatorValue, TestData, Screenshot);
	 System.out.println("hii34");
	 //System.out.println(row.getText());
	  try
	  {
	 flag=true;
	 String id=row.getAttribute("id");
	 name=id;
	 name=name.concat("']/td[8]");
	  id=id.concat("']/td[8]/a/span/u");
	  String id1=".//*[@id='";
	  id=id1.concat(id);
	  name=id1.concat(name);
	  //setID(name); 
	  System.out.println(id);
	  
	
	  WebElement ele4=driver.findElement(By.xpath(id));
	   ele4.click();
	   ele4.click();
	   Medicopilot.TestCaseStapeStatus="Pass";
	  }
	  catch(NullPointerException e)
        {
      	System.out.println("Patient is not correct  or deleted");
      	 Medicopilot.TestCaseStapeStatus="Failed";
      }
      
      
}
break;

default:
break;



}


}
	
public  void SP_verification(){
		/*Prvs_Text= driver.findElement(By.id("memoPreviousECGMDInterpretation")).getText();
		Old_Text = driver.findElement(By.id("memoOldestECGMDInterpretation")).getText();*/
			
		String previous = "PREVIOUS ECG"
				+"\n" +"ABERRANT";
				//+ "\n" +"\n" +"Confirmed by: Dr OMD123 On 12 Jul 2017 2255" ;
		
		String Oldest = "OLDEST ECG"
				+"\n" +"High Fever;"
				+"\n" + "HighFever;";
		try
		{
		if(previous.equals(Prvs_Text) && (Oldest.equals(Old_Text))){
			System.out.println("\n Pass");
		}else{
			System.out.println("\n Fail");
		}
		}catch(Exception e)
		{
			System.out.println("Exception handled" + e);
		}
	}
		private By getObject(String LocatorValue,String LocatorType) throws Exception
		{
			Properties prop=new Properties();
		    FileInputStream finp=new FileInputStream(PropertiesFile);
		    prop.load(finp);
		    String [] param;
	        //Find by xpath
			if(LocatorType.equalsIgnoreCase("XPATH"))
	        {
				param=LocatorValue.split("#");
			
				if(LocatorValue.split("#").length<2)
				{
					
				//	System.out.println("HIIIIIIIIIITestCases:"+LocatorValue.split("#").length);
				String xpath=prop.getProperty(param[0]);
	           // return By.xpath(LocatorValue);
				return By.xpath(xpath);
				}
				else
				{
					//System.out.println("HIIIIIIIIIITestCases:"LocatorValue.split("#").length);
					String xpath=prop.getProperty(param[0]).replace("@param", param[1]);
					
					return By.xpath(xpath);
				}
					
	        }
	        //find by class
	        else if(LocatorType.equalsIgnoreCase("CLASSNAME"))
	        {
	             
	            return By.className(LocatorValue);
	             
	        }
	        //find by name
	        else if(LocatorType.equalsIgnoreCase("NAME"))
	        {
	             
	            return By.name(LocatorValue);
	             
	        }
	        //Find by css
	        else if(LocatorType.equalsIgnoreCase("CSS"))
	        {
	             
	            return By.cssSelector(LocatorValue);
	             
	        }
	        //find by link
	        else if(LocatorType.equalsIgnoreCase("LINK"))
	        {
	             
	            return By.linkText(LocatorValue);
	             
	        }
			//find by ID
	        else if(LocatorType.equalsIgnoreCase("ID"))
	        {
	             
	           // return By.id(LocatorValue);
	            return By.id(prop.getProperty(LocatorValue));
	             
	        }
	        //find by partial link
	        else if(LocatorType.equalsIgnoreCase("PARTIALLINK"))
	        {
	             
	            return By.partialLinkText(LocatorValue);
	             
	        }else
	        	
	        
	        {
	            throw new Exception("Wrong object type");
	        }
	   
	}

	public <E> WebElement GVRSelect(String LocatorType,String LocatorValue,String TestData,String Screenshot)  throws Exception
	
	{
		WebElement ele=null;
		Properties prop=new Properties();
	    FileInputStream finp=new FileInputStream(PropertiesFile);
	    prop.load(finp);
		 Thread.sleep(5000);
		 WebElement row1=null;
	        System.out.println("Start");
			WebElement table = driver.findElement(By.id(prop.getProperty(LocatorValue)));

			// Now get all the TR elements from the table
			List<WebElement> allRows = table.findElements(By.tagName("tr"));
			ArrayList al=new ArrayList<E>();
			
			
		
			System.out.println("hii");			
			// And iterate over them, getting the cells
			try
		 	{
			for (WebElement row : allRows) 
			 {
				System.out.println("hii1*******" + row.getText());
			 List<WebElement> cells = row.findElements(By.tagName("td"));
			 for (WebElement cell : cells) 
			 {
				 System.out.println("hii2");
				
				if(cell.getText().length()>1)
				{
					System.out.println("Value is : "+cell.getText() +"      "+cell.getText().length());
					al.add(cell.getText());
					
				}
				
				
			}
			 	String[] ss=TestData.split("#");
			 	System.out.println(ss[0] + "\thiii7"+ ss[1] );
			 	String date2=ss[1].replace("/", "-");
			 	System.out.println("hi6");
			 	
			 	if(al.contains(ss[0]) && (al.contains(ss[1]) ||al.contains(date2)))
				{
					System.out.println("Matching   ::   "+al);
					al.clear();
					//System.out.println("After clear    ::   "+al);
					/* WebElement ele=driver.findElement(By.id(row.getAttribute("id")));*/
					System.out.println("hiii8"+row.getAttribute("id"));
					
					//row.click();
					/*driver.findElement(By.xpath(".//*[@id='ctl00_cpb_gridCallbackPanel_gridFilterData_DXDataRow9'/td[8]/a/span/u")).click();
					System.out.println(row.getText());*/
					
					 row1=row;
					 setID(row.getAttribute("id"));
					 break;
				}
			 	
			 	
			 	al.clear();
			 	ss=null;
			// System.out.println("==============================================================================");
			
		flag=true;
	}
		 	}
			
		 	catch(NullPointerException e)
           {
           	System.out.println("Patient is not correct  or deleted");
           	 Medicopilot.TestCaseStapeStatus="Failed";
           }
           
			return row1;


}

	private Connection MyDbConnection(String user1,String dbpwd,String servername,String dbname) throws ClassNotFoundException, IOException
	{
		Properties prop=new Properties();
		FileInputStream finp=new FileInputStream(PropertiesFile);
	    prop.load(finp);
	
//		String user=prop.getProperty(user1);
//		String password=prop.getProperty(dbpwd);
//		String database=prop.getProperty(dbname);
//		String Servername=prop.getProperty(servername);
//		
//		String script6="..\\ECGManagerAuto\\Workbook\\HW\\Testdata_final.sql";
		//String script7="..\\ECGManagerAuto\\Workbook\\HW\\trigger_add_user and assigned group.sql";
		
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	//	System.out.println(servername.split("\\.").length);
		String dbURL = "jdbc:sqlserver://"+servername+":1433;database="+dbname+";user="+user1+"@"+servername.split("\\.")[0]+";password="+dbpwd+";encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30";
	//	System.out.println(servername.split(".")[0]);
		System.out.println(dbURL);
		Connection conn=null;
    		try
    		{
    			conn = DriverManager.getConnection(dbURL);
    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    		if (conn!= null) {
    		    System.out.println("Connected");
		
	}
    		return conn;
	}

	}
