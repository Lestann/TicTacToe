package is.ru.tictactoe;
import java.util.Scanner;

public class TicTacToeConsole {
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    System.out.println("Player 1, what is your name?");
    String player1Name = scanner.nextLine();
    System.out.println("Player 2, what is your name?");
    String player2Name = scanner.nextLine();
    Player player1 = new Player(player1Name, Symbol.CROSS);
    Player player2 = new Player(player2Name, Symbol.CIRCLE);
    TicTacToe game = new TicTacToe(player1, player2);
    scanner.close();
  }
}
