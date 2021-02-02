package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1010 {
	static int[][] memo;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while(T-->0) {
			String[] str = br.readLine().split(" "); 
			int n = Integer.parseInt(str[0]);	// 서
			int m = Integer.parseInt(str[1]);	// 동
			
			memo = new int[31][31];
			int res = combination(m,n);
			System.out.println(res);
		}
	}
	
	static int combination(int n, int r) {
		if(n == r || r == 0)
			return 1;
		if(memo[n][r] != 0) {
			return memo[n][r];
		}
		return memo[n][r] = combination(n-1, r)+combination(n-1, r-1);		
	}

}
