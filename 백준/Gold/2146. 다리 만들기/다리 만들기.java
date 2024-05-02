import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[][] map;
    static int[][] visited;
    static int[][] distMap;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int minDist = Integer.MAX_VALUE;
    static Queue<Node> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1 && visited[i][j] == 0) {
                    bfs(i, j, cnt);
                    cnt++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1) {
                    distMap = new int[n][n];
                    int dist = findIsland(i, j);
                    minDist = Math.min(minDist, dist);
                }
            }
        }

        System.out.println(minDist);
    }

    static void bfs(int x, int y, int cnt) {
        q = new LinkedList<>();
        q.add(new Node(x, y));
        visited[x][y] = cnt;

        while (!q.isEmpty()) {
            Node now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;

                if (map[nx][ny] == 1 && visited[nx][ny] == 0) {
                    q.add(new Node(nx, ny));
                    visited[nx][ny] = cnt;
                }
            }
        }
    }

    static int findIsland(int x, int y) {
        int myCnt = visited[x][y];

        q = new LinkedList<>();
        q.add(new Node(x, y));
        distMap[x][y] = 1;

        while (!q.isEmpty()) {
            Node now = q.poll();

            if (map[now.x][now.y] == 1 && visited[now.x][now.y] != myCnt) {
                return distMap[now.x][now.y] - 2;
            }

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;

                if (visited[nx][ny] != myCnt && distMap[nx][ny] == 0) {
                    q.add(new Node(nx, ny));
                    distMap[nx][ny] = distMap[now.x][now.y] + 1;
                }
            }
        }

        return Integer.MAX_VALUE;
    }

    static class Node {
        int x;
        int y;

        Node (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}