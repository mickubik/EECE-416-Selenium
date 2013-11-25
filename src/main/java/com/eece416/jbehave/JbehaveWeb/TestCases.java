package com.eece416.jbehave.JbehaveWeb;


import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;



public class TestCases {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "https://new.toggl.com/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Login();
	}


	public void Login() throws Exception {
		driver.get(baseUrl + "/");
		driver.findElement(By.xpath("//div[@id='wrap']/div/div[2]/button")).click();
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if ("Log in with Google".equals(driver.findElement(By.id("google_header_login")).getText())) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

		driver.findElement(By.id("google_header_login")).click();
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if ("".equals(driver.findElement(By.id("Email")).getText())) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

		driver.findElement(By.id("Email")).clear();
		driver.findElement(By.id("Email")).sendKeys("416group18");
		driver.findElement(By.id("Passwd")).clear();
		driver.findElement(By.id("Passwd")).sendKeys("togglaccount");
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if ("".equals(driver.findElement(By.id("signIn")).getText())) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

		driver.findElement(By.id("signIn")).click();
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if ("416 Group18".equals(driver.findElement(By.linkText("416 Group18")).getText())) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

	}

	@Test
	public void testAddTask() throws Exception {
		// Now logged in
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (isElementPresent(By.xpath("//input[@type='text']"))) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (isElementPresent(By.xpath("//input[@type='text']"))) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

		driver.findElement(By.xpath("//input[@type='text']")).clear();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("test");
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if ("Start".equals(driver.findElement(By.xpath("//div[@id='js-new-task-form']/div[6]/button")).getText())) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}


		driver.findElement(By.xpath("//div[@id='js-new-task-form']/div[6]/button")).click();
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if ("Stop".equals(driver.findElement(By.xpath("//div[@id='js-new-task-form']/div[6]/button")).getText())) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
		Thread.sleep(1000);

		driver.findElement(By.xpath("//div[@id='js-new-task-form']/div[6]/button")).click();
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if ("Start".equals(driver.findElement(By.xpath("//div[@id='js-new-task-form']/div[6]/button")).getText())) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (isElementPresent(By.xpath("(//input[@type='text'])[3]"))) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

		//    for (int second = 0;; second++) {
		//    	if (second >= 60) fail("timeout");
		//    	try { if ("test".equals(driver.findElement(By.cssSelector("span.js-description")).getText())) break; } catch (Exception e) {}
		//    	Thread.sleep(1000);
		//    }
		//
		//    try {
		//      assertEquals("test", driver.findElement(By.cssSelector("span.js-description")).getText());
		//    } catch (Error e) {
		//      verificationErrors.append(e.toString());
		//    }
	}

	@Test
	public void testAddProject() throws Exception {
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if ("Projects".equals(driver.findElement(By.linkText("Projects")).getText())) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

		driver.findElement(By.linkText("Projects")).click();
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if ("Create Project".equals(driver.findElement(By.xpath("//div[@id='projects-page']/div[2]/div[3]/div/div[2]/button")).getText())) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

		driver.findElement(By.xpath("//div[@id='projects-page']/div[2]/div[3]/div/div[2]/button")).click();
		//Thread.sleep(1000);

		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if ("".equals(driver.findElement(By.xpath("/html/body/div[13]/div[2]/div/input")).getText())) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
		driver.findElement(By.xpath("/html/body/div[13]/div[2]/div/input")).clear();
		driver.findElement(By.xpath("/html/body/div[13]/div[2]/div/input")).sendKeys("test");

		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if ("Create".equals(driver.findElement(By.xpath("//div[@id='newProjectModal2']/div[2]/div[2]/button")).getText())) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

		driver.findElement(By.xpath("//div[@id='newProjectModal2']/div[2]/div[2]/button")).click();
	}

	
	@Test
	public void testAddAndRemoveClient() throws Exception {
		//Start add seleniumClient
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if ("Projects".equals(driver.findElement(By.linkText("Projects")).getText())) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

		driver.findElement(By.linkText("Projects")).click();
		
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (isElementPresent(By.xpath("/html/body/div[2]/div[5]/div[5]/div[2]/div[3]/div[2]/div/table/tbody/tr/td[3]/div[2]/span"))) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
		driver.findElement(By.xpath("/html/body/div[2]/div[5]/div[5]/div[2]/div[3]/div[2]/div/table/tbody/tr/td[3]/div[2]/span")).click();

		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (isElementPresent(By.xpath("/html/body/div[2]/div[5]/div[6]/div[2]/div[2]/div[2]/div/div[2]/span/a"))) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
		driver.findElement(By.xpath("/html/body/div[2]/div[5]/div[6]/div[2]/div[2]/div[2]/div/div[2]/span/a")).click();
		
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (isElementPresent(By.xpath("/html/body/div[2]/div[5]/div[6]/div[2]/div[2]/div[2]/div/div[2]/div/input"))) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
		driver.findElement(By.xpath("/html/body/div[2]/div[5]/div[6]/div[2]/div[2]/div[2]/div/div[2]/div/input")).click();
		driver.findElement(By.xpath("/html/body/div[2]/div[5]/div[6]/div[2]/div[2]/div[2]/div/div[2]/div/input")).clear();
		driver.findElement(By.xpath("/html/body/div[2]/div[5]/div[6]/div[2]/div[2]/div[2]/div/div[2]/div/input")).sendKeys("seleniumClient");
		
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (isElementPresent(By.id("js-add-client"))) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
		driver.findElement(By.id("js-add-client")).click();
		//End add seleniumClient

		//Start remove seleniumClient
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (isElementPresent(By.xpath("/html/body/div[2]/div/nav/ul/li[6]/a"))) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
		driver.findElement(By.xpath("/html/body/div[2]/div/nav/ul/li[6]/a")).click();
		
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (isElementPresent(By.xpath("/html/body/div[2]/div/nav/ul/li[6]/ul/li/a"))) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
		driver.findElement(By.xpath("/html/body/div[2]/div/nav/ul/li[6]/ul/li/a")).click();
		System.out.println("-2");
		
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (isElementPresent(By.xpath("/html/body/div[2]/div[5]/div[7]/div[4]/div/ul/li[3]/a"))) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
		driver.findElement(By.xpath("/html/body/div[2]/div[5]/div[7]/div[4]/div/ul/li[3]/a")).click();
		System.out.println("-1");
		
		System.out.println("0");
		
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (isElementPresent(By.cssSelector("span.element.js-clients > span"))) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}	
		assertEquals("seleniumClient", driver.findElement(By.cssSelector("span.element.js-clients > span")).getText());
		Thread.sleep(1000);
		
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (isElementPresent(By.cssSelector("span > i.icon-remove"))) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}	
	    driver.findElement(By.cssSelector("span > i.icon-remove")).click();
	  //End remove seleniumClient

		


	}


	@After
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	private boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	private String closeAlertAndGetItsText() {
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			acceptNextAlert = true;
		}
	}
}
