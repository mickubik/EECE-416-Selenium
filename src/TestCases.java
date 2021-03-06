


import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class TestCases {
	@Before
	public void setUp() throws Exception {
		//File file = new File("C:/Users/Mic/Documents/EECE 416/IEDriverServer.exe");
		//System.setProperty("webdriver.ie.driver","C:/Users/Mic/Documents/EECE 416/IEDriverServer.exe");
		//System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
		//Utils.driver = new InternetExplorerDriver();
		Utils.driver = new FirefoxDriver();
		Utils.baseUrl = "https://new.toggl.com/";
		Utils.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Utils.Login();
	}
	
	@Test
	public void testGoToProjects() throws Exception {
		Projects.goToProjects();
		for (int period = 0;; period++) {
	    	if (period >= Utils.PERIODS_TO_WAIT) fail("timeout");
	    	try { if (Utils.isElementPresent(By.id("projects-page"))) break; } catch (Exception e) {}
	    	Thread.sleep(Utils.SLEEP_INTERVAL);
	    }	
	}

	@Test
	public void testAddTask() throws Exception {
		Timer.switchToUseTimer();
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
	}
		
	@Test
	public void testAddManualTask() throws Exception {
		// Now logged in
		Timer.switchToAddManual();

		for (int period = 0;; period++) {
			if (period >= Utils.PERIODS_TO_WAIT) fail("timeout");
			try { if (Utils.isElementPresent(By.xpath("/html/body/div[2]/div[5]/div/div/div/input"))) break; } catch (Exception e) {}
			Thread.sleep(Utils.SLEEP_INTERVAL);
		}
		Utils.driver.findElement(By.xpath("/html/body/div[2]/div[5]/div/div/div/input")).clear();
		Utils.driver.findElement(By.xpath("/html/body/div[2]/div[5]/div/div/div/input")).sendKeys("seleniumManualTask");
		
		//Open Calendar
		for (int period = 0;; period++) {
			if (period >= Utils.PERIODS_TO_WAIT) fail("timeout");
			try { if (Utils.isElementPresent(By.xpath("/html/body/div[2]/div[5]/div/div/div[5]/input"))) break; } catch (Exception e) {}
			Thread.sleep(Utils.SLEEP_INTERVAL);
		}
		Utils.driver.findElement(By.xpath("/html/body/div[2]/div[5]/div/div/div[5]/input")).click();
		
		//Add Start Time
		for (int period = 0;; period++) {
			if (period >= Utils.PERIODS_TO_WAIT) fail("timeout");
			try { if (Utils.isElementPresent(By.xpath("/html/body/div[2]/div[5]/div/div/div[5]/div/div/div/div/div/input"))) break; } catch (Exception e) {}
			Thread.sleep(Utils.SLEEP_INTERVAL);
		}
		
 		Utils.driver.findElement(By.xpath("/html/body/div[2]/div[5]/div/div/div[5]/div/div/div/div/div/input")).click();
		Thread.sleep(Utils.SLEEP_INTERVAL);
		Utils.driver.findElement(By.xpath("/html/body/div[2]/div[5]/div/div/div[5]/div/div/div/div/div/input")).clear();
		Thread.sleep(Utils.SLEEP_INTERVAL);
		Utils.driver.findElement(By.xpath("/html/body/div[2]/div[5]/div/div/div[5]/div/div/div/div/div/input")).sendKeys("\b\b\b\b\b\b\b\b");
		Thread.sleep(Utils.SLEEP_INTERVAL);
		Utils.driver.findElement(By.xpath("/html/body/div[2]/div[5]/div/div/div[5]/div/div/div/div/div/input")).sendKeys("11:00 AM");
		Thread.sleep(Utils.SLEEP_INTERVAL);
		
		//Add End Time
		for (int period = 0;; period++) {
			if (period >= Utils.PERIODS_TO_WAIT) fail("timeout");
			try { if (Utils.isElementPresent(By.xpath("/html/body/div[2]/div[5]/div/div/div[5]/div/div/div/div/div/input"))) break; } catch (Exception e) {}
			Thread.sleep(Utils.SLEEP_INTERVAL);
		}
		Utils.driver.findElement(By.xpath("/html/body/div[2]/div[5]/div/div/div[5]/div/div/div/div/div[2]/input")).click();
		Thread.sleep(Utils.SLEEP_INTERVAL);
		Utils.driver.findElement(By.xpath("/html/body/div[2]/div[5]/div/div/div[5]/div/div/div/div/div[2]/input")).clear();
		Thread.sleep(Utils.SLEEP_INTERVAL);
		Utils.driver.findElement(By.xpath("/html/body/div[2]/div[5]/div/div/div[5]/div/div/div/div/div[2]/input")).sendKeys("\b\b\b\b\b\b\b\b");
		Thread.sleep(Utils.SLEEP_INTERVAL);
		Utils.driver.findElement(By.xpath("/html/body/div[2]/div[5]/div/div/div[5]/div/div/div/div/div[2]/input")).sendKeys("1:00 PM");
		Thread.sleep(Utils.SLEEP_INTERVAL);

		//Apply Calendar time
		for (int period = 0;; period++) {
			if (period >= Utils.PERIODS_TO_WAIT) fail("timeout");
			try { if (Utils.isElementPresent(By.cssSelector("button.btn-set.js-set"))) break; } catch (Exception e) {}
			Thread.sleep(Utils.SLEEP_INTERVAL);
		}
		Utils.driver.findElement(By.cssSelector("button.btn-set.js-set")).click();		
	}

	@Test
	public void testAddProject() throws Exception {
		Projects.goToProjects();
		Projects.addProject("test");
	}
	
	@Test
	public void testAddClient() throws Exception {
		//Start add seleniumClient
		Projects.goToProjects();
		Projects.addProjectClient();
	}	
	
	@Test
	public void testAddAndRemoveClient() throws Exception {
		//Start add seleniumClient
		Projects.goToProjects();
		//Projects.addProjectClient();
		WebElement clientButton = (new WebDriverWait(Utils.driver, Utils.TIME_TO_WAIT)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[5]/div[5]/div[2]/div[3]/div[2]/div/table/tbody/tr/td[3]/div[2]/span")));
		clientButton.click();
		
		WebElement addNewClientButton = (new WebDriverWait(Utils.driver, Utils.TIME_TO_WAIT)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[5]/div[6]/div[2]/div[2]/div[2]/div/div[2]/span/a")));
		addNewClientButton.click();
		
		Thread.sleep(Utils.SLEEP_INTERVAL);
		WebElement clientNameBox = (new WebDriverWait(Utils.driver, Utils.TIME_TO_WAIT)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[5]/div[6]/div[2]/div[2]/div[2]/div/div[2]/div/input")));
		clientNameBox.click();
		clientNameBox.clear();
		clientNameBox.sendKeys("seleniumClient");

		for (int period = 0;; period++) {
			if (period >= Utils.PERIODS_TO_WAIT) fail("timeout");
			try { if (Utils.isElementPresent(By.id("js-add-client"))) break; } catch (Exception e) {}
			Thread.sleep(Utils.SLEEP_INTERVAL);
		}
		Utils.driver.findElement(By.id("js-add-client")).click();

		//Start remove seleniumClient
		WorkspaceSettings.goToWorkspaceSettings();
	
		WorkspaceSettings.selectClientsInWorkspaceSettings();

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
