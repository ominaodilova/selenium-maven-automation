package com.dice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DiceJobSearch {

	public static void main(String[] args) {
		//Seting the driver path
		WebDriverManager.chromedriver().setup();
		//invoke selenium webdriver
		WebDriver driver=new ChromeDriver();
		//full screen
		driver.manage().window().fullscreen();
		//set universal wait time in case page is slow
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.navigate().to("https://www.dice.com");
		String actualTitle=driver.getTitle();
		String expectedTitle="Job Search for Technology Professionals | Dice.com";
		if(actualTitle.equals(expectedTitle)) {
			System.out.println("Dice homepage successfully loaded");
		}else {
			System.out.println("Step FAIL. Dice homepage did not load successfully");
			throw new RuntimeException("Step FAIL.Dice homepage did not load successfully");
		}
		driver.findElement(By.id("search-field-keyword")).sendKeys("java developer");
		driver.findElement(By.id("search-field-location")).clear();
		driver.findElement(By.id("search-field-location")).sendKeys("Pittsburgh,PA");
		driver.findElement(By.id("findTechJobs")).click();
		String count =driver.findElement(By.id("posiCountMobileId")).getText();
		System.out.println(count);
	}

}
