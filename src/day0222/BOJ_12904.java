package day0222;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_12904 {
    static boolean isTo = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String from = br.readLine();
        String to = br.readLine();

        bfs(from, to);
        if(isTo) System.out.println(1);
        else System.out.println(0);
    }
    public static void bfs(String from, String to){
        if(to.equals(from)){
            isTo = true;
            return;
        }
        int max = from.length();
        Queue<String> q = new LinkedList<>();
        q.add(to);
        while(!q.isEmpty()){
            String cur = q.poll();
            char c = cur.charAt(cur.length()-1);
            String prev = "";
            if(c=='A'){
                // A 제거
                prev = cur.substring(0,cur.length()-1);
            }
            else if(c=='B'){
                String tmp = cur.substring(0,cur.length()-1);
                for(int i = tmp.length()-1; i>=0; i--){
                    prev += tmp.charAt(i);
                }
            }
            if(prev.equals(from)){
                isTo = true;
                return;
            }
            if(prev.length()<max){
                return;
            }
            q.offer(prev);
        }
    }
}
