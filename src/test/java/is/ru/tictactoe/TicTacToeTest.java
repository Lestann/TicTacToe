package is.ru.tictactoe;

import org.junit.Test;
import static org.junit.Assert.*;

public class TicTacToeTest {

  @Test
  public void testMakValidMove(){
    TicTacToe game = new TicTacToe();
    assertEquals(true, game.makeMove(1));
  }

  @Test
  public void testMakeInvalidMove(){
    TicTacToe game = new TicTacToe();
    game.makeMove(1);
    assertEquals(false, game.makeMove(1));
  }

  @Test
  public void testCheckWinner(){
    TicTacToe game = new TicTacToe();
    game.makeMove(1); //X
    game.makeMove(4); //O
    game.makeMove(2); //X
    game.makeMove(5); //O
    game.makeMove(3); //X
    assertEquals("X", game.checkWinner());
  }

  @Test
  public void testCheckWinnerDraw(){
    TicTacToe game = new TicTacToe();
    game.makeMove(1); //X
    game.makeMove(2); //O
    game.makeMove(3); //X
    game.makeMove(7); //O
    game.makeMove(8); //X
    game.makeMove(9); //O
    game.makeMove(4); //X
    game.makeMove(5); //O
    game.makeMove(6); //X
    assertEquals("D", game.checkWinner());
  }

  @Test
  public void testNewRound(){
    TicTacToe game = new TicTacToe();
    game.newRound();
    assertEquals(Symbol.CIRCLE, game.getPlayer1().getSymbol());
  }
}
