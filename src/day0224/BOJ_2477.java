package day0224;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class BOJ_2477 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());

        int max = -1;
        int[] nums = new int[6];
        for(int i = 0; i<6; i++){
            String[] tmp = br.readLine().split(" ");
            int dir = Integer.parseInt(tmp[0]);
            int num = Integer.parseInt(tmp[1]);
            max = Math.max(max, num);
            nums[i] = num;
        }
        int big = 1;
        for(int i = 0; i<6; i++){
            if(max == nums[i]){
                int index = nums[(i+6-1)%6]>nums[(i+6+1)%6] ? (i+6-1)%6 : (i+6+1)%6;

                big = nums[i]*nums[index];
                nums[i] = -1;
                nums[index] = -1;
            }
        }
        int small = 1;
        for(int i = 0; i<6; i++){
            if(nums[i] == -1)continue;
            if(nums[(i+6-1)%6]!= -1 && nums[(i+6+1)%6]!=-1){
                small *= nums[i];
            }
        }

        System.out.println((big-small)*k);
    }
}
