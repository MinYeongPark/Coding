/*
 * @author Minyeong Park
 * @date 2024.04.11.
 * 유기농 배추 -> 이번에 다시 혼자 힘으로 풀었다
 * https://www.acmicpc.net/problem/1012
 */

import java.util.*;
import java.io.*;

public class Main
{
    static int m, n;
    static int[][] map;
    static boolean[][] visited;
    static Queue<Node> q;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < t; tc++) {
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            map = new int[m][n];
            visited = new boolean[m][n];
            q = new LinkedList<>();
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[x][y] = 1;
            }

            int cnt = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] == 1 && !visited[i][j]) {
                        bfs(i, j);
                        cnt++;
                    }
                }
            }

            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }

    static void bfs(int x, int y) {
        q.add(new Node(x, y));
        visited[x][y] = true;

        while (!q.isEmpty()) {
            Node now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                if (map[nx][ny] == 1 && !visited[nx][ny]) {
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