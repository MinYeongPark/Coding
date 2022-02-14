import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int input = Integer.parseInt(br.readLine()); //입력받는 수

        long[][] dp = new long[input+1][10];

        for (int i = 1; i < 10; i++) { // input이 1일 때의 값 초기화
            dp[1][i] = 1;
        }

        long result = 0;
        for (int i = 2; i <= input; i++) {
            dp[i][0] = dp[i-1][1] % 1000000000;
            dp[i][9] = dp[i-1][8] % 1000000000;

            for (int j = 1; j < 9; j++) {
                dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % 1000000000;
            }
//             //2번째 방법 (원리는 똑같음)
//            for (int j = 0; j < 10; j++) {
//                if (j==0) dp[i][j] = dp[i-1][j+1] % 1000000000;
//                else if (j==9) dp[i][j] = dp[i-1][j-1] % 1000000000;
//                else dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % 1000000000;
//            }
        }
        for (int i = 0; i < 10; i++) {
            result += dp[input][i];
        }

        bw.write(String.format("%d", result % 1000000000));
        bw.flush();
    }
}