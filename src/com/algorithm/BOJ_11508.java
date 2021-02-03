package com.algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_11508 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 유제품의 수
		int[] arr = new int[n];
		for(int i = 0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		int cost = 0;
		Arrays.sort(arr);
		int a = n%3;
	
		for(int i = 0; i<a; i++) {
			cost += arr[i];
		}
		int cnt = 0;
		for(int i = a; i<n; i++) {
			if(cnt == 0) {
				cnt++;
				continue;
			}
			cost += arr[i];
			cnt++;
			if(cnt == 3)
				cnt = 0;
		}
		
		System.out.println(cost);
	}
}
