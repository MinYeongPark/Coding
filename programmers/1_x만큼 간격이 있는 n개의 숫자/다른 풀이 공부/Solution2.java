import java.util.ArrayList;

class Solution {
    public long[] solution(long x, int n) {  //아예 매개변수에서 x를 long형으로 바꿔도 된다!
        long answer = new long[n];

        for (int i = 0; i < n; i++) {
            answer[i] = x * (i + 1);
        }

        return answer;
    }
}