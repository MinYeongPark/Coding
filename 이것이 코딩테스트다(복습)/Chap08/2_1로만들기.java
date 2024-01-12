/*
 * @author Minyeong Park
 * @date 2024.01.12.
 * 1로 만들기(스스로 풀어서 맞았긴 하지만 코드가 지저분해서 해설 보고 코드 더 깔끔하게 정리함)
 * '이것이 코딩테스트다' Chap08 다이나믹 프로그래밍 - 실전 문제 2
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        int[] dp = new int[30001];
        for (int i = 2; i <= x; i++) {
            dp[i] = dp[i - 1] + 1;
            if (i % 5 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 5] + 1);
            }
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }

        }
        System.out.println(dp[x]);
    }
}