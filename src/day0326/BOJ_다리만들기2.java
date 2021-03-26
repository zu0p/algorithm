package day0326;

import java.util.*;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import java.io.*;

public class BOJ_다리만들기2 {
    static int N,M;
    static int[][] map;
    static int[][] tempmap;
    static boolean[][] check;
    static int[][] dir = { {0,1},{0,-1},{1,0},{-1,0} };
    static int land =1;
    static int dist[][];
    static ArrayList<Land> Llist[] ;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        tempmap = new int[N][M];
        check= new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Llist= new ArrayList[7];
        for (int i = 0; i <N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] == 1 && !check[i][j])
                {
                    Llist[land] = new ArrayList<>();
                    dfs(i,j);
                    land +=1;
                }
            }
        }
        dist = new int[land][land];
        for (int i = 0; i < land; i++) {
            for (int j = 0; j < land; j++) {
                if(i!=j) {
                    dist[i][j] = 987654321;
                }
            }
        }

        for (int i = 1; i < land; i++) {
            for (int j = 1; j <land; j++) {

                for (int s1 = 0; s1 < Llist[i].size(); s1++) {
                    for (int s2 = 0; s2 < Llist[j].size(); s2++) {
                        if(i!=j && Llist[i].get(s1).x == Llist[j].get(s2).x)
                        {
                            int tempdist= Math.abs(Llist[i].get(s1).y - Llist[j].get(s2).y)-1;
                            if(dist[i][j] > tempdist)
                            {
                                dist[i][j] = tempdist;
                            }
                        }
                        if(i!=j && Llist[i].get(s1).y == Llist[j].get(s2).y)
                        {
                            int tempdist= Math.abs(Llist[i].get(s1).x - Llist[j].get(s2).x)-1;
                            if(dist[i][j] > tempdist)
                            {
                                dist[i][j] = tempdist;
                            }
                        }
                    }
                }

            }
        }

        for (int i = 1; i <land; i++) {
            for (int j = 1; j < land; j++) {
                if(dist[i][j] != 0 && dist[i][j] < 2 )
                {
                    dist[i][j] = 987654321;
                }
            }
        }
        ArrayList<Bridge> Blist = new ArrayList<>();

        for (int i = 1; i < land; i++) {
            for (int j = i+1; j < land; j++) {
                if( i!=j && dist[i][j] != 987654321) {
                    Blist.add(new Bridge(i, j, dist[i][j]));
                }
            }
        }
        Collections.sort(Blist);

        parent = new int[land+1];

        make(land);

        int sum =0;
        int cnt =0;
        for (int i = 0; i < Blist.size(); i++) {
            if( cnt == land -1)
            {
                break;
            }
            if(union(Blist.get(i).node1,Blist.get(i).node2) == true)
            {
                sum+= Blist.get(i).cost;
                cnt++;
            }
        }
        System.out.println(sum==0?-1:sum);
    }
    static void make(int len)
    {
        for (int i = 1; i <= len; i++) {
            parent[i] = i;
        }
    }
    static int find(int n)
    {
        if( n == parent[n])
            return n;
        else
            return parent[n] = find(parent[n]);
    }
    static boolean union(int a, int b){
        a = find(a);
        b = find(b);

        if(a==b) return false; //이미 같은 집합

        parent[b] = a;
        return true;
    }
    static int parent[];
    static void dfs(int x, int y)
    {
        check[x][y] = true;
        tempmap[x][y] = land;
        Llist[land].add(new Land(x, y));

        for (int i = 0; i <4; i++) {
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];

            if(nx <0 || ny< 0 || nx >= N || ny >= M) continue;
            if(check[nx][ny]) continue;
            if(map[nx][ny] == 0) continue;


            tempmap[nx][ny] = land;

            dfs(nx,ny);
        }
    }
    static class Bridge implements Comparable<Bridge>
    {
        int node1, node2;
        int cost;
        public Bridge(int node1, int node2, int cost) {
            this.node1 = node1;
            this.node2 = node2;
            this.cost = cost;
        }
        @Override
        public int compareTo(Bridge o)
        {
            return this.cost - o.cost;
        }
        @Override
        public String toString() {
            return "Bridge [node1=" + node1 + ", node2=" + node2 + ", cost=" + cost + "]";
        }

    }
    static class Land
    {
        int x,y;

        public Land(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Land [x=" + x + ", y=" + y + "]";
        }


    }
}
//package day0326;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.*;
//
//public class BOJ_다리만들기2 {
//    static class Node{
//        int x,y;
//        int w;
//        public Node(int x, int y) {
//            this.x = x;
//            this.y = y;
//        }
//
//        public Node(int x, int y, int w) {
//            this.x = x;
//            this.y = y;
//            this.w = w;
//        }
//    }
//    static int N, M;
//    static int[][] map;
//
//    static int cntIsland = 0;
//    static Map<Integer, ArrayList<Node>> islands = new HashMap<>();
//
//    static int[] dx ={ -1,1,0,0};
//    static int[] dy = {0,0,-1,1};
//
//    static ArrayList<Node> adjList;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//        N = Integer.parseInt(st.nextToken());
//        M = Integer.parseInt(st.nextToken());
//        map = new int[N][M];
//        for(int i = 0; i<N; i++){
//            st = new StringTokenizer(br.readLine(), " ");
//            for(int j = 0; j<M; j++){
//                map[i][j] = Integer.parseInt(st.nextToken());
//            }
//        }
//
//        // 섬 개수로 섬에 속하는 좌표들 나누기
//        makeIsland();
//
//        // 섬끼리 연결 가능 다리 중 최소 구하기
//        makeBridge();
//
//        // 모든 섬이 연결되어있는지 확인 - 크루스칼!
//    }
//
//    private static void makeBridge() {
//        adjList = new ArrayList<>();
//    }
//
//    private static void makeIsland() {
//        boolean[][] v = new boolean[N][M];
//        for(int i = 0; i<N; i++){
//            for(int j = 0; j<M; j++){
//                if(v[i][j] || map[i][j] == 0)continue;
//                Queue<Node> q = new LinkedList<>();
//                q.add(new Node(i,j));
//                v[i][j] = true;
//                ArrayList<Node> list = new ArrayList<>();
//                list.add(new Node(i, j));
//                while(!q.isEmpty()){
//                    Node cur = q.poll();
//                    for(int d = 0; d<4; d++){
//                        int ni = cur.x + dx[d];
//                        int nj = cur.y + dy[d];
//                        if(ni<0||nj<0||ni>=N||nj>=M||v[ni][nj]||map[ni][nj]==0)continue;
//                        v[ni][nj] = true;
//                        list.add(new Node(ni,nj));
//                    }
//                }
//
//                islands.put(cntIsland++, list);
//            }
//        }
//    }
//
//}
