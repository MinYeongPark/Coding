// 백준 허브로 자동으로 올라간 게 예전에 푼 코드여서... 230321 스터디 과제로 푼 것은 따로 올렸습니다!
import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] a = new boolean[123456 * 2 + 1];
        Arrays.fill(a, true);
        a[0] = a[1] = false;
        for (int i = 2; i < Math.sqrt(123456 * 2 + 1); i++) {
            for (int j = i + i; j <= 123456 * 2; j = j + i) {
                a[j] = false;
            }
        }

        String input;
        StringBuilder sb = new StringBuilder();
        while (!(input = br.readLine()).equals("0")) {
            int n = Integer.parseInt(input);
            int cnt = 0;
            for (int i = n+1; i <= 2 * n; i++) {
                if (a[i])
                    cnt++;
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}
