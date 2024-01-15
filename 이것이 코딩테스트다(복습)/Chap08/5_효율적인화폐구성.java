/*
 * @author Minyeong Park
 * @date 2024.01.15.
 * 효율적인 화폐 구성(막혀서 해설 보고 이해했다..)
 * '이것이 코딩테스트다' Chap08 다이나믹 프로그래밍 - 실전 문제 5
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] coin = new int[n];
        int[] dp = new int[10001];
        Arrays.fill(dp, 10001);
        for (int i = 0; i < n; i++) {
            coin[i] = Integer.parseInt(br.readLine());
            dp[coin[i]] = 1;
        }

        dp[0] = 0;
        for (int unit : coin) { // 모든 화폐 단위에 대해
            for (int i = unit; i <= m; i++) {
                if (dp[i - unit] != 10001) { // 방법이 존재하는 경우
                    dp[i] = Math.min(dp[i - unit] + 1, dp[i]);
                }
            }
        }

        if (dp[m] == 10001) {
            System.out.println(-1);
        } else {
            System.out.println(dp[m]);
        }
    }
}