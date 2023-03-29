import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[][] dp = new int[11][11];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        for (int i = 0; i < 11; i++) {
            dp[i][0] = 1;
        }
        System.out.println(combi(n, k));
    }

    static int combi(int i, int j) {
        if (i < j || j < 0) {
            return 0;
        }
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        return dp[i][j] = combi(i-1, j-1) + combi(i-1, j);
    }
}