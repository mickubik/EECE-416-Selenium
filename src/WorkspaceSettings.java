import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.openqa.selenium.By;


public class WorkspaceSettings {
	
	public static void goToWorkspaceSettings() throws Exception {
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
	
	public static void selectClientsInWorkspaceSettings() throws Exception {
		for (int period = 0;; period++) {
			if (period >= Utils.PERIODS_TO_WAIT) fail("timeout");
			try { if (Utils.isElementPresent(By.xpath("/html/body/div[2]/div[5]/div[7]/div[4]/div/ul/li[3]/a"))) break; } catch (Exception e) {}
			Thread.sleep(Utils.SLEEP_INTERVAL);
		}
		Utils.driver.findElement(By.xpath("/html/body/div[2]/div[5]/div[7]/div[4]/div/ul/li[3]/a")).click();
	}
	
	public static void enterClientNameAndAddInWorkspaceSettings(String name) throws Exception {
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
	
	public static void addWorkspaceClient() throws Exception {
		WorkspaceSettings.goToWorkspaceSettings();
		WorkspaceSettings.selectClientsInWorkspaceSettings();
		WorkspaceSettings.enterClientNameAndAddInWorkspaceSettings("seleniumClient");
	}
	
	public static void removeClient(String clientName) throws Exception {
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

}
