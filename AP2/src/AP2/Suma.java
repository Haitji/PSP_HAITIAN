package AP2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Suma {
	public static int sumar(int num1,int num2) {
		int count=0;
		for(int i=num1;i<=num2;i++) {
			count+=i;
		}
		return count;
	}

	public static void main(String[] args) {
		int num1 = 1;
		int num2= 100;
		int result = sumar(num1,num2);
		try {
			FileWriter writer = new FileWriter("1.txt");  
		    BufferedWriter buffer = new BufferedWriter(writer);  
		    buffer.write(String.valueOf(result));  
		    buffer.close();  
		System.out.println(String.valueOf(result));
		}catch(Exception e) {
			System.out.println("Error");
		}
		 
	}
}
