/*
 * @author Minyeong Park
 * @date 2024.10.22.
 * 곱하기 또는 더하기
 * '이것이 코딩테스트다' Chap11 그리디 문제 - 2
 * 살짝 로직을 틀리게 풀어서 해설 보고 보완함
 */

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int rst = s.charAt(0) - '0';
        for (int i = 1; i < s.length(); i++) {
            int num = s.charAt(i) - '0';
            if (num <= 1 || rst <= 1) {
                rst += num;
            } else {
                rst *= num;
            }
        }
        System.out.println(rst);
    }
}
