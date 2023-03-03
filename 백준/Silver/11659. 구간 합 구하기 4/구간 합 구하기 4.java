import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] s = new int[n+1];

        for (int i = 1; i <= n; i++) {
            s[i] = s[i-1] + Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        for (int line = 0; line < m; line++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            sb.append(s[j] - s[i-1]).append("\n");
        }
        System.out.println(sb);
    }
}
