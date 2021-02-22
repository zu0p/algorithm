package day0222;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class BOJ_13300 {
    static int n, k;
    static ArrayList<Student> students;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        n = Integer.parseInt(tmp[0]);
        k = Integer.parseInt(tmp[1]);
        students = new ArrayList<>();

        for(int i = 0; i<n; i++){
            tmp = br.readLine().split(" ");
            int s = Integer.parseInt(tmp[0]);
            int y = Integer.parseInt(tmp[1]);
            students.add(new Student(s,y));
        }
        Collections.sort(students);

        int cnt = 1, room = 1;
        Student pre = students.get(0);
        for(int i = 1; i<students.size(); i++){
            Student cur = students.get(i);
            if(cur.s == pre.s){
                if(cur.y==pre.y){
                    if(cnt+1<=k){
                        cnt++;
                    }
                    else{
                        cnt = 1;
                        room++;
                    }
                }
                else{
                    cnt = 1;
                    room++;
                }
            }
            else{
                cnt = 1;
                room++;
            }
            pre = cur;
        }
        System.out.println(room);
    }
}
class Student implements Comparable<Student>{
    int s,y;

    public Student(int s, int y) {
        this.s = s;
        this.y = y;
    }

    @Override
    public int compareTo(Student o) {
        int diff = s-o.s;
        return diff==0?y-o.y:diff;
    }

    @Override
    public String toString() {
        return "Student{" +
                "s=" + s +
                ", y=" + y +
                '}';
    }
}
