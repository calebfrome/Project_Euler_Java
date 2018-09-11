import java.util.ArrayList;


public class SudokuSquare {

	public ArrayList<Integer> yes;
	public ArrayList<Integer> no;
	public int value;
	public int position;
	
	public SudokuSquare(int pos) {
		this.position=pos;
		this.value=0;
	}
	
	public SudokuSquare(int pos,int val) {
		this.position=pos;
		this.value=val;
	}
	
	public void addPoss (int y) {
		this.yes.add(y);
	}
	
	public void addNotPoss(int z) {
		this.no.add(z);
	}
	
	public void setPoss(ArrayList<Integer> yes) {
		this.yes=yes;
	}
	
	public void setNotPoss(ArrayList<Integer> no) {
		this.no=no;
	}
	
	public int getVal() {
		return this.value;
	}
	
	public String toString() {
		if(value==0)
			return "_";
		return String.valueOf(value);
	}
}
