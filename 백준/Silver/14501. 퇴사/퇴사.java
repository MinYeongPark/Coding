/*
 * @author Minyeong Park
 * @date 2024.10.12.
 * 퇴사
 * https://www.acmicpc.net/problem/14501
 */

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] times = new int[n];
        int[] costs = new int[n];
        int maxValue = 0; // 뒤에서부터 계산할 때, 현재까지의 최대 상담 금액
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            times[i] = Integer.parseInt(st.nextToken());
            costs[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n + 1]; // 마지막날이 1일 소요인 경우는 next = n 이므로 dp 배열 크기를 n + 1 로 설정함
        for (int i = n - 1; i >= 0; i--) {
            int next = i + times[i]; // i일부터 시작하는 상담을 끝낸 이후 날짜

            // i일부터 시작하는 상담이 퇴사 이전 기간 안에 끝나는 경우
            if (next <= n) {
                // 점화식에 맞게, 현재까지의 최고 이익 계산
                dp[i] = Math.max(
                        costs[i] + dp[next], // i일의 상담을 진행하는 경우
                        maxValue             // i일의 상담을 진행하지 않는 경우
                );
                maxValue = dp[i];
            } else {
                dp[i] = maxValue;
            }
        }
        System.out.println(maxValue);
    }
}