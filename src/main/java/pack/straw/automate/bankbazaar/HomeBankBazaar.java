package pack.straw.automate.bankbazaar;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pack.straw.recog.RecognitionEngine;
import pack.straw.tts.Speaker;

public class HomeBankBazaar 
{
	private static String websiteURL = "https://www.bankbazaar.com";
	
	private static String recognizedString = "";
	
	private static WebElement myElementSelector;
	
	public static void run(RecognitionEngine REO, Speaker speak, WebDriver driver, JavascriptExecutor jse)
	{
		driver.get(websiteURL);
		
		REO.startMicRecording();
		while(!recognizedString.equalsIgnoreCase("PLEASE TERMINATE APPLICATION"))
		{
			REO.startRecognizing();
			recognizedString = REO.getResultText();
			
			if(recognizedString.equalsIgnoreCase("GO TO HOME PAGE"))
				run(REO, speak, driver, jse);
			else if(recognizedString.equalsIgnoreCase("MOUSE SCROLL UPWARD"))
				jse.executeScript("window.scrollBy(0,-200)");
			else if(recognizedString.equalsIgnoreCase("MOUSE SCROLL DOWN"))
				jse.executeScript("window.scrollBy(0,+200)");
			else if(recognizedString.equalsIgnoreCase("MUTUAL FUND"))
			{
				// will change this code
				driver.get("https://www.bankbazaar.com/mutual-fund.html");
			}
			else if(recognizedString.equalsIgnoreCase("SAVINGS ACCOUNT"))
			{
				SavingsAccount.run(REO, speak, driver, jse);
			}
			else if(recognizedString.equalsIgnoreCase("FIXED DEPOSIT"))
			{
				// will change this code
				driver.get("https://www.bankbazaar.com/fixed-deposit-rate.html");
			}
		}
	}
}
