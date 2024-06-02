import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        String[] names = new String[n + 1];
        int[] next = new int[n + 1]; // 다음에 연결할 곳
        int[] tail = new int[n + 1]; // 마지막 지점
        int m = -1, k;

        for (int i = 1; i <= n; i++) {
            names[i] = br.readLine();
            tail[i] = i;
        }

        for (int t = 0; t < n - 1; t++) {
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            // 예제)
            // 2->3, 1->2, 4->5, 1->4 에서
            // 1 23 4 5
            // 123 4 5
            // 123 45
            // 12345
            next[tail[m]] = k; // 'm의 끝' 다음에 와야 하는 게, 'k'라고 연결
            tail[m] = tail[k]; // m의 끝이 즉 k의 끝이라고 (연결되었다고) 명시
        }

        StringBuilder sb = new StringBuilder();
        while (m != 0) {
            sb.append(names[m]);
            m = next[m];
        }
        System.out.println(sb);
    }
}