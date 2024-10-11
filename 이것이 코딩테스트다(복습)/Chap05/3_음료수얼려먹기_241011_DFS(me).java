/*
 * @author Minyeong Park
 * @date 2024.10.11.
 * 음료수 얼려 먹기
 * '이것이 코딩테스트다' Chap05 DFS/BFS - 실전 문제 3
 * DFS로 풀어본 것
 */

import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] map;
    static boolean[][] visited;
    static Stack<Node> s = new Stack<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];

        String line;
        for (int i = 0; i < n; i++) {
            line = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && map[i][j] == 0) {
                    s.push(new Node(i, j));
                    visited[i][j] = true;
                    dfs();
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }

    static void dfs() {
        Node now = s.pop();

        for (int i = 0; i < 4; i++) {
            int nx = now.x + dx[i];
            int ny = now.y + dy[i];
            if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
            if (!visited[nx][ny] && map[nx][ny] == 0) {
                s.push(new Node(nx, ny));
                visited[nx][ny] = true;
                dfs();
            }
        }
    }
}

class Node {
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}