package is.ru.tictactoe;

import org.junit.Test;
import static org.junit.Assert.*;

public class BoardTest{
  @Test
  public void testCheckWinner()
  {
    Player player = new Player("Joi", Symbol.CROSS);
    Board board = new Board();
    board.changeBoard(player.getSymbol(), 1);
    board.changeBoard(player.getSymbol(), 2);
    board.changeBoard(player.getSymbol(), 3);
    assertEquals(true, board.checkWinner(player));
  }
}
