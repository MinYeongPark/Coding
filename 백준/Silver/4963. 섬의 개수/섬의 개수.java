import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int w, h;
    static boolean[][] visited;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0, -1, 1, -1, 1}; // 상하좌우 대각선 상좌, 대각선 상우, 대각선 하좌, 대각선 하우
    static int[] dy = {0, 1, 0, -1, 1, 1, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String line = "";
        StringBuilder sb = new StringBuilder();
        while (!(line = br.readLine()).equals("0 0")) {
            st = new StringTokenizer(line);
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            map = new int[h][w];
            visited = new boolean[h][w];

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int cnt = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (!visited[i][j] && map[i][j] == 1) {
                        bfs(i, j);
                        cnt++;
                    }
                }
            }

            sb.append(cnt + "\n");
        }
        System.out.println(sb);
    }

    static void bfs(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        visited[x][y] = true;
        queue.add(new Node(x, y));

        while(!queue.isEmpty()) {
            Node node = queue.poll();

            for (int i = 0; i < 8; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < h && ny < w) {
                    if (!visited[nx][ny] && map[nx][ny] == 1) {
                        queue.add(new Node(nx, ny));
                        visited[nx][ny] = true;
                    }
                }
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