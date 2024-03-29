import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        int[] dp = new int[input + 1];
        dp[0] = 0;
        dp[1] = 1;
        
        int min;
        
        for (int i = 2; i <= input; i++) {
            min = Integer.MAX_VALUE;
            for (int j = 1; j*j <= i; j++) {
                min = Math.min(dp[i - j * j], min);
            }
            dp[i] = min + 1;
        }

        System.out.println(dp[input]);
    }
}