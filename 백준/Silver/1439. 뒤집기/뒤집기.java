/*
 * @author Minyeong Park
 * @date 2024.10.30.
 * 문자열 뒤집기
 * '이것이 코딩테스트다' Chap11 그리디 문제 - 3
 *
 */

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();


        int cnt0 = 0;
        int cnt1 = 0;

        char prevChar = str.charAt(0);

        if (prevChar == '0') {
            cnt0++;
        } else {
            cnt1++;
        }

        int nowIdx = 1;
        while (nowIdx < str.length()) {
            char nowChar = str.charAt(nowIdx);
            if (prevChar != nowChar) {
                if (nowChar == '0') {
                    cnt0++;
                    prevChar = nowChar;
                } else {
                    cnt1++;
                    prevChar = nowChar;
                }
            }
            nowIdx++;
        }

        System.out.println(Math.min(cnt0, cnt1));
    }
}
