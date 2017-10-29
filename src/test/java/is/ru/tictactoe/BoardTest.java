package is.ru.tictactoe;

import org.junit.Test;
import static org.junit.Assert.*;

public class BoardTest {
  @Test
  public void testCheckWinnerHorizontal() {
    Player player = new Player("Joi", Symbol.CROSS);
    Board board = new Board();
    board.changeBoard(player.getSymbol(), 1);
    board.changeBoard(player.getSymbol(), 2);
    board.changeBoard(player.getSymbol(), 3);
    assertEquals(true, board.checkWinner(player.getSymbol()));
  }

  @Test
  public void testCheckWinnerVertical() {
    Player player = new Player("Joi", Symbol.CROSS);
    Board board = new Board();
    board.changeBoard(player.getSymbol(), 1);
    board.changeBoard(player.getSymbol(), 4);
    board.changeBoard(player.getSymbol(), 7);
    assertEquals(true, board.checkWinner(player.getSymbol()));
  }

  @Test
  public void testCheckWinnerDiagnalLeftRight() {
    Player player = new Player("Joi", Symbol.CROSS);
    Board board = new Board();
    board.changeBoard(player.getSymbol(), 1);
    board.changeBoard(player.getSymbol(), 5);
    board.changeBoard(player.getSymbol(), 9);
    assertEquals(true, board.checkWinner(player.getSymbol()));
  }

  @Test
  public void testCheckWinnerDiagnalRightLeft() {
    Player player = new Player("Joi", Symbol.CROSS);
    Board board = new Board();
    board.changeBoard(player.getSymbol(), 3);
    board.changeBoard(player.getSymbol(), 5);
    board.changeBoard(player.getSymbol(), 7);
    assertEquals(true, board.checkWinner(player.getSymbol()));
  }
  @Test
  public void testFailInputVertical()
  {
    Player player = new Player("Joi", Symbol.CROSS);
    Board board = new Board();
    board.changeBoard(player.getSymbol(), 2);
    board.changeBoard(player.getSymbol(), 5);
    board.changeBoard(player.getSymbol(), 7);
    assertEquals(false, board.checkWinner(player.getSymbol()));
  }
  @Test
  public void testFailInputHorizontal()
  {
    Player player = new Player("Joi", Symbol.CROSS);
    Board board = new Board();
    board.changeBoard(player.getSymbol(), 1);
    board.changeBoard(player.getSymbol(), 2);
    board.changeBoard(player.getSymbol(), 6);
    assertEquals(false, board.checkWinner(player.getSymbol()));
  }

  @Test
  public void checkValidMove() {
    Board board = new Board();
    assertEquals(false, board.checkValidMove(20));
    assertEquals(true, board.checkValidMove(8));
  }

  @Test
  public void testIsTaken() {
    Board board = new Board();
    board.changeBoard(Symbol.CROSS, 1);
    assertEquals(false, board.isTaken(2));
    assertEquals(true, board.isTaken(1));
  }

  @Test
  public void testFullBoardWinner(){
    Board board = new Board();
    board.changeBoard(Symbol.CROSS, 1);
    board.changeBoard(Symbol.CIRCLE, 2);
    board.changeBoard(Symbol.CROSS, 3);
    board.changeBoard(Symbol.CIRCLE, 7);
    board.changeBoard(Symbol.CROSS, 8);
    board.changeBoard(Symbol.CIRCLE, 9);
    board.changeBoard(Symbol.CROSS, 4);
    board.changeBoard(Symbol.CIRCLE, 5);
    board.changeBoard(Symbol.CROSS, 6);
    assertEquals(false, board.checkWinner(Symbol.CROSS));
  }

  @Test
  public void testIsFull(){
    Board board = new Board();
    board.changeBoard(Symbol.CROSS, 1);
    board.changeBoard(Symbol.CIRCLE, 2);
    board.changeBoard(Symbol.CROSS, 3);
    board.changeBoard(Symbol.CIRCLE, 4);
    board.changeBoard(Symbol.CIRCLE, 5);
    board.changeBoard(Symbol.CROSS, 6);
    board.changeBoard(Symbol.CIRCLE, 7);
    board.changeBoard(Symbol.CROSS, 8);
    board.changeBoard(Symbol.CIRCLE, 9);
    assertEquals(true, board.isFull());
  }

  @Test
  public void testGetSize(){
    Board board = new Board();
    assertEquals(3, board.getSize());
  }
}
