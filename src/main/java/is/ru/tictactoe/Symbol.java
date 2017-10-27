package is.ru.tictactoe;

public enum Symbol{
  CROSS,
  CIRCLE;
  public Symbol next(){
    if(this.equals(Symbol.CROSS)){
      return Symbol.CIRCLE;
    }
    return Symbol.CROSS;
  }
};
