
//Ezekial Page
import java.util.Random;

public class GameBoard {
	private char[][] board = new char[3][3];
	private int plays;

	public GameBoard() {
		plays = 0;
		//fills board with space values
		for (int r = 0; r < board.length; r++) {
			for (int c = 0; c < board[r].length; c++) {
				board[r][c] = ' ';
			}
		}
	}
	
	public boolean rangeCheck(int x, int y) {
		if(x > 3 && y )
		return true;
	}
	
	public boolean play(boolean x, int row, int column) {
		//checks who moves
		if (x == true) {
			// marks move for player
			if (board[row][column] != ' ') {
				return true;
			} else {
				board[row][column] = 'X';
				plays++;
				return false;
			}
		} else {
			// marks random move for computer
			Random rn = new Random();
			int r = rn.nextInt(3);
			int c = rn.nextInt(3);

			if (board[r][c] != ' ') {
				return true;
			} else {
				board[r][c] = 'O';
				plays++;
				return false;
			}
		}
	}

	public int validPlayCount() {
		return plays;
	}

	public char checkWin() {
		// check for vertical wins
		// X
		for (int r = 0; r < board.length; r++) {
			if ((board[r][0] == 'X') && (board[r][1] == 'X') && (board[r][2] == 'X')) {
				return 'X';
				// O
			} else if ((board[r][0] == 'O') && (board[r][1] == 'O') && (board[r][2] == 'O')) {
				return 'O';
			}
		}

		// check horizontal wins
		// X
		for (int c = 0; c < board.length; c++) {
			if ((board[0][c] == 'X') && (board[1][c] == 'X') && (board[2][c] == 'X')) {
				return 'X';
				// O
			} else if ((board[0][c] == 'O') && (board[1][c] == 'O') && (board[2][c] == 'O')) {
				return 'O';
			}
		}
		// checks diagonal wins
		// X
		if ((board[0][0] == 'X') && (board[1][1] == 'X') && (board[2][2] == 'X')) {
			return 'X';
			// O
		} else if ((board[0][0] == 'O') && (board[1][1] == 'O') && (board[2][2] == 'O')) {
			return 'O';
			// X
		} else if ((board[0][2] == 'X') && (board[1][1] == 'X') && (board[2][0] == 'X')) {
			return 'X';
			// O
		} else if ((board[0][2] == 'O') && (board[1][1] == 'O') && (board[2][0] == 'O')) {
			return 'O';
			// checks for tie or to continue
		} else if (plays < 9) {
			return ' ';
		} else {
			return 'T';
		}
	}

	public void showBoard() {
		//prints out current game board
		System.out.println("play: " + plays);
		System.out.println(board[0][0] + "  |  " + board[0][1] + "  |  " + board[0][2]);
		System.out.println("---+-----+---");
		System.out.println(board[1][0] + "  |  " + board[1][1] + "  |  " + board[1][2]);
		System.out.println("---+-----+---");
		System.out.println(board[2][0] + "  |  " + board[2][1] + "  |  " + board[2][2]);
		System.out.println();
	}
}
