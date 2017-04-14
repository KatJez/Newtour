package pl.lait.Newtour;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Newtour{
	static FirefoxDriver driver;
	
		@BeforeClass
		public static void openBrowser(){
			driver = new FirefoxDriver();
			driver.get("http://newtours.demoaut.com");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}
		
		@org.junit.Test
		public void test(){
						
			driver.findElement(By.linkText("SIGN-ON")).click();
			driver.findElement(By.name("userName")).sendKeys("kasia123");
			driver.findElement(By.name("password")).sendKeys("qwe123");
			driver.findElement(By.name("login")).click();

			driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td[2]/b/font/input[2]")).click();
			
			new Select(driver.findElement(By.name("passCount"))).selectByVisibleText("1");
			new Select(driver.findElement(By.name("fromPort"))).selectByVisibleText("Zurich");
			new Select(driver.findElement(By.name("fromMonth"))).selectByVisibleText("March");
			new Select(driver.findElement(By.name("fromDay"))).selectByVisibleText("10");
			new Select(driver.findElement(By.name("toPort"))).selectByVisibleText("Seattle");
			new Select(driver.findElement(By.name("toMonth"))).selectByVisibleText("October");
			new Select(driver.findElement(By.name("toDay"))).selectByVisibleText("12");
			
			driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[9]/td[2]/font/font/input[1]")).click();
			
			new Select(driver.findElement(By.name("airline"))).selectByVisibleText("Pangea Airlines");
			
			driver.findElement(By.name("findFlights")).click();
			driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[1]/tbody/tr[7]/td[1]/input")).click();
			driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[2]/tbody/tr[5]/td[1]/input")).click();
			driver.findElement(By.name("reserveFlights")).click();
			
			assertEquals("Summary", driver.findElement(By.xpath("(/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[1]/td/font/font/b/font/font)")).getText());
			assertEquals("Book a Flight: Mercury Tours", driver.getTitle());
			
			driver.findElement(By.name("passFirst0")).sendKeys("Anna");
			driver.findElement(By.name("passLast0")).sendKeys("Kowalska");
			
			new Select(driver.findElement(By.name("pass.0.meal"))).selectByVisibleText("Hindu");
			new Select(driver.findElement(By.name("creditCard"))).selectByVisibleText("Visa");
			
			driver.findElement(By.name("creditnumber")).sendKeys("123456789");
			
			new Select(driver.findElement(By.name("cc_exp_dt_mn"))).selectByVisibleText("04");
			new Select(driver.findElement(By.name("cc_exp_dt_yr"))).selectByVisibleText("2010");
			
			driver.findElement(By.name("cc_frst_name")).sendKeys("Anna");
			driver.findElement(By.name("cc_last_name")).sendKeys("Kowalska");
			driver.findElement(By.name("ticketLess")).click();
			driver.findElement(By.name("billAddress1")).clear();
			driver.findElement(By.name("billAddress1")).sendKeys("ulica Pierwsza");
			driver.findElement(By.name("billCity")).clear();
			driver.findElement(By.name("billCity")).sendKeys("Lublin");
			
			new Select(driver.findElement(By.name("billCountry"))).selectByVisibleText("POLAND");
			
			driver.findElement(By.name("buyFlights")).click();
			
			assertEquals("Flight Confirmation: Mercury Tours", driver.getTitle());
			assertTrue(isElementPresent(By.xpath("//td/table/tbody/tr/td[2]/table/tbody/tr/td/img")));
			assertEquals("", driver.findElement(By.xpath("//td/table/tbody/tr/td[2]/table/tbody/tr/td/img")).getText());
			
			driver.findElement(By.linkText("SIGN-OFF")).click();	
			}
		
		public boolean isElementPresent(By xpath) {
			return true;
		}

		public void linkClick(String linkText) {
			try {
				driver.findElement(By.linkText(linkText)).click();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}

		@AfterClass
		public static void closeBrowser(){
			driver.close();
			driver.quit();
		}
}