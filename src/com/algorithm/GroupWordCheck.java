// BOJ_1316
package com.algorithm;

import java.util.Scanner;

public class GroupWordCheck {
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		int n = sc.nextInt();
		int cnt = 0;
		for(int i = 0; i<n; i++) {
			if(check() == true)
				cnt++;
		}
		System.out.println(cnt);
	}
	
	public static boolean check() {
		boolean[] check = new boolean[26];
		int pre = 0;
		String str = sc.next();
		
		for(int i = 0; i<str.length(); i++) {
			int cur = str.charAt(i);
			
			if(pre != cur) { // pre문자와 cur문자 같지 않으면
				if(check[cur-'a']==false) { // cur이 처음 등장
					check[cur-'a'] = true;					
					pre = cur;
				}
				else {	// cur이 나온적 있는 경우
					return false;
				}
			}
		}
		
		return true;
	}
}
