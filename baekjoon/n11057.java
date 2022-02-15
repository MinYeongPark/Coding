/*
 * @author Minyeong Park
 * @date 2022.02.15.
 * 오르막 수
 * https://www.acmicpc.net/problem/11057
 */


import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int input = Integer.parseInt(br.readLine()); //입력받는 수

        int dp[][] = new int[input+1][10];

        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= input; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = j; k < 10; k++) {
                    dp[i][j] += dp[i-1][k];
                    dp[i][j] %= 10007;
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += dp[input][i];
        }
        bw.write(String.format("%d", sum % 10007));
        bw.flush();
    }
}