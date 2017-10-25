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
      play(scanner, player1, player2);
      scanner.close();
  }

  private static void play(Scanner scanner, Player player1, Player player2) {
    boolean continueGame = true;
    TicTacToe game = new TicTacToe(player1, player2);
    Player player = player1;
    final int SIZE = game.getSize();

    while (continueGame) {
      for (int i = 0; i < (SIZE*SIZE); i++) {
        printBoard(game.getBoard());
        System.out.print(player.getName() + ", its your move: ");
        int input = scanner.nextInt();
        Player temp = player;
        player = game.checkWinner(player, input);
        if(temp == player) {
          break;
        }
      }
      printBoard(game.getBoard());
      Player winner = game.restartGame();

      if(winner != null){
        System.out.println(winner.getName() + ", you won this round");
      }
      else{
        System.out.println("Well this one was a draw, hopefully someone will win next time");
      }
      System.out.println("Do you want to play another round (Y/N): ");
      char cont = scanner.next().charAt(0);
      continueGame = cont == 'Y' ? true : false;
    }

  }

  private static void printBoard(Board board) {
    System.out.println();
    board.print();
    System.out.println();
  }
  private static String getName(Scanner scanner){
    String name;
    name = scanner.nextLine();
    return name;
  }
}
