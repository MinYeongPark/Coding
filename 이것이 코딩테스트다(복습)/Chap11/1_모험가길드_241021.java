/*
 * @author Minyeong Park
 * @date 2024.10.21.
 * 모험가 길드
 * '이것이 코딩테스트다' Chap11 그리디 문제 - 1
 */

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        // 내가 푼 것
//        int startIdx = 0;
//        int endIdx = 0;
//        int cnt = 0;
//        while (endIdx < n) {
//            int teamCnt = endIdx - startIdx + 1;
//
//            if (arr[endIdx] <= teamCnt) {
//                cnt++;
//                startIdx = endIdx + 1;
//                endIdx++;
//            }
//            endIdx++;
//        }
//
//        System.out.println(cnt);

        // 풀이 - 더 간결하게 해결하는 버전
        int cnt = 0;
        int rst = 0;
        for (int i = 0; i < n; i++) {
            cnt++; // 현재 그룹에 해당 모험가를 포함시킴
            if (cnt >= arr[i]) { // 현재 그룹에 포함된 모험가의 수 > 현재 i 모험가의 공포도 -> 그룹 결성
                rst++; // 총 그룹의 수 증가시키기
                cnt = 0; // 현재 그룹에 포함된 모험가의 수 초기화
            }
        }

        System.out.println(rst);
    }
}
