/*
 * @author Minyeong Park
 * @date 2024.01.11.
 * 두 배열의 원소 교체
 * '이것이 코딩테스트다' Chap06 정렬 - 실전 문제 4
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Integer[] a = new Integer[n];
        Integer[] b = new Integer[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a);
        Arrays.sort(b, Collections.reverseOrder());
        for (int i = 0; i < k; i++) {
            if (a[i] < b[i]) {
                a[i] = b[i];
            }
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += a[i];
        }
        System.out.println(sum);
    }
}