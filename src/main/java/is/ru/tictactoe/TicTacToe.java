package is.ru.tictactoe;

public class TicTacToe {

  private Board board;
  private Player player1, player2, winner, firstPlayer;
  private final int SIZE = 3;

  public TicTacToe (Player player1, Player player2) {
    this.board = new Board();
    this.player1 = player1;
    this.player2 = player2;
    this.winner = null;
    this.firstPlayer = player1;
  }

  public Board getBoard() {
    return board;
  }

  public int getSize() {
    return SIZE;
  }

  public Player getFirstPlayer(){
    return firstPlayer;
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
      Symbol tempSymbol = player1.getSymbol();
      player1.setSymbol(player2.getSymbol());
      player2.setSymbol(tempSymbol);
      firstPlayer = player2;
      winner = null;
      return player;
    }
    Symbol tempSymbol = player1.getSymbol();
    player1.setSymbol(player2.getSymbol());
    player2.setSymbol(tempSymbol);
    firstPlayer = player2;

    return winner;
  }
}
