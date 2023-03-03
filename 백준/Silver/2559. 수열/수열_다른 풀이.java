// 2023-03-04 풀이
// 부분합 바로 적용해서 푼 코드인데 예전에 푼 코드가 더 효율이 좋았던 탓에 이 코드는 안 올라가서 따로 업로드했습니다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i-1] + Integer.parseInt(st.nextToken());
        }

        int max = sum[k] - sum[0];
        for (int i = k+1; i <= n; i++) {
            max = Math.max(max, sum[i] - sum[i-k]);
        }
        System.out.println(max);
    }
}
