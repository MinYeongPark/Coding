/*
 * @author Minyeong Park
 * @date 2024.12.04.
 * 만들 수 없는 금액
 * '이것이 코딩테스트다' Chap11 그리디 문제 - Q4
 * 해결을 못해서 결국 해설 보고 이해함..
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main
{
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(coins);

        int target = 1;

        // 1) 해설 원리 보고 내가 푼 것
//        int now = coins[0];
//        int nowIdx = 0;
//
//        while (target >= now && nowIdx < n) {
//            target = target + now;
//
//            nowIdx++;
//            now = coins[nowIdx];
//        }

        // 2) 해설 코드
        for (int coin : coins) {
            if (target < coin) break;

            target += coin;
        }


        System.out.println(target);
    }
}
