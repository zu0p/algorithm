package day0222;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10163 {
    static int[][] map = new int[101][101];
    static Data[] input;
    static int[] res;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        input = new Data[n];
        res = new int[n];

        for(int i = 0; i<n; i++){
            String[] tmp = br.readLine().split(" ");
            int x = Integer.parseInt(tmp[0]);
            int y = Integer.parseInt(tmp[1]);
            int w = Integer.parseInt(tmp[2]);
            int h = Integer.parseInt(tmp[3]);
            input[i] = new Data(x,y,w,h);
        }

        for(int k = n-1; k>=0; k--){
            int cnt = 0;
            Data cur = input[k];
            for(int i = cur.y; i<cur.y+cur.h; i++){
                for(int j = cur.x; j<cur.x+cur.w; j++){
                    if(map[i][j] == 1) continue;
                    map[i][j] = 1;
                    cnt++;
                }
            }
            res[k] = cnt;
        }

        for(int i = 0; i<n; i++){
            System.out.println(res[i]);
        }
    }
}

class Data{
    int x,y;
    int w,h;

    public Data(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }
}