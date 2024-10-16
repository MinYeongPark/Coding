/*
 * @author Minyeong Park
 * @date 2024.10.16.
 * 바닥 공사
 * '이것이 코딩테스트다' Chap08 다이나믹 프로그래밍 - 실전 문제 4
 * 나머지로 출력하는 것 깜빡해서 해설 보고 채워넣음..!! 문제 꼼꼼히 읽자
 */

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 3;
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i-2] * 2 + dp[i-1]) % 796796;
        }
        System.out.println(dp[n]);
    }
}
