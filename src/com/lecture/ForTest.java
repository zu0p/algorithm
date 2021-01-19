/*
 * Writer: 주영,박
 * 20210118
 * For문 연습 
 */
package com.lecture;

import java.util.*;

public class ForTest {

	public static void main(String[] args) {	
		Scanner sc = new Scanner(System.in);
		int input1 = sc.nextInt();
		digitTest1(input1);
		int input2 = sc.nextInt();
		digitTest2(input2);
	}
	
	public static void digitTest1(int num) {
		int cnt = 1;
		for(int i = 0; i<num; i++) {
			for(int j = 0; j<i; j++) {
				System.out.print("\t");
			}
			for(int k = 0; k<num-i; k++) {
				System.out.print(cnt++ + "\t");
			}
			System.out.println();
		}
	}
	
	public static void digitTest2(int num) {
		int cnt = 1;
		
		for(int i = num-1; Math.abs(i)<num; i-=2) {			// 4 2 0 |-2| |-4|번씩
			for(int j = 0; j<(num-1-Math.abs(i))/2; j++) {	// 0 1 2 1 0 번씩
				System.out.print("\t");
			}
			for(int j = 0; j<Math.abs(i)+1; j++) {
				System.out.print(cnt++ + "\t");
			}
			System.out.println();
		}
	}

}
