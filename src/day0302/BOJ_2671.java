package day0302;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2671 {
    static String in;
//    static int size;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        in = br.readLine();

        if(in.matches("^(100+1+|01)+")) {
            System.out.println("SUBMARINE");
        }else {
            System.out.println("NOISE");
        }
//        size = in.length();
//        boolean isMarine = true;
//        if(in.charAt(size-1)=='0'){
//            isMarine = false;
//            print(0);
//        }
//        else{
//            int i = 0;
//            while(i<size){
//                char prev=in.charAt(i);
//                char cur = in.charAt(i+1);
//                boolean a = isStart1(prev, cur);
//                if(a){
//                    int j=find(i+2, '0');
//                    if(j==-1){
//                        isMarine = false;
//                        print(0);
//                        break;
//                    }
//                    int k=find(j+1,'1');
//                    if(k==-1){
//                        isMarine = false;
//                        print(0);
//                        break;
//                    }
//                    i = k;
//                }
//                else{
//                    if(prev==cur){
//                        //00
//                        if(i-1>=0 && in.charAt(i-1)=='1'){
//                            if(i-2>=0 && in.charAt(i-2)=='1'){
//                                i-=2;
//                            }
//                            else{
//                                isMarine=false;
//                                print(0);
//                                break;
//                            }
//                        }
//                        else{
//                            isMarine=false;
//                            print(0);
//                            break;
//                        }
//                    }
//                    else {
//                        //01
//                        if (prev != '0' || cur != '1') {
//                            isMarine = false;
//                            print(0);
//                            break;
//                        }
//                        i++;
//                    }
//                }
//                i++;
//            }
//        }
//
//        if(isMarine)
//            print(1);
    }

//    private static int find(int i, char target) {
//        while(i<size){
//            if(in.charAt(i)==target){
//                if(i+1<size && in.charAt(i+1)==target){
//                    i++;
//                    continue;
//                }
//                else return i;
//            }
//            else{
//                return -1;
//            }
//        }
//        return -1;
//    }
//
//    private static boolean isStart1(char prev, char cur) {
//        return prev=='1' && cur=='0';
//    }
//
//
//    private static void print(int i) {
//        if(i==0)
//            System.out.println("NOISE");
//        else
//            System.out.println("SUBMARINE");
//    }
}
