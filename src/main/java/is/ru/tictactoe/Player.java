package is.ru.tictactoe;

public class Player {
  private String name;
  private Symbol symbol;
  private int score;

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

  public void setSymbol(Symbol symbol) {
    this.symbol = symbol;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void incrementScore() {
    score++;
  }
}
