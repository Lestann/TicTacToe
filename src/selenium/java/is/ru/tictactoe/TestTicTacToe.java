package is.ru.tictactoe;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;


public class TestTicTacToe extends SeleniumTestWrapper {
  @Test
  public void testTitleMatches() {
    driver.get(baseUrl);
    assertEquals("TicTacToe", driver.getTitle());
  }

  @Test
  public void testFirstRowWin() throws Exception {
    driver.get(baseUrl);
    WebElement td1 = driver.findElement(By.id("1"));
    WebElement td2 = driver.findElement(By.id("2"));
    WebElement td3 = driver.findElement(By.id("3"));
    WebElement td4 = driver.findElement(By.id("4"));
    WebElement td5 = driver.findElement(By.id("5"));
    WebElement td6 = driver.findElement(By.id("6"));
    WebElement td7 = driver.findElement(By.id("7"));
    WebElement td8 = driver.findElement(By.id("8"));
    WebElement td9 = driver.findElement(By.id("9"));
    String p1Score = driver.findElement(By.id("player1Score")).getText();
    JavascriptExecutor executor = (JavascriptExecutor)driver;
    executor.executeScript("arguments[0].click();", td1);
    executor.executeScript("arguments[0].click();", td7);
    executor.executeScript("arguments[0].click();", td2);
    executor.executeScript("arguments[0].click();", td8);
    executor.executeScript("arguments[0].click();", td3);

    String newp1Score = driver.findElement(By.id("player1Score")).getText();
    assertEquals(Integer.parseInt(newp1Score), Integer.parseInt(p1Score)+1);// driver.findElement(By.id("player1Score")).getText());
  }
  @Test
  public void testSecondRowWin() throws Exception {
    driver.get(baseUrl);
    WebElement td1 = driver.findElement(By.id("1"));
    WebElement td2 = driver.findElement(By.id("2"));
    WebElement td3 = driver.findElement(By.id("3"));
    WebElement td4 = driver.findElement(By.id("4"));
    WebElement td5 = driver.findElement(By.id("5"));
    WebElement td6 = driver.findElement(By.id("6"));
    WebElement td7 = driver.findElement(By.id("7"));
    WebElement td8 = driver.findElement(By.id("8"));
    WebElement td9 = driver.findElement(By.id("9"));
    String p1Score = driver.findElement(By.id("player1Score")).getText();
    JavascriptExecutor executor = (JavascriptExecutor)driver;
    executor.executeScript("arguments[0].click();", td4);
    executor.executeScript("arguments[0].click();", td7);
    executor.executeScript("arguments[0].click();", td5);
    executor.executeScript("arguments[0].click();", td8);
    executor.executeScript("arguments[0].click();", td6);
    String newp1Score = driver.findElement(By.id("player1Score")).getText();
    assertEquals(Integer.parseInt(newp1Score), Integer.parseInt(p1Score)+1);
  }
  @Test
  public void testThirdRowWin() throws Exception {
    driver.get(baseUrl);
    WebElement td1 = driver.findElement(By.id("1"));
    WebElement td2 = driver.findElement(By.id("2"));
    WebElement td3 = driver.findElement(By.id("3"));
    WebElement td4 = driver.findElement(By.id("4"));
    WebElement td5 = driver.findElement(By.id("5"));
    WebElement td6 = driver.findElement(By.id("6"));
    WebElement td7 = driver.findElement(By.id("7"));
    WebElement td8 = driver.findElement(By.id("8"));
    WebElement td9 = driver.findElement(By.id("9"));
    String p1Score = driver.findElement(By.id("player1Score")).getText();
    JavascriptExecutor executor = (JavascriptExecutor)driver;
    executor.executeScript("arguments[0].click();", td7);
    executor.executeScript("arguments[0].click();", td1);
    executor.executeScript("arguments[0].click();", td8);
    executor.executeScript("arguments[0].click();", td2);
    executor.executeScript("arguments[0].click();", td9);
    String newp1Score = driver.findElement(By.id("player1Score")).getText();
    assertEquals(Integer.parseInt(newp1Score), Integer.parseInt(p1Score)+1);
  }
  @Test
  public void testDraw() throws Exception {
    driver.get(baseUrl);
    WebElement td1 = driver.findElement(By.id("1"));
    WebElement td2 = driver.findElement(By.id("2"));
    WebElement td3 = driver.findElement(By.id("3"));
    WebElement td4 = driver.findElement(By.id("4"));
    WebElement td5 = driver.findElement(By.id("5"));
    WebElement td6 = driver.findElement(By.id("6"));
    WebElement td7 = driver.findElement(By.id("7"));
    WebElement td8 = driver.findElement(By.id("8"));
    WebElement td9 = driver.findElement(By.id("9"));
    String p1Score = driver.findElement(By.id("player1Score")).getText();
    JavascriptExecutor executor = (JavascriptExecutor)driver;
    executor.executeScript("arguments[0].click();", td1);
    executor.executeScript("arguments[0].click();", td2);
    executor.executeScript("arguments[0].click();", td3);
    executor.executeScript("arguments[0].click();", td7);
    executor.executeScript("arguments[0].click();", td8);
    executor.executeScript("arguments[0].click();", td9);
    executor.executeScript("arguments[0].click();", td4);
    executor.executeScript("arguments[0].click();", td5);
    executor.executeScript("arguments[0].click();", td6);
    String newp1Score = driver.findElement(By.id("player1Score")).getText();
    assertEquals(Integer.parseInt(newp1Score), Integer.parseInt(p1Score));
  }
  @Test
  public void testOWinDiagnal() throws Exception {
    driver.get(baseUrl);
    WebElement td1 = driver.findElement(By.id("1"));
    WebElement td2 = driver.findElement(By.id("2"));
    WebElement td3 = driver.findElement(By.id("3"));
    WebElement td4 = driver.findElement(By.id("4"));
    WebElement td5 = driver.findElement(By.id("5"));
    WebElement td6 = driver.findElement(By.id("6"));
    WebElement td7 = driver.findElement(By.id("7"));
    WebElement td8 = driver.findElement(By.id("8"));
    WebElement td9 = driver.findElement(By.id("9"));
    String p2Score = driver.findElement(By.id("player2Score")).getText();
    JavascriptExecutor executor = (JavascriptExecutor)driver;
    executor.executeScript("arguments[0].click();", td2);
    executor.executeScript("arguments[0].click();", td1);
    executor.executeScript("arguments[0].click();", td3);
    executor.executeScript("arguments[0].click();", td5);
    executor.executeScript("arguments[0].click();", td8);
    executor.executeScript("arguments[0].click();", td9);
    String newp2Score = driver.findElement(By.id("player2Score")).getText();
    assertEquals(Integer.parseInt(newp2Score), Integer.parseInt(p2Score) + 1);
  }
  @Test
  public void testXWinDiagnal() throws Exception {
    driver.get(baseUrl);
    WebElement td1 = driver.findElement(By.id("1"));
    WebElement td2 = driver.findElement(By.id("2"));
    WebElement td3 = driver.findElement(By.id("3"));
    WebElement td4 = driver.findElement(By.id("4"));
    WebElement td5 = driver.findElement(By.id("5"));
    WebElement td6 = driver.findElement(By.id("6"));
    WebElement td7 = driver.findElement(By.id("7"));
    WebElement td8 = driver.findElement(By.id("8"));
    WebElement td9 = driver.findElement(By.id("9"));
    String p1Score = driver.findElement(By.id("player1Score")).getText();
    JavascriptExecutor executor = (JavascriptExecutor)driver;
    executor.executeScript("arguments[0].click();", td3);
    executor.executeScript("arguments[0].click();", td1);
    executor.executeScript("arguments[0].click();", td5);
    executor.executeScript("arguments[0].click();", td2);
    executor.executeScript("arguments[0].click();", td7);
    String newp1Score = driver.findElement(By.id("player1Score")).getText();
    assertEquals(Integer.parseInt(newp1Score), Integer.parseInt(p1Score) + 1);
  }
  @Test
  public void testVerticalWin() throws Exception {
    driver.get(baseUrl);
    WebElement td1 = driver.findElement(By.id("1"));
    WebElement td2 = driver.findElement(By.id("2"));
    WebElement td3 = driver.findElement(By.id("3"));
    WebElement td4 = driver.findElement(By.id("4"));
    WebElement td5 = driver.findElement(By.id("5"));
    WebElement td6 = driver.findElement(By.id("6"));
    WebElement td7 = driver.findElement(By.id("7"));
    WebElement td8 = driver.findElement(By.id("8"));
    WebElement td9 = driver.findElement(By.id("9"));
    String p1Score = driver.findElement(By.id("player1Score")).getText();
    JavascriptExecutor executor = (JavascriptExecutor)driver;
    executor.executeScript("arguments[0].click();", td1);
    executor.executeScript("arguments[0].click();", td2);
    executor.executeScript("arguments[0].click();", td4);
    executor.executeScript("arguments[0].click();", td3);
    executor.executeScript("arguments[0].click();", td7);
    String newp1Score = driver.findElement(By.id("player1Score")).getText();
    assertEquals(Integer.parseInt(newp1Score), Integer.parseInt(p1Score) + 1);
  }
  /*@Test
  public void testNewGame() throws Exception {
    driver.get(baseUrl);
    WebElement td1 = driver.findElement(By.id("1"));
    WebElement td2 = driver.findElement(By.id("2"));
    WebElement td3 = driver.findElement(By.id("3"));
    WebElement td4 = driver.findElement(By.id("4"));
    WebElement td5 = driver.findElement(By.id("5"));
    WebElement td6 = driver.findElement(By.id("6"));
    WebElement td7 = driver.findElement(By.id("7"));
    WebElement td8 = driver.findElement(By.id("8"));
    WebElement td9 = driver.findElement(By.id("9"));
    JavascriptExecutor executor = (JavascriptExecutor)driver;
    executor.executeScript("arguments[0].click();", td1);
    executor.executeScript("arguments[0].click();", td2);
    executor.executeScript("arguments[0].click();", td4);
    executor.executeScript("arguments[0].click();", td3);
    executor.executeScript("arguments[0].click();", td7);
    String newp1Score = driver.findElement(By.id("player1Score")).getText();
    WebElement newGame = driver.findElement(By.id("newGame"));
    newGame.click();
    Alert alert = driver.switchTo().alert();
    alert.accept();
    String p1Score = driver.findElement(By.id("player1Score")).getText();
    String p2Score = driver.findElement(By.id("player2Score")).getText();
    assertEquals(0, Integer.parseInt(p1Score));
    assertEquals(0, Integer.parseInt(p2Score));
  }*/
}
