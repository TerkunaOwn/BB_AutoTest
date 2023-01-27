package AppManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ApplicationManager
{
  public WebDriver driver;
  private String browser;
  public final Properties properties;

  public ApplicationManager(String browser)
  {
    this.browser = browser;
    properties = new Properties(); //иниц. объекта пропертис
  }

  public void init() throws IOException {
    String target = System.getProperty("target", "local"); //название конфиг. файла
    properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));
    driver = new ChromeDriver();
    driver.manage().window().maximize(); // ход теста отображается в полностью открытом окне
    driver.get(properties.getProperty("web.baseUrl"));
  }

  public void stop() {
    driver.quit();
  }


  public String getProperty(String key)
  {
    return properties.getProperty(key);
  }
}
