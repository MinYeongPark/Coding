class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        int min = Math.min(n,m);
        int max = Math.max(n,m);
        int min_result = 1;
        for (int i = 1; i <= min; i++) {
            if (n % i == 0 && m % i == 0)
                min_result = i;
        }
        answer[0] = min_result;

        int max_result = min;
        while (max_result % n != 0 || max_result % m != 0) {
            max_result++;
        }
        answer[1] = max_result;
        return answer;
    }
}


// 다른 사람 풀이
class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];

        for (int i = 1; i <= n + m; i++) {
            if (n % i == 0 && m % i == 0) {
                answer[0] = i;
                answer[1] = n * m / answer[0];
            }
        }
        return answer;
    }
}