import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] temp_answer = new int[arr.length];
        Arrays.fill(temp_answer, -1);

        boolean duplicate = false;
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (!duplicate) {
                temp_answer[index] = arr[i];
                index++;
            }
            if (i+1 < arr.length && arr[i] == arr[i+1]) {
                duplicate = true;
            } else if (i+1 < arr.length && arr[i] != arr[i+1]) {
                duplicate = false;
            }
        }

        int[] answer = new int[index];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = temp_answer[i];
        }

        return answer;
    }
}