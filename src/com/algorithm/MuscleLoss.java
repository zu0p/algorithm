/*
 * Writer: 주영,박
 * 20210119
 * 
 * 백준_20300) 서강근육맨
 * https://www.acmicpc.net/problem/20300
 * 
 * 정렬 후 맨앞 + 맨뒤, 그다음 + 그다름 뒤...
 */
package com.algorithm;

import java.io.*;
import java.util.Arrays;

public class MuscleLoss {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

		int num = Integer.parseInt(br.readLine());
		
		String[] strLoss = br.readLine().split(" ");
		long[] loss = new long[num];
		for(int i = 0; i<num; i++) {
			loss[i] = Long.parseLong(strLoss[i]);
		}

		long m = Long.MIN_VALUE;
		Arrays.sort(loss);	// 정렬한 다음			
		if(num%2 == 0) { 	// 근손실 배열 길이가 짝수
			for(int i = 0; i<num; i++) 
				 m = Math.max(m, loss[i]+loss[num-1-i]);			
		}
		else { 				// 근손실 배열 길이가 홀수
			for(int i = 0; i<num-1; i++) 
				m = Math.max(m, loss[i]+loss[num-2-i]);			
		}
		
		bw.write(Long.toString(m));
		
        bw.flush();
        bw.close();
        br.close();
	}
}
