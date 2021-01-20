/*
 * Writer: 주영,박
 * 20210120
 * 
 * 백준_1251) 단어나누기
 * https://www.acmicpc.net/problem/1251
 * 
 * 완탐
 */
package com.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class WordDivision {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String word = sc.next();
		ArrayList<String> list  = new ArrayList<String>();
		for(int i = 1; i<word.length()-1; i++) {
			for(int j = i+1; j<word.length(); j++) {
				String w1 = word.substring(0, i);
				String w2 = word.substring(i, j);
				String w3 = word.substring(j);
				
				String newWord = reverse(w1)+reverse(w2)+reverse(w3);
				
				list.add(newWord);
			}
		}

		// 정렬
		Collections.sort(list);
		System.out.println(list.get(0));
	}

	static String reverse(String word) {
		String res = "";
		for(int i = word.length()-1; i>=0; i--) {
			res += word.charAt(i);
		}
		return res;
	}
}
