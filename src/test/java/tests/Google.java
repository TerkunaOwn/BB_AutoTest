package tests;


import org.testng.annotations.Test;
import page.ObjectGoogle;

public class Google extends TestBase {

  @Test
  public void Test() {
    ObjectGoogle objectGoogle = new ObjectGoogle(app.driver);
    objectGoogle.open();
    objectGoogle.search();
    objectGoogle.enter();
    
  }
}
