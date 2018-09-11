import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class _096_Sudoku {

	public static ArrayList<SudokuSquare> board = new ArrayList<SudokuSquare>();
	
	public static int[] setup = new int[81];
	
	public static int[] box1 = {0,1,2,9,10,11,18,19,20};
	public static int[] box2 = {3,4,5,12,13,14,21,22,23};
	public static int[] box3 = {6,7,8,15,16,17,24,25,26};
	public static int[] box4 = {27,28,29,36,37,38,45,46,47};
	public static int[] box5 = {30,31,32,39,40,41,48,49,50};
	public static int[] box6 = {33,34,35,42,43,44,51,52,53};
	public static int[] box7 = {54,55,56,63,64,65,72,73,74};
	public static int[] box8 = {57,58,59,66,67,68,75,76,77};
	public static int[] box9 = {60,61,62,69,70,71,78,79,80};

	public static int[] column1 = {0,9,18,27,36,45,54,63,72};
	public static int[] column2 = {1,10,19,28,37,46,55,64,73};
	public static int[] column3 = {2,11,20,29,38,47,56,65,74};
	public static int[] column4 = {3,12,21,30,39,48,57,66,75};
	public static int[] column5 = {4,13,22,31,40,49,58,67,76};
	public static int[] column6 = {5,14,23,32,41,50,59,68,77};
	public static int[] column7 = {6,15,24,33,42,51,60,69,78};
	public static int[] column8 = {7,16,25,34,43,52,61,70,79};
	public static int[] column9 = {8,17,26,35,44,53,62,71,80};

	public static int[] row1 = {0,1,2,3,4,5,6,7,8};
	public static int[] row2 = {9,10,11,12,13,14,15,16,17};
	public static int[] row3 = {18,19,20,21,22,23,24,25,26};
	public static int[] row4 = {27,28,29,30,31,32,33,34,35};
	public static int[] row5 = {36,37,38,39,40,41,42,43,44};
	public static int[] row6 = {45,46,47,48,49,50,51,52,53};
	public static int[] row7 = {54,55,56,57,58,59,60,61,62};
	public static int[] row8 = {63,64,65,66,67,68,69,70,71};
	public static int[] row9 = {72,73,74,75,76,77,78,79,80};
	

	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(new File("file_096.txt"));
		String tempLine;
		int index;
		for(int puzzle=0; puzzle<50; puzzle++) {
			input.nextLine();
			for(int line=0; line<9; line++) {
				
			}
		}

		

	}
	
	public static void solvePuzzle() {
		for(int i=0;i<81;i++) {
			board.add(new SudokuSquare(i));
		}

		initBoard();
		showBoard();
		
		boolean continueSolving=true; //debug: break if no progress
		while(continueSolving) {
			for(int i=0;i<9;i++) {
				for(int j=0;j<9;j++) {
					continueSolving=solveRow(i+1,j+1);
				}
			}
			if(boardSolved())
				break;
			else showBoard();
			for(int i=0;i<9;i++) {
				for(int j=0;j<9;j++) {
					continueSolving|=solveColumn(i+1,j+1);
				}
			}
			if(boardSolved())
				break;
			else showBoard();
			for(int i=0;i<9;i++) {
				for(int j=0;j<9;j++) {
					continueSolving|=solveBox(i+1,j+1);
				}
			}
			if(boardSolved())
				break;
			else showBoard();
			for(int i=0;i<9;i++) {
				for(int j=0;j<9;j++) {
					continueSolving|=solveSquare(9*i+j);
				}
			}
			if(boardSolved())
				break;
			else showBoard();
		}
		System.out.println("Puzzle Complete!");
		showBoard();
	}
	
	/*
	 * Setup the board
	 */
	public static void initBoard() {
		for(int i=0;i<81;i++) {
			board.set(i,new SudokuSquare(i,setup[i]));
		}
	}
	
	/*
	 * Show the board
	 */
	public static void showBoard() {
		int pos=0;
		System.out.println("________________________");
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				System.out.print("| ");
				for(int k=0;k<3;k++) {
					for(int l=0;l<3;l++) {
						System.out.print(board.get(pos++).toString()+" ");
					}
					System.out.print("| ");
				}
				System.out.println();
			}
			System.out.println("________________________");
		}
		System.out.println();
	}

	/*
	 * Attempt to solve a number x in a given row
	 * @return true if a successful solve happens
	 * @return false if no progress is made (x is already solved in the row, or cannot yet be)
	 */
	public static boolean solveRow(int row,int x) {
		int[] rowStatus = new int[9];
		if(row==1) {
			for(int i:row1) {
				rowStatus[i%9]=checkSquare(i,x);
			}
		}
		if(row==2) {
			for(int i:row2) {
				rowStatus[i%9]=checkSquare(i,x);
			}
		}
		if(row==3) {
			for(int i:row3) {
				rowStatus[i%9]=checkSquare(i,x);
			}
		}
		if(row==4) {
			for(int i:row4) {
				rowStatus[i%9]=checkSquare(i,x);
			}
		}
		if(row==5) {
			for(int i:row5) {
				rowStatus[i%9]=checkSquare(i,x);
			}
		}
		if(row==6) {
			for(int i:row6) {
				rowStatus[i%9]=checkSquare(i,x);
			}
		}
		if(row==7) {
			for(int i:row7) {
				rowStatus[i%9]=checkSquare(i,x);
			}
		}
		if(row==8) {
			for(int i:row8) {
				rowStatus[i%9]=checkSquare(i,x);
			}
		}
		if(row==9) {
			for(int i:row9) {
				rowStatus[i%9]=checkSquare(i,x);
			}
		}
		int numPoss = 0; //number of squares in the row that could contain x
		int pos = 0; //index of these squares
		for(int i=0;i<9;i++) {
			if(rowStatus[i]==1) {
				numPoss++;
				pos=i;
			}
		}
		if(numPoss==1) {
			board.set(9*(row-1)+pos, new SudokuSquare(9*row+pos,x));
			return true;
		}
		return false;
	}
	
	/*
	 * Attempt to solve a number x in a given column
	 * @return true if a successful solve happens
	 * @return false if no progress is made (x is already solved in the column, or cannot yet be)
	 */
	public static boolean solveColumn(int column,int x) {
		int[] colStatus = new int[9];
		int index=0;
		if(column==1) {
			for(int i:column1) {
				colStatus[index++]=checkSquare(i,x);
			}
		}
		if(column==2) {
			for(int i:column2) {
				colStatus[index++]=checkSquare(i,x);
			}
		}
		if(column==3) {
			for(int i:column3) {
				colStatus[index++]=checkSquare(i,x);
			}
		}
		if(column==4) {
			for(int i:column4) {
				colStatus[index++]=checkSquare(i,x);
			}
		}
		if(column==5) {
			for(int i:column5) {
				colStatus[index++]=checkSquare(i,x);
			}
		}
		if(column==6) {
			for(int i:column6) {
				colStatus[index++]=checkSquare(i,x);
			}
		}
		if(column==7) {
			for(int i:column7) {
				colStatus[index++]=checkSquare(i,x);
			}
		}
		if(column==8) {
			for(int i:column8) {
				colStatus[index++]=checkSquare(i,x);
			}
		}
		if(column==9) {
			for(int i:column9) {
				colStatus[index++]=checkSquare(i,x);
			}
		}
		int numPoss = 0;
		int pos = 0;
		for(int i=0;i<9;i++) {
			if(colStatus[i]==1) {
				numPoss++;
				pos=i;
			}
		}
		if(numPoss==1) {
			board.set(9*pos+column-1, new SudokuSquare(9*pos+column-1,x));
			return true;
		}
		return false;
	}
	
	/*
	 * Attempt to solve a number x in a given box
	 * @return true if a successful solve happens
	 * @return false if no progress is made (x is already solved in the box, or cannot yet be)
	 */
	public static boolean solveBox(int box, int x) {
		int[] boxStatus = new int[9];
		int index=0;
		if(box==1) {
			for(int i:box1) {
				boxStatus[index++]=checkSquare(i,x);
			}
		}
		if(box==2) {
			for(int i:box2) {
				boxStatus[index++]=checkSquare(i,x);
			}
		}
		if(box==3) {
			for(int i:box3) {
				boxStatus[index++]=checkSquare(i,x);
			}
		}
		if(box==4) {
			for(int i:box4) {
				boxStatus[index++]=checkSquare(i,x);
			}
		}
		if(box==5) {
			for(int i:box5) {
				boxStatus[index++]=checkSquare(i,x);
			}
		}
		if(box==6) {
			for(int i:box6) {
				boxStatus[index++]=checkSquare(i,x);
			}
		}
		if(box==7) {
			for(int i:box7) {
				boxStatus[index++]=checkSquare(i,x);
			}
		}
		if(box==8) {
			for(int i:box8) {
				boxStatus[index++]=checkSquare(i,x);
			}
		}
		if(box==9) {
			for(int i:box9) {
				boxStatus[index++]=checkSquare(i,x);
			}
		}
		int numPoss = 0;
		int pos = 0; //offset
		for(int i=0;i<9;i++) {
			if(boxStatus[i]==1) {
				numPoss++;
				pos=i;
			}
		}
		if(numPoss==1) {
			board.set(getSquareFromBox(box,pos),new SudokuSquare(getSquareFromBox(box,pos),x));
			return true;
		}
		return false;
	}

	/*
	 * Check whether a square does/could/could not contain a number
	 * @return 0 if square cannot be x
	 * @return 1 if square could be x
	 * @return 2 if square = x
	 */
	public static int checkSquare(int pos, int x) {
		if(board.get(pos).getVal()==x)
			return 2;
		else {
			if(board.get(pos).getVal()!=0)
				return 0;
			//check box, check row, check column
			if(inBox(x,getBox(pos)))
				return 0;
			if(inColumn(x,getColumn(pos)))
				return 0;
			if(inRow(x,getRow(pos)))
				return 0;

		}
		return 1;
	}
	
	/*
	 * Attempt to solve a square (if it has only one option)
	 */
	public static boolean solveSquare(int square) {
		int options = 0;
		int val = 0;
		for(int i=1;i<=9;i++) {
			if(checkSquare(square,i)==1) {
				options++;
				val=i;
			}
		}
		if(options==1) {
			board.set(square,new SudokuSquare(square,val));
			return true;
		}
		return false;
	}
	
	/*
	 * Check whether a number x is already solved in a certain box
	 */
	public static boolean inBox(int x, int box) {
		if(box==1) {
			for(int i:box1) {
				if(board.get(i).getVal()==x)
					return true;
			}
		}
		if(box==2) {
			for(int i:box2) {
				if(board.get(i).getVal()==x)
					return true;
			}
		}
		if(box==3) {
			for(int i:box3) {
				if(board.get(i).getVal()==x)
					return true;
			}
		}
		if(box==4) {
			for(int i:box4) {
				if(board.get(i).getVal()==x)
					return true;
			}
		}
		if(box==5) {
			for(int i:box5) {
				if(board.get(i).getVal()==x)
					return true;
			}
		}
		if(box==6) {
			for(int i:box6) {
				if(board.get(i).getVal()==x)
					return true;
			}
		}
		if(box==7) {
			for(int i:box7) {
				if(board.get(i).getVal()==x)
					return true;
			}
		}
		if(box==8) {
			for(int i:box8) {
				if(board.get(i).getVal()==x)
					return true;
			}
		}
		if(box==9) {
			for(int i:box9) {
				if(board.get(i).getVal()==x)
					return true;
			}
		}
		return false;
	}
	
	/*
	 * Find the box that contains a certain square
	 */
	public static int getBox(int pos) {
		for(int i:box1) {
			if(pos==i)
				return 1;
		}
		for(int i:box2) {
			if(pos==i)
				return 2;
		}
		for(int i:box3) {
			if(pos==i)
				return 3;
		}
		for(int i:box4) {
			if(pos==i)
				return 4;
		}
		for(int i:box5) {
			if(pos==i)
				return 5;
		}
		for(int i:box6) {
			if(pos==i)
				return 6;
		}
		for(int i:box7) {
			if(pos==i)
				return 7;
		}
		for(int i:box8) {
			if(pos==i)
				return 8;
		}
		for(int i:box9) {
			if(pos==i)
				return 9;
		}
		//never gets here
		return 0; 
	}
	
	/*
	 * Check whether a certain column contains a certain number x
	 */
	public static boolean inColumn(int x,int column) {
		if(column==1) {
			for(int i:column1) {
				if(board.get(i).getVal()==x)
					return true;
			}
		}
		if(column==2) {
			for(int i:column2) {
				if(board.get(i).getVal()==x)
					return true;
			}
		}
		if(column==3) {
			for(int i:column3) {
				if(board.get(i).getVal()==x)
					return true;
			}
		}
		if(column==4) {
			for(int i:column4) {
				if(board.get(i).getVal()==x)
					return true;
			}
		}
		if(column==5) {
			for(int i:column5) {
				if(board.get(i).getVal()==x)
					return true;
			}
		}
		if(column==6) {
			for(int i:column6) {
				if(board.get(i).getVal()==x)
					return true;
			}
		}
		if(column==7) {
			for(int i:column7) {
				if(board.get(i).getVal()==x)
					return true;
			}
		}
		if(column==8) {
			for(int i:column8) {
				if(board.get(i).getVal()==x)
					return true;
			}
		}
		if(column==9) {
			for(int i:column9) {
				if(board.get(i).getVal()==x)
					return true;
			}
		}
		return false;
	}

	/*
	 * Find which column contains a certain square
	 */
	public static int getColumn(int pos) {
		for(int i:column1) {
			if(pos==i)
				return 1;
		}
		for(int i:column2) {
			if(pos==i)
				return 2;
		}
		for(int i:column3) {
			if(pos==i)
				return 3;
		}
		for(int i:column4) {
			if(pos==i)
				return 4;
		}
		for(int i:column5) {
			if(pos==i)
				return 5;
		}
		for(int i:column6) {
			if(pos==i)
				return 6;
		}
		for(int i:column7) {
			if(pos==i)
				return 7;
		}
		for(int i:column8) {
			if(pos==i)
				return 8;
		}
		for(int i:column9) {
			if(pos==i)
				return 9;
		}
		//never gets here
		return 0;
	}

	/*
	 * Check whether a number x has been solved in a certain row
	 */
	public static boolean inRow(int x,int row) {
		if(row==1) {
			for(int i:row1) {
				if(board.get(i).getVal()==x)
					return true;
			}
		}
		if(row==2) {
			for(int i:row2) {
				if(board.get(i).getVal()==x)
					return true;
			}
		}
		if(row==3) {
			for(int i:row3) {
				if(board.get(i).getVal()==x)
					return true;
			}
		}
		if(row==4) {
			for(int i:row4) {
				if(board.get(i).getVal()==x)
					return true;
			}
		}
		if(row==5) {
			for(int i:row5) {
				if(board.get(i).getVal()==x)
					return true;
			}
		}
		if(row==6) {
			for(int i:row6) {
				if(board.get(i).getVal()==x)
					return true;
			}
		}
		if(row==7) {
			for(int i:row7) {
				if(board.get(i).getVal()==x)
					return true;
			}
		}
		if(row==8) {
			for(int i:row8) {
				if(board.get(i).getVal()==x)
					return true;
			}
		}
		if(row==9) {
			for(int i:row9) {
				if(board.get(i).getVal()==x)
					return true;
			}
		}
		return false;
	}

	/*
	 * Find which row contains a certain number
	 */
	public static int getRow(int pos) {
		for(int i:row1) {
			if(pos==i)
				return 1;
		}
		for(int i:row2) {
			if(pos==i)
				return 2;
		}
		for(int i:row3) {
			if(pos==i)
				return 3;
		}
		for(int i:row4) {
			if(pos==i)
				return 4;
		}
		for(int i:row5) {
			if(pos==i)
				return 5;
		}
		for(int i:row6) {
			if(pos==i)
				return 6;
		}
		for(int i:row7) {
			if(pos==i)
				return 7;
		}
		for(int i:row8) {
			if(pos==i)
				return 8;
		}
		for(int i:row9) {
			if(pos==i)
				return 9;
		}
		//never gets here
		return 0;
	}
	
	/*
	 * Given a box and offset, find the corresponding square
	 */
	public static int getSquareFromBox(int box,int boxPos) {
		int square=0;
		
		switch(box) {
		case 1:
			square=0;
			break;
		case 2:
			square=3;
			break;
		case 3:
			square=6;
			break;
		case 4:
			square=27;
			break;
		case 5:
			square=30;
			break;
		case 6:
			square=33;
			break;
		case 7:
			square=54;
			break;
		case 8:
			square=57;
			break;
		case 9:
			square=60;
			break;
		}
	
		switch(boxPos) {
		case 0:
			break;
		case 1:
			square+=1;
			break;
		case 2:
			square+=2;
			break;
		case 3:
			square+=9;
			break;
		case 4:
			square+=10;
			break;
		case 5:
			square+=11;
			break;
		case 6:
			square+=18;
			break;
		case 7:
			square+=19;
			break;
		case 8:
			square+=20;
			break;
		}
		
		return square;
	}
	
	/*
	 * Check whether the puzzle is solved
	 */
	public static boolean boardSolved() {
		for(SudokuSquare s:board) {
			if(s.getVal()==0)
				return false;
		}
		return true;
	}
	
	/*
	 * Find exclusive pairs
	 */
	public static void findDoubles() {
		
	}
	
	
	public static void performAnalysis() {
		
	}
}
