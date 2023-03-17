import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] tree = new int[n];
        st = new StringTokenizer(br.readLine());
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, tree[i]);
        }

        int start = 0;
        int end = max;
        long result_h = 0;
        while (start <= end) {
            int temp_h = (start + end) / 2;
            long remainder = 0;
            for (int i = 0; i < n; i++) {
                remainder += Math.max(tree[i] - temp_h, 0);
            }

            if (remainder == m) {
                result_h = temp_h;
                break;
            } else if (remainder > m) {
                // 너무 많이 남았으므로 높이를 더 높여야 함
                result_h = temp_h; // 일단 결과값에 담음
                start = temp_h + 1;
            } else {
                // 적게 남았으므로 높이를 더 낮춰야 함
                end = temp_h - 1;
            }
        }
        System.out.println(result_h);
    }
}