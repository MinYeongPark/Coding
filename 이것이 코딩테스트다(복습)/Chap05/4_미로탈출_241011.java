/*
 * @author Minyeong Park
 * @date 2024.10.11.
 * 미로 탈출
 * '이것이 코딩테스트다' Chap05 DFS/BFS - 실전 문제 4
 * BFS로 풀었음!
 */

import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] map;
    static Queue<Node> q = new LinkedList<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        String line;
        for (int i = 0; i < n; i++) {
            line = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        q.offer(new Node(0, 0, 1));
        map[0][0] = 0;
        System.out.println(bfs());
    }

    static int bfs() {
        while (!q.isEmpty()) {
            Node now = q.poll();

            if (now.x == n - 1 && now.y == m - 1) {
                return now.d;
            }

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (map[nx][ny] == 1) {
                    q.offer(new Node(nx, ny, now.d + 1));
                    map[nx][ny] = 0;
                }
            }
        }
        return -1;
    }
}

class Node {
    int x;
    int y;
    int d;

    public Node(int x, int y, int d) {
        this.x = x;
        this.y = y;
        this.d = d;
    }
}