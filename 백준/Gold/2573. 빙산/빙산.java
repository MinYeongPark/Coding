import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int yearCnt = 0;
        while (true) {
            afterOneYear();
            yearCnt++;

            visited = new boolean[n][m];
            int islandCnt = findIsland();
            if (islandCnt >= 2) {
                System.out.println(yearCnt);
                return;
            } else if (islandCnt == 0) {
                System.out.println(0);
                return;
            }
        }
    }

    static void afterOneYear() {
        int[][] nowMap = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                nowMap[i][j] = map[i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] > 0) {
                    for (int d = 0; d < 4; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];

                        if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

                        if (nowMap[nx][ny] == 0 && map[i][j] > 0) {
                            map[i][j]--;
                        }
                    }
                }
            }
        }
    }

    static int findIsland() {
        int islandCnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] > 0 && !visited[i][j]) {
                    bfs(i, j);
                    islandCnt++;
                }
            }
        }

        return islandCnt;
    }

    static void bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y));
        visited[x][y] = true;

        while (!q.isEmpty()) {
            Node now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

                if (map[nx][ny] > 0 && !visited[nx][ny]) {
                    q.add(new Node(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }
    }
}

class Node {
    int x;
    int y;

    Node (int x, int y) {
        this.x = x;
        this.y = y;
    }
}