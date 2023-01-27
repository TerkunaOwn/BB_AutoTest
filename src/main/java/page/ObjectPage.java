package page;

import AppManager.HelperBase;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ObjectPage extends HelperBase {

  Actions mouse = new Actions(driver);

  public ObjectPage(WebDriver driver) {
    super(driver);
    PageFactory.initElements(driver, this);
  }

  @FindBy(css = "[name=Login]") //поле для ввода логина
  private WebElement loginField;
  @FindBy(css = "[name=Password]") //поле для ввода пароля
  private WebElement passwordField;
  @FindBy(css = "button[name='loginSubmit']") //кнопка "Войти"
  private WebElement buttonLoginSubmit;
  @FindBy(css = "div[class='account-widget__username']") //авторизованный аккаунт. иконка аккаунта
  private WebElement iconAccount;
  @FindBy(css = "div[class='account-widget__navigation-block']") //авторизованный аккаунт. навигационный блок
  private WebElement navigationBlock;
  @FindBy(css = "a[href='/account/logout']") //авторизованный аккаунт. навигационный блок. Кнопка "Выйти"
  private WebElement navigationBlock_ButtonExit;

  //вводим номер телефона в соответсвующее поле
  @Step("Вводим номер телефона: {0}")
  public void inputAccountLogin(String login) {
    wait.until(ExpectedConditions.visibilityOf(loginField)).click();
    wait.until(ExpectedConditions.visibilityOf(loginField)).sendKeys(login);
  }

  //вводим пароль в соответствующее поле
  @Step("Вводим пароль: {password}")
  public void inputAccountPassword(String password) {
    wait.until(ExpectedConditions.visibilityOf(passwordField)).click();
    wait.until(ExpectedConditions.visibilityOf(passwordField)).sendKeys(password);
  }

  //нажимаем кнопку Войти
  public void pressButtonLogin() {
    wait.until(ExpectedConditions.elementToBeClickable(buttonLoginSubmit)).click();
  }

  //Иконка аккаунта
  public void iconAccount() {
    wait.until(ExpectedConditions.elementToBeClickable(iconAccount)).isDisplayed();
  }
}
