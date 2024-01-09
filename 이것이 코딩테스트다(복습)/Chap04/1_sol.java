/*
 * @author Minyeong Park
 * @date 2024.01.09.
 * 상하좌우(해설)
 * '이것이 코딩테스트다' Chap04 구현 - 예제 문제 4-1
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        // L, R, U, D에 따른 이동 방향
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        char[] moveTypes = {'L', 'R', 'U', 'D'};

        int x = 1, y = 1;
        while (st.hasMoreTokens()) {
            char next = st.nextToken().charAt(0);
            int nx = -1, ny = -1;
            for (int j = 0; j < 4; j++) {
                if (next == moveTypes[j]) {
                    nx = x + dx[j];
                    ny = y + dy[j];
                }
            }

            // 공간을 벗어나는 경우 무시
            if (nx < 1 || nx > n || ny < 1 || ny > n) continue;

            // 이동 수행
            x = nx;
            y = ny;
        }
        System.out.println(x + " " + y);
    }
}