package page;

import AppManager.HelperBase;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ObjectGoogle extends HelperBase {

  public ObjectGoogle(WebDriver driver) {
    super(driver);
    PageFactory.initElements(driver, this);
  }

  String BASE_URL = "https://google.com";

  @FindBy(css = "input[class=gLFyf]")
  private WebElement Find;

  @Step("open")
  public void open() {
    driver.get(BASE_URL);
  }

  @Step("search")
  public void search() {
    wait.until(ExpectedConditions.visibilityOf(Find)).click();
    wait.until(ExpectedConditions.visibilityOf(Find)).sendKeys("Hi");
  }

  @Step("Enter")
  public void enter() {
    wait.until(ExpectedConditions.visibilityOf(Find)).sendKeys(Keys.ENTER);
  }
}
