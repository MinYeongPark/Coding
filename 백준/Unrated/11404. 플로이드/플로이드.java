import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] d = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(d[i], Integer.MAX_VALUE);
        }
        for (int i = 1; i <= n; i++) {
            d[i][i] = 0;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            d[a][b] = Math.min(d[a][b], c);
        }

        for (int k = 1; k <= n; k++) {
            for (int s = 1; s <= n; s++) {
                for (int e = 1; e <= n; e++) {
                    if (d[s][k] + d[k][e] >= 0) {
                        d[s][e] = Math.min(d[s][e], d[s][k] + d[k][e]);
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (d[i][j] == Integer.MAX_VALUE) {
                    sb.append(0 + " ");
                } else {
                    sb.append(d[i][j] + " ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}