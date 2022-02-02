import java.io.*;

public class Main {
    static int[] dp; // 메모이제이션할 배열
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int input = Integer.parseInt(br.readLine()); // 정수
        dp = new int[input+1];

        bw.write(String.format("%d", make(input)));
        bw.flush();
    }

    static int make(int n) {
        if (n == 1) {    //정수가 1이라면 횟수는 0번
            return 0;
        }
        if (dp[n] > 0) { //정수가 이미 dp배열에 있다면 이미 계산한 값이다
            return dp[n];
        }

        int r1 = Integer.MAX_VALUE; // 2로 나눌 때의 횟수
        int r2 = Integer.MAX_VALUE; // 3으로 나눌 때의 횟수
        int r3;                     // 1을 뺄 때의 횟수

        if (n % 3 == 0) {
            r1 = make(n/3) + 1;
        }

        if (n % 2 == 0) {
            r2 = make(n/2) + 1;
        }

        r3 = make(n-1) + 1;

        return dp[n] = Math.min(r1, Math.min(r2, r3));
    }
}
