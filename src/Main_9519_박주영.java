import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_9519_박주영 {
    static int n;
    static char[] in;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String origin = br.readLine();
        in = origin.toCharArray();

        if(in.length <= 2){
            System.out.println(origin);
            return;
        }

        int mid = in.length/2;
        if(in.length%2==1)
            mid+=1;
        int cnt = 0;
        char[] tmp = origin.toCharArray();
        ArrayList<String> list = new ArrayList<>();
        list.add(origin);
        while(true){
            String step = solve(mid, tmp);
            tmp = step.toCharArray();
            cnt++;
            if(step.equals(origin)){
                break;
            }
            list.add(step);
        }
        //System.out.println(cnt);

        n %= cnt;
        in = list.get(n).toCharArray();

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<in.length; i++){
            sb.append(in[i]);
        }

        System.out.println(sb.toString());
    }

    private static String solve(int size, char[] arr) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for(int i = 0; i<size; i++){
            sb1.append(arr[i*2]);
            if(i*2+1<arr.length)
                sb2.insert(0,arr[i*2+1]);
        }
        //System.out.println(sb1.toString() + " " + sb2.toString());
        return sb1.append(sb2).toString();
    }
}
