/*
 * @author Minyeong Park
 * @date 2024.01.10.
 * 미로 탈출(중간에 막혀서 해설 보고 해결..)
 * '이것이 코딩테스트다' Chap05 DFS/BFS - 실전 문제 4
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] map;
    static Queue<Node> q;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.println(bfs(0, 0));
    }

    static int bfs(int x, int y) {
        q = new LinkedList<>();
        q.add(new Node(0, 0));

        while (!q.isEmpty()) {
            Node node = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    // 해당 노드를 처음 방문하는 경우에만 최단 거리 기록
                    if (map[nx][ny] == 1) {
                        map[nx][ny] = map[node.x][node.y] + 1;
                        q.add(new Node(nx, ny));
                    }
                }
            }
        }
        // 가장 오른쪽 아래까지의 최단 거리 반환
        return map[n-1][m-1];
    }
}

class Node {
    int x, y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}