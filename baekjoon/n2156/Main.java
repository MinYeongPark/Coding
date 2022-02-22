/*
 * @author Minyeong Park
 * @date 2022.02.22.
 * 포도주 시식
 * https://www.acmicpc.net/problem/2156
 */


import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine()); // 포도잔 개수
        int[] array = new int[n+1]; // 포도주 양에 대한 배열
        int[] dp = new int[n+1]; // 포도주 합에 대한 메모이제이션 배열

        for (int i = 1; i <= n; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        if (n == 1) {
            bw.write(String.format("%d", array[1]));
            bw.flush();
            return;
        } else if (n == 2) {
            bw.write(String.format("%d", array[1] + array[2]));
            bw.flush();
            return;
        }

        // n >= 3 이후인 경우
        dp[1] = array[1];
        dp[2] = array[1] + array[2];
        for (int i = 3; i <= n; i++) {
                             //연속0번          //연속1번          //연속2번 마시는 경우
            dp[i] = Math.max(dp[i-1], Math.max(dp[i-2]+array[i], dp[i-3]+array[i-1]+array[i]));
        }
        bw.write(String.format("%d", dp[n]));
        bw.flush();
    }
}