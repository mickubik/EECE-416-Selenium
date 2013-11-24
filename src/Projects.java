import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

import org.openqa.selenium.By;


public class Projects {
	
	public static void goToProjects() throws Exception {
		for (int period = 0;; period++) {
			if (period >= Utils.PERIODS_TO_WAIT) fail("timeout");
			try { if ("Projects".equals(Utils.driver.findElement(By.linkText("Projects")).getText())) break; } catch (Exception e) {}
			Thread.sleep(Utils.SLEEP_INTERVAL);
		}
		Utils.driver.findElement(By.linkText("Projects")).click();
	}
	
	public static void addProjectClient() throws Exception {		
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
		Thread.sleep(Utils.SLEEP_INTERVAL);
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
	
		//End add seleniumClient
		//Ensure there is no alert
		try {
			assertFalse(Utils.driver.findElement(By.cssSelector("div.alert-box.alert")).isDisplayed());
		} catch (Error e) {
			Utils.verificationErrors.append("Alert box visible: " + e.toString());
		}
	}

}
