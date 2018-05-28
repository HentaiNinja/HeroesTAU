package pl.hentaininja.selenium;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class SiteTest {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception {
    driver = new FirefoxDriver();
    System.setProperty("webdriver.gecko.driver", "/home/PJWSTK/s12581/TAU/HeroesTAU/lab01");
	baseUrl = "http://automationpractice.com/index.php";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    driver.manage().window().fullscreen();
    }
    

	@Test
	public void test() throws Exception {
		driver.get(baseUrl + "/");
        driver.findElement(By.linkText("Sign in")).click();        
        driver.findElement(By.id("email_create")).click();
        driver.findElement(By.id("email_create")).clear();
        driver.findElement(By.id("email_create")).sendKeys("bla12bla1994@hopkins.com");
        //Thread.sleep(5000);
		assertEquals("bla12bla1994@hopkins.com", driver.findElement(By.cssSelector("#email_create")).getAttribute("value"));
		// File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        // FileUtils.copyFile(scrFile, new File("target/SomeSiteTest1.png"));
        driver.findElement(By.id("SubmitCreate")).click();
        driver.findElement(By.id("id_gender1")).click();
        driver.findElement(By.id("customer_firstname")).click();
        driver.findElement(By.id("customer_firstname")).sendKeys("Bezimienny");
        assertNotNull(driver.findElement(By.cssSelector("#customer_firstname")).getAttribute("value"));
        assertEquals("Bezimienny", driver.findElement(By.cssSelector("#customer_firstname")).getAttribute("value"));
        driver.findElement(By.id("customer_lastname")).click();
        driver.findElement(By.id("customer_lastname")).sendKeys("Ja");
        assertNotNull(driver.findElement(By.cssSelector("#customer_lastname")).getAttribute("value"));
        assertEquals("Ja", driver.findElement(By.cssSelector("#customer_lastname")).getAttribute("value"));
        driver.findElement(By.id("passwd")).click();
        driver.findElement(By.id("passwd")).sendKeys("staplehorsebattery");
        driver.findElement(By.id("days")).click();
        // new Select(driver.findElement(By.id("days"))).selectByVisibleText("11");
        // driver.findElement(By.id("months")).click();
        // new Select(driver.findElement(By.id("months"))).selectByVisibleText("January");
        // driver.findElement(By.id("years")).click();
        // new Select(driver.findElement(By.id("years"))).selectByVisibleText("2017");
        driver.findElement(By.id("newsletter")).click();
        driver.findElement(By.id("firstname")).click();
        driver.findElement(By.id("firstname")).clear();
        driver.findElement(By.id("firstname")).sendKeys("Mr");
        assertNotNull(driver.findElement(By.cssSelector("#firstname")).getAttribute("value"));
        assertEquals("Mr", driver.findElement(By.cssSelector("#firstname")).getAttribute("value"));
        driver.findElement(By.id("lastname")).click();
        driver.findElement(By.id("lastname")).clear();
        driver.findElement(By.id("lastname")).sendKeys("Krabs");
        assertNotNull(driver.findElement(By.cssSelector("#lastname")).getAttribute("value"));
        assertEquals("Krabs", driver.findElement(By.cssSelector("#lastname")).getAttribute("value"));
        driver.findElement(By.id("company")).click();
        driver.findElement(By.id("company")).sendKeys("fompany");
        driver.findElement(By.id("address1")).click();
        driver.findElement(By.id("address1")).clear();
        driver.findElement(By.id("address1")).sendKeys("Brzegi55");
        assertNotNull(driver.findElement(By.cssSelector("#address1")).getAttribute("value"));
        assertEquals("Brzegi55", driver.findElement(By.cssSelector("#address1")).getAttribute("value"));
        driver.findElement(By.id("city")).click();
        driver.findElement(By.id("city")).sendKeys("gdynia");
        driver.findElement(By.id("id_state")).click();
        new Select(driver.findElement(By.id("id_state"))).selectByVisibleText("Alaska");
        driver.findElement(By.id("postcode")).click();
        driver.findElement(By.id("postcode")).sendKeys("12345");
        driver.findElement(By.id("id_country")).click();
        new Select(driver.findElement(By.id("id_country"))).selectByVisibleText("United States");
        driver.findElement(By.id("phone_mobile")).click();
        driver.findElement(By.id("phone_mobile")).clear();
        driver.findElement(By.id("phone_mobile")).sendKeys("999888777");
        assertNotNull(driver.findElement(By.id("phone_mobile")).getAttribute("value"));
        assertEquals("999888777", driver.findElement(By.id("phone_mobile")).getAttribute("value"));
        driver.findElement(By.id("alias")).click();
        driver.findElement(By.id("alias")).sendKeys("BOI");
        driver.findElement(By.id("submitAccount")).click();


	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	private boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	private String closeAlertAndGetItsText() {
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