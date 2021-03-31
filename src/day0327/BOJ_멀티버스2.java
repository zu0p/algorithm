package day0327;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_멀티버스2 {
    static int N, M;
    static class Node implements Comparable<Node>{
        int id, val;

        public Node(){}
        public Node(int id, int val) {
            this.id = id;
            this.val = val;
        }

        @Override
        public int compareTo(Node o) {
            return this.val-o.val;
        }
    }
    static HashMap<String,Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());//우주 개수
        N = Integer.parseInt(st.nextToken());//행성 개수
        String idxs[] = new String[M] ;

        Node[] universal = new Node[N];
        for(int i = 0 ;i<M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int id = 0;
            for(int j = 0; j<N; j++){
                int val = Integer.parseInt(st.nextToken());
                universal[j] = new Node(id++, val);
            }
            Arrays.sort(universal);
            idxs[i] = "";
            for(int j = 0; j<N; j++){
                idxs[i] += universal[j].id;
            }
            if(map.containsKey(idxs[i]))
                map.put(idxs[i], map.get(idxs[i])+1);
            else
                map.put(idxs[i], 1);
        }

        int total = 0;
        for(String key: map.keySet()){
            total += map.get(key)/2;
        }

        System.out.println(total);
    }

}
