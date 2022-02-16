/*
 * @author Minyeong Park
 * @date 2022.02.16.
 * 이친수
 * https://www.acmicpc.net/problem/2193
 */


import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int input = Integer.parseInt(br.readLine()); //입력받는 수

        long dp[] = new long[input+1]; // input이 90인 경우 값이 매우 커지므로 long 타입 배열로 설정
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= input; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }


        bw.write(String.format("%d", dp[input]));
        bw.flush();
    }
}