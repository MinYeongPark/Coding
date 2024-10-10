/*
 * @author Minyeong Park
 * @date 2024.10.10.
 * 왕실의 나이트
 * '이것이 코딩테스트다' Chap04 구현 - 실전 문제 2
 */

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String now = br.readLine();
        int x = now.charAt(1) - '0';
        int y = now.charAt(0) - 'a' + 1;

        int[] dx = {2, 2, -2, -2, 1, -1, 1, -1};
        int[] dy = {1, -1, 1, -1, 2, 2, -2, -2};
        int nx, ny;
        int cnt = 0;
        for (int i = 0; i < 8; i++) {
            nx = x + dx[i];
            ny = y + dy[i];
            if (nx >= 1 && ny >= 1 && nx <= 8 && ny <= 8) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
