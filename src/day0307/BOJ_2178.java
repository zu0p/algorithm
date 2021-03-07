package day0307;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2178 {
    static int n, m;
    static int map[][];
    static boolean visited[][];

    static int dx[] = {1,-1,0,0};
    static int dy[] = {0,0,1,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        map = new int[n][m];
        visited = new boolean[n][m];
        for(int i = 0; i<n; i++){
            input = br.readLine().split("");
            for(int j = 0; j<m; j++){
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        int res = bfs(0,0);
        System.out.println(res);
    }

    private static int bfs(int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i,j,1});
        visited[i][j] = true;
        int cnt = 0;

        a: while(!q.isEmpty()){
            int cur[] = q.poll();
            for(int d = 0; d<4; d++){
                int ni = cur[0]+dx[d];
                int nj = cur[1]+dy[d];
                if(ni<0||nj<0||ni>=n||nj>=m||visited[ni][nj]==true||map[ni][nj]==0)continue;

                visited[ni][nj] = true;
                q.offer(new int[]{ni,nj,cur[2]+1});
                if(ni == n-1 && nj == m-1) {
                    cnt = cur[2]+1;
                    break a;
                }
            }
        }
        return cnt;
    }
}
