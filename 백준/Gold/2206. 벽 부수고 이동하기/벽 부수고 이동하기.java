import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static int[][] map;
    static int[][] dist; // 거리 측정 배열
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        dist = new int[n][m];

        if (n - 1 == 0 && m - 1 == 0) {
            System.out.println(1);
            return;
        }

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.println(bfs());
    }

    static int bfs() {
        Queue<Node> q = new LinkedList<>();
        boolean[][][] visited = new boolean[2][n][m]; // 3차원 배열
                                                        // - 0: 벽 안 부수고 지나가는 방문노드 경로
                                                        // - 1: 벽 부수고 지나가는 방문노드 경로
        q.offer(new Node(0, 0, 0));

        while (!q.isEmpty()) {
            Node now = q.poll();
            int curX = now.x;
            int curY = now.y;

            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;

                // 다음 칸에 벽이 있을 때
                // 1) 벽을 부순 적이 있는지 체크
                // 2) 그 벽을 방문한 적이 있는지 체크
                if (map[nx][ny] == 1) {
                    if (now.crash == 0 && !visited[1][nx][ny]) {
                        visited[now.crash][nx][ny] = true; // 방문 처리
                        dist[nx][ny] = dist[curX][curY] + 1;
                        q.offer(new Node(nx, ny, 1));
                    }
                }
                // 다음 칸이 벽이 아닐 경우
                // 벽을 부순 여부에 따라 방문을 했는지 체크
                else {
                    if (!visited[now.crash][nx][ny]) {
                        // 해당 칸을 방문하지 않았을 때
                        visited[now.crash][nx][ny] = true; // 방문처리
                        dist[nx][ny] = dist[curX][curY] + 1;
                        q.offer(new Node(nx, ny, now.crash));
                    }
                }

                // 도착 지점에 도달했을 때 출력하고 종료
                if (nx == n - 1 && ny == m - 1) {
                    return dist[nx][ny] + 1;
                }
            }
        }

        return -1;
    }
}

class Node {
    int x;
    int y;
    int crash;

    Node (int x, int y, int crash) {
        this.x = x;
        this.y = y;
        this.crash = crash;
    }
}