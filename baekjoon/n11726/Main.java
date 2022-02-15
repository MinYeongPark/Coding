import java.io.*;

public class Main {
    static int[] dp; // 메모이제이션할 배열
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int input = Integer.parseInt(br.readLine()); // 정수
        dp = new int[1001];

        bw.write(String.format("%d", tile(input)));
        bw.flush();
    }

    static int tile(int input) {
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= input; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 10007;
        }
        return dp[input];
    }
}
