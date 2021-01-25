package com.algorithm;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class PrinterQueue {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0) {
			int n = sc.nextInt();	// 문서의 개수
			int m = sc.nextInt();	// 몇번째
			Queue<Node> queue = new LinkedList<>();
			for(int i = 0; i<n; i++) {
				Node tmp = new Node(i, sc.nextInt());
				queue.add(tmp);
			}
			
			// m번째 문서가 몇번째로 출력되는지
			int cnt = 1;
			while(!queue.isEmpty()) {
				Node curNode = queue.poll(); 
				Iterator<Node> iter = queue.iterator();
				boolean check = true;
				while(iter.hasNext()) {
					Node node = (Node)iter.next();
					if(curNode.pr < node.pr) {
						check = false;
						break;
					}
				}
				if(check == false)
					queue.offer(curNode);
				else {
					if(curNode.id == m)
						System.out.println(cnt);
					else
						cnt++;
				}
			}
			
		}
	}
	
	static class Node{
		int id;
		int pr;
		Node(int id, int pr){
			this.id = id;
			this.pr = pr;
		}
	}
}
