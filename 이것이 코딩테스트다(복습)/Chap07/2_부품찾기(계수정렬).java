/*
 * @author Minyeong Park
 * @date 2024.01.11.
 * 부품 찾기(해설-계수 정렬)
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
        arr = new int[1000001];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());
            arr[x] = 1;
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int target = Integer.parseInt(st.nextToken());
            if (arr[target] == 1) {
                System.out.print("yes ");
            } else {
                System.out.print("no ");
            }
        }
    }
}