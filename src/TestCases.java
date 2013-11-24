

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;



public class TestCases {
	/*	
	static final int Utils.MS_IN_A_SECOND = 1000;
	static final int Utils.SLEEP_INTERVAL = 500; //1000 = 1 second
	static final int Utils.SECONDS_UNTIL_TIMEOUT = 20;
	static final int Utils.PERIODS_TO_WAIT = (Utils.MS_IN_A_SECOND/Utils.SLEEP_INTERVAL)*Utils.SECONDS_UNTIL_TIMEOUT;
	
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();*/

	@Before
	public void setUp() throws Exception {
		Utils.driver = new FirefoxDriver();
		Utils.baseUrl = "https://new.toggl.com/";
		Utils.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Login();
	}


	public void Login() throws Exception {
		Utils.driver.get(Utils.baseUrl + "/");
		Utils.driver.findElement(By.xpath("//div[@id='wrap']/div/div[2]/button")).click();
		for (int period = 0;; period++) {
			if (period >= Utils.PERIODS_TO_WAIT) fail("timeout");
			try { if ("Log in with Google".equals(Utils.driver.findElement(By.id("google_header_login")).getText())) break; } catch (Exception e) {}
			Thread.sleep(Utils.SLEEP_INTERVAL);
		}

		Utils.driver.findElement(By.id("google_header_login")).click();
		for (int period = 0;; period++) {
			if (period >= Utils.PERIODS_TO_WAIT) fail("timeout");
			try { if ("".equals(Utils.driver.findElement(By.id("Email")).getText())) break; } catch (Exception e) {}
			Thread.sleep(Utils.SLEEP_INTERVAL);
		}

		Utils.driver.findElement(By.id("Email")).clear();
		Utils.driver.findElement(By.id("Email")).sendKeys("416group18");
		Utils.driver.findElement(By.id("Passwd")).clear();
		Utils.driver.findElement(By.id("Passwd")).sendKeys("togglaccount");
		for (int period = 0;; period++) {
			if (period >= Utils.PERIODS_TO_WAIT) fail("timeout");
			try { if ("".equals(Utils.driver.findElement(By.id("signIn")).getText())) break; } catch (Exception e) {}
			Thread.sleep(Utils.SLEEP_INTERVAL);
		}

		Utils.driver.findElement(By.id("signIn")).click();
		for (int period = 0;; period++) {
			if (period >= Utils.PERIODS_TO_WAIT) fail("timeout");
			try { if ("416 Group18".equals(Utils.driver.findElement(By.linkText("416 Group18")).getText())) break; } catch (Exception e) {}
			Thread.sleep(Utils.SLEEP_INTERVAL);
		}

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
		for (int period = 0;; period++) {
			if (period >= Utils.PERIODS_TO_WAIT) fail("timeout");
			try { if ("Projects".equals(Utils.driver.findElement(By.linkText("Projects")).getText())) break; } catch (Exception e) {}
			Thread.sleep(Utils.SLEEP_INTERVAL);
		}

		Utils.driver.findElement(By.linkText("Projects")).click();
		for (int period = 0;; period++) {
			if (period >= Utils.PERIODS_TO_WAIT) fail("timeout");
			try { if ("Create Project".equals(Utils.driver.findElement(By.xpath("//div[@id='projects-page']/div[2]/div[3]/div/div[2]/button")).getText())) break; } catch (Exception e) {}
			Thread.sleep(Utils.SLEEP_INTERVAL);
		}

		Utils.driver.findElement(By.xpath("//div[@id='projects-page']/div[2]/div[3]/div/div[2]/button")).click();
		//Thread.sleep(Utils.SLEEP_INTERVAL);

		for (int period = 0;; period++) {
			if (period >= Utils.PERIODS_TO_WAIT) fail("timeout");
			try { if ("".equals(Utils.driver.findElement(By.xpath("/html/body/div[13]/div[2]/div/input")).getText())) break; } catch (Exception e) {}
			Thread.sleep(Utils.SLEEP_INTERVAL);
		}
		Utils.driver.findElement(By.xpath("/html/body/div[13]/div[2]/div/input")).clear();
		Utils.driver.findElement(By.xpath("/html/body/div[13]/div[2]/div/input")).sendKeys("test");

		for (int period = 0;; period++) {
			if (period >= Utils.PERIODS_TO_WAIT) fail("timeout");
			try { if ("Create".equals(Utils.driver.findElement(By.xpath("//div[@id='newProjectModal2']/div[2]/div[2]/button")).getText())) break; } catch (Exception e) {}
			Thread.sleep(Utils.SLEEP_INTERVAL);
		}

		Utils.driver.findElement(By.xpath("//div[@id='newProjectModal2']/div[2]/div[2]/button")).click();
	}
	
