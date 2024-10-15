/*
 * @author Minyeong Park
 * @date 2024.10.13.
 * 아기 상어
 * https://www.acmicpc.net/problem/16236
 * 참고 : https://girawhale.tistory.com/39
 */

import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] map;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};
    static int sharkSize;
    static Node now = new Node();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for (int i = 0; i < n ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    now.x = i;
                    now.y = j;
                    map[i][j] = 0; // 아기상어가 있던 위치에는 아무것도 없다고 처리
                }
            }
        }

        sharkSize = 2;
        int eat = 0;  // 먹은 물고기 수
        int move = 0; // 움직인 총 거리

        while (true) {
            PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) ->
                    o1.d != o2.d ?
                    Integer.compare(o1.d, o2.d) // 움직인 거리
                    : (o1.x != o2.x ?
                            Integer.compare(o1.x, o2.x) // x좌표
                            : Integer.compare(o1.y, o2.y)) // y좌표
            );
            boolean[][] visit = new boolean[n][n];

            pq.add(new Node(now.x, now.y, 0));
            visit[now.x][now.y] = true;

            boolean check = false; // 상어가 먹이를 먹었는지 체크할 변수

            while (!pq.isEmpty()) {
                now = pq.poll();
                if (map[now.x][now.y] != 0 && map[now.x][now.y] < sharkSize) { // 해당 위치에 있는 물고기를 먹을 수 있는 경우
                    map[now.x][now.y] = 0; // 물고기 먹음
                    eat++;
                    move += now.d; // 움직인 거리를 총 움직인 거리에 추가
                    check = true; // 먹이 먹었다고 체크
                    break;
                }

                for(int i = 0; i < 4; i++) {
                    int nx = now.x + dx[i];
                    int ny = now.y + dy[i];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= n || visit[nx][ny] || map[nx][ny] > sharkSize) continue;

                    pq.offer(new Node(nx, ny, now.d + 1));
                    visit[nx][ny] = true;
                }
            }

            if (!check) break; // 큐가 비워질 때까지 먹이를 먹은 적이 없다면, 더이상 먹은 물고기가 없으므로 탈출

            if (sharkSize == eat) { // 상어 사이즈와 먹이를 먹은 수가 동일하다면, 상어의 크기를 증가
                sharkSize++;
                eat = 0;
            }
        }

        System.out.println(move);
    }
}

class Node {
    int x;
    int y;
    int d;

    public Node() {
        this.x = -1;
        this.y = -1;
        this.d = -1;
    }

    public Node(int x, int y, int d) {
        this.x = x;
        this.y = y;
        this.d = d;
    }
}