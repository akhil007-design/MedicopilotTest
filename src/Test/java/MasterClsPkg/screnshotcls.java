package Test.java.MasterClsPkg;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.PixelGrabber;
import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Test.java.TestCases.Medicopilot;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.PixelGrabber;
public class screnshotcls 
{
	public static String screshotpath;
	public static WebDriver driver;
	
	public screnshotcls(WebDriver mydriver) 
	
	{
		driver=mydriver;
		try
    	{	
        File scrshot=((TakesScreenshot)mydriver).getScreenshotAs(OutputType.FILE);
    	String myscreshotpath=Medicopilot.path+"\\ECGManagerAuto\\seleniumscreenshot\\"+Medicopilot.TestCaseName.toString()+"\\"+Medicopilot.TestCaseName.toString()+"_"+"Step#"+(Medicopilot.TestCaseStapeNo)+".png";
       // String myscreshotpath="D:/java-neon/Project/ECGManagerAuto/seleniumscreenshot/test.png";
        FileUtils.copyFile(scrshot, new File(myscreshotpath));
        screnshotcls.screshotpath=myscreshotpath;
       // Medicopilot.TestCaseStapeStatus="Pass";
    	}
		catch(Exception e)
		{
			    System.out.println("Exception in screenshot Action : "+e);
			 //   Medicopilot.TestCaseStapeStatus="Fail";
			    MasterActions.ExceptionMessage="Exception in screenshot Action : "+e.getMessage().toString();
			    if(Medicopilot.TestCasePriority.equalsIgnoreCase("P1"))
		    	{
		    	MasterActions.TestCasePriorityRep=true;
		    	mydriver.close();
		    	}
		}
	}

	public static void compareImage(WebDriver driver, String fileB) 
	{
		screnshotcls screnshotcls=new screnshotcls(driver);
		File fileA=new File( screnshotcls.screshotpath);
		System.out.println("File 1 ::  "+fileA);
		System.out.println("File 2 ::  "+fileB);
		Image image1 = Toolkit.getDefaultToolkit().getImage(screnshotcls.screshotpath);
        Image image2 = Toolkit.getDefaultToolkit().getImage(fileB);
	    float percentage = 0;
	    try 
        {    
            PixelGrabber grab1 = new PixelGrabber(image1, 0, 0, -1, -1, false);
            PixelGrabber grab2 = new PixelGrabber(image2, 0, 0, -1, -1, false);
 
            int[] data1 = null;
 
            if (grab1.grabPixels()) 
            {
                int width = grab1.getWidth();
                int height = grab1.getHeight();
                data1 = new int[width * height];
                data1 = (int[]) grab1.getPixels();
            }
 
            int[] data2 = null;
 
            if (grab2.grabPixels()) {
                int width = grab2.getWidth();
                int height = grab2.getHeight();
                data2 = new int[width * height];
                data2 = (int[]) grab2.getPixels();
            }
 
            System.out.println("Pixels equal: " + java.util.Arrays.equals(data1, data2));
            if(java.util.Arrays.equals(data1, data2))
            {
            	System.out.println("Images are similar");
            }
            else
            {
            	System.out.println("Images are not similar");
            }
 
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
	    /*try {
	     * 
	        // take buffer data from both image files //
	        BufferedImage biA = ImageIO.read(fileA);
	        DataBuffer dbA = biA.getData().getDataBuffer();
	        int sizeA = dbA.getSize();
	        BufferedImage biB = ImageIO.read(fileB);
	        DataBuffer dbB = biB.getData().getDataBuffer();
	        int sizeB = dbB.getSize();
	        int count = 0;
	        // compare data-buffer objects //
	        if (sizeA == sizeB) {
	            for (int i = 0; i < sizeA; i++) {
	                if (dbA.getElem(i) == dbB.getElem(i)) {
	                    count = count + 1;
	                }
	            }
	            percentage = (count * 100) / sizeA;
	            if(percentage<=95)
	            {
	            	System.out.println("Image Test Case is Pass");
	            }
	        } else 
	        {
	            System.out.println("Both the images are not of same size");
	        }

	    } catch (Exception e) {
	        System.out.println("Failed to compare image files ...");
	    }
	    return percentage;
	}*/
	}
	public static void NewWindowScreenShot() throws IOException
	{
		//all window
		List<String> myallWindows = new ArrayList<String> (driver.getWindowHandles());
		//switch to child window
		driver.switchTo().window(myallWindows.get(1));
		screnshotcls screnshotcls=new screnshotcls(driver);
		driver.close();
		driver.switchTo().window(myallWindows.get(0));		
		//System.out.println(browserWindows.get(0));
	}
}


