package day0220;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_3709 {
    static int n, r;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while(t-->0){
            String[] in1 = br.readLine().split(" ");
            n = Integer.parseInt(in1[0]);
            r = Integer.parseInt(in1[1]);
            map = new int[n+2][n+2];
            for(int i = 0; i<r; i++){
                in1 = br.readLine().split(" ");
                map[Integer.parseInt(in1[0])][Integer.parseInt(in1[1])] = 1;
            }
            in1 = br.readLine().split(" ");

            int r = Integer.parseInt(in1[0]);
            int c = Integer.parseInt(in1[1]);
            res = new int[2];
            int dir = -1;
            if(r == n+1){
                dir = 3;
            }
            else if(r == 0){
                dir = 1;
            }
            else if(c == n+1){
                dir = 2;
            }
            else if(c == 0){
                dir = 0;
            }

            dfs(r, c, dir);

            System.out.println(res[0]+" "+res[1]);
        }

    }

    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int[] res;
    private static void dfs(int r, int c, int d) {
        int nr = r+dx[d];
        int nc = c+dy[d];
        if(nr<1 || nc<1 || nr>n || nc>n) {
            res[0] = nr;
            res[1] = nc;
            return;
        }
        if(map[nr][nc] == 1){
            d = (d+1)%4;
        }
        dfs(nr,nc,d);

    }
}
