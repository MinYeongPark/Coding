import java.util.*;
import java.io.*;

public class Main {

    static int i;
    static int[][] map;
    static int nowX, nowY, toX, toY;
    static Queue<Node> q;
    static int result;
    static int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] dy = {-2, -1, 1, 2, -2, -1, 1, 2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < t; tc++) {
            i = Integer.parseInt(br.readLine());
            map = new int[i][i];
            q = new LinkedList<>();
            result = Integer.MAX_VALUE;

            st = new StringTokenizer(br.readLine());
            nowX = Integer.parseInt(st.nextToken());
            nowY = Integer.parseInt(st.nextToken());
            q.add(new Node(nowX, nowY));
            map[nowX][nowY] = 1;

            st = new StringTokenizer(br.readLine());
            toX = Integer.parseInt(st.nextToken());
            toY = Integer.parseInt(st.nextToken());

            bfs();
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }

    static void bfs() {
        while (!q.isEmpty()) {
            Node now = q.poll();

            if (now.x == toX && now.y == toY) {
                result = map[now.x][now.y] - 1;
                return;
            }

            for (int a = 0; a < 8; a++) {
                int nx = now.x + dx[a];
                int ny = now.y + dy[a];
                if (nx < 0 || ny < 0 || nx >= i || ny >= i) continue;
                if (map[nx][ny] == 0) {
                    q.add(new Node(nx, ny));
                    map[nx][ny] = map[now.x][now.y] + 1;
                }
            }
        }
    }
}

class Node {
    int x;
    int y;

    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}