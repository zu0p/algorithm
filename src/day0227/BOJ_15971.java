package day0227;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_15971 {
    static int n, r1, r2;
    static Vector<int[]>[] v;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        r1 = Integer.parseInt(st.nextToken());
        r2 = Integer.parseInt(st.nextToken());
        v = new Vector[n+1]; //0:dummy
        visited = new boolean[n+1];

        for(int i = 0; i<n-1; i++){
            st = new StringTokenizer(br.readLine()," ");
            int tmp1 = Integer.parseInt(st.nextToken());    // 방1
            int tmp2 = Integer.parseInt(st.nextToken());    // 방2
            int tmp3 = Integer.parseInt(st.nextToken());    // 통로 길이

            if(v[tmp1]==null)
                v[tmp1] = new Vector<>();
            if(v[tmp2]==null)
                v[tmp2] = new Vector<>();
            v[tmp1].add(new int[]{tmp2, tmp3});
            v[tmp2].add(new int[]{tmp1, tmp3});
        }

        visited[r1] = true;
        if(r1!=r2)
            findLine(r1,0,-1,0);

        if(result==-1)
            result = 0;

        System.out.println(result);
    }

    static int result = -1;
    private static boolean findLine(int num, int sum, int max, int cnt) {

        if(num == r2){
            if(cnt!=1)
                result = sum-max;
            return true;
        }

        for(int i = 0; i<v[num].size(); i++){
            if(visited[v[num].get(i)[0]])continue;
            visited[v[num].get(i)[0]] = true;
            int next = v[num].get(i)[0];
            int length = v[num].get(i)[1];

            if(findLine(next, sum+length, Math.max(max, length), cnt+1))
                return true;
        }

        return false;
    }
}
