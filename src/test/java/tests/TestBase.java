package tests;

import AppManager.ApplicationManager;
import io.qameta.allure.Step;
import org.openqa.selenium.remote.Browser;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

  public static final ApplicationManager app
          = new ApplicationManager(System.getProperty("browser", String.valueOf(Browser.CHROME)));

  @BeforeMethod(alwaysRun = true)
  @Step("метод")
  public void setUp() throws Exception
  {
    app.init();
  }

  @AfterMethod(alwaysRun = true)
  public void tearDown() throws Exception {
    app.stop();
  }
}
