/*
 * @author Minyeong Park
 * @date 2024.01.24.
 * 볼링공 고르기(해설 - 시간 복잡도가 작고 효과적인 풀이)
 * '이것이 코딩테스트다' Chap11 그리디 문제 Q5
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[11]; // 1 ~ 10 까지 무게를 담을 수 있는 배열

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int weight = Integer.parseInt(st.nextToken());
            arr[weight] += 1;
        }

        int result = 0;
        for (int i = 1; i <= m; i++) {
            n -= arr[i]; // 무게가 i인 볼링공의 개수(A가 선택할 수 있는 개수) 제외
            result += arr[i] * n; // B가 선택하는 경우의 수와 곱해주기
        }

        System.out.println(result);
    }
}