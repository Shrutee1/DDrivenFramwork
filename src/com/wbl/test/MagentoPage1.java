package com.wbl.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MagentoPage1 {
public static void main(String []args) throws IOException, InterruptedException {
	
	FileInputStream  fis=new FileInputStream("C:\\Users\\16179\\eclipse-workspace\\DDrivenFramwork\\"
			+ "src\\com\\wbl\\properties\\DD.properties");
	Properties prop =new Properties();
	
	prop.load(fis);
	
		
	String emailLocator=prop.getProperty("emailLocator");
	String emailValue =prop.getProperty("emailValue");
	String PassLocator =prop.getProperty("PassLocator");
	String PassValue =prop.getProperty("PassValue");
	String loginbuttonLocator=prop.getProperty("loginbuttonLocator");
	String logoutLocator =prop.getProperty("logoutLocator");
	
	
	
	WebDriverManager.chromedriver().setup();
	WebDriver driver =new ChromeDriver();
	
/*System.setProperty("webdriver.chrome.driver", "C:\\Users\\16179\\eclipse-workspace\\DDrivenFramwork\\lib\\geckodriver\\chromedriver_win32\\chromedriver.exe");

  ChromeDriver driver =new ChromeDriver();*/
System.out.println("abc");
	driver.manage().window().maximize();
driver.get("https://account.magento.com/customer/account/login");//3rd step
	driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
	driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);


driver.findElement(By.xpath(emailLocator)).sendKeys(emailValue);
	 driver.findElement(By.xpath(PassLocator)).sendKeys(PassValue);
 driver.findElement(By.xpath(loginbuttonLocator)).click();
 Thread.sleep(3000L);

driver.findElement(By.xpath(logoutLocator)).click();
driver.quit();
	


	
}
}


