package MavenSeleniumGA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Leave {
	@Test
	public void leavemethod() throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.get("https://opensource-demo.orangehrmlive.com/");
	driver.manage().window().maximize();

	driver.findElement(By.cssSelector("#txtUsername")).sendKeys("Admin");
	Thread.sleep(1000);

	driver.findElement(By.name("txtPassword")).sendKeys("admin123");
	Thread.sleep(1000);

	driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[3]/div[2]/div[2]/form[1]/div[5]/input[1]")).click();
	Thread.sleep(2000);
	
	//leave will execute with javascript.
	driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/ul[1]/li[3]/a[1]/b[1]")).click();
	Thread.sleep(2000);
	driver.findElement(By.cssSelector("#menu_leave_viewLeaveList")).click();
	Thread.sleep(2000);
	Select year = new Select(driver.findElement(By.cssSelector("#calFromDate")));
	Thread.sleep(2000);
	year.selectByVisibleText("2021");
	Thread.sleep(2000);
	Select month = new Select(driver.findElement(By.cssSelector("#calFromDate")));
	Thread.sleep(2000);
	month.selectByVisibleText("october");
	Select date = new Select(driver.findElement(By.cssSelector("#calFromDate")));
	Thread.sleep(2000);
	date.selectByVisibleText("1");
	Select year1 = new Select(driver.findElement(By.cssSelector("#calToDate")));
	Thread.sleep(2000);
	year1.selectByVisibleText("2021");
	Thread.sleep(2000);
	Select month1 = new Select(driver.findElement(By.cssSelector("#calToDate")));
	Thread.sleep(2000);
	month1.selectByVisibleText("october");
	Select date1 = new Select(driver.findElement(By.cssSelector("#calToDate")));
	Thread.sleep(2000);
	date1.selectByVisibleText("4");
	driver.findElement(By.cssSelector("#leaveList_txtEmployee_empName")).sendKeys("Boney Xavier");
	Thread.sleep(2000);
	Select userRole = new Select(driver.findElement(By.id("leaveList_cmbSubunit")));
	Thread.sleep(2000);
	userRole.selectByVisibleText("Human Resources");
	Thread.sleep(2000);
	driver.findElement(By.cssSelector("#btnSearch")).click();
	Thread.sleep(2000);
	driver.quit();
	
}
	
}
