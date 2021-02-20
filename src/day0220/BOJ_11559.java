package day0220;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_11559 {
    static char[][] map = new char[12][6];
    static int[][] v;
    static int ans = 0;
    static ArrayList<int[]> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i<12; i++){
            map[i] = br.readLine().toCharArray();
        }

        while(true) {
            boolean isremove = false;
            v = new int[12][6];
            for (int i = 11; i >=0; i--) {
                for (int j = 0; j < 6; j++) {
                    if (map[i][j] == '.' || v[i][j] == 1) continue;
                    list = new ArrayList<>();
                    list.add(new int[]{i,j});
                    findPuyo(i, j, map[i][j]);

                    if (list.size() >= 4) {
                        isremove = true;
                        for (int[] p : list) {
                            map[p[0]][p[1]] = '.';
                        }
                    }
                }
            }
            if(!isremove) break;
            ans++;
            resetPuyo();
        }

        System.out.println(ans);
    }

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    // 터질 뿌요 찾기
    static void findPuyo(int i, int j, char c){
        v[i][j] = 1;
        for(int k = 0; k<4; k++){
            int ni = i+dx[k];
            int nj = j+dy[k];
            if(ni<0 || nj<0 || ni>=12 || nj>=6 || v[ni][nj]==1 || map[ni][nj]!=c) continue;

            list.add(new int[]{ni, nj});
            v[ni][nj] = 1;
            findPuyo(ni,nj,c);
        }
    }

    // 터진 후 뿌요 재 정렬
    static void resetPuyo(){
        for(int j= 0; j<6; j++){
            findChar(12-1, j);
        }
    }
    static void findChar(int i, int j){
        if(map[i][j] != '.'){
            int changeI = i;
            if(changeI+1<12) {
                while (changeI+1<12 && map[changeI+1][j] == '.') {
                    changeI++;
                }
                if(changeI!=i) {
                    map[changeI][j] = map[i][j];
                    map[i][j] = '.';
                }
            }
        }
        int ni = i-1;
        if(ni<0) return;
        findChar(ni, j);
    }
}
