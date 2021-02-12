package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_15652 {
    static int n, m;
    static int[] res;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        n = Integer.parseInt(in[0]);
        m = Integer.parseInt(in[1]);
        res = new int[m];
        combi(0, 0);
        System.out.println(sb.toString());
    }

    private static void combi(int cnt, int index) {
        if(cnt == m){
            for(int i = 0; i<m; i++){
                sb.append(res[i]+" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = index; i<n; i++){
            res[cnt] = i+1;
            combi(cnt+1, i);
        }
    }
}
