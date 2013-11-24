

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;



public class TestCases {
	@Before
	public void setUp() throws Exception {
		Utils.driver = new FirefoxDriver();
		Utils.baseUrl = "https://new.toggl.com/";
		Utils.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Utils.Login();
	}

	@Test
	public void testAddTask() throws Exception {
		// Now logged in
		for (int period = 0;; period++) {
			if (period >= Utils.PERIODS_TO_WAIT) fail("timeout");
			try { if (Utils.isElementPresent(By.xpath("//input[@type='text']"))) break; } catch (Exception e) {}
			Thread.sleep(Utils.SLEEP_INTERVAL);
		}

		for (int period = 0;; period++) {
			if (period >= Utils.PERIODS_TO_WAIT) fail("timeout");
			try { if (Utils.isElementPresent(By.xpath("//input[@type='text']"))) break; } catch (Exception e) {}
			Thread.sleep(Utils.SLEEP_INTERVAL);
		}

		Utils.driver.findElement(By.xpath("//input[@type='text']")).clear();
		Utils.driver.findElement(By.xpath("//input[@type='text']")).sendKeys("test");
		for (int period = 0;; period++) {
			if (period >= Utils.PERIODS_TO_WAIT) fail("timeout");
			try { if ("Start".equals(Utils.driver.findElement(By.xpath("//div[@id='js-new-task-form']/div[6]/button")).getText())) break; } catch (Exception e) {}
			Thread.sleep(Utils.SLEEP_INTERVAL);
		}


		Utils.driver.findElement(By.xpath("//div[@id='js-new-task-form']/div[6]/button")).click();
		for (int period = 0;; period++) {
			if (period >= Utils.PERIODS_TO_WAIT) fail("timeout");
			try { if ("Stop".equals(Utils.driver.findElement(By.xpath("//div[@id='js-new-task-form']/div[6]/button")).getText())) break; } catch (Exception e) {}
			Thread.sleep(Utils.SLEEP_INTERVAL);
		}
		Thread.sleep(Utils.SLEEP_INTERVAL);

		Utils.driver.findElement(By.xpath("//div[@id='js-new-task-form']/div[6]/button")).click();
		for (int period = 0;; period++) {
			if (period >= Utils.PERIODS_TO_WAIT) fail("timeout");
			try { if ("Start".equals(Utils.driver.findElement(By.xpath("//div[@id='js-new-task-form']/div[6]/button")).getText())) break; } catch (Exception e) {}
			Thread.sleep(Utils.SLEEP_INTERVAL);
		}

		for (int period = 0;; period++) {
			if (period >= Utils.PERIODS_TO_WAIT) fail("timeout");
			try { if (Utils.isElementPresent(By.xpath("(//input[@type='text'])[3]"))) break; } catch (Exception e) {}
			Thread.sleep(Utils.SLEEP_INTERVAL);
		}

		//    for (int period = 0;; period++) {
		//    	if (period >= Utils.PERIODS_TO_WAIT) fail("timeout");
		//    	try { if ("test".equals(Utils.driver.findElement(By.cssSelector("span.js-description")).getText())) break; } catch (Exception e) {}
		//    	Thread.sleep(Utils.SLEEP_INTERVAL);
		//    }
		//
		//    try {
		//      assertEquals("test", Utils.driver.findElement(By.cssSelector("span.js-description")).getText());
		//    } catch (Error e) {
		//      verificationErrors.append(e.toString());
		//    }
	}

	@Test
	public void testAddProject() throws Exception {
		Projects.goToProjects();
		Projects.addProject("test");
	}
	
		
	@Test
	public void testAddAndRemoveClient() throws Exception {
		//Start add seleniumClient
		Projects.goToProjects();
		Projects.addProjectClient();

		//Start remove seleniumClient
		WorkspaceSettings.goToWorkspaceSettings();
		WorkspaceSettings.selectClientsInWorkspaceSettings();
		
		WorkspaceSettings.addWorkspaceClient();
		
		//Ensure there is an alert
		for (int period = 0;; period++) {
			if (period >= Utils.PERIODS_TO_WAIT) fail("timeout");
			try { if (Utils.driver.findElement(By.cssSelector("div.alert-box.alert")).isDisplayed()) break; } catch (Exception e) {}
			Thread.sleep(Utils.SLEEP_INTERVAL);
		}	
		
		//Remove client
		WorkspaceSettings.removeClient("seleniumClient");
	  //End remove seleniumClient
	}


	@After
	public void tearDown() throws Exception {
		Utils.driver.quit();
		String verificationErrorString = Utils.verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			System.out.println(verificationErrorString);
			fail(verificationErrorString);
		}
	}

	
}
