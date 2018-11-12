package com.peterwkc.test;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Selenium_SAP {
	private WebDriver driver;
	
	public Selenium_SAP() {
	}
	
	@BeforeTest
	public void setup() {               
		System.setProperty("webdriver.chrome.driver","C:\\Users\\peter\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://sapui5.hana.ondemand.com/test-resources/sap/m/demokit/cart/webapp/index.html");
	}
	
	@Test
	public void testSearch() {
	    WebDriverWait wait=new WebDriverWait(driver, 20);  	
	
		WebElement searchInput;
		searchInput= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath( "//input[@id='cart---homeView--searchField-I']")));
		searchInput.sendKeys("Phone");
		
		WebElement item= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath( "//img[@id='__item0-cart---homeView--productList-0-img']")));
		item.click();
		
		WebElement cart_icon= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath( "//button[@title='Add the product to your shopping cart']")));
		cart_icon.click();
		
		WebElement goto_cart= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath( "//button[@title ='Show Shopping Cart']")));
		goto_cart.click();
		
		WebElement list_item= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath( "//ul[@role='listbox']")));
		assertEquals(list_item.isDisplayed(), true);
	}
	
	
	
	@AfterTest
	public void tearDown() {
		driver.close();
		driver.quit();
	}
	
	
	
	
	
	

}
