package day0310;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16197 {
    static int n,m;
    static char map[][] = new char[21][21];
    static int dx[] = {-1,1,0,0};
    static int dy[] = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for(int i = 0; i<n; i++){
            map[i] = br.readLine().toCharArray();
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        int[][] pos = findCoin();
        Queue<int[][]> q = new LinkedList<>();
        q.offer(pos);

        while(!q.isEmpty()){
            int[][] cur = q.poll();
            if(cur[2][0]>10)
                break;
            for(int d = 0; d<4; d++){
                int cnt = 0;
                int ni1 = cur[0][0]+dx[d];
                int nj1 = cur[0][1]+dy[d];
                int ni2 = cur[1][0]+dx[d];
                int nj2 = cur[1][1]+dy[d];

                // 떨어지기
                if(ni1<0 || nj1<0 || ni1>=n || nj1>=m){
                    cnt++;
                }
                if(ni2<0 || nj2<0 || ni2>=n || nj2>=m){
                    cnt++;
                }
                if(cnt==1){
                    if(cur[2][0]+1>10) return -1;
                    return cur[2][0]+1;
                }
                else if(cnt==2) continue;

                // 벽
                if(map[ni1][nj1]=='#' && map[ni2][nj2]=='#') continue;
                if(map[ni1][nj1]=='#'){
                    ni1 = cur[0][0];
                    nj1 = cur[0][1];
                }
                if(map[ni2][nj2]=='#'){
                    ni2 = cur[1][0];
                    nj2 = cur[1][1];
                }

                int[][] in = {{ni1, nj1},{ni2,nj2},{cur[2][0]+1,0}};
                q.offer(in);
            }
        }
        return -1;
    }

    private static int[][] findCoin() {
        int[][] ans = new int[3][2];
        int cnt = 0;
        for(int i = 0; i<n;i++){
            for(int j = 0; j<m; j++){
                if(map[i][j]!='o')continue;
                ans[cnt][0] = i;
                ans[cnt++][1] = j;
            }
        }
        ans[2][0]=0;
        ans[2][1]=0;
        return ans;
    }
}
