import java.util.*;
import java.io.*;

public class Main
{
    static int m, n;
    static int[][] map;
    static int[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Queue<Node> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new int[n][m];

        boolean all_one = true;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    continue;
                }
                all_one = false;
            }
        }

        if (all_one) {
            System.out.println(0);
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1) {
                    q.offer(new Node(i, j));
                    visited[i][j] = 1;
                }
            }
        }

        bfs();

        boolean all_reach = true;
        int min_date = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0 && visited[i][j] == 0) {
                    all_reach = false;
                }
                if (visited[i][j] != 0 && map[i][j] != -1) {
                    min_date = Math.max(min_date, visited[i][j] - 1);
                }
            }
        }

        if (!all_reach) {
            System.out.println(-1);
            return;
        }

        System.out.println(min_date);
    }

    static void bfs() {
        while (!q.isEmpty()) {
            Node now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (map[nx][ny] == 0 && visited[nx][ny] == 0) {
                    q.offer(new Node(nx, ny));
                    visited[nx][ny] = visited[now.x][now.y] + 1;
                }
            }
        }
    }
}

class Node {
    int x;
    int y;

    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}