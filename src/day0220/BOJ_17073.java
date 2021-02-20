package day0220;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

// 리프 노드의 개수만 구하면 됨!!
public class BOJ_17073 {
    static int n,w;
    static Vector<Integer>[] vector = new Vector[500001];
    static int visited[] = new int[500001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        w = Integer.parseInt(input[1]);

        for(int i = 0; i<n-1; i++){
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0])-1;
            int b = Integer.parseInt(input[1])-1;

            if(vector[a] == null)
                vector[a] = new Vector<>();
            if(vector[b] == null)
                vector[b] = new Vector<>();

            vector[a].add(b);
            vector[b].add(a);
        }

        int cnt = 0;
        Queue<Integer> q = new LinkedList<>();

        visited[0] = 1;
        q.offer(0);
        while(!q.isEmpty()){
            int cur = q.poll();
            boolean flag = false;
            for(int i = 0; i<vector[cur].size(); i++){
                int next = vector[cur].get(i);
                if(visited[next]==1)continue;
                visited[next] = 1;
                q.offer(next);
                flag = true;
            }
            if(!flag) cnt++;
        }

        System.out.println(String.format("%.11f",(double)w/cnt));
    }
}
