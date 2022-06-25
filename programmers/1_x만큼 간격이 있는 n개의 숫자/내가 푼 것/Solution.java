import java.util.ArrayList;

class Solution {
    public long[] solution(int x, int n) {
        ArrayList<Long> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            long num = (long) x * (i+1); // x와 i가 int형이므로, long 타입으로 바꾸어주어야 한다.
            list.add(num);
        }

        long[] answer = list.stream().mapToLong(l->l).toArray();

        return answer;
    }
}