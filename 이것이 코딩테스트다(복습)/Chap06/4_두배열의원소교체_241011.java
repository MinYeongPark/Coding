/*
 * @author Minyeong Park
 * @date 2024.10.11.
 * 두 배열의 원소 교체
 * '이것이 코딩테스트다' Chap06 정렬 - 실전 문제 4
 */

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] a = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int[] b = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a);
        Arrays.sort(b);

        for (int i = 0; i < k; i++) {
            if (a[i] < b[n-i-1]) {
                a[i] = b[n-i-1];
            } else {
                break;
            }
        }

        int aSum = 0;
        for (int i = 0; i < n; i++) {
            aSum += a[i];
        }
        System.out.println(aSum);
    }
}