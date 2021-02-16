package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_4963 {
    static int w,h;
    static int[][] map,v;
    static int[] dx = {-1,-1,0,1,1,1,0,-1};//상 우상 우 우하 하 좌하 좌 좌상
    static int[] dy = {0,1,1,1,0,-1,-1,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        while(!in[0].equals("0")){
            w = Integer.parseInt(in[0]);
            h = Integer.parseInt(in[1]);
            map = new int[h][w];
            v = new int[h][w];
            for(int i = 0; i<h; i++){
                String[] in2 = br.readLine().split(" ");
                for(int j = 0; j<w; j++){
                    map[i][j] = Integer.parseInt(in2[j]);
                }
            }
            int cnt = 0;
            for(int i = 0; i<h; i++) {
                for(int j = 0; j<w; j++) {
                    if(v[i][j]==1) continue;
                    if(map[i][j]==0) continue;
                    dfs(i, j);
                    cnt++;
                }
            }
            System.out.println(cnt);

            in = br.readLine().split(" ");
        }
    }

    private static void dfs(int i, int j) {
        v[i][j] = 1;
        for(int k = 0; k<8; k++){
            int ni = i+dx[k];
            int nj = j+dy[k];
            if(ni>=0 && ni<h && nj>=0 && nj<w && v[ni][nj]==0 && map[ni][nj]==1){
                v[ni][nj] = 1;
                dfs(ni,nj);
            }
        }
    }
}
