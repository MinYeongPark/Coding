/*
 * @author Minyeong Park
 * @date 2024.10.08.
 * 숫자 카드 게임
 * '이것이 코딩테스트다' Chap03 그리디 - 실전 문제 3
 */

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];

        int answer = -1;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int lineMin = 10001;
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                lineMin = Math.min(lineMin, map[i][j]);
            }

            answer = Math.max(answer, lineMin);
        }

        System.out.println(answer);
    }
}
