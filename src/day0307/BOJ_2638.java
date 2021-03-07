package day0307;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2638 {
    static int[][] map;
    static boolean[][] visited;
    static int n, m;

    static int dx[] = {1,-1,0,0};
    static int dy[] = {0,0,1,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];

        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int res = 0;
        while (true){

            init();
            dfs(0,0);

            int cnt = 0; // 치즈 카운트

            for(int i = 1; i<n-1; i++){
                for(int j = 1; j<m-1; j++){
                    if(map[i][j] == 1){
                        if(isDeletable(i,j)){
                            cnt++;
                        }
                    }
                }
            }

            if(cnt == 0)
                break;

            res++;
        }

        System.out.println(res);
    }

    private static boolean isDeletable(int i, int j) {
        int cnt = 0; // 외부 인접면 카운트
        for(int d = 0; d<4; d++){
            int ni = i+dx[d];
            int nj = j+dy[d];
            if(ni<0||nj<0||ni>=n||nj>=m||map[ni][nj]==1||map[ni][nj]==0)continue;
            cnt++;
        }
        if(cnt>=2){
            map[i][j] = 0;
            return true;
        }
        else
            return false;
    }

    private static void dfs(int i, int j) {
        //outer air = -1 로 change
        map[i][j] = -1;
        visited[i][j] = true;

        for(int d=0; d<4; d++){
            int ni = i+dx[d];
            int nj = j+dy[d];

            if(ni<0||nj<0||ni>=n||nj>=m||visited[ni][nj]==true||map[ni][nj]==1)continue;
            dfs(ni,nj);
        }
    }

    private static void init() {
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                visited[i][j] = false;
            }
        }
    }
}
