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
		char player = 'X';

		if (symbol == Symbol.CIRCLE) {
			player = 'O';
		}
		else {
			player = 'X';
		}

		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; i < 3; i++)
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
}