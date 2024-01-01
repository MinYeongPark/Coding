/*
 * @author Minyeong Park
 * @date 2024.01.01.
 * 숫자 카드 게임 (해설 보고 보완한 것)
 * '이것이 코딩테스트다' Chap03 그리디 - 실전 문제 3
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

        int max = -1;
        for (int i = 0; i < n; i++) {
            int low_min = 10001;
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                low_min = Math.min(low_min, Integer.parseInt(st.nextToken()));
            }
            max = Math.max(low_min, max);
        }
        System.out.println(max);
    }
}