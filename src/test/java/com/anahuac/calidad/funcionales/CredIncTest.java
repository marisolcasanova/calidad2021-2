package com.anahuac.calidad.funcionales;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.commons.io.FileUtils;
import java.io.File;

public class CredIncTest {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  JavascriptExecutor js;
  @Before
  public void setUp() throws Exception {
	WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    baseUrl = "https://www.facebook.com/";
    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    js = (JavascriptExecutor) driver;
  }

  @Test
  public void testBusqueda() throws Exception {
    driver.get("https://www.facebook.com/");
    driver.findElement(By.name("email")).clear();
    driver.findElement(By.name("email")).sendKeys("sdfd");
    driver.findElement(By.name("pass")).clear();
    driver.findElement(By.name("pass")).sendKeys("123456");
    driver.findElement(By.name("login")).click();
    pause(1000);
    String AlertMessage = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div/div[2]/div[2]/form/div/div[1]/div[2]")).getText();
    assertThat("El correo electrónico o número de celular que ingresaste no está conectado a una cuenta. Encuentra tu cuenta e inicia sesión.", is(AlertMessage));
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
  
  private void pause(long mils) {
	  try {
		  Thread.sleep(mils);
	  } catch (Exception e) {
		  e.printStackTrace();
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


