// BOJ_1357
package com.algorithm;

import java.util.Scanner;

public class ReverseAdd {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		System.out.println(reverseInt(reverseInt(a) + reverseInt(b)));
	}
	
	static int reverseInt(int ori) {
		String res = "";
		while(ori!=0) {
			res += Integer.toString(ori%10);
			ori /= 10;
		}
		return Integer.parseInt(res);
	}

}
