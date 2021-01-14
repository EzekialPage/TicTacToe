//Ezekial Page

import javax.swing.JOptionPane;

public class TicTacToe {
	public static void main(String[] args) {
		GameBoard g1 = new GameBoard();
		String input;
		int x, y;
		boolean retry, gameEnd = false;
		
		//display menu
		System.out.println("Play TicTacToe against the computer\nYou are X's\nTo play enter the coordinate of the space you want\nto mark based on the grid below\n");
		System.out.println("    0    1     2 ");
		System.out.println(" 0    |     | ");
		System.out.println("   ---+-----+---");
		System.out.println(" 1    |     | ");
		System.out.println("   ---+-----+---");
		System.out.println(" 2    |     | \n");	
		
		//checks if game has ended
		while (gameEnd == false) {
			//check who plays
			if (g1.validPlayCount() % 2 == 0) {
				// user plays
				input = JOptionPane.showInputDialog(null, "Enter selection (ex: 0 0): ");
				x = Integer.parseInt(input.substring(0, 1));
				y = Integer.parseInt(input.substring(2, 3));
				retry = g1.play(true, x, y);
				while (retry == true) {
					input = JOptionPane.showInputDialog(null, "Invalid Selection\nRe-enter selection (ex: 0 0): ");
					x = Integer.parseInt(input.substring(0, 1));
					y = Integer.parseInt(input.substring(2, 3));
					retry = g1.play(false, 0, 0);
				}
				System.out.println("You played");
				g1.showBoard();
				
				//check for game end
				if(g1.checkWin() == 'T') {
					System.out.print("Game over. Game resulted in a tie!");
					gameEnd = true;
				}else if(g1.checkWin() != ' ') {
					System.out.print("Game over. Winner is " + g1.checkWin() +"!");
					gameEnd = true;
				}
			} else {
				//computer plays
				retry = g1.play(false, 0, 0);
				while (retry == true) {
					retry = g1.play(false, 0, 0);
				}
				System.out.println("Ai plays.");
				g1.showBoard();
				
				//check for game end
				if(g1.checkWin() == 'T') {
					System.out.print("Game over. Game resulted in a tie!");
					gameEnd = true;
				}else if(g1.checkWin() != ' ') {
					System.out.print("Game over. Winner is " + g1.checkWin() +"!");
					gameEnd = true;
				}
			
			} // end if statement
		} // end while loop
	}// end main
}// end class
