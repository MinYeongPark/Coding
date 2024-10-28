/*
 * @author Minyeong Park
 * @date 2024.10.28.
 * 퇴사 2
 * https://www.acmicpc.net/problem/15486
 */

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        int[] dp = new int[n + 1];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            dp[i + 1] = Math.max(dp[i], dp[i + 1]);

            if (i + t > n) continue;
            dp[i + t] = Math.max(dp[i + t], dp[i] + p);
        }

        System.out.println(dp[n]);
    }
}
