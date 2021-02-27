package day0227;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16953 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int res = -1;
        int cnt = 1;
        while(b>=a){
            if(b == a) {
                res = 0;
                break;
            }

            if(b%2 == 0){
                cnt++;
                b /= 2;
            }
            else{
                if(b%10 != 1){
                    res = -1;
                    break;
                }
                else{
                    cnt++;
                    b/=10;
                }
            }
        }

        if(res == 0)
            System.out.println(cnt);
        else {
            System.out.println(res);
        }
    }
}
