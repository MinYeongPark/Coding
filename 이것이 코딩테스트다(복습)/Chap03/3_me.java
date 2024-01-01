/*
 * @author Minyeong Park
 * @date 2024.01.01.
 * 숫자 카드 게임(내가 푼 것)
 * '이것이 코딩테스트다' Chap03 그리디 - 실전 문제 3
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int max = -1;
        for (int i = 0; i < n; i++) {
            int low_min = 10001;
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int now = Integer.parseInt(st.nextToken());
                if (now < low_min) {
                    low_min = now;
                }
            }
            if (low_min > max) {
                max = low_min;
            }
        }
        System.out.println(max);
    }
}