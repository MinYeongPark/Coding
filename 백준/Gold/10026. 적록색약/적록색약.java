import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        String line;
        for (int i = 0; i < n; i++) {
            line = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        // 적록색약이 아닌 사람
        visited = new boolean[n][n];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    bfsRGB(i, j, map[i][j]);
                    cnt++;
                }
            }
        }
        System.out.println(cnt);

        // 적록색약인 사람
        visited = new boolean[n][n];
        cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    bfsNotRGB(i, j, map[i][j]);
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }

    static void bfsRGB(int x, int y, char color) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y, color));
        visited[x][y] = true;

        while (!q.isEmpty()) {
            Node now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if (!visited[nx][ny] && now.color == map[nx][ny]) {
                    q.offer(new Node(nx, ny, map[nx][ny]));
                    visited[nx][ny] = true;
                }
            }
        }
    }

    static void bfsNotRGB(int x, int y, char color) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y, color));
        visited[x][y] = true;

        while (!q.isEmpty()) {
            Node now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if (!visited[nx][ny]) {
                    if (now.color == 'B' && now.color != map[nx][ny]) continue;
                    if ((now.color == 'R' || now.color == 'G') && map[nx][ny] == 'B') continue;
                    q.offer(new Node(nx, ny, map[nx][ny]));
                    visited[nx][ny] = true;
                }
            }
        }
    }
}

class Node {
    int x;
    int y;
    char color;

    Node (int x, int y, char color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }
}