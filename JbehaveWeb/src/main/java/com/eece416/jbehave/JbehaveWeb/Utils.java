package com.eece416.jbehave.JbehaveWeb;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;


public class Utils {

	static final int MS_IN_A_SECOND = 1000;
	static final int SLEEP_INTERVAL = 500; //1000 = 1 second
	static final int SECONDS_UNTIL_TIMEOUT = 20;
	static final int PERIODS_TO_WAIT = (MS_IN_A_SECOND/SLEEP_INTERVAL)*SECONDS_UNTIL_TIMEOUT;
	
	public static WebDriver driver;
	public static String baseUrl;
	public static boolean acceptNextAlert = true;
	public static StringBuffer verificationErrors = new StringBuffer();
	
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
