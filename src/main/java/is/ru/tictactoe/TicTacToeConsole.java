package is.ru.tictactoe;
import java.util.Scanner;

public class TicTacToeConsole {
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    String player1Name = getName(1, scanner);
    String player2Name = getName(2, scanner);
    Player player1 = new Player(player1Name, Symbol.CROSS);
    Player player2 = new Player(player2Name, Symbol.CIRCLE);
    play(player1, player2, scanner);
    scanner.close();
  }

  private static void play(Player player1, Player player2, Scanner scanner){
    TicTacToe game = new TicTacToe(player1, player2);
    Player player = player1;
    final int SIZE = game.getBoard().SIZE;
    for(int i = 0; i < SIZE*SIZE; i++){
      char[][] board = game.getBoard().getBoard();;
      System.out.println();
      for (int k = 0; k < SIZE; k++) {
        for (int j = 0; j < SIZE; j++) {
          System.out.print(board[k][j] + " ");
        }
        System.out.println();
      }
      System.out.print(player.getName() + ", where do you want to put your " + game.getNextTurn().toString().toLowerCase() + ": ");
      int n = scanner.nextInt();
      game.makeMove(n);
      if(player == player1) player = player2;
      else player = player1;
    }
  }

  private static String getName(int number, Scanner scanner){
    System.out.println("Player " + number + " what is your name?");
    String name = scanner.nextLine();
    return name;
  }
}
