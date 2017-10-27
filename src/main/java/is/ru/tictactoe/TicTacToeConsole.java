package is.ru.tictactoe;
import java.util.Scanner;

public class TicTacToeConsole {
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);  
    String player1Name = getName(1, scanner);
    String player2Name = getName(2, scanner);
    Player player1 = new Player(player1Name, Symbol.CROSS);
    Player player2 = new Player(player2Name, Symbol.CIRCLE);
    TicTacToe game = new TicTacToe(player1, player2);
    scanner.close();
  }

  private static String getName(int number, Scanner scanner){
    System.out.println("Player " + number + " what is your name?");
    String name = scanner.nextLine();
    return name;
  }
}
