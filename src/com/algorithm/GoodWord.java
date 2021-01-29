// BOJ_3986
package com.algorithm;

import java.util.Scanner;
import java.util.Stack;

public class GoodWord {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());
		int cnt = 0;
		
		while(N-->0) {
			Stack<Character> stack = new Stack<>();
			String tmp = sc.nextLine();
			for(int j = 0; j<tmp.length(); j++) {	// 알파벳 스택에 넣기
				if(!stack.isEmpty()) {
					if(stack.peek() == tmp.charAt(j)) {
						stack.pop();
					}
					else {
						stack.push(tmp.charAt(j));
					}
				}
				else
					stack.push(tmp.charAt(j));
			}
			if(stack.isEmpty())
				cnt++;
		}
		System.out.println(cnt);
	}
}
  