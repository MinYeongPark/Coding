/*
 * @author Minyeong Park
 * @date 2024.01.09.
 * 1이 될 때까지(내가 푼 건 히든케이스에서는 틀리는 코드라 해설 보고 보완..)
 * '이것이 코딩테스트다' Chap03 그리디 - 실전 문제 4
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
        int k = Integer.parseInt(st.nextToken());
        int cnt = 0;

        while (true) {
            // n이 k의 배수가 될 때까지 1로 빼기
            int target = (n / k) * k;
            cnt += n - target;
            n = target;

            // n < k 일 때(더 이상 나눌 수 없을 때) 반복문 탈출
            if (n < k) break;

            // k로 나누기
            n /= k;
            cnt++;
        }

        // 남은 수에 대해 1씩 빼기
        cnt += (n - 1);
        System.out.println(cnt);
    }
}