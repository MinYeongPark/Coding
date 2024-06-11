import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int k, w, h;
    static int[][] map;
    static int[][][] visited;

    // 원숭이
    static int[] dxMon = {-1, 1, 0, 0};
    static int[] dyMon = {0, 0, -1, 1};

    // 말
    static int[] dxHor = {-1, -2, -2, -1,
                            1, 2, 2, 1};
    static int[] dyHor = {-2, -1, 1, 2,
                            -2, -1, 1, 2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        k = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        map = new int[h][w];
        visited = new int[h][w][k+1];
        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < w; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(bfs());
    }

    static int bfs() {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0, 0));
        for (int i = 0; i <= k; i++) {
            visited[0][0][i] = 1;
        }

        while (!q.isEmpty()) {
            Node now = q.poll();

            if (now.x == h - 1 && now.y == w - 1) {
                return visited[now.x][now.y][now.useHorse] - 1;
            }

            for (int i = 0; i < 8; i++) {
                int nx = now.x + dxHor[i];
                int ny = now.y + dyHor[i];
                if (nx < 0 || ny < 0 || nx >= h || ny >= w || now.useHorse + 1 > k) continue;
                if (map[nx][ny] == 0 && visited[nx][ny][now.useHorse + 1] == 0) {
                    q.add(new Node(nx, ny, now.useHorse + 1));
                    visited[nx][ny][now.useHorse + 1] = visited[now.x][now.y][now.useHorse] + 1;
                }
            }

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dxMon[i];
                int ny = now.y + dyMon[i];
                if (nx < 0 || ny < 0 || nx >= h || ny >= w) continue;
                if (map[nx][ny] == 0 && visited[nx][ny][now.useHorse] == 0) {
                    q.add(new Node(nx, ny, now.useHorse));
                    visited[nx][ny][now.useHorse] = visited[now.x][now.y][now.useHorse] + 1;
                }
            }
        }

        return -1;
    }
}

class Node {
    int x;
    int y;
    int useHorse;

    Node(int x, int y, int useHorse) {
        this.x = x;
        this.y = y;
        this.useHorse = useHorse;
    }
}