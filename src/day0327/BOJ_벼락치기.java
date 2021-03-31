package day0327;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_벼락치기 {
    static int N, T;
    static int[] score, time;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        score = new int[N+1];
        time = new int[N+1];
        dp = new int[N+1][T+1];
        int min = Integer.MAX_VALUE;
        for(int i = 1; i<=N; i++){
            st = new StringTokenizer(br.readLine()," ");
            time[i] = Integer.parseInt(st.nextToken());
            score[i] = Integer.parseInt(st.nextToken());
            if(min>time[i])  min = time[i];
        }
        for(int i = 1; i<N+1; i++){ //단원
            for(int t = min; t<T+1; t++){ //걸리는 시간
                if(time[i]<=t){
                    dp[i][t] = Math.max(dp[i-1][t], dp[i-1][t-time[i]]+score[i]);
                }
                else{
                    dp[i][t] = dp[i-1][t];
                }
            }
        }

        System.out.println(dp[N][T]);
    }
}
