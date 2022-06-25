import java.util.ArrayList;

class Solution {
    public long[] solution(int x, int n) {
        long answer = new long[n];  // 개수가 n개로 이미 정해져 있으므로 이렇게 바로 n개 배열로 만들면 된다!
        answer[0] = x;

        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] + x;
        }

        return answer;
    }
}