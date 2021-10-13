package com.selenium.project;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JsExecutionExample {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com");
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("alert('do not close me')");
		Thread.sleep(5000);
		driver.quit();
	}

}
