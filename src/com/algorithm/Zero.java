package com.algorithm;

import java.util.ArrayList;
import java.util.Scanner;

public class Zero {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		int cur = 0;
		
		// input
		while(k-->0) {
			int tmp = sc.nextInt();
			if(tmp == 0) {
				list.remove(cur-1);
				cur--;
			}
			else {
				list.add(tmp);
				cur++;
			}
		}
		
		// sum
		int sum = 0;
		for(int i : list) {
			sum += i;
		}
		System.out.println(sum);
	}

}
