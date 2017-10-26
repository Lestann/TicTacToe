package is.ru.tictactoe;

import org.junit.Test;
import static org.junit.Assert.*;

public class TicTacToeTest {

  @Test
  public void testCorrectGridSize() {
    Board board = new Board();
    assertEquals(9, board.getSize() * 3);
  }

  @Test
  public void testIncorrectGridSize() {
    Board board = new Board();
    assertNotEquals(1337, board.getSize());
  }
}
