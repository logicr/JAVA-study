package task;

import java.util.Scanner;

public class Palindromic {
	public static void main(String[] args) {
		System.out.println("Please input any number:>");
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int i = 0;
		String string = String.valueOf(a);
		char [] arry = string.toCharArray();
		for ( i = 0; i <= arry.length/2;i ++) {
			if(arry[i] != arry[(arry.length-i)-1]) {
				System.out.println(a+" is not Palindromic");
				break;
			}
			//System.out.println(i);
		}
		if(i > arry.length/2) {
			System.out.println(a +" is Palindromic");
		}
		scanner.close();
	}
}
