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
      printBoard(board, SIZE);
      System.out.print(player.getName() + ", where do you want to put your " + game.getNextTurn().toString().toLowerCase() + ": ");
      int n = scanner.nextInt();
      game.makeMove(n);
      player = switchPlayer(player1, player2, player);
    }
  }

  private static void printBoard(char[][] board, int SIZE){
    System.out.println();
    for (int i = 0; i < SIZE; i++) {
      for (int j = 0; j < SIZE; j++) {
        System.out.print(board[i][j] + " ");
      }
      System.out.println();
    }
  }

  private static Player switchPlayer(Player player1, Player player2, Player player){
    if(player == player1){
       return player2;
    }
    return player1;
  }

  private static String getName(int number, Scanner scanner){
    System.out.println("Player " + number + " what is your name?");
    String name = scanner.nextLine();
    return name;
  }
}
