/*
 * @author Minyeong Park
 * @date 2024.01.09.
 * 시각 (시간 내에 못 풀어서 해설 보고 이해..)
 * '이것이 코딩테스트다' Chap04 구현 - 예제 문제 4-2
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        for (int hour = 0; hour <= n; hour++) {
            for (int min = 0; min < 60; min++) {
                for (int sec = 0; sec < 60; sec++) {
                    if (check(hour, min, sec))
                        cnt++;
                }
            }
        }
        System.out.println(cnt);
    }

    static boolean check(int h, int m, int s) {
        if (h % 10 == 3 || m % 10 == 3 || m / 10 == 3 || s % 10 == 3 || s / 10 == 3) {
            return true;
        }
        return false;
    }
}