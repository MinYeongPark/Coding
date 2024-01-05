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

        int idx = 1;
        int cnt = 0;
        int ans = 0;
        while (idx < m - 1) {
            if (str.charAt(idx) == 'O' && str.charAt(idx + 1) == 'I') {
                cnt++;
                if (cnt == n) {
                    if (str.charAt(idx - (cnt * 2 - 1)) == 'I')
                        ans++;
                    cnt--; // 다음 OI로 넘어가야 하니까 cnt 하나 감소
                }
                idx += 2;
            } else {
                cnt = 0;
                idx++;
            }
        }

        System.out.println(ans);
    }
}