import java.util.ArrayList;


public class _018_TrianglePath {

	public static void main(String[] args) {
		int[] row1 = {75};
		int[] row2 = {95, 64};
		int[] row3 = {17, 47, 82};
		int[] row4 = {18, 35, 87, 10};
		int[] row5 = {20, 04, 82, 47, 65};
		int[] row6 = {19, 01, 23, 75, 03, 34};
		int[] row7 = {88, 02, 77, 73, 07, 63, 67};
		int[] row8 = {99, 65, 04, 28, 06, 16, 70, 92};
		int[] row9 = {41, 41, 26, 56, 83, 40, 80, 70, 33};
		int[] row10 = {41, 48, 72, 33, 47, 32, 37, 16, 94, 29};
		int[] row11 = {53, 71, 44, 65, 25, 43, 91, 52, 97, 51, 14};
		int[] row12 = {70, 11, 33, 28, 77, 73, 17, 78, 39, 68, 17, 57};
		int[] row13 = {91, 71, 52, 38, 17, 14, 91, 43, 58, 50, 27, 29, 48};
		int[] row14 = {63, 66, 04, 68, 89, 53, 67, 30, 73, 16, 69, 87, 40, 31};
		int[] row15 = {04, 62, 98, 27, 23, 9, 70, 98, 73, 93, 38, 53, 60, 04, 23};

		int[] path1 = {0};
		int[] path2 = {0,0};
		int[] path3 = {0,0,0};
		int[] path4 = {0,0,0,0};
		int[] path5 = {0,0,0,0,0};
		int[] path6 = {0,0,0,0,0,0};
		int[] path7 = {0,0,0,0,0,0,0};
		int[] path8 = {0,0,0,0,0,0,0,0};
		int[] path9 = {0,0,0,0,0,0,0,0,0};
		int[] path10 = {0,0,0,0,0,0,0,0,0,0};
		int[] path11 = {0,0,0,0,0,0,0,0,0,0,0};
		int[] path12 = {0,0,0,0,0,0,0,0,0,0,0,0};
		int[] path13 = {0,0,0,0,0,0,0,0,0,0,0,0,0};
		int[] path14 = {0,0,0,0,0,0,0,0,0,0,0,0,0,0};
		int[] pathSolution = {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0};

		ArrayList<int[]> arrays = new ArrayList<>();
		arrays.add(row1); 
		arrays.add(path1);
		arrays.add(row2);
		arrays.add(path2);
		arrays.add(row3);
		arrays.add(path3);
		arrays.add(row4);
		arrays.add(path4);
		arrays.add(row5);
		arrays.add(path5);
		arrays.add(row6);
		arrays.add(path6);
		arrays.add(row7);
		arrays.add(path7);
		arrays.add(row8);
		arrays.add(path8);
		arrays.add(row9);
		arrays.add(path9);
		arrays.add(row10);
		arrays.add(path10);
		arrays.add(row11);
		arrays.add(path11);
		arrays.add(row12);
		arrays.add(path12);
		arrays.add(row13); //24
		arrays.add(path13); //25
		arrays.add(row14); //26
		arrays.add(path14); //27
		arrays.add(row15); //28
		arrays.add(pathSolution); //29
		
		
		for(int i=14;i>0;i--) {
			for(int j=0;j<i;j++) {
				if(sumFromRowPos(arrays,i+1,j+1,false)>sumFromRowPos(arrays,i+1,j+2,false))
					arrays.get(2*i-1)[j]=j+1;
				else
					arrays.get(2*i-1)[j]=j+2;
			}
		}
		
		for(int i=1;i<15;i++) {
			pathSolution[i] = arrays.get(2*i-1)[pathSolution[i-1]-1];
		}
		printArray(pathSolution);
		
		//calculate overall sum based on pathSolution
		int sum=0;
		for(int i=0;i<15;i++) {
			sum+=arrays.get(2*i)[pathSolution[i]-1];
		}
		System.out.println(sum);
		System.out.println(sumFromRowPos(arrays,1,1,true));
	}
	
	public static int sumFromRowPos(ArrayList<int[]> arrays, int rowStart, int posStart, boolean showSteps) {
		int row = rowStart;
		int oldPos=0;
		int pos = posStart-1;
		int sum = arrays.get(2*row-2)[pos];
		row++;
		while(row<16) {
			if(showSteps)
				System.out.println(sum);
			oldPos=pos;
			pos=arrays.get(2*row-3)[oldPos]-1;
			sum+=arrays.get(2*row-2)[pos];
			row++;
		}
		return sum;
	}
	
	public static void printArray(int[] AL) {
		for(int i:AL)
			System.out.print(i+" ");
		System.out.println();
	}
}
