// 숨바꼭질
package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_1697 {
    static int n, k;
    static int[] v = new int[100001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        n = Integer.parseInt(in[0]);
        k = Integer.parseInt(in[1]);

        if(n==k){
            System.out.println(0);
        }
        else {
            bfs(n);
        }

    }

    private static void bfs(int n) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{n, 1});
        v[n] = 1;

        while(!q.isEmpty()){
            int[] tmp = q.poll();

            for(int i = 0; i<3; i++){
                int next;

                if(i==0){
                    next = tmp[0]+1;
                }
                else if(i==1){
                    next = tmp[0]-1;
                }
                else {
                    next = tmp[0]*2;
                }

                if(next == k){
                    System.out.println(tmp[1]);
                    return;
                }

                if(next >= 0 && next < v.length && v[next]==0){
                    q.offer(new int[]{next, tmp[1]+1});
                    v[next] = 1;
                }
            }
        }
    }
}
