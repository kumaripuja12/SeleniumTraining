package com.group.activity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocatorConcept {
	@Test

	public void locator()  throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		//1.id
		//WebElement uname =driver.findElement(By.id("txtUsername"));
		//uname.sendKeys("Admin");
		//WebElement password =driver.findElement(By.id("txtPassword"));
		//password.sendKeys("admin123");
		//WebElement login =driver.findElement(By.id("btnLogin"));
		//login.click();
		//driver.quit();
		
		//2.name
		//driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		//driver.findElement(By.name("txtPassword")).sendKeys("admin123");
		//driver.findElement(By.name("Submit")).click();
		
		//3.class
		driver.findElement(By.className("textInputContainer")).sendKeys("Admin");
		driver.findElement(By.className("textInputContainer")).sendKeys("admin123");
		driver.findElement(By.className("button")).click();
	}

}
