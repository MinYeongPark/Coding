/*
 * @author Minyeong Park
 * @date 2024.04.17.
 * 벽 부수고 이동하기 -> 다시 풀었지만 실패해서 해설 코드 참고,,
 * https://www.acmicpc.net/problem/2206
 */

import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int[][] map;
    static int[][][] dist;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        dist = new int[n][m][2];
        // dist[x][y][0] : 벽을 하나도 부수지 않고 (x,y)까지 오는 데 걸리는 비용
        // dist[x][y][1] : 벽을 하나만 부수고 (x,y)까지 오는 데 걸리는 비용 - ((x,y)가 벽이라서 부수는 경우 포함)

        String line;
        for (int i = 0; i < n; i++) {
            line = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.println(bfs());
    }

    static int bfs() {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0, 0));
        dist[0][0][0] = dist[0][0][1] = 1;

        while (!q.isEmpty()) {
            Node now = q.poll();
            if (now.x == n-1 && now.y == m-1) return dist[now.x][now.y][now.broken];
            int nextDist = dist[now.x][now.y][now.broken] + 1;
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (map[nx][ny] == 0 && dist[nx][ny][now.broken] == 0) {
                    dist[nx][ny][now.broken] = nextDist;
                    q.offer(new Node(nx, ny, now.broken));
                }

                // (nx, ny)를 부수는 경우
                if (now.broken == 0 && map[nx][ny] == 1 && dist[nx][ny][1] == 0) {
                    dist[nx][ny][1] = nextDist;
                    q.offer(new Node(nx, ny, 1));
                }
            }
        }

        return -1;
    }
}

class Node {
    int x;
    int y;
    int broken;

    Node (int x, int y, int broken) {
        this.x = x;
        this.y = y;
        this.broken = broken;
    }
}