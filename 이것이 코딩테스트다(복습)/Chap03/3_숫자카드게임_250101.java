/*
 * @author Minyeong Park
 * @date 2025.01.01.
 * 숫자 카드 게임
 * '이것이 코딩테스트다' Chap03 그리디 (3) 실전문제
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main
{
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] minArr = new int[n];
        Arrays.fill(minArr, 10000);
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int now = Integer.parseInt(st.nextToken());
                minArr[i] = Math.min(now, minArr[i]);
            }
        }

        int ans = 0;
        for (int num : minArr) {
            ans = Math.max(num, ans);
        }

        System.out.println(ans);
    }
}