package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11723 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int mask = 0;

        for(int tc = 0; tc<t; tc++){
            String[] read = br.readLine().split(" ");
            String oper = read[0];
            int num = 0;

            switch (oper) {
                case "add":
                    num = Integer.parseInt(read[1])-1;
                    mask |= 1<<num;
                    break;
                case "remove":
                    num = Integer.parseInt(read[1])-1;
                    mask &= ~(1<<num);
                    break;
                case "check":
                    num = Integer.parseInt(read[1])-1;
                    if((mask&1<<num)!=0){ // 있으면
                        sb.append(1+"\n");
                    }
                    else{
                        sb.append(0+"\n");
                    }
                    break;
                case "toggle":
                    num = Integer.parseInt(read[1])-1;
                    mask ^= 1<<num;
                    break;
                case "all":
                    mask |= ~0;
                    break;
                case "empty":
                    mask &= 0;
                    break;
            }
        }
        System.out.println(sb.toString());
        br.close();
    }
}
