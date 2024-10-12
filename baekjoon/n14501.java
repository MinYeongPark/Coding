/*
 * @author Minyeong Park
 * @date 2024.10.12.
 * 퇴사
 * https://www.acmicpc.net/problem/14501
 * 참고 : https://hidelookit.tistory.com/118
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
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            times[i] = Integer.parseInt(st.nextToken());
            costs[i] = Integer.parseInt(st.nextToken());
        }

        // 앞에서부터 진행하는 방식으로 풀기
        int[] dp = new int[n + 1]; // 마지막날이 1일 소요인 경우는 next = n 이므로 dp 배열 크기를 n + 1 로 설정함
        for (int i = 0; i < n; i++) {
            int next = i + times[i]; // i일부터 시작하는 상담을 끝낸 이후 날짜

            // i일부터 시작하는 상담이 퇴사 이전 기간 안에 끝나는 경우
            if (next <= n) {
                dp[next] = Math.max(
                        dp[next], // i일의 상담을 진행하지 않는 경우
                        dp[i] + costs[i] // i일의 상담을 진행하는 경우
                );
            }

            dp[i+1] = Math.max(
                    dp[i+1], // i+1일에 벌어들이는 수익이
                    dp[i]    // 전날까지의 수익(dp[i]의 값)이 더 큰지 비교해서 더 큰 값을 보내주어야 한다.
            );
        }
        System.out.println(dp[n]);
    }
}