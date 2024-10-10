/*
 * @author Minyeong Park
 * @date 2024.10.10.
 * 시각
 * '이것이 코딩테스트다' Chap04 구현 - 예제 문제 2
 * 각 시각 별로 몇 개가 나오는지 직접 계산해서 하고 싶었는데 머리가 안 돌아가서.. 해설 봄...
 */

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int cnt = 0;
        String str;
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < 60; j++) {
                for (int k = 0; k < 60; k++) {
                    str = i + "" + j + "" + k;
                    if (str.contains("3")) {
                        cnt++;
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}
