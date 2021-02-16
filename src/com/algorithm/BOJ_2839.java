package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if(n == 4| n == 7){
            System.out.println(-1);
        }
        else{
            int cnt3 = 0;
            while(n%5!=0 && n>0){
                n -= 3;
                cnt3++;
            }
            int cnt5 = n/5;
            System.out.println(cnt5+cnt3);
        }
    }
}
