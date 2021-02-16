package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BOJ_1931 {
    static class Meeting implements Comparable<Meeting>{
        int start, end;
        public Meeting(int start, int end){
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Meeting o) {
            int diff = this.end-o.end;
            return diff!=0?diff:this.start-o.start;
        }
    }
    static int n;
    static Meeting[] m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        m = new Meeting[n];
        for(int i = 0; i<n; i++){
            String[] tmp = br.readLine().split(" ");
            int s = Integer.parseInt(tmp[0]);
            int e = Integer.parseInt(tmp[1]);
            m[i] = new Meeting(s, e);
        }
        System.out.println(cntMeeting());
    }

    static int cntMeeting(){
        int cnt = 1;
        Arrays.sort(m);
        int cur = m[0].end;
        for(int i = 1; i<m.length; i++){
            if(cur<=m[i].start){
                cnt++;
                cur = m[i].end;
            }
        }
        return cnt;
    }
}
