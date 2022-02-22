/*
 * @author Minyeong Park
 * @date 2022.02.17. & 20. & 21. & 22.
 * 스티커
 * https://www.acmicpc.net/problem/9465
 */


import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        int t = Integer.parseInt(br.readLine()); // 입력 케이스 개수 T
        int n; // 각 케이스 별 n의 값
        int array[][]; // 각 케이스 별 스티커 배열
        int dp[][]; //각 케이스 별 최대 점수 값 저장
        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());

            array = new int[2][n+1];
            dp = new int[2][n+1];

            st = new StringTokenizer(br.readLine()); //1번째 열
            for (int j = 1; j < n+1; j++) {
                array[0][j] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine()); //2번째 열
            for (int j = 1; j < n+1; j++) {
                array[1][j] = Integer.parseInt(st.nextToken());
            }

            dp[0][1] = array[0][1];
            dp[1][1] = array[1][1];

            for (int j = 2; j < n+1; j++) {
                dp[0][j] = Math.max(dp[1][j-1], dp[1][j-2]) + array[0][j];
                dp[1][j] = Math.max(dp[0][j-1], dp[0][j-2]) + array[1][j];
            }

            bw.write(String.format("%d\n", Math.max(dp[0][n], dp[1][n])));
        }

        bw.flush();
    }
}