package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;

public class BOJ_15663 {
    static int n,m;
    static int[] res, input, v;
    static LinkedHashSet<String> set = new LinkedHashSet<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in1 = br.readLine().split(" ");
        String[] in2 = br.readLine().split(" ");

        n = Integer.parseInt(in1[0]);
        m = Integer.parseInt(in1[1]);
        res = new int[m];
        v= new int[n];
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
            StringBuilder tmp = new StringBuilder();
            for(int i = 0; i<m; i++){
                tmp.append(res[i]+" ");
            }
            String str = tmp.toString();
            set.add(str);
            return;
        }

        for(int i = 0; i<n; i++){
            if(v[i] == 1) continue;

            v[i] = 1;
            res[cnt] = input[i];
            permu(cnt+1);
            v[i] = 0;
        }
    }
}
