package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_12761 {
    static int a,b,n,m;
    static int[] v = new int[100001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        a = Integer.parseInt(tmp[0]);
        b = Integer.parseInt(tmp[1]);
        n = Integer.parseInt(tmp[2]);
        m = Integer.parseInt(tmp[3]);

        if(n==m){
            System.out.println(0);
            return;
        }
        else{
            bfs(n);
        }

    }

    private static void bfs(int n) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{n,1});

        while(!q.isEmpty()){
            int[] tmp = q.poll();
            for(int i = 0; i<8; i++){
                int next;
                if(i==0){
                    next = tmp[0]+1;
                }
                else if(i==1){
                    next = tmp[0]-1;
                }
                else if(i==2){
                    next = tmp[0]+a;
                }
                else if(i==3){
                    next = tmp[0]-a;
                }
                else if(i==4){
                    next = tmp[0]+b;
                }
                else if(i==5){
                    next = tmp[0]-b;
                }
                else if(i==6){
                    next = tmp[0]*a;
                }
                else {
                    next = tmp[0]*b;
                }

                if(next==m){
                    System.out.println(tmp[1]);
                    return;
                }

                if(next>=0 && next<v.length && v[next]==0){
                    v[next] = 1;
                    q.offer(new int[]{next, tmp[1]+1});
                }
            }
        }
    }
}
