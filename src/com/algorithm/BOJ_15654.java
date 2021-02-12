package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

public class BOJ_15654 {
    static int n,m;
    static int[] input, res, v;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in1 = br.readLine().split(" ");
        String[] in2 = br.readLine().split(" ");

        n = Integer.parseInt(in1[0]);
        m = Integer.parseInt(in1[1]);
        input = new int[n];
        res = new int[m];
        v = new int[n];
        for(int i = 0; i<n; i++){
            input[i] = Integer.parseInt(in2[i]);
        }
        Arrays.sort(input);

        permu(0);
        System.out.println(sb.toString());
    }

    private static void permu(int cnt) {
        if(cnt == m){
            for(int i = 0; i<m; i++){
                sb.append(res[i]+" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=0; i<n; i++){
            if(v[i] == 1) continue;

            v[i] = 1;
            res[cnt] = input[i];
            permu(cnt+1);
            v[i] = 0;
        }
    }
}
