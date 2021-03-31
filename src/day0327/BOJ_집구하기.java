package day0327;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_집구하기 {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static long MAX=1000000000;
    static ArrayList<Node> list[]=new ArrayList[10003];
    static int dx[]= {0,0,1,-1};
    static int dy[]= {1,-1,0,0};
    static int n,m;
    static long dist1[]=new long[10003];//맥도날드
    static boolean visit1[]=new boolean[10003];//맥도날드
    static long dist2[]=new long[10003];//스타벅스
    static boolean visit2[]=new boolean[10003];//스타벅스

    public static void main(String[] args) throws IOException {
        st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        for(int i=1;i<=n+2;i++) {
            list[i]=new ArrayList<>();
        }
        for(int i=0;i<m;i++) {
            int s,e,cost;
            st=new StringTokenizer(br.readLine());
            s=Integer.parseInt(st.nextToken());
            e=Integer.parseInt(st.nextToken());
            cost=Integer.parseInt(st.nextToken());
            list[s].add(new Node(e,cost));
            list[e].add(new Node(s,cost));
        }
        st=new StringTokenizer(br.readLine());
        int a;long b,c;
        a=Integer.parseInt(st.nextToken());
        b=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<a;i++) {
            list[n+1].add(new Node(Integer.parseInt(st.nextToken()),0));
        }
        st=new StringTokenizer(br.readLine());
        a=Integer.parseInt(st.nextToken());
        c=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<a;i++) {
            list[n+2].add(new Node(Integer.parseInt(st.nextToken()),0));
        }

        PriorityQueue<Node> pq=new PriorityQueue<>();
        for(int i=1;i<=n+2;i++) {
            dist1[i]=MAX;dist2[i]=MAX;
        }
        pq.add(new Node(n+1,0));
        dist1[n+1]=0;
        while(!pq.isEmpty()) {
            Node node=pq.poll();
            int s=node.e;
            if(visit1[s]) continue;
            visit1[s]=true;
            int size=list[s].size();
            for(int i=0;i<size;i++) {
                int next=list[s].get(i).e;
                long cost=list[s].get(i).cost;
                if(dist1[next]>dist1[s]+cost) {
                    dist1[next]=dist1[s]+cost;
                    pq.add(new Node(next,dist1[next]));
                }
            }
        }
        pq.add(new Node(n+2,0));
        dist2[n+2]=0;
        while(!pq.isEmpty()) {
            Node node=pq.poll();
            int s=node.e;
            if(visit2[s]) continue;
            visit2[s]=true;
            int size=list[s].size();
            for(int i=0;i<size;i++) {
                int next=list[s].get(i).e;
                long cost=list[s].get(i).cost;
                if(dist2[next]>dist2[s]+cost) {
                    dist2[next]=dist2[s]+cost;
                    pq.add(new Node(next,dist2[next]));
                }
            }
        }
        long ans=MAX;
        for(int i=1;i<=n;i++) {
            if(dist1[i]==0) continue;
            if(dist2[i]==0) continue;
            if(dist1[i]>b) continue;
            if(dist2[i]>c) continue;
            ans=Math.min(ans, dist1[i]+dist2[i]);
        }
        bw.write(Long.toString(ans==MAX?-1:ans));
        bw.flush();
        bw.close();
        br.close();
    }
}
class Node implements Comparable<Node>{
    int e;long cost;
    public Node(int e, long cost) {
        super();
        this.e = e;
        this.cost = cost;
    }
    @Override
    public int compareTo(Node o) {
        // TODO Auto-generated method stub
        return Long.compare(cost, o.cost);
    }
}
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.*;
//
//public class BOJ_집구하기 {
//    static int V, E;
//    static int[][] map;
//    static int M, S, x, y; //맥도날드 개수 | 스벅 개수
//    static int[] mv, sv;
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//        V = Integer.parseInt(st.nextToken());
//        E = Integer.parseInt(st.nextToken());
//        map = new int[V + 1][V + 1];
//        for (int i = 0; i < E; i++) {
//            st = new StringTokenizer(br.readLine(), " ");
//            int from = Integer.parseInt(st.nextToken());
//            int to = Integer.parseInt(st.nextToken());
//            int weight = Integer.parseInt(st.nextToken());
//            map[from][to] = weight;
//        }
//        //맥도날드
//        st = new StringTokenizer(br.readLine(), " ");
//        M = Integer.parseInt(st.nextToken());
//        x = Integer.parseInt(st.nextToken());
//        mv = new int[M];
//        st = new StringTokenizer(br.readLine(), " ");
//        for (int i = 0; i < M; i++) {
//            mv[i] = Integer.parseInt(st.nextToken());
//        }
//        //스벅
//        st = new StringTokenizer(br.readLine(), " ");
//        S = Integer.parseInt(st.nextToken());
//        y = Integer.parseInt(st.nextToken());
//        sv = new int[S];
//        st = new StringTokenizer(br.readLine(), " ");
//        for (int i = 0; i < S; i++) {
//            sv[i] = Integer.parseInt(st.nextToken());
//        }
//
//        //맥세권 찾기
//        ArrayList<Integer> macList = new ArrayList<>(); //맥세권인 정점 리스트
//        for (int i = 0; i < M; i++) {
//            ArrayList<Integer> tmp = find(mv[i]);
//            for (int t : tmp) {
//                if (macList.contains(t)) continue;
//                macList.add(t);
//            }
//        }
//        //스세권 찾기
//        ArrayList<Integer> starList = new ArrayList<>(); //맥세권인 정점 리스트
//        for (int i = 0; i < M; i++) {
//            ArrayList<Integer> tmp = find(mv[i]);
//            for (int t : tmp) {
//                if (starList.contains(t)) continue;
//                starList.add(t);
//            }
//        }
//        //맥세권이면서 스세권인 집 중 최단거리 합 최소인 집 찾기
//        for(int i = 0; i<macList.size(); i++){
//            for(int j = 0; j<starList.size(); j++){
//                if(macList.get(i))
//            }
//        }
//    }
//
//    static class Node implements Comparable<Node>{
//        int x,y,w;
//
//        public Node(int x, int y, int w) {
//            this.x = x;
//            this.y = y;
//            this.w = w;
//        }
//
//        @Override
//        public int compareTo(Node o) {
//            return this.w-o.w;
//        }
//    }
//
//    private static ArrayList<Integer> find(int start) { //맥도날드/스벅을 시작으로
//        ArrayList<Integer> res = new ArrayList<>();
//        PriorityQueue<Node> q = new PriorityQueue<>();
//        int[] v = new int[V+1];
//        q.offer(new Node(start,0,0));
//        v[start] = 1;
//        while(!q.isEmpty()){
//            Node cur = q.poll(); //current vertex
//            for(int i = 1; i<V+1; i++){
//                if(map[cur.x][i]>0){ //연결됨
//                    int sum = cur.w + map[cur.x][i];
//                    if(sum <= x){
//                        q.offer(new Node(i,0, sum));
//                        res.add(i);
//                    }
//                }
//            }
//        }
//        return res;
//    }
//}
