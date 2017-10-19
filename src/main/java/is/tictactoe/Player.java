package is.ru.tictactoe;

public class Player {

  private Symbol symbol;
  private int score;

  public Player(Symbol symbol)
  {
    this.symbol = symbol;
    this.score = 0;
  }

  public Symbol getSymbol()
  {
    return symbol;
  }

  public int getScore()
  {
    return score;
  }

}
