/*
 * @author Minyeong Park
 * @date 2024.10.10.
 * 게임 개발
 * '이것이 코딩테스트다' Chap04 구현 - 실전 문제 3
 * 막혀서 해설 보고 이해하면서 했는데,, 다음에 한번 더 풀어보자
 */

import java.io.*;
import java.util.*;

public class Main {

    static int n, m, x, y, direction;
    static int[][] map, d; // map : 전체 맵 정보, d : 방문한 위치를 저장하기 위한 맵을 생성하여 0으로 초기화

    // 북,동,남,서 방향에서 한 칸 전진하는 방향 정의
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        direction = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        d = new int[n][m];
        d[x][y] = 1; // 방문 처리
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 시뮬레이션 시작
        int cnt = 1;
        int turnTime = 0;
        while (true) {
            // 왼쪽으로 회전
            turnLeft();
            int nx = x + dx[direction];
            int ny = y + dy[direction];

            if (nx < 0 && ny < 0 && nx > n && ny > m) continue;
            if (d[nx][ny] == 0 && map[nx][ny] == 0) {
                d[nx][ny] = 1;
                turnTime = 0;
                x = nx;
                y = ny;
                cnt++;
                continue;
            }
            // 회전한 이후 정면에 가보지 않은 칸이 없거나 바다인 경우
            else {
                turnTime++;
            }

            // 네 방향 모두 갈 수 없는 경우
            if (turnTime == 4) {
                nx = x - dx[direction];
                ny = y - dy[direction];

                if (nx < 0 && ny < 0 && nx > n && ny > m) continue;

                // 뒤로 갈 수 있다면 이동하기
                if (map[nx][ny] == 0) {
                    x = nx;
                    y = ny;
                } else { // 뒤가 바다로 막혀 있는 경우
                    break;
                }
                turnTime = 0;
            }
        }
        System.out.println(cnt);
    }

    // 왼쪽으로 회전
    static void turnLeft() {
        direction -= 1;
        if (direction == -1) direction = 3;
    }
}
