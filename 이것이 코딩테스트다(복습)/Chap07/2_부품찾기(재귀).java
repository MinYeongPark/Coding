/*
 * @author Minyeong Park
 * @date 2024.01.11.
 * 부품 찾기(중간에 막혀서 해설 보고 해결..)(재귀함수 쓰는 방법)
 * '이것이 코딩테스트다' Chap07 이진 탐색 - 실전 문제 2
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int find = Integer.parseInt(st.nextToken());
            if (binary_sort(find, 0, n - 1) == -1) {
                System.out.print("no ");
            } else {
                System.out.print("yes ");
            }
        }
    }

    static int binary_sort(int find, int start, int end) {
        int mid = (start + end) / 2;

        if (start > end) {
            return -1;
        }

        if (find == arr[mid]) { // 찾은 경우 중간점 인덱스 반환
            return mid;
        } else if (find > arr[mid]) { // 오른쪽 부분 탐색
            return binary_sort(find, mid + 1, end);
        } else { // 왼쪽 부분 탐색
            return binary_sort(find, start, mid - 1);
        }
    }
}