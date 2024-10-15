/*
 * @author Minyeong Park
 * @date 2024.10.15.
 * 1로 만들기
 * '이것이 코딩테스트다' Chap08 다이나믹 프로그래밍 - 실전 문제 2
 * 살짝 지저분하게 풀어서 조금 다듬음
 */

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        int[] dp = new int[x + 1];

        for (int i = 2; i <= x; i++) {
            dp[i] = dp[i-1] + 1;
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i/2] + 1, dp[i]);
            }
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i/3] + 1, dp[i]);
            }
            if (i % 5 == 0) {
                dp[i] = Math.min(dp[i/5] + 1, dp[i]);
            }
        }
        System.out.println(dp[x]);
    }
}