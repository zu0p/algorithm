package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// n과 m
public class BOJ_15649 {
    static int n, m;
    static int[] res;
    static int[] v;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        n = Integer.parseInt(in[0]);
        m = Integer.parseInt(in[1]);
        res = new int[m];
        v = new int[n];

        permu(0);
        System.out.println(sb.toString());

    }
    static void permu(int cnt){
        if(cnt == m){
            for(int i = 0; i<m; i++){
                sb.append(res[i]+" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 0; i<n; i++){
            if(v[i]==1) continue;
            v[i] = 1;
            res[cnt] = i+1;
            permu(cnt+1);
            v[i] = 0;
        }
    }
}
