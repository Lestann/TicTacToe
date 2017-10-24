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
}
