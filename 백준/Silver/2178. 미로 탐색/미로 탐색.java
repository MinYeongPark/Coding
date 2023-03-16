import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dx = {-1, 1, 0, 0}; // 상 하 좌 우
    static int[] dy = {0, 0, -1, 1};
    static int n, m;
    static char[][] arr;
    static int min_cnt = 10000;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new char[n+1][m+1];
        visited = new boolean[n+1][m+1];
        for (int i = 1; i <= n; i++) {
            String line = br.readLine();
            for (int j = 1; j <= m; j++) {
                arr[i][j] = line.charAt(j-1);
            }
        }

        bfs(1,1);
        System.out.println(min_cnt);
    }

    static void bfs(int start_x, int start_y) {
        visited[start_x][start_y] = true;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(start_x, start_y, 1));

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int x = node.x;
            int y = node.y;
            int cnt = node.count;

            if (x == n && y == m && cnt < min_cnt)
                min_cnt = cnt;

            // 상하좌우 칸 확인
            for (int i = 0; i < 4; i++) {
                int next_x = x + dx[i];
                int next_y = y + dy[i];

                if (next_x <= 0 || next_y <= 0 || next_x > n || next_y > m) {
                    continue;
                }

                if (arr[next_x][next_y] == '1' && !visited[next_x][next_y]) {
                    queue.offer(new Node(next_x, next_y, cnt + 1));
                    visited[next_x][next_y] = true;
                }
            }
        }
    }

    static class Node {
        int x, y, count;

        public Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }


}