/*
 * @author Minyeong Park
 * @date 2024.01.09.
 * 왕실의 나이트
 * '이것이 코딩테스트다' Chap04 구현 - 실전 문제 2
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String now = br.readLine();
        char col_c = now.charAt(0);
        int y = 0;
        switch(col_c) {
            case 'a' :
                y = 1;
                break;
            case 'b' :
                y = 2;
                break;
            case 'c' :
                y = 3;
                break;
            case 'd' :
                y = 4;
                break;
            case 'e' :
                y = 5;
                break;
            case 'f' :
                y = 6;
                break;
            case 'g' :
                y = 7;
                break;
            case 'h' :
                y = 8;
                break;
        }
//        int y = now.charAt(0) - 'a' + 1; // 이렇게 더 간단히 나타낼 수 있음!!
        int x = now.charAt(1) - '0';

        int[] dx = {2, 2, -1, 1, -2, -2, -1, 1};
        int[] dy = {1, -1, 2, 2, 1, -1, -2, -2};
        int cnt = 0;
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 1 || ny < 1 || nx > 8 || ny > 8) continue;
            cnt++;
        }
        System.out.println(cnt);
    }
}