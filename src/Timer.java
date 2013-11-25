import static org.junit.Assert.fail;

import org.openqa.selenium.By;


public class Timer {
	public static void switchToAddManual() throws Exception {
		for (int period = 0;; period++) {
			if (period >= Utils.PERIODS_TO_WAIT) fail("timeout");
			try { if (Utils.isElementPresent(By.cssSelector("html.no-js body div.page-wrapper div.content-wrapper div#timer-page.view div#js-new-task-form.row div.button-container a#switchMode.alternative"))) break; } catch (Exception e) {}
			Thread.sleep(Utils.SLEEP_INTERVAL);
		}
		//if ("Add manually".equals(Utils.driver.findElement(By.xpath("//div[@id='js-new-task-form']/div[6]/button")).getText())){
		//	Utils.driver.findElement(By.cssSelector("html.no-js body div.page-wrapper div.content-wrapper div#timer-page.view div#js-new-task-form.row div.button-container a#switchMode.alternative")).click();			
		//}		
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
		//*[@id="switchMode"]
	}
	
	public static void switchToUseTimer() throws Exception {
		for (int period = 0;; period++) {
			if (period >= Utils.PERIODS_TO_WAIT) fail("timeout");
			try { if (Utils.isElementPresent(By.cssSelector("html.no-js body div.page-wrapper div.content-wrapper div#timer-page.view div#js-new-task-form.row div.button-container a#switchMode.alternative"))) break; } catch (Exception e) {}
			Thread.sleep(Utils.SLEEP_INTERVAL);
		}
		//if ("Use timer".equals(Utils.driver.findElement(By.xpath("//div[@id='js-new-task-form']/div[6]/button")).getText())){
		//	Utils.driver.findElement(By.cssSelector("html.no-js body div.page-wrapper div.content-wrapper div#timer-page.view div#js-new-task-form.row div.button-container a#switchMode.alternative")).click();
		//}
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
