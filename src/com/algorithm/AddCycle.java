// BOJ_1110
package com.algorithm;

import java.util.Scanner;

public class AddCycle {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		String origin = sc.next();
//		String cur = "";
//		String pre = origin;
		int origin = sc.nextInt();
		int pre = origin;
		int cur = -1;
		int cnt = 0;
		while(true) {
			if(origin == cur)
				break;
//			if(origin.equals(cur))
//				break;
			// pre 각자리 수 더하기 
//			String[] tmp = pre.split("");
//			int sum = 0;
//			for(String s: tmp) {
//				sum += Integer.parseInt(s);
//			}
			
			int tmp = pre;
			int sum = 0;
			while(tmp!=0) {
				sum += tmp%10;
				tmp /= 10;
			}
			
			// cur과 pre 마지막 글자 더하기 
//			cur = tmp[tmp.length-1]+Integer.toString(sum%10);
//			pre = cur;
//			cnt++;
			cur = (pre%10)*10 + sum%10;
			pre = cur;
			cnt++;
						
		}
		System.out.println(cnt);
	}

}
