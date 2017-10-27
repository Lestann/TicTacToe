package is.ru.tictactoe;

import org.junit.Test;
import static org.junit.Assert.*;

public class PlayerTest {

  @Test
  public void testConstructor()
  {
    Symbol circle = Symbol.CIRCLE;
    Player player = new Player("Kolbeinn Ari", circle);
    assertEquals("Kolbeinn Ari", player.getName());
    assertEquals(circle, player.getSymbol());
    assertEquals(0, player.getScore());
  }

  @Test
  public void testIncrementScore()
  {
    Player player = new Player("Kolbeinn Ari", Symbol.CIRCLE);
    player.incrementScore();
    assertEquals(1, player.getScore());
  }
  @Test
  public void testIncrementScore2(){
    Player player1 = new Player("Steinar", Symbol.CROSS);
    Player player2 = new Player("Kolbeinn Ari", Symbol.CIRCLE);
    TicTacToe game = new TicTacToe(player1, player2); 
    game.makeMove(1)
    game.makeMove(2)
    game.makeMove(4)
    game.makeMove(3)
    game.makeMove(7)
    String winner = game.checkWinner();
    if(winner == player1.getSymbol){
      assertEquals(1, player1.getScore());
    }
    if(winner == player2.getSymbol){
      assertEquals(1, player2.getScore());
    }
  }
}
