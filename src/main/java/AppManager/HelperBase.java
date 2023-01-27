package AppManager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HelperBase
{
  protected static WebDriver driver;
  protected WebDriverWait wait;

  public HelperBase(WebDriver driver)
  {
    this.driver = driver;
    this.wait = new WebDriverWait(driver, Duration.ofMillis(10000));
  }

  protected void click(By locator) {
    driver.findElement(locator).click();
  }

  protected boolean isElementPresent(By locator)
  {
    try
    {
      driver.findElement(locator);
      return true;
    }
    catch (NoSuchElementException ex)
    {
      return false;
    }
  }
}
