package day0302;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_2667 {
    static int n;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for(int i = 0; i<n; i++){
            String[] st = br.readLine().split("");
            for(int j = 0; j<n;j++){
                map[i][j] = Integer.parseInt(st[j]);
            }
        }

        ArrayList<Integer> cnt = new ArrayList<>();
        int totalCnt = 0;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(map[i][j] == 0)continue;

                cnt.add(dfs(i,j));
                totalCnt++;
            }
        }

        System.out.println(totalCnt);
        Collections.sort(cnt);
        for(int i = 0; i<cnt.size(); i++){
            System.out.println(cnt.get(i));
        }
    }

    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,-1,1};
    private static Integer dfs(int i, int j) {
        int cnt = 1;
        map[i][j] = 0;

        for(int d = 0; d<4; d++){
            int ni = i+dx[d];
            int nj = j+dy[d];

            if(ni<0||nj<0||ni>=n||nj>=n||map[ni][nj]==0)continue;
            cnt += dfs(ni, nj);
        }

        return cnt;
    }
}
