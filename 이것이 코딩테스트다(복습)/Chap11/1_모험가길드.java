/*
 * @author Minyeong Park
 * @date 2024.01.18.
 * 모험가 길드
 * '이것이 코딩테스트다' Chap11 그리디 문제 Q1
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int cnt = 0; // 현재 그룹에 포함된 모험가의 수
        int result = 0; // 총 그룹의 수
        for (int i = 0; i < n; i++) {
            cnt += 1; // 현재 그룹에 해당 모함가 포함시킴
            if (cnt >= arr[i]) { // '현재 그룹에 포함된 모험가의 수'가 '현재 공포도' 이상이면 -> 그룹 결성
                result += 1; // 총 그룹의 수 증가
                cnt = 0; // 현재 그룹에 포함된 모험가의 수 초기화
            }
        }

        System.out.println(result);
    }
}