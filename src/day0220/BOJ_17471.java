package day0220;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_17471 {
    static Vector<Integer>[] v;
    static int[] p; // 인구수
    static boolean[] visited;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        v = new Vector[n];
        p = new int[n];
        visited = new boolean[n];

        String[] input = br.readLine().split(" ");
        for(int i = 0; i<n; i++){
            p[i] = Integer.parseInt(input[i]);
        }

        for(int i = 0; i<n; i++){
            input = br.readLine().split(" ");
            int k = Integer.parseInt(input[0]);
            v[i] = new Vector();
            for(int j = 1; j<=k; j++){
                v[i].add(Integer.parseInt(input[j])-1);
            }
        }

        int res = subset(1<<n);
        System.out.println(res);
    }

    static int subset(int cnt){
        int min = Integer.MAX_VALUE;
        boolean check = false;
        for(int flag = 1; flag<cnt-1; flag++){
            Arrays.fill(visited, false);
            int[] a = bfs(flag); // a 구역
            int[] b = bfs(~flag);// b 구역
            if(a[0] == -1 || b[0] == -1) continue;

            check = true;
            min = Math.min(min, Math.abs(a[1]-b[1]));
        }
        if(!check) return -1;
        return min;
    }

    private static int[] bfs(int num) {
        // 연결되어있는지 확인
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i<n; i++){
            if((num&1<<i)!=0){
                list.add(i);
            }
        }

        Queue<Integer> q = new LinkedList<>();
        visited[list.get(0)] = true;
        q.offer(list.get(0));

        int cnt = 1, sum = p[list.get(0)];
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int i = 0; i<v[cur].size(); i++){
                int next = v[cur].get(i);
                if(visited[next] || !list.contains(next)) continue;
                visited[next] = true;
                cnt++;
                sum += p[next];
                q.offer(next);
            }
        }

        if(cnt == list.size()) return new int[]{cnt, sum};

        return new int[]{-1,-1};
    }
}
