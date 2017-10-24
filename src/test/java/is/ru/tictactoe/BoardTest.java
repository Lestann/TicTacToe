package is.ru.tictactoe;

import org.junit.Test;
import static org.junit.Assert.*;

public class BoardTest{
  @Test
  public void testCheckWinnerHorizontal()
  {
    Player player = new Player("Joi", Symbol.CROSS);
    Board board = new Board();
    board.changeBoard(player.getSymbol(), 1);
    board.changeBoard(player.getSymbol(), 2);
    board.changeBoard(player.getSymbol(), 3);
    assertEquals(true, board.checkWinner(player));
  }
  @Test
  public void testCheckWinnerVertical()
  {
    Player player = new Player("Joi", Symbol.CROSS);
    Board board = new Board();
    board.changeBoard(player.getSymbol(), 1);
    board.changeBoard(player.getSymbol(), 4);
    board.changeBoard(player.getSymbol(), 7);
    assertEquals(true, board.checkWinner(player));
  }
  @Test
  public void testCheckWinnerDiagnalLeftRight()
  {
    Player player = new Player("Joi", Symbol.CROSS);
    Board board = new Board();
    board.changeBoard(player.getSymbol(), 1);
    board.changeBoard(player.getSymbol(), 5);
    board.changeBoard(player.getSymbol(), 9);
    assertEquals(true, board.checkWinner(player));
  }
  @Test
  public void testCheckWinnerDiagnalRightLeft()
  {
    Player player = new Player("Joi", Symbol.CROSS);
    Board board = new Board();
    board.changeBoard(player.getSymbol(), 3);
    board.changeBoard(player.getSymbol(), 5);
    board.changeBoard(player.getSymbol(), 7);
    assertEquals(true, board.checkWinner(player));
  }
  @Test
  public void testRandomInput()
  {
    Player player = new Player("Joi", Symbol.CROSS);
    Board board = new Board();
    board.changeBoard(player.getSymbol(), 2);
    board.changeBoard(player.getSymbol(), 5);
    board.changeBoard(player.getSymbol(), 7);
    assertEquals(false, board.checkWinner(player));
  }

  @Test
  public void testIsTaken () {
    Board board = new Board();
    assertEquals(false, board.isTaken(2));
  }

}
