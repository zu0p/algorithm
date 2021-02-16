package com.lecture;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ActivitySelection {
    static class Meeting implements Comparable<Meeting>{
        int start, end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "Meeting{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }

        @Override
        public int compareTo(Meeting o) {
            int diff = this.end - o.end;
            return diff!=0?diff:this.start-o.start;
        }
    }
    static Meeting[] m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        m = new Meeting[n];
        for(int i = 0; i<n; i++){
            String[] tmp = br.readLine().split(" ");
            m[i] = new Meeting(Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1]));
        }
        Arrays.sort(m);
        List<Meeting> list = getMeetingSchedule();
        for(Meeting mm: list){
            System.out.println(mm);
        }
    }

    private static List<Meeting> getMeetingSchedule() {
        List<Meeting> list = new ArrayList<>();
        list.add(m[0]);
        for(int i = 1, size = m.length; i<size; i++){
            if(list.get(list.size()-1).end<m[i].start){
                list.add(m[i]);
            }
        }
        return list;
    }
}
