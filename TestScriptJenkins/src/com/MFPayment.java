package com;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;

import com.ReadData;

public class MFPayment {
	public WebDriver driver;
	ReadData read = new ReadData ();
	
	
  @Test
  public void checkoutprocess() throws Exception {
	  driver.get("http://testsiterplan.membership.invanto.net/welcome");
	  WebElement element = driver.findElement(By.xpath(read.getData("membershipmenu")));
      Actions action = new Actions(driver);
      action.moveToElement(element).perform();

      WebElement subElement = driver.findElement(By.xpath(read.getData("firstplan")));
      action.moveToElement(subElement);

      action.click();
      action.perform();
      
      driver.findElement(By.xpath(read.getData("planunlockbutton"))).click();
      
      driver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS);
      driver.findElement(By.xpath(read.getData("payeename"))).clear();
      driver.findElement(By.xpath(read.getData("payeename"))).sendKeys("Rams");
      
      driver.findElement(By.xpath(read.getData("payeeemail"))).clear();
      driver.findElement(By.xpath(read.getData("payeeemail"))).sendKeys("ram@invanto.com");
      driver.findElement(By.xpath(read.getData("creditcardnumber"))).clear();
      driver.findElement(By.xpath(read.getData("creditcardnumber"))).sendKeys("4242424242424242");
      
      Select expmonth = new Select(driver.findElement(By.xpath(read.getData("expirationmonth"))));
      expmonth.selectByVisibleText("3");
      
      Select expyear = new Select(driver.findElement(By.xpath(read.getData("expirationyear"))));
      expyear.selectByVisibleText("2021");
      
      driver.findElement(By.xpath(read.getData("cvvcode"))).clear();
      driver.findElement(By.xpath(read.getData("cvvcode"))).sendKeys("213");
      
      driver.findElement(By.xpath(read.getData("checkoutbutton"))).click();
      
      driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
      driver.findElement(By.xpath(read.getData("continuebutton"))).click();
      
      
  }
  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.chrome.driver","C:\\Users\\admin\\Downloads\\chromedriver.exe");
	  driver = new ChromeDriver(); 
	  driver.manage().window().maximize();
	  read.getProperties("mfpayment.properties");
	  
  }

  @AfterClass
  public void afterClass() {
	//  driver.close();
  }

}
