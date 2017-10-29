package is.ru.tictactoe;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;


public class TestTicTacToe extends SeleniumTestWrapper {
  @Test
  public void testTitleMatches() {
    driver.get(baseUrl);
    assertEquals("TicTacToe", driver.getTitle());
  }

  @Test
  public void testSimpleAdd() throws Exception {
    Thread.sleep(2000);
    WebElement td1 = driver.findElement(By.id("1"));
    WebElement td2 = driver.findElement(By.id("2"));
    WebElement td3 = driver.findElement(By.id("3"));
    JavascriptExecutor executor = (JavascriptExecutor)driver;
    executor.executeScript("arguments[0].click();", td1);
    Thread.sleep(2000);
    executor.executeScript("arguments[0].click();", td2);
    Thread.sleep(2000);
    executor.executeScript("arguments[0].click();", td3);

  }
}
