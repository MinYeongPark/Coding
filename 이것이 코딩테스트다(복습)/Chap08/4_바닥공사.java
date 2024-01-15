/*
 * @author Minyeong Park
 * @date 2024.01.15.
 * 바닥 공사(내 힘으로 해결 못해서 해설 보고 이해..)
 * '이것이 코딩테스트다' Chap08 다이나믹 프로그래밍 - 실전 문제 4
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[1001];
        dp[1] = 1;
        dp[2] = 3;
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i-2] * 2 + dp[i-1]) % 796796;
        }
        System.out.println(dp[n]);
    }
}