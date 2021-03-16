import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_13904_박주영 {
    static int n;
    static Homework[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new Homework[n];
        int maxDate = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            arr[i] = new Homework(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            if (maxDate < arr[i].date)
                maxDate = arr[i].date;
        }

        int sum = 0;
        while(maxDate>0) {
            int max = -1;
            for (int i = 0; i < n; i++) {
                if (arr[i].date >= maxDate) {
                    if (arr[i].score > max) {
                        max = arr[i].score;
                    }
                }
            }
            sum += max;
            maxDate--;
        }
        System.out.println(sum);
    }
}
class Homework{
    int date, score;

    public Homework(int date, int score) {
        this.date = date;
        this.score = score;
    }
}
