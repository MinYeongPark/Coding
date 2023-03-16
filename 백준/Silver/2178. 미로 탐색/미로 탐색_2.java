// 백준 허브로 자동으로 올라간 코드가 예전에 제출했던 코드여서.. 오늘(230316) 과제로 푼 것은 따로 추가로 이 파일로 올립니다!

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[][] map;
    static Queue<int[]> q = new LinkedList<>(); // 데이터가 2개 들어오니까 int배열 형 큐로 선언한다
    static int depth = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[n][m];

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        bfs(0,0);
        System.out.println(map[n-1][m-1]);
    }


    static void bfs(int x, int y) {
        q.offer(new int[] {x, y});
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] temp = q.poll();
            for (int i = 0; i < 4; i++) {
                int next_x = temp[0] + dx[i];
                int next_y = temp[1] + dy[i];
                if (next_x >= 0 && next_x < n && next_y >= 0 && next_y < m) {
                    if (map[next_x][next_y] != 0 && !visited[next_x][next_y]) { // 0이어서 갈 수 없거나 이미 방문했으면 안 됨
                        visited[next_x][next_y] = true;
                        map[next_x][next_y] = map[temp[0]][temp[1]] + 1; // 핵심
                        q.offer(new int[] {next_x, next_y});
                    }
                }
            }
        }
    }
}
