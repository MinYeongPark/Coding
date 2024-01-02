import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m, r;
    static int min;
    static int[][] map;

    static int[] dx = {0, 1, 0, -1}; // 왼쪽으로 넣는, 위로 넣는, 오른쪽으로 넣는, 아래로 넣는
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        min = Math.min(n, m);
        for (int i = 1; i <= r; i++) { // 회전 횟수 만큼 회전시킴
            rotate();
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(map[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    // 회전 시키는 메서드
    static void rotate() {
        for (int t = 0; t < min / 2; t++) {
            int x = t;
            int y = t;

            int temp = map[x][y]; // 마지막에 넣을 값 미리 빼놓음

            int idx = 0; // 우, 하, 좌, 상 방향으로 이동하여 반시계 방향으로 값 넣을 인덱스
            while (idx < 4) { // 왼쪽으로 넣는, 위로 넣는, 오른쪽으로 넣는, 아래로 넣는 연산을 차례로 수행
                int nx = x + dx[idx];
                int ny = y + dy[idx];

                // 범위 안이라면
                if (nx < n-t && nx >= t && ny < m-t && ny >= t) {
                    map[x][y] = map[nx][ny];
                    x = nx;
                    y = ny;
                } else { // 범위를 벗어났다면 다음 방향으로 진행
                    idx++;
                }
            }

            map[t+1][t] = temp; // 빼 놓은 값 넣어줌
        }
    }
}