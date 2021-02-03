// BOJ_1213
package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class MakePalindrome {
	static int[] cnt = new int[26];
	static char oddChar = ' ';

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		Stack<Character> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		
		int oddCnt = getOddCnt(str);
		if(oddCnt >= 2) {
			System.out.println("I'm Sorry Hansoo");
		}
		else {
			// 홀수갯수로 0개 또는 1개일 때
			
			for(int i = 0; i<26; i++) {
				if(cnt[i] == 0)
					continue;
				int repeat = cnt[i]/2;
				for(int j = 0; j<repeat; j++) {
					stack.push((char)(i+'A'));
					sb.append((char)(i+'A'));
				}
			}
			
			if(oddCnt == 1)
				sb.append(oddChar);
			
			int len = stack.size();
			for(int i = 0; i<len; i++) {
				sb.append(stack.pop());
			}
			System.out.println(sb);
		}
		
	}

	static int getOddCnt(String str) {		
		int oddCnt = 0;
		
		// cnt 배열 채우기
		for(int i = 0; i<str.length(); i++) {
			cnt[str.charAt(i)-'A']++;
		}
//		for(int i = 0; i<cnt.length; i++) {
//			System.out.print(cnt[i]+ " ");
//		}
//		System.out.println();
		
		// 홀수번 cnt된 것들의 수
		for(int i = 0; i<26; i++) {
			if(cnt[i]%2 == 1) {
//				System.out.println("홀수"+i);
				oddCnt++;
				if(oddCnt > 1) {
					oddChar=' ';
					return 2;
				}				
				oddChar = (char) (i+65);
				cnt[i]--;
			}
		}	
		
		return oddCnt;
	}
}
