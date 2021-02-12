package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_15655 {
    static int n, m;
    static int[] res, input;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        n = Integer.parseInt(in[0]);
        m = Integer.parseInt(in[1]);
        res = new int[m];
        input = new int[n];

        String[] in2 = br.readLine().split(" ");
        for(int i = 0; i<n; i++){
            input[i] = Integer.parseInt(in2[i]);
        }
        Arrays.sort(input);

        combi(0,0);
        System.out.println(sb.toString());
    }

    private static void combi(int cnt, int start) {
        if(cnt == m){
            for(int i = 0; i<m; i++){
                sb.append(res[i]+" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = start; i<n; i++){
            res[cnt] = input[i];
            combi(cnt+1, i+1);
        }
    }
}
