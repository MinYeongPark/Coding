/*
 * @author Minyeong Park
 * @date 2024.01.09.
 * 게임 개발(틀려서 해설 보고 해결..)
 * '이것이 코딩테스트다' Chap04 구현 - 실전 문제 3
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int dir = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 0, 1, 2, 3인 경우 각각 왼쪽으로 회전 시
        int[] dx = {0, -1, 0, 1};
        int[] dy = {-1, 0, 1, 0};

        // 0, 1, 2, 3인 경우 각각 한 칸 뒤로 갈 떄
        int[] back_x = {-1, 0, -1, 0};
        int[] back_y = {0, -1, 0, 1};

        int cnt = 1;
        int turn_time = 0;
        visited[x][y] = true;
        while (true) {
            dir -= 1;
            if (dir == -1)
                dir = 3;
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            // 회전한 이후 정면에 가보지 않은 칸이 존재하는 경우 이동
            if (!visited[nx][ny] && map[nx][ny] == 0) {
                visited[nx][ny] = true;
                x = nx;
                y = ny;
                cnt++;
                turn_time = 0;
                continue;
            }
            // 회전한 이후 정면에 가보지 않은 칸이 없거나 바다인 경우
            else turn_time += 1;

            // 네 방향 모두 갈 수 없는 경우
            if (turn_time == 4) {
                nx = x - dx[dir];
                ny = y - dy[dir];
                // 뒤로 갈 수 있다면 이동하기
                if (map[nx][ny] == 0) {
                    x = nx;
                    y = ny;
                }
                // 뒤가 바다로 막혀 있는 경우
                else break;
                turn_time = 0;
            }
        }

        System.out.println(cnt);
    }
}