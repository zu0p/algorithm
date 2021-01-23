package com.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class FindMarble {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		ArrayList<Integer>[] havier = new ArrayList[n+1];	// index 0 : dummy
		ArrayList<Integer>[] lighter = new ArrayList[n+1];
		// init
		for(int i = 1; i<=n; i++) {
			havier[i] = new ArrayList<>();
			lighter[i] = new ArrayList<>();
		}
		// 입력
		for(int i = 0; i<m; i++) {
			int num1 = sc.nextInt();
			int num2 = sc.nextInt();
			havier[num2].add(num1);
			lighter[num1].add(num2);
		}
		
		int[] visited = new int[n+1];
		
		int answer = 0;
		
		for(int i = 1; i<=n; i++) {
			Arrays.fill(visited, 0); // init
			int heavy = dfs(i, havier, visited);
			Arrays.fill(visited, 0); // init
			int light= dfs(i, lighter, visited);
			
			int mid = n/2;
			if(heavy>mid || light>mid) {
				answer++;
			}
		}
		System.out.println(answer);
	}
	
	static int dfs(int idx, ArrayList<Integer>[] list, int[] visited) {
		int sum = 0;
		visited[idx] = 1;
		for(int marble : list[idx]) {
			if(visited[marble]==0) {
				visited[marble] = 1;
				sum += dfs(marble, list, visited)+1;
			}
		}
		return sum;
	}

}
