/*ANSWER IS 70600674*/
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class _011_GridProduct {

	public static void main(String[] args) throws FileNotFoundException {
		int tempProduct=0;
		int maxProduct=0;
		
		Scanner file = new Scanner(new File("file12.txt"));
		int[] data = new int[400];
		for(int i=0;i<400;i++) {
			data[i]=file.nextInt();
		}
		maxProduct=findHMaxProduct(data);
		tempProduct=findVMaxProduct(data);
		if(tempProduct>maxProduct)
			maxProduct=tempProduct;
		tempProduct=findDNegMaxProduct(data);
		if(tempProduct>maxProduct)
			maxProduct=tempProduct;
		tempProduct=findDPosMaxProduct(data);
		if(tempProduct>maxProduct)
			maxProduct=tempProduct;
		System.out.println("The largest product is "+maxProduct);
		file.close();
	}
	
	public static int findVMaxProduct(int[] data) {
		int product=0;
		int tempProduct=0;
		int chainStartIndex=0;
		int val1=0;
		int val2=0;
		int val3=0;
		int val4=0;
		for(int column=0;column<20;column++) {
			for(int row=0;row<17;row++) {
				chainStartIndex=20*(row)+column;
				val1=data[chainStartIndex];
				val2=data[chainStartIndex+20];
				val3=data[chainStartIndex+40];
				val4=data[chainStartIndex+60];
				tempProduct=val1*val2*val3*val4;
				//System.out.println(val1+" "+val2+" "+val3+" "+val4+" = "+tempProduct); //debug
				if(tempProduct>product)
					product=tempProduct;
			}
		}
		System.out.println("The largest vertical product is "+product);
		return product;
	}
	
	public static int findHMaxProduct(int[] data) {
		int product=0;
		int tempProduct=0;
		int chainStartIndex=0;
		int val1=0;
		int val2=0;
		int val3=0;
		int val4=0;
		for(int row=0;row<20;row++) {
			for(int column=0;column<17;column++) {
				chainStartIndex=20*(row)+column;
				val1=data[chainStartIndex];
				val2=data[chainStartIndex+1];
				val3=data[chainStartIndex+2];
				val4=data[chainStartIndex+3];
				tempProduct=val1*val2*val3*val4;
				//System.out.println(val1+" "+val2+" "+val3+" "+val4+" = "+tempProduct); //debug
				if(tempProduct>product)
					product=tempProduct;
			}
		}
		System.out.println("The largest horizontal product is "+product);
		return product;
	}
	
	public static int findDNegMaxProduct(int[] data) {
		int product=0;
		int tempProduct=0;
		int chainStartIndex=0;
		int val1=0;
		int val2=0;
		int val3=0;
		int val4=0;
		for(int row=0;row<17;row++) {
			for(int column=0;column<17;column++) {
				chainStartIndex=20*(row)+column;
				val1=data[chainStartIndex];
				val2=data[chainStartIndex+21];
				val3=data[chainStartIndex+42];
				val4=data[chainStartIndex+63];
				tempProduct=val1*val2*val3*val4;
				//System.out.println(val1+" "+val2+" "+val3+" "+val4+" = "+tempProduct); //debug
				if(tempProduct>product)
					product=tempProduct;
			}
		}
		System.out.println("The largest negative slope product is "+product);		
		return product;
	}
	
	public static int findDPosMaxProduct(int[] data) {
		int product=0;
		int tempProduct=0;
		int chainStartIndex=0;
		int val1=0;
		int val2=0;
		int val3=0;
		int val4=0;
		for(int row=0;row<17;row++) {
			for(int column=3;column<20;column++) {
				chainStartIndex=20*(row)+column;
				val1=data[chainStartIndex];
				val2=data[chainStartIndex+19];
				val3=data[chainStartIndex+38];
				val4=data[chainStartIndex+57];
				tempProduct=val1*val2*val3*val4;
				//System.out.println(val1+" "+val2+" "+val3+" "+val4+" = "+tempProduct); //debug
				if(tempProduct>product)
					product=tempProduct;
			}
		}
		System.out.println("The largest positive slope product is "+product);		
		return product;
	}

}
