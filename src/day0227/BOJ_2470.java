package day0224;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class BOJ_2470 {
    static int n;
    static Long[] input;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        input = new Long[n];

        String[] tmp = br.readLine().split(" ");
        for(int i = 0; i<n; i++){
            input[i] = Long.parseLong(tmp[i]);
        }

        Arrays.sort(input);
        
        int left = 0;
        int right = input.length-1;
        long min = Long.MAX_VALUE;
        long[] res = new long[2];
        while(left<right){
            if(min>Math.abs(input[left]+input[right])){
                min = Math.abs(input[left]+input[right]);
                res[0] = input[left];
                res[1] = input[right];
            }
            if(Math.abs(input[left]+input[right-1])<Math.abs(input[left+1]+input[right])){
                right--;
            }
            else{
                left++;
            }
        }
        Arrays.sort(res);
        System.out.println(res[0]+" "+res[1]);
    }
}
