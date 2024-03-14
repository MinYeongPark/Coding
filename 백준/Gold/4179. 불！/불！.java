import java.io.*;
import java.util.*;

public class Main {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        char[][] map = new char[r][c];
        Queue<Node> jq = new LinkedList<>();
        Queue<Node> fq = new LinkedList<>();
        int[][] jVisited = new int[r][c];
        int[][] fVisited = new int[r][c];
        for (int i = 0; i < r; i++) {
            String line = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'J') {
                    jq.offer(new Node(i, j));
                    jVisited[i][j] = 1;
                } else if (map[i][j] == 'F') {
                    fq.offer(new Node(i, j));
                    fVisited[i][j] = 1;
                }
            }
        }

        // 불
        while (!fq.isEmpty()) {

            Node fNow = fq.poll();
            int fx = fNow.x;
            int fy = fNow.y;

            for (int i = 0; i < 4; i++) {
                int nx = fx + dx[i];
                int ny = fy + dy[i];

                if (nx < 0 || nx >= r || ny < 0 || ny >= c) continue;
                if (map[nx][ny] != '#' && fVisited[nx][ny] == 0) {
                    fq.offer(new Node(nx, ny));
                    fVisited[nx][ny] = fVisited[fx][fy] + 1;
                }
            }
        }

        // 지훈
        while (!jq.isEmpty()) {

            Node now = jq.poll();
            int jx = now.x;
            int jy = now.y;

            for (int i = 0; i < 4; i++) {
                int nx = jx + dx[i];
                int ny = jy + dy[i];

                if (nx < 0 || nx >= r || ny < 0 || ny >= c) {
                    System.out.println(jVisited[jx][jy]);
                    return;
                }
                if (fVisited[nx][ny] != 0 && fVisited[nx][ny] <= jVisited[jx][jy] + 1) continue;
                if (map[nx][ny] != '#' && jVisited[nx][ny] == 0) {
                    jq.offer(new Node(nx, ny));
                    jVisited[nx][ny] = jVisited[jx][jy] + 1;
                }
            }
        }

        System.out.println("IMPOSSIBLE");
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