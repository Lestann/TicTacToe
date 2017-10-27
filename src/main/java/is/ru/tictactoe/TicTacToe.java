package is.ru.tictactoe;

public class TicTacToe {

  private Board board;
  private Player player1, player2;
  private Symbol nextTurn;

  public TicTacToe() {
    this.board = new Board();
    this.player1 = new Player("Player 1", Symbol.CROSS);
    this.player2 = new Player("Player 2", Symbol.CIRCLE);
    this.nextTurn = Symbol.CROSS;
  }

  public TicTacToe(Player player1, Player player2) {
    this.board = new Board();
    this.player1 = player1;
    this.player2 = player2;
    this.nextTurn = Symbol.CROSS;
  }

  public Player getPlayer1(){
    return player1;
  }

  public Player getPlayer2(){
    return player2;
  }

  public Board getBoard(){
    return board;
  }

  public Symbol getNextTurn() {
    return nextTurn;
  }

  public void setNextTurn(Symbol nextTurn) {
    this.nextTurn = nextTurn;
  }

  private Player switchPlayer(Player player) {
    if (player == player1)
      return player2;

    return player1;
  }

  public boolean makeMove(int position) {
    if(!board.isTaken(position)){
      board.changeBoard(nextTurn, position);
      nextTurn = nextTurn.next();
      return true;
    }

    return false;
  }

  public String checkWinner() {

    if(board.checkWinner(nextTurn.next())){
      if(nextTurn.next() == Symbol.CROSS){
        incrementScore(nextTurn.next());
        return "X";
      }
      incrementScore(nextTurn.next());
      return "O";
    }
    else if(board.isFull())
    {
      return "D";
    }
    return "";

  }

  private void incrementScore(Symbol symbol){
    if(player1.getSymbol() == symbol){
      player1.incrementScore();
      return;
    }
    player2.incrementScore();
    return;
  }

  public boolean resetGame(){
    board = new Board();
    player1.setSymbol(player1.getSymbol().next());
    player2.setSymbol(player2.getSymbol().next());
    nextTurn = Symbol.CROSS;

    return true;
  }
}
