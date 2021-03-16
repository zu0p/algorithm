import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_20056 {
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    static int N, M, K;
    static class Ball{
        int r,c;
        int m, s, d;
        public Ball(int r, int c, int m, int s, int d) {
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }
    static Queue<Ball> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            q.add(new Ball(r,c,m,s,d));
        }

        for(int i = 0; i<K; i++){
            move();
        }

        int res = 0;
        for(Ball ball: q){
            res+=ball.m;
        }
        System.out.println(res);
    }

    private static void move() {
        ArrayList<Ball>[][] cnt = new ArrayList[N+1][N+1];
        for(int i = 0; i<N+1; i++){
            for(int j = 0; j<N+1; j++){
                cnt[i][j] = new ArrayList<>();
            }
        }
        ArrayList<Ball> newList = new ArrayList<>();
        while(!q.isEmpty()){
            Ball cur = q.poll();
//            int nr = (cur.r + dx[cur.d]*cur.s + N) % N;
//            int nc = (cur.c + dy[cur.d]*cur.s + N) % N;
            int nr = cur.r + dx[cur.d]*cur.s  % N;
            int nc = cur.c + dy[cur.d]*cur.s  % N;
            if(nr>N) nr %= N;
            else if(nr<1) nr = N - (Math.abs(nr)%N);
            if(nc>N) nc %= N;
            else if(nc<1) nc = N - (Math.abs(nc)%N);

            newList.add(new Ball(nr,nc,cur.m,cur.s,cur.d));
            cnt[nr][nc].add(new Ball(nr,nc,cur.m,cur.s,cur.d));
        }

        for(int i = 0; i<=N; i++){
            for(int j = 0; j<=N; j++){
                if(cnt[i][j].size() == 0) continue;

                else if(cnt[i][j].size() == 1){
                    // 안겹칠 때
                    q.offer(cnt[i][j].get(0));
                }

                else if(cnt[i][j].size()>=2){
                    // 2개 이상 파이어볼
                    int sumS = 0, sumM = 0, cnts = 0;
                    int odd=0, even=0;
                    for(Ball cur: cnt[i][j]){
                        sumS += cur.s;
                        sumM += cur.m;
                        cnts++;

                        if(cur.d%2==0)  even++;
                        else odd++;
                    }
                    // 4개 추가
                    for(int k=0; k<4; k++){
                        int add;
                        if(odd==cnts || even==cnts) add = k*2;
                        else add = k*2+1;
                        q.offer(new Ball(i,j,sumM / 5, sumS / cnts, add));
                    }
                }
            }
        }
    }
}