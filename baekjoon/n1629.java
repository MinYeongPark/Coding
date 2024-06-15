/*
 * @author Minyeong Park
 * @date 2024.06.15.
 * 곱셈 (전에 풀어봤지만 제대로 다시 도전..)
 * https://www.acmicpc.net/problem/1629
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Integer.parseInt(st.nextToken());
        long b = Integer.parseInt(st.nextToken());
        long c = Integer.parseInt(st.nextToken());

        System.out.println(mod(a, b, c) % c);
    }

    static long mod(long a, long b, long c) {
        if (b == 1) {
            return a % c;
        }

        long val = mod(a, b/2, c);
        val = val * val % c; // (val * val * a) % c = (val % c) * (val % c) * (a % c) 니까 여기에서 한번 % c 계산해주고
        if (b % 2 == 0) {
            return val;
        } else {
            return val * a % c; // 여기서 또 % c를 해주는 것인듯!
        }
    }
}
