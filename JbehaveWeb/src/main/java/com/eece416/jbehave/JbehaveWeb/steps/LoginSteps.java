package com.eece416.jbehave.JbehaveWeb.steps;

import java.util.concurrent.TimeUnit;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;
import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class LoginSteps extends Steps {

	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "https://new.toggl.com/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	
	
	public LoginSteps() 
	{
		
	}
	
	@Given("the $url website is open")
	public void openWebSite(String url) 
	{
		driver.get(baseUrl + "/");
		assertEquals(baseUrl, url);
	}
	
	@When("the user clicks login")
	public void clickLogin()
	{
		driver.findElement(By.xpath("//div[@id='wrap']/div/div[2]/button")).click();

		driver.findElement(By.id("google_header_login")).click();
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if ("".equals(driver.findElement(By.id("Email")).getText())) break; } catch (Exception e) {}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	@When("enters the correct username and password")
	public void enterCredentials()
	{
		driver.findElement(By.id("Email")).clear();
		driver.findElement(By.id("Email")).sendKeys("416group18");
		driver.findElement(By.id("Passwd")).clear();
		driver.findElement(By.id("Passwd")).sendKeys("togglaccount");
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if ("".equals(driver.findElement(By.id("signIn")).getText())) break; } catch (Exception e) {}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	@Then("toggl logs them in and opens the Timer page")
	public void openTimerPage()
	{
		driver.findElement(By.id("signIn")).click();
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if ("416 Group18".equals(driver.findElement(By.linkText("416 Group18")).getText())) break; } catch (Exception e) {}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
}
