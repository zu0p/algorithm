package com.lecture;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class NextPermutation {
    public static void main(String[] args) throws IOException, NumberFormatException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int r = Integer.parseInt(br.readLine());
        int[] input = new int[n];
        String[] tmp = br.readLine().split(" ");
        for(int i = 0; i<n; i++){
            input[i] = Integer.parseInt(tmp[i]);
        }

        System.out.println("=============nPn=============");
        Arrays.sort(input);
        do{
            // nPn 순열 구하기
            System.out.println(Arrays.toString(input));
        }while(np(input));


        System.out.println("=============nCr=============");
        int[] p = new int[n];
        int cnt = 0;
        while(++cnt<=r){
            p[n-cnt] = 1;
        }
        do{
            for(int i = 0; i<n; i++){
                if(p[i] == 1)
                    System.out.print(input[i]+" ");
            }
            System.out.println();
        }while(np(p));
    }

    private static boolean np(int[] arr) {
        int n = arr.length;
        int i = n-1;
        // 바꿀 값 찾기
        while(i-1>=0 && arr[i-1]>=arr[i]){
            i--;
        }
        if(i==0) return false;

        int j = n-1;
        while(arr[i-1]>=arr[j]){
            j--;
        }
        swap(arr, i-1, j);

        int k = n-1;
        while(i<k){
            swap(arr, i++, k--);
        }
        return true;
    }

    private static void swap(int[] arr, int a, int b){
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
