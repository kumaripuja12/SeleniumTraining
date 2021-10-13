package com.individual.activity;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SauceDemo {
	//1.	Invoke Google Chrome browser/Firefox browser (any one).
	WebDriver driver;
	
	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	
	@Test
	public void sauceDemo() throws InterruptedException {
		//2.	open url :   https://www.saucedemo.com/

		driver.get("https://www.saucedemo.com/"); 
		driver.manage().window().maximize(); //maximize the window
                //3.	login to website using username and password (username -  standard_user   passwd -  secret_sauce)
		driver.findElement(By.cssSelector("#user-name")).sendKeys("standard_user"); //Entering UserName
		driver.findElement(By.cssSelector("#password")).sendKeys("secret_sauce"); //Entering password
		driver.findElement(By.xpath("//input[@id='login-button']")).click(); //click login
		Thread.sleep(3000);
		
		
		Assert.assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl());
		String url = driver.getCurrentUrl();
		System.out.println("Home Page URL = " +url);
				
		//Verifying Logo on Home Page
		boolean Logo = driver.findElement(By.className("app_logo")).isDisplayed();//To check whether Logo is displayed or not

		if(Logo) {
			System.out.print("Logo Verified");
		}else {
			System.out.print("Logo Not verified");
		}
		
		driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click(); //Adding product to cart
		
		driver.findElement(By.className("shopping_cart_link")).click(); //opening cart list
		//9.	Add details for CHECKOUT (First name, Last name, zip code)
		driver.findElement(By.cssSelector("#checkout")).click(); // checkout
		
		driver.findElement(By.id("first-name")).sendKeys("puja");  // Entering first name in the field
		
		driver.findElement(By.id("last-name")).sendKeys("kumari"); //Entering Last name in the field
		
		driver.findElement(By.id("postal-code")).sendKeys("560076"); //Entering Postal code in the field
		Thread.sleep(1000);
		
		//Scroll down and click on continue
		
		WebElement continueButton = driver.findElement(By.id("continue"));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", continueButton);
		Thread.sleep(2000);
		continueButton.click();
		Thread.sleep(2000);
		
		//Scroll down and click on finish
		WebElement finish = driver.findElement(By.id("finish"));
		js.executeScript("arguments[0].scrollIntoView(true);", finish);
		Thread.sleep(2000);
		finish.click();
		Thread.sleep(1500);
		
		//Scrolling up and click on back to home
		WebElement backHome = driver.findElement(By.id("back-to-products"));
		js.executeScript("window.scrollBy(0,-350)", "");
		Thread.sleep(2000);
		backHome.click();
		Thread.sleep(2000);
		
		//Scrolling up and click on menu button
		js.executeScript("window.scrollBy(0,-350)", "");
		driver.findElement(By.id("react-burger-menu-btn")).click();
		Thread.sleep(2000);
		
		//Log out from the Home Page
		driver.findElement(By.id("logout_sidebar_link")).click();
		Thread.sleep(2000);	
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
