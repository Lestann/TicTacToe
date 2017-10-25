package is.ru.tictactoe;

public class TicTacToe {

  private Board board;
  private Player player1, player2, winner;
  private final int SIZE = 3;

  public TicTacToe (Player player1, Player player2) {
    this.board = new Board();
    this.player1 = player1;
    this.player2 = player2;
    this.winner = null;
  }

  public Board getBoard() {
    return board;
  }

  public int getSize() {
    return SIZE;
  }

  private Player switchPlayer(Player player){
    if(player == player1){
      return player2;
    }
    return player1;
  }

  public Player checkWinner(Player player, int input) {

    board.changeBoard(player.getSymbol(), input);
    if (board.checkWinner(player)){
      winner = player;
      return player;
    }
    return switchPlayer(player);
  }

  public Player restartGame(){
    board = new Board();
    if(winner != null){
      if(winner == player1){
        player1.incrementScore();
      }
      else{
        player2.incrementScore();
      }
      Player player = winner;
      winner = null;
      return player;
    }
    return winner;
  }
}
