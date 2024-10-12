/*
 * @author Minyeong Park
 * @date 2024.10.12.
 * 떡볶이 떡 만들기
 * '이것이 코딩테스트다' Chap07 이진탐색 - 실전 문제 3
 * 반복문으로 푸는 방법 - 파라메트릭서치 문제들은 반복문으로 구현하면 더 간결하다고 함
 */

import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] arr;
    static int rst;

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
        int end = arr[n-1];

        while (start <= end) {
            int mid = (start + end) / 2;
            int tempLeft = calcLeft(mid);
            if (tempLeft >= m) {
                rst = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(rst);
    }

    static int calcLeft(int slice) {
        int tempSum = 0;
        for (int riceCake : arr) {
            tempSum += Math.max(riceCake - slice, 0); // slice 보다 더 길이가 긴 것만 나머지가 발생하니까, 뺀 결과값이 0보다 작은 건 무시
        }
        return tempSum;
    }
}