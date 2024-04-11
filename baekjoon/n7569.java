/*
 * @author Minyeong Park
 * @date 2024.04.11.
 * 토마토 -> 이번에 다시 혼자 힘으로 풀었다
 * https://www.acmicpc.net/problem/7569
 */


import java.util.*;
import java.io.*;

public class Main {
    static int m, n, h;
    static int[][][] map;
    static int[][][] visited;
    static Queue<Node> q = new LinkedList<>();
    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        map = new int[h][n][m];
        visited = new int[h][n][m];
        boolean allOne = true;
        for (int k = 0; k < h; k++) {
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    map[k][i][j] = Integer.parseInt(st.nextToken());
                    if (map[k][i][j] == 1) {
                        q.offer(new Node(i, j, k));
                        visited[k][i][j] = 1;
                        continue;
                    }
                    allOne = false;
                }
            }
        }

        if (allOne) {
            System.out.println(0);
            return;
        }

        bfs();

        int minDay = Integer.MIN_VALUE;
        for (int k = 0; k < h; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[k][i][j] == 0 && visited[k][i][j] == 0) {
                        System.out.println(-1);
                        return;
                    }
                    minDay = Math.max(minDay, visited[k][i][j] - 1);
                }
            }
        }

        System.out.println(minDay);
    }

    static void bfs() {
        while (!q.isEmpty()) {
            Node now = q.poll();
//            System.out.println(now.z + " " + now.x + " " + now.y);

            for (int i = 0; i < 6; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                int nz = now.z + dz[i];

                if (nx < 0 || ny < 0 || nz < 0 || nx >= n || ny >= m || nz >= h) continue;
                if (map[nz][nx][ny] == 0 && visited[nz][nx][ny] == 0) {
                    q.offer(new Node(nx, ny, nz));
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

    Node(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}