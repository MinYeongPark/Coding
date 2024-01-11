/*
 * @author Minyeong Park
 * @date 2024.01.11.
 * 떡볶이 떡 만들기(해설 - 반복문)
 * '이것이 코딩테스트다' Chap07 이진 탐색 - 실전 문제 3
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m;
    static int[] arr;
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int start = 0;
        int end = (int) 1e9;
        while (start <= end) {
            int mid = (start + end) / 2;
            long left_sum = 0;
            for (int i = 0; i < n; i++) {
                if (arr[i] - mid > 0) {
                    left_sum += arr[i] - mid;
                }
            }

            if (left_sum >= m) {
                result = mid; // 중간점의 값은 시간이 지날수록 '최적화된 값'을 찾기 때문에, 과정을 반복하면서 얻을 수 있는 '떡의 길이 합'이 '필요한 떡의 길이'보다 크거나 같을 때마다 결괏값을 중간점 값으로 갱신해주면 된다.
                start = mid + 1;
            } else { // 남은 양이 더 적은 경우 -> 더 많이 잘라야 함! -> start를 높여야 함
                end = mid - 1;
            }
        }

        System.out.println(result);
    }
}