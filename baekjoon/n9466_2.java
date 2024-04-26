import java.util.*;
import java.io.*;

public class Main {
    static final int NOT_VISITED = 0;
    static final int IN_CYCLE = -1;
    static int n;
    static int[] select, state;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < t; tc++) {
            n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            select = new int[n + 1];
            state = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                select[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= n; i++) {
                if (state[i] == 0) run(i);
            }

            int cnt = 0;
            for (int i = 1; i <= n; i++) {
                if (state[i] != IN_CYCLE) cnt++;
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }

    static void run(int x) { // x = 몇 번 학생에서 출발한 것인지!
        int cur = x;

        while (true) {
            state[cur] = x;
            cur = select[cur]; // 다음 것

            // 이번 방문에서 지나간 학생에 도달했을 경우 -> 사이클 o
            if (state[cur] == x) {
                while (state[cur] != IN_CYCLE) {
                    state[cur] = IN_CYCLE;
                    cur = select[cur];
                }
                return;
            }

            // 이전 방문에서 지나간 학생에 도달했을 경우
            if (state[cur] != NOT_VISITED) {
                return;
            }
        }
    }
}