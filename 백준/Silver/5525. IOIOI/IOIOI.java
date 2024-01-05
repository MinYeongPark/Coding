/*
 * @author Minyeong Park
 * @date 2024.01.05.
 * IOIOI
 * https://www.acmicpc.net/problem/5525
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        String str = br.readLine();

        StringBuilder find_sb = new StringBuilder("I");
        for (int i = 0; i < n; i++) {
            find_sb.append("OI");
        }
        String find = find_sb.toString();

        int idx = 0;
        int cnt = 0;
        while (idx < m) {
            if (idx + n * 2 < m) {
                if (str.substring(idx, idx + n * 2 + 1).equals(find)) {
                    cnt++;
                }
            }
            idx++;
        }

        System.out.println(cnt);
    }
}