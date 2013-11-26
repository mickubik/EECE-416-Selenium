import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static org.junit.Assert.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Utils {

	static final int MS_IN_A_SECOND = 1000;
	static final int SLEEP_INTERVAL = 500; //1000 = 1 second
	static final int SECONDS_UNTIL_TIMEOUT = 20;
	static final int PERIODS_TO_WAIT = (MS_IN_A_SECOND/SLEEP_INTERVAL)*SECONDS_UNTIL_TIMEOUT;
	static final int TIME_TO_WAIT = 30;
	
	public static WebDriver driver;
	public static String baseUrl;
	public static boolean acceptNextAlert = true;
	public static StringBuffer verificationErrors = new StringBuffer();
	
	
	public static void Login() throws Exception {
		Utils.driver.get(Utils.baseUrl + "/");
		Utils.driver.findElement(By.xpath("//div[@id='wrap']/div/div[2]/button")).click();

		WebElement googleLogin = (new WebDriverWait(Utils.driver, Utils.TIME_TO_WAIT)).until(ExpectedConditions.presenceOfElementLocated(By.id("google_header_login")));
		assertTrue("Log in with Google".equals(googleLogin.getText()));
		googleLogin.click();

		WebElement enterEmail = (new WebDriverWait(Utils.driver, Utils.TIME_TO_WAIT)).until(ExpectedConditions.presenceOfElementLocated(By.id("Email")));
		assertTrue("".equals(enterEmail.getText()));
		enterEmail.clear();
		enterEmail.sendKeys("416group18");
		
		WebElement enterPassword = (new WebDriverWait(Utils.driver, Utils.TIME_TO_WAIT)).until(ExpectedConditions.presenceOfElementLocated(By.id("Passwd")));
		assertTrue("".equals(enterPassword.getText()));
		enterPassword.clear();
		enterPassword.sendKeys("togglaccount");
		
		WebElement signIn = (new WebDriverWait(Utils.driver, Utils.TIME_TO_WAIT)).until(ExpectedConditions.presenceOfElementLocated(By.id("signIn")));
		signIn.click();
	}
	
	public static boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public static boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	public static String closeAlertAndGetItsText() {
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
