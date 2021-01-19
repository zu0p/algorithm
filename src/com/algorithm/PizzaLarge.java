/*
 * Writer: 주영,박
 * 20210119
 * 
 * 백준_14607) 피자(Large)
 * https://www.acmicpc.net/problem/14607
 * 
 * 수학 / 규칙 / 점화식
 */
package com.algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class PizzaLarge {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

		long height = Long.parseLong(br.readLine());
		long res = 0;
		if(height != 1) {
			res = (height*(height-1))/2;
		}
			
		bw.write(Long.toString(res));
		
        bw.flush();
        bw.close();
        br.close();
	}
}
