package day0326;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_부분문자열 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String P = br.readLine();

        System.out.println(kmp(S,P));

    }

    public static int kmp(String str, String pattern) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int[] pi = getPi(pattern);

        int n = str.length(), m = pattern.length(), j = 0;
        char[] s = str.toCharArray();
        char[] p = pattern.toCharArray();

        for (int i = 0; i < n; i++) {
            while (j > 0 && s[i] != p[j]) {
                j = pi[j - 1];
            }
            if (s[i] == p[j]) {
                if (j == m - 1) {
                    list.add(i - m + 1);
                    j = pi[j];
                } else {
                    j++;
                }
            }
        }

        return list.size()>0?1:0;
    }

    public static int[] getPi(String pattern) {
        int m = pattern.length();
        int j = 0;
        char[] p = new char[m];
        int[] pi = new int[m];

        p = pattern.toCharArray();
        for (int i = 1; i < m; i++) {
            while (j > 0 && p[i] != p[j]) {
                j = pi[j - 1];
            }
            if (p[i] == p[j]) {
                pi[i] = ++j;

            }

        }
        return pi;
    }
}
