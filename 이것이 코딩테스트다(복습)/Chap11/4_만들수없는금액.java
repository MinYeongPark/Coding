/*
 * @author Minyeong Park
 * @date 2024.01.23.
 * 만들 수 없는 금액
 * '이것이 코딩테스트다' Chap11 그리디 문제 Q4
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int target = 1;
        for (int i = 0; i < n; i++) {
            if (target < arr[i])
                break;
            target = target + arr[i];
        }
        System.out.println(target);
    }
}