import java.util.Random;
import java.util.Stack;
// Lab29ast.java
// This is the student version of the Lab29a assignment.
// Completing this file, as is, is the 100 point version.
// For 80 points you will be given the <getMove> code.


		import java.util.*;


public class lab29a {
	public static void main(String args[]) {
		System.out.println("\nLab 29a 80/100 Point Version\n");
		Scanner input = new Scanner(System.in);
		System.out.print("Enter random starting seed  ===>>  ");
		int seed = input.nextInt();

		Maze maze = new Maze(seed);
		maze.displayMaze();
		maze.solveMaze();
		maze.displayMaze();
		maze.mazeSolution();
	}
}


class Maze {

	private char mat[][];			// 2d character array that stores the maze display
	private Coord currentMove;		// object that stores current maze position
	private Stack visitStack;		// stack that stores location that have been visited

	// Coord is a class that stores a single maze location.
	class Coord {
		private int rPos;
		private int cPos;
		public Coord (int r, int c) 		{ rPos = r; cPos = c; }
		public boolean isFree() 			{ return (rPos == 0 && cPos == 0); }
		public void setPos(int r, int c) 	{ visitStack.add(currentMove); rPos+= r; cPos+= c; }
	}

	// constructor which generates the random maze, random starting location
	// and initializes Maze class values.  If the random value equals 0 the maze
	// store an 'X' otherwise it store an 'O' in the maze.
	public Maze(int seed) {
		Random random = new Random(seed);
		int startRow, startCol;
		mat = new char[12][12];
		for (int r = 0; r < 12; r++)
			for (int c = 0; c < 12; c++)
			{
				if (r == 0 || c == 0 || r == 11 || c == 11)
					mat[r][c] = 'X';
				else
				{
					int rndInt = random.nextInt(2);
					if (rndInt == 0)
						mat[r][c] = 'X';
					else
						mat[r][c] = 'O';
				}
			}
		mat[0][0] = 'O';
		startRow = random.nextInt(12);
		startCol = 11;
		mat[startRow][startCol] = '.';
		visitStack = new Stack();
		currentMove = new Coord(startRow,startCol);
		visitStack.push(currentMove);
	}

	// displays the current maze configuration
	void displayMaze() {
		System.out.println("\nRANDOM MAZE DISPLAY\n");
		for (int r = 0; r < 12; r++)
		{
			for (int c = 0; c < 12; c++)
				System.out.print(mat[r][c] + "  ");
			System.out.println();
		}
		System.out.println();
		pause();
	}

	// This methods solves the maze with private helper method <getMove>.
	// A loop is needed to repeat getting new moves until either a maze solution
	// is found or it is determined that there is no way out off the maze.
	public void solveMaze() {
		System.out.println("\n>>>>>   WORKING  ....  SOLVING MAZE   <<<<<\n");
		

	}

	// Short method to display the result of the maze solution
	public void mazeSolution() {
		if (currentMove.isFree())
			System.out.println("\nTHE MAZE HAS A SOLUTION.\n");
		else
			System.out.println("\nTHE MAZE HAS NO SOLUTION.\n");
	}

	// This method determines if a coordinate position is inbounds or not
	private boolean inBounds(int r, int c) {
		boolean inBounds1 = true;
		if(r>mat.length || r<0|| c> mat[0].length|| c<0){
			inBounds1 =false;
		}
		return inBounds1;
	}

	// This method checks eight possible positions in a counter-clock wise manner
	// starting with the (-1,0) position.  If a position is found the method returns
	// true and the currentMove coordinates are altered to the new position
	private boolean getMove() {

		 if(inBounds(currentMove.rPos-1,currentMove.cPos)){
		 	currentMove.setPos(-1,0);
			return true;
		}else if(inBounds(currentMove.rPos-1,currentMove.cPos+1)){
			 currentMove.setPos(-1,1);
			return true;
		}else if(inBounds(currentMove.rPos,currentMove.cPos+1)){
			 currentMove.setPos(0,1);
			return true;
		}else if(inBounds(currentMove.rPos+1,currentMove.cPos+1)){
			 currentMove.setPos(1,1);
			return true;
		}else if(inBounds(currentMove.rPos+1,currentMove.cPos)){
			 currentMove.setPos(1,0);
			return true;
		}else if(inBounds(currentMove.rPos+1,currentMove.cPos+1)) {
			 currentMove.setPos(1,1);
			 return true;
		} else if(inBounds(currentMove.rPos,currentMove.cPos-1)){
			 currentMove.setPos(0,-1);
				 return true;
		}else if(inBounds(currentMove.rPos-1,currentMove.cPos-1)){
			 currentMove.setPos(-1,-1);
				 return true;
		}else{
			return false;
		}

	}

	private void pause() {
		Scanner input = new Scanner(System.in);
		String dummy;
		System.out.print("\nPress <Enter> to continue  ===>>  ");
		dummy = input.nextLine();
	}


}
