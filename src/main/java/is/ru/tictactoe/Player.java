package is.ru.tictactoe;

public class Player {
  private Symbol symbol;
  private int score;
  private String name;

  public Player(String name, Symbol symbol) {
    this.name = name;
    this.symbol = symbol;
    this.score = 0;
  }

  public Symbol getSymbol() {
    return symbol;
  }

  public int getScore() {
    return score;
  }

  public String getName() {
    return name;
  }

  public void incrementScore() {
    score++;
  }
}
