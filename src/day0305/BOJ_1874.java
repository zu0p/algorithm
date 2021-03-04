package day0305;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_1874 {
    static int n;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        StringBuilder sb = new StringBuilder();
        int i = 1, index = 0;
        while(i<=n+1){
            if(!stack.isEmpty() ){
                if(stack.peek() == arr[index]) {
                    stack.pop();
                    sb.append("-\n");
                    index++;
                }
                else if (stack.peek() < arr[index]) {
                    stack.push(i);
                    sb.append("+\n");
                    i++;
                }
                else if (stack.peek() > arr[index]) {
                    stack.pop();
                    sb.append("-\n");
                }
            }
            else {
                if(i<=n) {
                    stack.push(i);
                    sb.append("+\n");
                }
                i++;
            }
        }
        for(int j = index; j<n; j++){
            if(!stack.isEmpty()) {
                if (arr[index] == stack.pop()) continue;
                else{
                    sb.setLength(0);
                }
            }
            else{
                sb.setLength(0);
            }
        }

        if(sb.length()==0)
            System.out.println("NO");
        else
            System.out.println(sb.toString());
    }
}
