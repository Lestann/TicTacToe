package is.ru.tictactoe;

import java.util.Scanner;


public class TicTacToeConsole {
  public static void main(String[] args){
      Scanner scanner = new Scanner(System.in);
      System.out.println();
      System.out.print("Please enter a name for player1: ");
      String p1Name = getName(scanner);
      Player player1 = new Player(p1Name, Symbol.CROSS);
      System.out.println();
      System.out.print("Please enter a name for player2: ");
      String p2Name = getName(scanner);
      Player player2 = new Player(p2Name, Symbol.CIRCLE);
      TicTacToe game = new TicTacToe(player1, player2);
      game.play(scanner);
      scanner.close();
  }

  private static String getName(Scanner scanner){
    String name;
    name = scanner.nextLine();
    return name;
  }
}