	public void addProjectClient() throws Exception {
		for (int period = 0;; period++) {
			if (period >= Utils.PERIODS_TO_WAIT) fail("timeout");
			try { if ("Projects".equals(Utils.driver.findElement(By.linkText("Projects")).getText())) break; } catch (Exception e) {}
			Thread.sleep(Utils.SLEEP_INTERVAL);
		}

		Utils.driver.findElement(By.linkText("Projects")).click();
		
		for (int period = 0;; period++) {
			if (period >= Utils.PERIODS_TO_WAIT) fail("timeout");
			try { if (Utils.isElementPresent(By.xpath("/html/body/div[2]/div[5]/div[5]/div[2]/div[3]/div[2]/div/table/tbody/tr/td[3]/div[2]/span"))) break; } catch (Exception e) {}
			Thread.sleep(Utils.SLEEP_INTERVAL);
		}
		Utils.driver.findElement(By.xpath("/html/body/div[2]/div[5]/div[5]/div[2]/div[3]/div[2]/div/table/tbody/tr/td[3]/div[2]/span")).click();

		for (int period = 0;; period++) {
			if (period >= Utils.PERIODS_TO_WAIT) fail("timeout");
			try { if (Utils.isElementPresent(By.xpath("/html/body/div[2]/div[5]/div[6]/div[2]/div[2]/div[2]/div/div[2]/span/a"))) break; } catch (Exception e) {}
			Thread.sleep(Utils.SLEEP_INTERVAL);
		}
		Utils.driver.findElement(By.xpath("/html/body/div[2]/div[5]/div[6]/div[2]/div[2]/div[2]/div/div[2]/span/a")).click();
		
		for (int period = 0;; period++) {
			if (period >= Utils.PERIODS_TO_WAIT) fail("timeout");
			try { if (Utils.isElementPresent(By.xpath("/html/body/div[2]/div[5]/div[6]/div[2]/div[2]/div[2]/div/div[2]/div/input"))) break; } catch (Exception e) {}
			Thread.sleep(Utils.SLEEP_INTERVAL);
		}
		Utils.driver.findElement(By.xpath("/html/body/div[2]/div[5]/div[6]/div[2]/div[2]/div[2]/div/div[2]/div/input")).click();
		Utils.driver.findElement(By.xpath("/html/body/div[2]/div[5]/div[6]/div[2]/div[2]/div[2]/div/div[2]/div/input")).clear();
		Utils.driver.findElement(By.xpath("/html/body/div[2]/div[5]/div[6]/div[2]/div[2]/div[2]/div/div[2]/div/input")).sendKeys("seleniumClient");
		
		for (int period = 0;; period++) {
			if (period >= Utils.PERIODS_TO_WAIT) fail("timeout");
			try { if (Utils.isElementPresent(By.id("js-add-client"))) break; } catch (Exception e) {}
			Thread.sleep(Utils.SLEEP_INTERVAL);
		}
		Utils.driver.findElement(By.id("js-add-client")).click();
	}

	public void goToWorkspaceSettings() throws Exception {
		//Click arrow for workspace
				for (int period = 0;; period++) {
					if (period >= Utils.PERIODS_TO_WAIT) fail("timeout");
					try { if (Utils.isElementPresent(By.xpath("/html/body/div[2]/div/nav/ul/li[6]/a"))) break; } catch (Exception e) {}
					Thread.sleep(Utils.SLEEP_INTERVAL);
				}
				Utils.driver.findElement(By.xpath("/html/body/div[2]/div/nav/ul/li[6]/a")).click();
				
				//Click workspace settings
				for (int period = 0;; period++) {
					if (period >= Utils.PERIODS_TO_WAIT) fail("timeout");
					try { if (Utils.isElementPresent(By.xpath("/html/body/div[2]/div/nav/ul/li[6]/ul/li/a"))) break; } catch (Exception e) {}
					Thread.sleep(Utils.SLEEP_INTERVAL);
				}
				Utils.driver.findElement(By.xpath("/html/body/div[2]/div/nav/ul/li[6]/ul/li/a")).click();
		
	}
	public void selectClientsInWorkspaceSettings() throws Exception {
		for (int period = 0;; period++) {
			if (period >= Utils.PERIODS_TO_WAIT) fail("timeout");
			try { if (Utils.isElementPresent(By.xpath("/html/body/div[2]/div[5]/div[7]/div[4]/div/ul/li[3]/a"))) break; } catch (Exception e) {}
			Thread.sleep(Utils.SLEEP_INTERVAL);
		}
		Utils.driver.findElement(By.xpath("/html/body/div[2]/div[5]/div[7]/div[4]/div/ul/li[3]/a")).click();
	}
	
