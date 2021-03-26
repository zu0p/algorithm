package day0326;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_연구소 {
    static int N,M;
    static int[][] map;
    static int vcnt, wcnt;
    static class Node{
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int max = -1;
    static Queue<Node> virus;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        virus = new LinkedList<>();
        wcnt=0;
        vcnt=0;
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==1)
                    wcnt++;
                if(map[i][j] == 2) {
                    vcnt++;
                    virus.add(new Node(i, j));
                }
            }
        }

        selectThree(0);
        System.out.println(max);
    }

    private static void selectThree(int cnt){
        if(cnt == 3) {
            solution();
            return;
        }
        for(int i = 0; i<N; i++){
            for(int j = 0; j<M; j++){
                if(map[i][j] == 0){
                    map[i][j] = 1;
                    selectThree(cnt+1);
                    map[i][j] = 0;
                }
            }
        }
    }

    private static int[] dx = {1,-1,0,0};
    private static int[] dy = {0,0,1,-1};
    static ArrayList<Node> change = new ArrayList<>();
    private static void solution() {
        // 1. Virus 퍼뜨리기
        Queue<Node> q = new LinkedList<>();
        boolean v[][] = new boolean[N][M];
        for(Node n: virus){
            q.offer(n);
            v[n.x][n.y] = true;
        }
        while (!q.isEmpty()){
            Node cur = q.poll();
            for(int d = 0; d<4; d++){
                int ni = cur.x+dx[d];
                int nj = cur.y+dy[d];
                if(ni<0||nj<0||ni>=N||nj>=M||v[ni][nj]||map[ni][nj]>0)continue;
                v[ni][nj] = true;
                map[ni][nj] = 2;
                q.offer(new Node(ni, nj));
                change.add(new Node(ni, nj));
            }
        }

        // 2. 안전영역 개수 구하기 -> max값 갱신
        int safeArea = N*M-(wcnt+3)-(vcnt+change.size());
        max = Math.max(safeArea, max);

        // 3. map 원래대로 되돌려놓기
        for(Node n: change){
            map[n.x][n.y] = 0;
        }
        change.clear();
    }

}
