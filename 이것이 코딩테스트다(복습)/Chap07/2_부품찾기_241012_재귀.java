/*
 * @author Minyeong Park
 * @date 2024.10.12.
 * 부품 찾기
 * '이것이 코딩테스트다' Chap07 이진탐색 - 실전 문제 2
 */

import java.io.*;
import java.util.*;

public class Main {
    static int[] my;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        my = new int[n];
        for (int i = 0; i < n; i++) {
            my[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(my);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int req = Integer.parseInt(st.nextToken());
            sb.append(binary_search(0, n-1, req) + " ");
        }
        System.out.println(sb);
    }

    static String binary_search(int start, int end, int target) {
        if (start > end) return "no";

        int mid = (start + end) / 2;

        if (my[mid] == target) {
            return "yes";
        } else if (my[mid] > target) {
            return binary_search(start, mid - 1, target);
        } else {
            return binary_search(mid + 1, end, target);
        }
    }
}