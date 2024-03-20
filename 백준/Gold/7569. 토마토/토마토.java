import java.io.*;
import java.util.*;

public class Main {

    static int m, n, h;
    static int[][][] map;
    static int[][][] visited;
    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};
    static Queue<Node> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        map = new int[h][n][m];
        visited = new int[h][n][m];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    map[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }


        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (map[i][j][k] == 1 && visited[i][j][k] == 0) {
                        q.offer(new Node(i, j, k));
                        visited[i][j][k] = 1; // +1으로 설정
                    }
                }
            }
        }
        bfs();

        int result = -1;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (map[i][j][k] == 0 && visited[i][j][k] == 0) {
                        System.out.println(-1);
                        return;
                    } else {
                        result = Math.max(result, visited[i][j][k]);
                    }
                }
            }
        }

        System.out.println(result - 1);
    }

    static void bfs() {
        while (!q.isEmpty()) {
            Node now = q.poll();

            for (int i = 0; i < 6; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                int nz = now.z + dz[i];
                if (nx < 0 || ny < 0 || nz < 0 || nx >= n || ny >= m || nz >= h) continue;
                if (map[nz][nx][ny] == 0 && visited[nz][nx][ny] == 0) {
                    q.offer(new Node(nz, nx, ny));
                    visited[nz][nx][ny] = visited[now.z][now.x][now.y] + 1;
                }
            }
        }
    }
}

class Node {
    int x;
    int y;
    int z;

    Node (int z, int x, int y) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}