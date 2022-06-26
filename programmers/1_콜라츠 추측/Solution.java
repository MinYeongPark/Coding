// 참고 : https://programmers.co.kr/questions/25819
class Solution {
    public int solution(int num) {
        int answer = 0;
        long n = num; // int형이라면 오버플로우가 발생하므로 long형으로 형변환해주어야 한다!
        if (num == 1)
            return 0;
        while (n != 1) {
            if (n % 2 == 0) {
                n /= 2;
                answer++;
            } else {
                n = n * 3 + 1;
                answer++;
            }
        }
        if (answer >= 500)
            return -1;
        return answer;
    }
}