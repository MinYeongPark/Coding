import java.util.*;
import java.io.*;

public class Main {

    static int w, h;
    static char[][] map;
    static Queue<Node> sq; // 상근
    static Queue<Node> fq; // 불
    static int[][] s_visited;
    static int[][] f_visited;
    static int result;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < t; tc++) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            map = new char[h][w];
            s_visited = new int[h][w];
            f_visited = new int[h][w];
            sq = new LinkedList<>();
            fq = new LinkedList<>();
            result = Integer.MAX_VALUE;

            for (int i = 0; i < h; i++) {
                String line = br.readLine();
                for (int j = 0; j < w; j++) {
                    map[i][j] = line.charAt(j);
                    if (map[i][j] == '@') {
                        sq.add(new Node(i, j));
                        s_visited[i][j] = 1;
                    } else if (map[i][j] == '*') {
                        fq.add(new Node(i, j));
                        f_visited[i][j] = 1;
                    }
                }
            }

            // 불 BFS
            f_bfs();

            // 상근 BFS
            if (s_bfs()) {
                sb.append(result).append("\n");
            } else {
                sb.append("IMPOSSIBLE").append("\n");
            }
        }
        System.out.println(sb);
    }

    static void f_bfs() {
        while (!fq.isEmpty()) {
            Node now = fq.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= h || ny >= w) continue;
                if (map[nx][ny] != '#' && f_visited[nx][ny] == 0) {
                    fq.add(new Node(nx, ny));
                    f_visited[nx][ny] = f_visited[now.x][now.y] + 1;
                }
            }
        }
    }

    static boolean s_bfs() {
        boolean canExit = false;

        while (!sq.isEmpty()) {
            Node now = sq.poll();

            if (now.x == 0 || now.y == 0 || now.x == h - 1 || now.y == w - 1) {
                canExit = true;
                result = Math.min(result, s_visited[now.x][now.y]);
            }

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= h || ny >= w) continue;
                if (map[nx][ny] == '*' || map[nx][ny] == '#' ||
                        (map[nx][ny] == '.' && f_visited[nx][ny] != 0 && f_visited[nx][ny] <= s_visited[now.x][now.y] + 1))
                    continue;
                if (map[nx][ny] == '.' && s_visited[nx][ny] == 0) {
                    sq.add(new Node(nx, ny));
                    s_visited[nx][ny] = s_visited[now.x][now.y] + 1;
                }
            }
        }

        return canExit;
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