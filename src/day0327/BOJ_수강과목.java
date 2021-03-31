package day0327;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_수강과목 {
    static int N, K; //최대 공부시간 | 과목 수
    static int dp[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        dp = new int[K+1][N+1];
        int importants[] = new int[K+1];
        int times[] = new int[K+1];
        int min = Integer.MAX_VALUE;
        for(int i = 1; i<=K; i++){
            st = new StringTokenizer(br.readLine(), " ");
            importants[i] = Integer.parseInt(st.nextToken());
            times[i] = Integer.parseInt(st.nextToken());
            if(min>times[i]) min = times[i];
        }

        for(int i = 1; i<K+1; i++){
            for(int j = min; j<N+1; j++){
                if(times[i]<=j)
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-times[i]]+importants[i]);
                else
                    dp[i][j] = dp[i-1][j];
            }
        }

        System.out.println(dp[K][N]);
    }
}
