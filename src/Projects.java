import static org.junit.Assert.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Projects {
	
	public static void goToProjects() throws Exception {
		WebElement projectsLink = (new WebDriverWait(Utils.driver, Utils.TIME_TO_WAIT)).until(ExpectedConditions.presenceOfElementLocated(By.linkText("Projects")));
		projectsLink.click();
	}
	
	public static void addProject(String name) throws Exception {
		WebElement createProjectsButton = (new WebDriverWait(Utils.driver, Utils.TIME_TO_WAIT)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='projects-page']/div[2]/div[3]/div/div[2]/button")));
		"Create Project".equals(createProjectsButton.getText());
		createProjectsButton.click();

		WebElement projectName = (new WebDriverWait(Utils.driver, Utils.TIME_TO_WAIT)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[13]/div[2]/div/input")));
		projectName.clear();
		projectName.sendKeys(name);

		WebElement createButton = (new WebDriverWait(Utils.driver, Utils.TIME_TO_WAIT)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='newProjectModal2']/div[2]/div[2]/button")));
		"Create".equals(createButton.getText());
		createButton.click();
	}
	
	public static void addProjectClient() throws Exception {		
		WebElement clientButton = (new WebDriverWait(Utils.driver, Utils.TIME_TO_WAIT)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[5]/div[5]/div[2]/div[3]/div[2]/div/table/tbody/tr/td[3]/div[2]/span")));
		clientButton.click();
		
		WebElement addNewClientButton = (new WebDriverWait(Utils.driver, Utils.TIME_TO_WAIT)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[5]/div[6]/div[2]/div[2]/div[2]/div/div[2]/span/a")));
		addNewClientButton.click();
		

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
	}

}
