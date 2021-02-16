package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_13565 {
    static int m,n;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in1 = br.readLine().split(" ");
        n = Integer.parseInt(in1[0]);
        m = Integer.parseInt(in1[1]);
        map = new int[n][m];
        for(int i = 0; i<n; i++){ // 입력
            String in2 = br.readLine();
            for(int j = 0; j<m; j++){
                map[i][j] = in2.charAt(j)-'0';
            }
        }

        cango = false;
        for(int i = 0; i<m; i++){
            if(map[0][i] == 1) continue;
            dfs(0, i);
        }
        System.out.println(cango?"YES":"NO");
        br.close();
    }

    static int[] dx = {-1,1,0,0}; //상 하 좌 우
    static int[] dy = {0,0,-1,1};
    static boolean cango;
    private static void dfs(int i, int j) {
        map[i][j] = 1;
        if(i == n-1){
            cango = true;
            return;
        }
        for(int k = 0; k<4; k++){
            int ni = i+dx[k];
            int nj = j+dy[k];
            if(ni<0 || ni>=n || nj<0 || nj>=m || map[ni][nj] == 1) continue;

            dfs(ni, nj);
        }
    }
}
