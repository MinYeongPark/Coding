/*
 * @author Minyeong Park
 * @date 2024.01.09.
 * 상하좌우(내가 푼 것)
 * '이것이 코딩테스트다'  Chap04 구현 - 예제 문제 4-1
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = 0, y = 0;
        while (st.hasMoreTokens()) {
            String next = st.nextToken();
            int nx = x, ny = y;
            if (next.equals("L")) {
                ny--;
            } else if (next.equals("R")) {
                ny++;
            } else if (next.equals("U")) {
                nx--;
            } else {
                nx++;
            }
            if (nx >= 0 || nx < n - 1 || ny >= 0 || ny < n - 1) {
                x = nx;
                y = ny;
            }
        }
        System.out.println((x+1) + " " + (y+1));
    }
}