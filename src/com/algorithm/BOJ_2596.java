package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2596 {
	static String res="";

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String str = br.readLine();
		
		String[] ward = new String[n];
		int cnt = 0;
		for(int i = 0; i<n*6; i+=6) {
			ward[cnt++] = str.substring(i, i+6);
		}
//		System.out.println(Arrays.toString(ward));
		
		for(int i = 0; i<n; i++) {
			if(!isAlph(ward[i])) {
				res = Integer.toString(i+1);
				break;
			}
		}
		
		System.out.println(res);
		
	}
	
	static boolean isAlph(String str) {
		String[] ABCD = {"000000","001111","010011","011100","100110","101001","110101","111010"};
		String[] real = {"A","B","C","D","E","F","G","H"};
		
		boolean ans = false;
		
		for(int i = 0; i<ABCD.length; i++) {
			int cnt = 0;
			for(int j = 0; j<6; j++) {
				if(str.charAt(j) != ABCD[i].charAt(j))
					cnt++;
			}
			if(cnt==0) {
				ans = true;
				res+=real[i];
				break;
			}
			else if(cnt==1) {
				ans = true;
				res+=real[i];
				break;
			}
		}
		return ans;
	}

}
