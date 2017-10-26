package is.ru.tictactoe;

import org.junit.Test;
import static org.junit.Assert.*;

public class TicTacToeTest {

  @Test
  public void testCorrectGridSize() {
    TicTacToe game = new TicTacToe();
    assertEquals(9, game.getSize() * 3);
  }

  @Test
  public void testIncorrectGridSize() {
    TicTacToe game = new TicTacToe();
    assertNotEquals(1337, game.getSize());
  }
}
