package com.algorithm;
import java.util.Scanner;

public class BOJ_1145 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arr[] = new int[5];
		// 입력
		for(int i = 0; i<5; i++) {
			arr[i] = sc.nextInt();
		}
		
		int res = getMin(arr);
		while(true) {
			int cnt = 0;
			for(int i = 0; i<5; i++) {
				if(res%arr[i] == 0) 
					cnt++;
			}
			if(cnt >= 3)
				break;
			res++;
		}
		
		System.out.println(res);
		
	}
	
	static int getMin(int[] arr) {
		int min = Integer.MAX_VALUE;
		for(int i = 0; i<arr.length; i++) {
			if(arr[i]<min)
				min = arr[i];
		}
		return min;
	}
}
