package day0316;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1759 {
    static int L,C;
    static char[] input;
    static boolean[] v;
    static char[] res;
    static ArrayList<String>list;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        input = new char[C];
        v = new boolean[C];
        res = new char[L];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i<C; i++){
            input[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(input);

        list = new ArrayList<>();
        permu(0, input[0]);

        sb.setLength(0);
        for(String s: list){
            sb.append(s+"\n");
        }
        System.out.println(sb.toString());
        br.close();
    }

    private static void permu(int cnt, char pre) {
        if(cnt == L){
            int aCnt = 0, bCnt = 0;
            sb.setLength(0);
            for(int i = 0; i<res.length; i++){
                if(res[i]=='a'||res[i]=='e'||res[i]=='i'||res[i]=='o'||res[i]=='u')
                    aCnt++;
                else bCnt++;
                sb.append(res[i]);
            }

            if(aCnt>=1 && bCnt>=2)
                list.add(sb.toString());
            return;
        }

        for(int i = 0; i<C; i++){
            if(v[i]) continue;
            v[i] = true;
            res[cnt] = input[i];
            if(pre<=res[cnt])
                permu(cnt+1, res[cnt]);
            v[i] = false;
        }
    }
}
