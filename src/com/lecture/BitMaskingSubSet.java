package com.lecture;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BitMaskingSubSet {
    static int[] input;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        input = new int[n];
        String[] tmp = br.readLine().split(" ");
        for(int i = 0; i<n; i++){
            input[i] = Integer.parseInt(tmp[i]);
        }
        binaryCounting(1<<n, n);
    }

    private static void binaryCounting(int total, int n) {
        for(int flag = 0; flag<total; flag++){
            for(int j = 0; j<n; j++){
                if((flag&1<<j)!=0){
                    System.out.print(input[j]+" ");
                }
                else{
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }
}
