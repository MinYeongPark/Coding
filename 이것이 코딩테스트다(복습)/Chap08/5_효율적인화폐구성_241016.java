/*
 * @author Minyeong Park
 * @date 2024.10.16.
 * 효율적인 화폐 구성
 * '이것이 코딩테스트다' Chap08 다이나믹 프로그래밍 - 실전 문제 5
 */

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[10001];
        Arrays.fill(dp, 10001);
//        for (int i = 0; i < n; i++) {
//            int num = arr[i];
//            dp[num] = 1;
//
//            for (int j = 1; j <= m; j++) {
//                if (j % num == 0) {
//                    dp[j] = Math.min(dp[j], dp[j-num] + 1);
//                }
//            }
//        }

        // 해설 참고해서 조금 더 깔끔하게 코드를 수정해보면 아래와 같다.
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            int num = arr[i];
            for (int j = num; j <= m; j++) { // num부터 시작하면 됨!
                dp[j] = Math.min(dp[j], dp[j-num] + 1);
            }
        }

        System.out.println(
                dp[m] == 10001 ? -1 : dp[m]
        );
    }
}
