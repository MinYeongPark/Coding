/*
 * @author Minyeong Park
 * @date 2024.01.19.
 * 곱하기 혹은 더하기(예제는 맞았지만 원리가 틀려서 해설 보고 보완..)
 * '이것이 코딩테스트다' Chap11 그리디 문제 Q2
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int result = 0;
        for (int i = 0; i < input.length(); i++) {
            int now = input.charAt(i) - '0';
            if (result <= 1 || now <= 1) {
                result += now;
            } else {
                result *= now;
            }
        }

        System.out.println(result);
    }
}