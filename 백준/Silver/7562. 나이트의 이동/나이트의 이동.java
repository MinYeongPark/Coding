import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1, -2, -1, -2, 1, 2, 1, 2};
    static int[] dy = {-2, -1, 2, 1, -2, -1, 2, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < t; tc++) {
            int l = Integer.parseInt(br.readLine());
            int[][] map = new int[l][l];
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int tx = Integer.parseInt(st.nextToken());
            int ty = Integer.parseInt(st.nextToken());

            System.out.println(bfs(map, l, x, y, tx, ty));
        }
    }

    static int bfs(int[][] map, int l, int x, int y, int tx, int ty) {
        Queue<Node> q = new LinkedList<>();

        q.offer(new Node(x, y));
        map[x][y] = 1;

        while(!q.isEmpty()) {
            Node now = q.poll();

            if (now.x == tx && now.y == ty) {
                return map[now.x][now.y] - 1;
            }

            for (int i = 0; i < 8; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= l || ny >= l) continue;
                if (map[nx][ny] == 0) { // 방문한 적이 없으면
                    q.offer(new Node(nx, ny));
                    map[nx][ny] = map[now.x][now.y] + 1;
                }
            }
        }

        return -1;
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