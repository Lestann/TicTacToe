package is.ru.tictactoe;

public class TicTacToe {

  private Board board;
  private Player player1, player2;

  public TicTacToe (Player player1, Player player2) {
    this.board = new Board();
    this.player1 = player1;
    this.player2 = player2;
  }

  public static void main(String[] args){
    System.out.println("okei etta virkar");
  }
}
