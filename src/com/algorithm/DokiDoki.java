// BOJ_12789 도키도키 간식드리미
package com.algorithm;

import java.util.Scanner;
import java.util.Stack;

public class DokiDoki {
	static Scanner sc  = new Scanner(System.in);
	public static void main(String[] args) {
		int N = Integer.parseInt(sc.nextLine());

		boolean isSad = solve(N);
		
		if(!isSad)
			System.out.println("Nice");
		else if(isSad)
			System.out.println("Sad");
			
		
	}
	
	static boolean solve(int N) {
		Stack<Integer> stack = new Stack<>();
		int pass = 1;
		
		for(int i = 0; i<N; i++) {
			int num = sc.nextInt();
			if(num == pass) {
				pass++;
				continue;
			}
			else {
				while(!stack.isEmpty()) {
					if(stack.peek() == pass) {
						stack.pop();
						pass++;
						continue;
					}
					else {
						break;
					}
				}
				stack.push(num);
			}
		}
		
		int pre = stack.pop();
		while(!stack.isEmpty()) {
			int cur = stack.pop();
			if(pre>cur) {				
				return true;
			}
			pre = cur;
		}
		
		return false;
	}

}
