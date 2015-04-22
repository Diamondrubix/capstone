 

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Testing {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://finance.yahoo.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testIng() throws Exception {
    driver.get(baseUrl + "/;_ylt=A0LEVjxD0jdVyHQAi6gnnIlQ;_ylu=X3oDMTByMG04Z2o2BHNlYwNzcgRwb3MDMQRjb2xvA2JmMQR2dGlkAw--");
    driver.findElement(By.id("UHSearchBox")).click();
    driver.findElement(By.id("UHSearchBox")).clear();
    driver.findElement(By.id("UHSearchBox")).sendKeys("GOOG,");
    driver.findElement(By.id("UHSearchProperty")).click();
    driver.findElement(By.id("mnp-search_box")).clear();
    driver.findElement(By.id("mnp-search_box")).sendKeys("YHOO,");
    driver.findElement(By.id("yucs-sprop_button")).click();
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
