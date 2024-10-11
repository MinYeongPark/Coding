/*
 * @author Minyeong Park
 * @date 2024.10.11.
 * 음료수 얼려 먹기
 * '이것이 코딩테스트다' Chap05 DFS/BFS - 실전 문제 3
 * DFS로 풀어본 것을 해설 토대로 조금 더 보완한 것
 */

import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] map;

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

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dfs(i, j)) {
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }

    static boolean dfs(int x, int y) {
        if (x < 0 || y < 0 || x >= n || y >= m) return false;

        if (map[x][y] == 0) {
            map[x][y] = 1; // 방문 처리
            // 상하좌우 위치들 재귀적으로 호출
            dfs(x - 1, y);
            dfs(x + 1, y);
            dfs(x, y - 1);
            dfs(x, y + 1);
            return true;
        }
        return false;
    }
}