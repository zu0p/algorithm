package day0316;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_Contact {
    static ArrayList<Integer>[] list;
    static int start;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        for(int tc = 1; tc<=10; tc++) {
            list = new ArrayList[101];
            st = new StringTokenizer(br.readLine(), " ");
            int size = Integer.parseInt(st.nextToken());
            start = Integer.parseInt(st.nextToken());

            for(int i = 0; i<101; i++){
                list[i] = new ArrayList<>();
            }
            st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0; i<size/2; i++){
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                if(!isExist(from, to))
                    list[from].add(to);
            }


            System.out.println("#"+tc+" "+bfs());
        }
    }
    private static boolean isExist(int idx, int target){
        for(int i = 0; i<list[idx].size(); i++){
            if(list[idx].get(i)==target)
                return true;
        }
        return false;
    }

    private static int bfs() {
        Queue<Integer> q = new LinkedList<>();
        int visited[] = new int[101];
        q.add(start);
        visited[start]++;
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int i = 0; i<list[cur].size(); i++){
                if(visited[list[cur].get(i)]>0)continue;
                visited[list[cur].get(i)] = visited[cur]+1;
                q.offer(list[cur].get(i));
            }
        }

        int max = -1;
        int idx = 0;
        for(int i = 0; i< visited.length; i++){
            if(max<=visited[i]){
                max = visited[i];
                if(idx<i)
                    idx = i;
            }
        }
        return idx;
    }
}