	public void enterClientNameAndAddInWorkspaceSettings(String name) throws Exception {
		for (int period = 0;; period++) {
			if (period >= Utils.PERIODS_TO_WAIT) fail("timeout");
			try { if (Utils.isElementPresent(By.xpath("/html/body/div[2]/div[5]/div[7]/div[7]/div/div/input"))) break; } catch (Exception e) {}
			Thread.sleep(Utils.SLEEP_INTERVAL);
		}
		Utils.driver.findElement(By.xpath("/html/body/div[2]/div[5]/div[7]/div[7]/div/div/input")).click();
		Utils.driver.findElement(By.xpath("/html/body/div[2]/div[5]/div[7]/div[7]/div/div/input")).clear();
		Utils.driver.findElement(By.xpath("/html/body/div[2]/div[5]/div[7]/div[7]/div/div/input")).sendKeys(name);
		for (int period = 0;; period++) {
			if (period >= Utils.PERIODS_TO_WAIT) fail("timeout");
			try { if (Utils.isElementPresent(By.xpath("/html/body/div[2]/div[5]/div[7]/div[7]/div/div[2]/button"))) break; } catch (Exception e) {}
			Thread.sleep(Utils.SLEEP_INTERVAL);
		}
		Utils.driver.findElement(By.xpath("/html/body/div[2]/div[5]/div[7]/div[7]/div/div[2]/button")).click();
		
	}


	public void addWorkspaceClient() throws Exception {
		goToWorkspaceSettings();
		selectClientsInWorkspaceSettings();
		enterClientNameAndAddInWorkspaceSettings("seleniumClient");
	}
	
	public void removeClient(String clientName) throws Exception {
		//Given already on Workspace Settings page
		for (int period = 0;; period++) {
			if (period >= Utils.PERIODS_TO_WAIT) fail("timeout");
			try { if (Utils.isElementPresent(By.cssSelector("span.element.js-clients > span"))) break; } catch (Exception e) {}
			Thread.sleep(Utils.SLEEP_INTERVAL);
		}	
		assertEquals(clientName, Utils.driver.findElement(By.cssSelector("span.element.js-clients > span")).getText());
		Thread.sleep(Utils.SLEEP_INTERVAL);
		
		for (int period = 0;; period++) {
			if (period >= Utils.PERIODS_TO_WAIT) fail("timeout");
			try { if (Utils.isElementPresent(By.cssSelector("span > i.icon-remove"))) break; } catch (Exception e) {}
			Thread.sleep(Utils.SLEEP_INTERVAL);
		}	
	    Utils.driver.findElement(By.cssSelector("span > i.icon-remove")).click();
	}
	
	@Test
	public void testAddAndRemoveClient() throws Exception {
		//Start add seleniumClient
		addProjectClient();
		//End add seleniumClient
		//Ensure there is no alert
		try {
			assertFalse(Utils.driver.findElement(By.cssSelector("div.alert-box.alert")).isDisplayed());
		} catch (Error e) {
			Utils.verificationErrors.append("Alert box visible: " + e.toString());
		}

		//Start remove seleniumClient
		goToWorkspaceSettings();
		selectClientsInWorkspaceSettings();
		
		addWorkspaceClient();
		
		//Ensure there is an alert
		for (int period = 0;; period++) {
			if (period >= Utils.PERIODS_TO_WAIT) fail("timeout");
			try { if (Utils.driver.findElement(By.cssSelector("div.alert-box.alert")).isDisplayed()) break; } catch (Exception e) {}
			Thread.sleep(Utils.SLEEP_INTERVAL);
		}	
		
		//Remove client
		removeClient("seleniumClient");
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
