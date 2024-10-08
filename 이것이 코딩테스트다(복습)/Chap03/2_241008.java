/*
 * @author Minyeong Park
 * @date 2024.10.08.
 * 큰 수의 법칙
 * '이것이 코딩테스트다' Chap03 그리디 - 실전 문제 2
 */

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        // (1) 아래는 내가 푼건데 코드가 지저분함..
        // 그리고 이 방법은 m이 100억 이상 커진다면 시간초과가 뜰 것이다
//        int sum = 0;
//        int cnt = 0;
//        while (cnt < m && m - cnt >= k) {
//            for (int i = 0; i < k; i++) {
//                sum += arr[n-1];
//                cnt++;
//            }
//            sum += arr[n-2];
//            cnt++;
//        }
//
//        while (cnt <= k) {
//            sum += arr[n-1];
//            cnt++;
//        }

        // (2) 간결하게 수정
        // 가장 큰 수가 더해지는 횟수
        int cnt = (m / (k + 1)) * k + (m % (k + 1));
        int sum = 0;
        sum += cnt * arr[n-1];

        // 두번째로 큰 수가 더해지는 과정
        sum += (m - cnt) * arr[n-2];

        System.out.println(sum);
    }
}
