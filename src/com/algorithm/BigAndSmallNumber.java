/*
 * Writer: 주영,박
 * 20210119
 * 
 * 백준_2992) 크면서 작은 수
 * https://www.acmicpc.net/problem/2992
 * 
 * 순열
 */
package com.algorithm;

import java.io.*;
import java.util.*;

public class BigAndSmallNumber {
    static int min = Integer.MAX_VALUE;
    static boolean isChanged = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        // input
        String input = br.readLine();
        String[] str = input.split("");

        int n = input.length();
        boolean visited[] = new boolean[n];
        int arr[] = new int[n];
        int output[] = new int[n];
        for(int i = 0; i<n; i++){
            arr[i] = Integer.valueOf(str[i]);
        }
        int t = arrToInt(arr);

        perm(t, arr, output, visited, 0, n, n);
        if(isChanged != true){
            bw.write("0");
        }
        else{
            bw.write(Integer.toString(min));
        }

        bw.flush();
        bw.close();
        br.close();
    }
    
    // 순서가 있는 조합(순열)
    // 재귀
    static void perm(int origin, int[] arr, int[] output, boolean[] visited, int depth, int n, int r) {
        if (depth == r) {
                int tmp = arrToInt(output);
                if(tmp>origin){
                    if(tmp<min){
                        min = tmp;
                        isChanged = true;
                    }
                }
                return;
        }

        for (int i=0; i<n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = arr[i];
                perm(origin, arr, output, visited, depth + 1, n, r);
                visited[i] = false;
            }
        }
    }

    static int arrToInt(int[] arr){
        int res = 0;
        int size = arr.length;
        for(int i = 0; i<size; i++){
            res += arr[i]*Math.pow(10,size-i-1);
        }
        return res;
    }
}
