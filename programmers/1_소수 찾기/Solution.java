class Solution {
    public int solution(int n) {
        boolean[] prime = new boolean[n+1]; // true : 소수 X
        prime[0] = true;
        prime[1] = true;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (prime[i])
                continue;
            for (int j = i * i; j <= n; j += i) {
                prime[j] = true;
            }
        }
        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (!prime[i])
                count++;
        }

        return count;
    }
}