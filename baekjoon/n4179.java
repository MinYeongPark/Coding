/*
 * @author Minyeong Park
 * @date 2024.04.09.
 * 불! -> 이번에 다시 혼자 힘으로 풀었다
 * https://www.acmicpc.net/problem/4179
 */

import java.util.*;
import java.io.*;

public class Main
{
    static int r, c;
    static char[][] map;
    static int[][] j_visited;
    static int[][] f_visited;
    static Queue<Node> jq = new LinkedList<>();
    static Queue<Node> fq = new LinkedList<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int result = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new char[r][c];
        j_visited = new int[r][c];
        f_visited = new int[r][c];

        for (int i = 0; i < r; i++) {
            String line = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'J') {
                    jq.offer(new Node(i, j));
                    j_visited[i][j] = 1;
                } else if (map[i][j] == 'F') {
                    fq.offer(new Node(i, j));
                    f_visited[i][j] = 1;
                }
            }
        }

        f_bfs();
        j_bfs();

        if (result == -1) {
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println(result);
        }
    }

    static void f_bfs() {
        while (!fq.isEmpty()) {
            Node now = fq.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= r || ny >= c) continue;
                if (map[nx][ny] != '#' && f_visited[nx][ny] == 0) {
                    fq.offer(new Node(nx, ny));
                    f_visited[nx][ny] = f_visited[now.x][now.y] + 1;
                }
            }
        }
    }

    static void j_bfs() {
        while (!jq.isEmpty()) {
            Node now = jq.poll();

            if (now.x == 0 || now.y == 0 || now.x == r - 1 || now.y == c - 1) {
                result = j_visited[now.x][now.y];
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= r || ny >= c) continue;
                if (f_visited[nx][ny] != 0 && f_visited[nx][ny] <= j_visited[now.x][now.y] + 1) continue;
                if (map[nx][ny] == '.' && j_visited[nx][ny] == 0) {
                    jq.offer(new Node(nx, ny));
                    j_visited[nx][ny] = j_visited[now.x][now.y] + 1;
                }
            }
        }
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