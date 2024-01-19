/*
 * @author Minyeong Park
 * @date 2024.01.19.
 * 문자열 뒤집기(막혀서 해설을 좀 보고 이해함..)
 * '이것이 코딩테스트다' Chap11 그리디 문제 Q3
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int cnt_0 = 0;
        int cnt_1 = 0;

        if (input.charAt(0) == '1')
            cnt_1 += 1;
        else
            cnt_0 += 1;

        for (int i = 0; i < input.length() - 1; i++) {
            if (input.charAt(i) != input.charAt(i + 1)) {
                if (input.charAt(i + 1) == '1')
                    cnt_1 += 1;
                else
                    cnt_0 += 1;
            }
        }

        System.out.println(Math.min(cnt_0, cnt_1));
    }
}