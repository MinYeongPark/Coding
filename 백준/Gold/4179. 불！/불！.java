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
        ArrayList<Node> exitCandidateList = new ArrayList<>();
        while (!jq.isEmpty()) {

            Node now = jq.poll();
            int jx = now.x;
            int jy = now.y;

            if (jx == 0 || jx == r - 1 || jy == 0 || jy == c - 1) {
                if (map[jx][jy] != '#') {
                    exitCandidateList.add(new Node(jx, jy));
                }
            }

            for (int i = 0; i < 4; i++) {
                int nx = jx + dx[i];
                int ny = jy + dy[i];

                if (nx < 0 || nx >= r || ny < 0 || ny >= c) continue;
                if (map[nx][ny] != '#' && jVisited[nx][ny] == 0) {
                    jq.offer(new Node(nx, ny));
                    jVisited[nx][ny] = jVisited[jx][jy] + 1;
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (Node node : exitCandidateList) {
            if (fVisited[node.x][node.y] != 0 && jVisited[node.x][node.y] >= fVisited[node.x][node.y]) {
                continue;
            }
            min = Math.min(min, jVisited[node.x][node.y]);
        }
        if (min == Integer.MAX_VALUE) {
            System.out.println("IMPOSSIBLE");
            return;
        }
        System.out.println(min);
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