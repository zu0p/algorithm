package day0331;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_싸이버개강총회 {
    static String S,E,Q;
    static class Time implements Comparable<Time>{
        int hour, min;

        public Time(int hour, int min) {
            this.hour = hour;
            this.min = min;
        }

        @Override
        public int compareTo(Time o) {
            int diff = this.hour-o.hour;
            return diff!=0?diff:this.min-o.min;
        }

        @Override
        public String toString() {
            return "Time{" +
                    "hour=" + hour +
                    ", min=" + min +
                    '}';
        }
    }
    static Time start,end,quit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        S = st.nextToken();
        start = stringToTime(S);
        E = st.nextToken();
        end = stringToTime(E);
        Q = st.nextToken();
        quit = stringToTime(Q);

        HashSet<String> before = new HashSet<>();
        HashSet<String> after = new HashSet<>();

        int cnt = 0;
        String read=null;
        while((read = br.readLine()) != null) {
            String tmp[] = read.split(" ");
            Time now = stringToTime(tmp[0]);
            if(now.compareTo(start)<=0){
                // 개총 시작 전 입장
                before.add(tmp[1]);
            }
            else if(now.compareTo(end)>=0 && now.compareTo(quit)<=0){
                // 개총 끝 ~ 스트리밍 끝
                if(before.contains(tmp[1]))
                    after.add(tmp[1]);
            }
        }


        System.out.println(after.size());
    }

    private static Time stringToTime(String str){
        String[] arr = str.split(":");
        int[] res = new int[2];
        for(int i = 0; i<2; i++){
            res[i] = (arr[i].charAt(0)-'0')*10 + (arr[i].charAt(1)-'0');
        }

        return new Time(res[0], res[1]);
    }
}
