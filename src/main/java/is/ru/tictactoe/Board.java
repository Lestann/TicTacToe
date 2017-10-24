package is.ru.tictactoe;


public class Board
{

	char[][] board;
	private final int constSize = 3;

	public Board() {
		board = new char[constSize][constSize];
		int count = 1;

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				board[i][j] = (char) count;
				count++;
			}
		}
	}

	public void print() {

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

	public void changeBoard(Symbol symbol, int position)
	{
		int count = 1;
		char player = getSymbol(symbol);

		for(int i = 0; i < constSize; i++)
		{
			for(int j = 0; j < constSize; j++)
			{
				if(position == count)
				{
					board[i][j] = player;
					return;
				}
				count++;
			}
		}
	}

	public boolean checkWinner(Player p)
	{
		int horizontal = 0;
		int vertical = 0;
		int diagnallr = 0;
		int diagnalrl = 0;
		char player = getSymbol(p.getSymbol());
		for(int i = 0; i < constSize; i++)
		{
			for(int j = 0; j < constSize; j++)
			{
				if (board[i][j] == player){ horizontal++; }
				else { horizontal = 0; }
				if (board[j][i] == player) vertical++;
				else { vertical = 0; }
				if (i == j && board[i][j] == player) diagnallr++;
				if (j == ((constSize-1)-i) && board[i][j] == player) diagnalrl++;
				if(horizontal == constSize || vertical == constSize ||
					 diagnallr == constSize || diagnalrl == constSize) return true;
			}
		}
		return false;
	}

	private char getSymbol(Symbol symbol){
		if (symbol == Symbol.CIRCLE) {
			return 'O';
		}
		else {
			return 'X';
		}
	}

	public boolean checkValidMove(int position) {
		

		for (int i = 1; i <= 9; i++) {

			if (position == i) {
				return true;
			}
		}

		return false;
	} 
}
