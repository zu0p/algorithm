package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;

public class BOJ_15665 {
    static int n,m;
    static int[] res, input;
    static LinkedHashSet<String> set = new LinkedHashSet<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in1 = br.readLine().split(" ");
        String[] in2 = br.readLine().split(" ");
        n = Integer.parseInt(in1[0]);
        m = Integer.parseInt(in1[1]);
        res = new int[m];
        input = new int[n];
        for(int i = 0; i<n; i++){
            input[i] = Integer.parseInt(in2[i]);
        }
        Arrays.sort(input);

        permu(0);
        for(String s: set){
            sb.append(s+"\n");
        }
        System.out.println(sb.toString());
    }

    private static void permu(int cnt) {
        if(cnt == m){
            String tmp = "";
            for(int i = 0; i<m; i++){
                tmp+=res[i]+" ";
            }
            set.add(tmp);
            return;
        }

        for(int i = 0; i<n; i++){
            res[cnt] = input[i];
            permu(cnt+1);
        }
    }
}
