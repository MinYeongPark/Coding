/*
 * @author Minyeong Park
 * @date 2024.01.01.
 * 큰 수의 법칙
 * '이것이 코딩테스트다' Chap03 그리디 - 실전 문제 2
 * (혼자 풀긴 했는데 예제만 맞고 원리는 틀려서.. 해설보고 보완)
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        // 입력값 중에서 1) 가장 큰 수와 2) 두 번째로 큰 수만 저장하면 된다.
        // 연속으로 저장할 수 있는 횟수는 최대 k번
        // 1) 가장 큰 수를 K번 더하고,
        // 2) 두 번째로 큰 수를 한 번 더하는 연산을 반복

        // 가장 큰 수가 더해지는 횟수 계산
        int cnt = (m / (k + 1)) * k;
        cnt += m % (k + 1); // k+1개씩 나누고 남은 개수들은 모두 가장 큰 수로 더해줘야 함!

        int sum = 0;
        sum += cnt * arr[n - 1];
        sum += (m - cnt) * arr[n - 2];

        System.out.println(sum);
    }
}