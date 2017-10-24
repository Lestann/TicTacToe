package is.ru.tictactoe;
import java.util.Scanner;

public class TicTacToe {

  private Board board;
  private Player player1, player2;
  private final int SIZE = 3;

  public TicTacToe (Player player1, Player player2) {
    this.board = new Board();
    this.player1 = player1;
    this.player2 = player2;
  }

  public void play() {
    boolean continueGame = true;
    Player player = player1;
    while (continueGame) {
      for (int i = 0; i < SIZE*SIZE; i++) {
        if (board.checkWinner(player)){
          break;
        }
      }
    }
  }

  public static void main(String[] args){
      Scanner scanner = new Scanner(System.in);
      System.out.print("Please enter a name for player1: ");
      String p1Name = getName(scanner);
      Player player1 = new Player(p1Name, Symbol.CROSS);
      System.out.print("Please enter a name for player2: ");
      String p2Name = getName(scanner);
      scanner.close();
      Player player2 = new Player(p1Name, Symbol.CROSS);
      TicTacToe game = new TicTacToe(player1, player2);
  }

  private static String getName(Scanner scanner){
    String name;
    name = scanner.nextLine();
    return name;
  }
}
