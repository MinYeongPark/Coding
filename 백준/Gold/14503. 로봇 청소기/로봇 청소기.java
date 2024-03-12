import java.io.*;
import java.util.*;

public class Main {

    static int n, m, r, c, d;
    static int cnt = 0;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0}; // 북동남서
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        run(r, c);

        System.out.println(cnt);
    }

    static void run(int r, int c) {
        if (!visited[r][c] && map[r][c] == 0) {
            visited[r][c] = true; // 청소
            cnt++;
        }

        for (int i = 0; i < 4; i++) {
            d = (d + 3) % 4; // 반시계로 90도 회전
            int nr = r + dx[d];
            int nc = c + dy[d];
            if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
                if (!visited[nr][nc] && map[nr][nc] == 0) {
                    run(nr, nc);
                    return;
                }
            }
        }

        // 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우
        // 한 칸 후진
        int nd = (d + 2) % 4;
        int nr = r + dx[nd];
        int nc = c + dy[nd];
        if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
            if (map[nr][nc] == 0) {
                run(nr, nc);
            }
        }
    }
}