package day0227;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2468 {
    static int n;
    static int[][] map;
    static int[] h = new int[101];
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        visited = new boolean[n][n];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                min = Math.min(min, map[i][j]);
                max = Math.max(max, map[i][j]);
                h[map[i][j]]++;
            }
        }

        int res = Integer.MIN_VALUE;

        if(min==max)
            System.out.println(1);
        else {
            for (int k = min; k <= max; k++) {
                int cur = k;
                if (h[cur] == 0) continue;
                visited = new boolean[n][n];

                int cnt = 0;
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (map[i][j] <= cur || visited[i][j]) continue;

                        visited[i][j] = true;
                        dfs(i, j, cur);
                        cnt++;
                    }
                }
                res = Math.max(res, cnt);
            }

            System.out.println(res);
        }

    }

    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,-1,1};
    private static void dfs(int i, int j, int std) {
        for(int d = 0; d<4; d++){
            int ni = i+dx[d];
            int nj = j+dy[d];
            if(ni<0 || nj<0 || ni>=n || nj>=n || map[ni][nj]<=std || visited[ni][nj]) continue;

            visited[ni][nj] = true;
            dfs(ni, nj, std);
        }
    }
}
