import java.util.Scanner;
import java.util.Stack;

public class Lab26b {
        public static void main (String args[])
        {
            System.out.println("\nLab26b 90/100 Point Version\n");
            Knight knight = new Knight();
            knight.getStart();
            knight.solveTour();
            knight.displayBoard();
        }
}


class Knight {
        private int board[][];			// stores the sequence of knight moves
        private int startRow;			// row location where the knight starts
        private int startCol;			// col location where the knight starts
        private int rowPos;				// current row position of the knight
        private int colPos;				// current col position of the knight
        private int moves;				// number of location visited by the knight
	    final private int ACCESS[][] = {
	                                {0,0,0,0,0,0,0,0,0,0,0,0},
 						 			{0,0,0,0,0,0,0,0,0,0,0,0},
     					 			{0,0,2,3,4,4,4,4,3,2,0,0},
     					 			{0,0,3,4,6,6,6,6,4,3,0,0},
     					 			{0,0,4,6,8,8,8,8,6,4,0,0},
     					 			{0,0,4,6,8,8,8,8,6,4,0,0},
     					 			{0,0,4,6,8,8,8,8,6,4,0,0},
     					 			{0,0,4,6,8,8,8,8,6,4,0,0},
     					 			{0,0,3,4,6,6,6,6,4,3,0,0},
     					 			{0,0,2,3,4,4,4,4,3,2,0,0},
     					 			{0,0,0,0,0,0,0,0,0,0,0,0},
     					 			{0,0,0,0,0,0,0,0,0,0,0,0}
	    };

        // constructor used to initializes the data attributes
        public Knight() {
            this(1,1);
            getStart();
        }
        public Knight(int startRow, int startCol) {
            this.startRow = startRow;
            this.startCol = startCol;
            this.rowPos = 0;
            this.colPos = 0;
            this.moves = 0;
        }

    // input method to get starting row and col from keyboard entry
        public void getStart() {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter starting row ==> ");
            this.startRow = sc.nextInt();
            System.out.print("Enter starting col ==> ");
            this.startCol = sc.nextInt();
        }


        // displays the chessboard after the tour is concluded
        public void displayBoard() {


        }

        // computes the next available knight's move.  Alters RowPos and ColPos and
        // returns true if move is possible, otherwise returns false
        private boolean getMove() {

            return false;
        }


        public void solveTour() {// primary method that drives the knight's tour solution


        }

}