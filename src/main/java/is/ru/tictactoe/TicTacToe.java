package is.ru.tictactoe;
import java.util.Scanner;

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

  private Player switchPlayer(Player player){
    if(player == player1){
      player = player2;
    }
    else{
      player = player1;
    }

    return player;
  }

  private void gameIteration(Player player, Scanner scanner){
    for (int i = 0; i < (SIZE*SIZE); i++) {
      System.out.println();
      board.print();
      System.out.println();
      System.out.print(player.getName() + ", its your move: ");
      int input = scanner.nextInt();
      board.changeBoard(player.getSymbol(), input);
      if (board.checkWinner(player)){
        winner = player;
        return;
      }
      player = switchPlayer(player);
    }
  }

  public void restartGame(){
    if(winner != null){
      if(winner == player1){
        player1.incrementScore();
      }
      else{
        player2.incrementScore();
      }
      System.out.println(winner.getName() + ", You won this round");
      winner = null;
    }
    else{
      System.out.println("This round was a draw!");
    }
  }

  public void play(Scanner scanner) {
    boolean continueGame = true;
    Player player = player1;
    while (continueGame) {
      gameIteration(player, scanner);
      board.print();
      board = new Board();
      restartGame();
      System.out.println("Do you want to play another round (Y/N): ");
      char cont = scanner.next().charAt(0);
      continueGame = cont == 'Y' ? true : false;
    }
  }


}
