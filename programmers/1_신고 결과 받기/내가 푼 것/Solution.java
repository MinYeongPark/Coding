/*
 * @author Minyeong Park
 * @date 2022.06.17.
 * 1단계 - 신고 결과 받기
 * https://programmers.co.kr/learn/courses/30/lessons/92334
 */

import java.util.StringTokenizer;
import java.util.Arrays;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        StringTokenizer st;
        int[][] arr = new int[id_list.length][id_list.length];

        for (String str : report) {
            st = new StringTokenizer(str);
            String a = st.nextToken();
            String b = st.nextToken();

            int row_index = Arrays.asList(id_list).indexOf(a);
            int col_index = Arrays.asList(id_list).indexOf(b);

            arr[row_index][col_index] = 1;
        }

        int[] counts = new int[id_list.length]; // 신고당한 횟수
        for (int i = 0; i < id_list.length; i++) {
            int count = 0;
            for (int j = 0; j < id_list.length; j++) {
                if (arr[j][i] == 1)
                    counts[i]++;
            }
        }

        boolean[] flag = new boolean[id_list.length];
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] >= k)
                flag[i] = true;
        }

        for (int i = 0; i < id_list.length; i++) {
            int rst_count = 0;
            for (int j = 0; j < id_list.length; j++) {
                if (arr[i][j] == 1 && flag[j]) {
                    rst_count++;
                }
            }
            answer[i] = rst_count;
        }
        return answer;
    }
}
