package day0331;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_추월 {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        HashMap<String, Integer> mapin = new HashMap<>();
        for(int i = 0; i<N; i++){
            mapin.put(br.readLine(),i);
        }
        int[] out = new int[N];
        for(int i = 0; i<N; i++){
            out[i] = mapin.get(br.readLine());
        }

        int cnt = 0;
        for(int i=0; i<N-1; i++) {
            for(int j=i+1; j<N; j++) {
                if(out[i]>out[j]) {
                    cnt++;
                    break;
                }
            }
        }
        System.out.println(cnt);
    }
}
