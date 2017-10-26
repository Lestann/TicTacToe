package is.ru.tictactoe;

public class TicTacToe {

  private Board board;
  private Player player1, player2;
  private char nextTurn;

  public TicTacToe() {
    this.board = new Board();
    this.player1 = new Player("Player 1", Symbol.CROSS);
    this.player2 = new Player("Player 2", Symbol.CIRCLE);
    this.nextTurn = 'X';
  }

  public TicTacToe(Player player1, Player player2) {
    this.board = new Board();
    this.player1 = player1;
    this.player2 = player2;
    this.nextTurn = 'X';
  }

  public Board getBoard() {
    return board;
  }

  public char getNextTurn() {
    return nextTurn;
  }

  public void setNextTurn(char nextTurn) {
    this.nextTurn = nextTurn;
  }

  private Player switchPlayer(Player player) {
    if (player == player1)
      return player2;

    return player1;
  }

  public boolean makeMove(int position) {
     System.out.println("Position" + position);

     board.print();

    return true;
  }

  public String checkWinner() {
    return "Kristján";
  }
}
