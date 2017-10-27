package is.ru.tictactoe;

public class Board {
  char[][] board;
  private final int SIZE = 3;

  public Board() {
    board = new char[SIZE][SIZE];
    int count = 1;

    for (int i = 0; i < SIZE; i++) {
      for (int j = 0; j < SIZE; j++) {
        board[i][j] = (char)(count+48);
        count++;
      }
    }
  }

  public int getSize() {
    return SIZE;
  }

  public void print() {
    for (int i = 0; i < SIZE; i++) {
      for (int j = 0; j < SIZE; j++) {
        System.out.print(board[i][j] + " ");
      }
      System.out.println();
    }
  }

  public void changeBoard(Symbol symbol, int position) {
    int count = 1;
    char player = getSymbol(symbol);

    for (int i = 0; i < SIZE; i++) {
      for (int j = 0; j < SIZE; j++) {
        if (position == count) {
          board[i][j] = player;
          return;
        }
        count++;
      }
    }
  }
  public boolean checkWinner(Symbol p) {
    int diagnallr = 0;
    int diagnalrl = 0;
    char player = getSymbol(p);
    for (int i = 0; i < SIZE; i++) {
      int horizontal = 0;
      int vertical = 0;
      for (int j = 0; j < SIZE; j++) {
        if (board[i][j] == player) {
          horizontal++;
        }
        else { horizontal = 0; }
        if (board[j][i] == player) vertical++;
        else { vertical = 0; }
        if (i == j && board[i][j] == player) diagnallr++;
        if (j == ((SIZE-1)-i) && board[i][j] == player) diagnalrl++;
        if(horizontal == SIZE || vertical == SIZE ||
           diagnallr == SIZE || diagnalrl == SIZE) return true;
      }
    }
    return false;
  }

  private char getSymbol(Symbol symbol) {
    if (symbol == Symbol.CIRCLE)
      return 'O';

    return 'X';
  }

  public boolean isTaken(int position) {
    int count = 1;
    for (int i = 0; i < SIZE; i++) {
      for (int j = 0; j < SIZE; j++) {
        if (position == count) {
          if (board[i][j] == getSymbol(Symbol.CROSS) || board[i][j] == getSymbol(Symbol.CIRCLE)) {
            return true;
          }
        }
        count++;
      }
    }
    return false;
  }

  public boolean checkValidMove(int position) {
    for (int i = 1; i <= 9; i++) {
      if (position == i) {
        return true;
      }
    }
    return false;
  }

  public boolean isFull(){
    char x, y;
    x = getSymbol(Symbol.CROSS);
    y = getSymbol(Symbol.CIRCLE);
    for(int i = 0; i < SIZE; i++){
      for(int j = 0; j < SIZE; j++){
        if(board[i][j] != x && board[i][j] != y){
          return false;
        }
      }
    }
    return true;
  }
}
