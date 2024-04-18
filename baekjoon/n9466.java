/*
 * @author Minyeong Park
 * @date 2024.04.18.
 * 텀 프로젝트 -> 다시 풀었지만 실패해서 해설 코드 참고,,
 * https://www.acmicpc.net/problem/9466
 */

import java.util.*;
import java.io.*;

public class Main {
    static final int NOT_VISITED = 0;
    static final int CYCLE_IN = -1;
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
                if (state[i] == NOT_VISITED) run(i);
            }

            int cnt = 0;
            for (int i = 1; i <= n; i++) {
                if (state[i] != CYCLE_IN) cnt++;
            }

            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }

    static void run(int x) {
        int cur = x;

        while (true) {
            state[cur] = x;
            cur = select[cur];

            // "이번" 방문에서 지나간 학생에 도달했을 경우
            if (state[cur] == x) {
                while (state[cur] != CYCLE_IN) {
                    state[cur] = CYCLE_IN;
                    cur = select[cur];
                }
                return;
            }
            // "이전" 방문에서 지나간 학생에 도달했을 경우
            else if (state[cur] != 0) return;
        }
    }
}