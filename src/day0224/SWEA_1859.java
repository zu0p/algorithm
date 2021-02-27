package day0224;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1859 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int tc = 1; tc<=t; tc++){
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String[] tmp = br.readLine().split(" ");
            for(int i = 0; i<n; i++){
                arr[i] = Integer.parseInt(tmp[i]);
            }

            long ans = 0;
            long cnt = 0, buy = 0;
            for(int i = 0; i<n; i++){
                boolean isMax = true;
                for(int j = i+1; j<n; j++){
                    if(arr[i]<arr[j]){
                        isMax = false;
                        break;
                    }
                }
                if(isMax){
                    // 팔기
                    if(cnt>0){
                        ans += cnt*arr[i] - buy;
                        cnt = 0;
                        buy = 0;
                    }
                }
                else{
                    // 사기
                    buy += arr[i];
                    cnt++;
                }
            }

            System.out.println("#"+tc+" "+ans);
        }
    }
}
