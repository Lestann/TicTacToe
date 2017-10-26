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

    while (continueGame) {
      gameIteration(player, game, scanner);
      printBoard(game.getBoard());
      Player winner = game.restartGame();
      continueGame = printResults(winner, scanner);
    }
  }

  private static boolean printResults(Player winner, Scanner scanner) {
    if(winner != null){
      System.out.println(winner.getName() + ", you won this round");
    }
    else{
      System.out.println("Well this one was a draw, hopefully someone will win next time");
    }
    System.out.println("Do you want to play another round (Y/N): ");
    return checkIfYOrN(scanner);
  }

  private static boolean checkIfYOrN(Scanner scanner){
    String contin = "";
    char cont = Character.MIN_VALUE;
    boolean valid = false;
    do{
      contin = scanner.next();
      if(!contin.matches("[A-Za-z]{1}")){
        System.out.print("Please enter Y for yes or N for no: ");
        continue;
      }
      cont = Character.toUpperCase(contin.charAt(0));
      if(cont != 'Y' && cont != 'N'){
        System.out.print("Please enter Y for yes or N for no: ");
        continue;
      }
      valid = true;
   }while(!contin.matches("[A-Za-z]{1}") && !valid);

    return cont == 'Y' ? true : false;
  }

  private static void gameIteration(Player player, TicTacToe game, Scanner scanner) {
    final int SIZE = game.getSize();
    for (int i = 0; i < (SIZE*SIZE); i++) {
      printBoard(game.getBoard());
      System.out.print(player.getName() + ", its your move: ");
      int input = getInput(scanner, game.getBoard());
      Player temp = player;
      player = game.checkWinner(player, input);
      if(temp == player){
          return;
      }
    }
  }
  private static int getInput(Scanner scanner, Board board){
    int input;
    do{
      checkIfInt(scanner);
      input = scanner.nextInt();
      if(board.isTaken(input)){
        System.out.print("This spot is taken, please choose another one: ");
      }
      else if(!board.checkValidMove(input)){
        System.out.print("Please enter a number between 1 and 9: ");
      }
    }while(board.isTaken(input) || !board.checkValidMove(input));

    return input;
  }

  private static void checkIfInt(Scanner scanner){
    while(!scanner.hasNextInt()){
      System.out.print("Please enter a valid input: ");
      scanner.next();
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
