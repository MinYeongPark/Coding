import java.io.*;

public class Main {
    static int[] dp = new int[11];; // 메모이제이션할 배열
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int count = Integer.parseInt(br.readLine()); // 입력할 숫자들 개수
        for (int i = 0; i < count; i++) {
            int input = Integer.parseInt(br.readLine()); // 정수
            bw.write(String.format("%d\n", tile(input)));
        }

        bw.flush();
    }

    static int tile(int input) {
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i <= input; i++) {
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }
        return dp[input];
    }
}
