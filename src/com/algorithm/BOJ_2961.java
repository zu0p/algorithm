package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2961 {
    static int n;
    static int[] s,b;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        s = new int[n];
        b = new int[n];
        for(int i = 0; i<n; i++){
            String[] tmp = br.readLine().split(" ");
            s[i] = Integer.parseInt(tmp[0]);
            b[i] = Integer.parseInt(tmp[1]);
        }

        System.out.println(subset(1<<n));
        br.close();
    }

    private static int subset(int cnt){
        int min = Integer.MAX_VALUE;
        for(int flag = 0; flag<cnt; flag++){
            int sproduct = 1;
            int bsum = 0;
            for(int i = 0; i<n; i++){
                if((flag & 1<<i) != 0){
                    sproduct*=s[i];
                    bsum+=b[i];
                }
            }
            if(sproduct ==1 && bsum == 0) continue; // 공집합 포함 안함
            min = Math.min(min, Math.abs(sproduct-bsum));
        }
        return min;
    }
}
