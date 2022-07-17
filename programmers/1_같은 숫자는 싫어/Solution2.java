// 다른 사람 풀이

import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        ArrayList<Integer> tempList = new ArrayList<Integer>();
        int preNum = 10; // 이전의 인덱스에 있던 숫자
        for (int num : arr) {
            if (preNum != num)
                tempList.add(num);
            preNum = num; // 현재 숫자를 이전 것으로 두기
        }

        int[] answer = new int[tempList.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = tempList.get(i).intValue();
        }

        return answer;
    }
}