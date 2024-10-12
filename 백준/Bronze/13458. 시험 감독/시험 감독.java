/*
 * @author Minyeong Park
 * @date 2024.10.12.
 * 시험 감독
 * https://www.acmicpc.net/problem/13458
 */

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        long cnt = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Math.max(arr[i] - b, 0);
            cnt++;
            cnt += arr[i] / c;
            if (arr[i] % c != 0) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}