/*
 * @author Minyeong Park
 * @date 2024.03.04.
 * 셀프 넘버
 * https://www.acmicpc.net/problem/4673
 */

import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static int[] dx = {1, -1, 0, 1}; // 하, 오른쪽상 대각선, 오른쪽, 오른쪽하 대각선
    static int[] dy = {0, 1, 1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        map = new int[19][19];

        for (int i = 0; i < 19; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 19; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 모든 칸에 대해 오목 완성 찾기
        for (int j = 0; j < 19; j++) {
            for (int i = 0; i < 19; i++) {
                if (map[i][j] != 0) {
                    for (int dir = 0; dir < 4; dir++) {
                        int nx = i;
                        int ny = j;
                        int cnt = 1; // 일치하는 바둑알 개수

                        // 증가하는 방향 탐색
                        while (true) {
                            nx += dx[dir];
                            ny += dy[dir];
                            if (nx >= 0 && nx < 19 && ny >= 0 && ny < 19) {
                                if (map[i][j] == map[nx][ny]) cnt++;
                                else break;
                            } else break;
                        }

                        nx = i;
                        ny = j;
                        // 반대 방향 탐색
                        while (true) {
                            nx -= dx[dir];
                            ny -= dy[dir];
                            if (nx >= 0 && nx < 19 && ny >= 0 && ny < 19) {
                                if (map[i][j] == map[nx][ny]) cnt++;
                                else break;
                            } else break;
                        }

                        // 같은 오목눈이 5개라면
                        if (cnt == 5) {
                            System.out.println(map[i][j]);
                            System.out.println((i + 1) + " " + (j + 1));
                            return;
                        }
                    }
                }
            }
        }

        // 아무도 이기지 않은 경우
        System.out.println(0);
    }
}