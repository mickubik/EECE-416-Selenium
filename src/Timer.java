import static org.junit.Assert.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Timer {
	public static void switchToAddManual() throws Exception {
		WebElement timerPage = (new WebDriverWait(Utils.driver, Utils.TIME_TO_WAIT)).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("html.no-js body div.page-wrapper div.content-wrapper div#timer-page.view div#js-new-task-form.row div.button-container a#switchMode.alternative")));
		for (int period = 0;; period++) {
			if (period >= Utils.PERIODS_TO_WAIT) fail("timeout");{
				try { 
					if ("Use timer".equals(Utils.driver.findElement(By.cssSelector("html.no-js body div.page-wrapper div.content-wrapper div#timer-page.view div#js-new-task-form.row div.button-container a#switchMode.alternative")).getText())){
						break; 
					}else if ("Add manually".equals(Utils.driver.findElement(By.cssSelector("html.no-js body div.page-wrapper div.content-wrapper div#timer-page.view div#js-new-task-form.row div.button-container a#switchMode.alternative")).getText())){
						Utils.driver.findElement(By.cssSelector("html.no-js body div.page-wrapper div.content-wrapper div#timer-page.view div#js-new-task-form.row div.button-container a#switchMode.alternative")).click();
					}	
					System.out.println(Utils.driver.findElement(By.cssSelector("html.no-js body div.page-wrapper div.content-wrapper div#timer-page.view div#js-new-task-form.row div.button-container a#switchMode.alternative")).getText());
				} catch (Exception e) {}
			}
			Thread.sleep(Utils.SLEEP_INTERVAL);
		}
	}
	
	public static void switchToUseTimer() throws Exception {
		WebElement timerPage = (new WebDriverWait(Utils.driver, Utils.TIME_TO_WAIT)).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("html.no-js body div.page-wrapper div.content-wrapper div#timer-page.view div#js-new-task-form.row div.button-container a#switchMode.alternative")));
		for (int period = 0;; period++) {
			if (period >= Utils.PERIODS_TO_WAIT) fail("timeout");{
				try { 
					if ("Add manually".equals(Utils.driver.findElement(By.cssSelector("html.no-js body div.page-wrapper div.content-wrapper div#timer-page.view div#js-new-task-form.row div.button-container a#switchMode.alternative")).getText())){
						break; 
					}else if ("Use timer".equals(Utils.driver.findElement(By.cssSelector("html.no-js body div.page-wrapper div.content-wrapper div#timer-page.view div#js-new-task-form.row div.button-container a#switchMode.alternative")).getText())){
						Utils.driver.findElement(By.cssSelector("html.no-js body div.page-wrapper div.content-wrapper div#timer-page.view div#js-new-task-form.row div.button-container a#switchMode.alternative")).click();
					}	
					System.out.println(Utils.driver.findElement(By.cssSelector("html.no-js body div.page-wrapper div.content-wrapper div#timer-page.view div#js-new-task-form.row div.button-container a#switchMode.alternative")).getText());
				} catch (Exception e) {}
			}
			Thread.sleep(Utils.SLEEP_INTERVAL);
		}
	}
}
