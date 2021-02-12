package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_15651 {
    static int n, m;
    static int[] res;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        n = Integer.parseInt(in[0]);
        m = Integer.parseInt(in[1]);
        res = new int[m];
        permu(0);
        System.out.println(sb.toString());
    }

    private static void permu(int cnt) {
        if(cnt == m){
            for(int i = 0; i<m; i++){
                sb.append(res[i]+ " ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 0; i<n; i++){
            res[cnt] = i+1;
            permu(cnt+1);
        }
    }
}
