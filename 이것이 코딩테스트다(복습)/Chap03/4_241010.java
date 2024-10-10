/*
 * @author Minyeong Park
 * @date 2024.10.10.
 * 1이 될 때까지
 * (히든케이스에서 틀리는 코드로 풀어서 해설 보고 보완)
 * '이것이 코딩테스트다' Chap03 그리디 - 실전 문제 4
 */

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int cnt = 0;

        while (n >= k) {
            if (n % k == 0) {
                n /= k;
                cnt++;
            } else {
                n -= 1;
                cnt++;
            }
        }

        while (n > 1) {
            n -= 1;
            cnt++;
        }

        System.out.println(cnt);
    }
}
