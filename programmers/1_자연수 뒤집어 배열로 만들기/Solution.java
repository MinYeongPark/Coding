// 주의 했어야 하는 점 : 원소를 내림차순 정렬하라는 게 아니라 그냥 순서대로 뒤집는 것이였다!! 문제를 잘 읽자!!
// 참고 : https://programmers.co.kr/questions/30909
class Solution {
    public int[] solution(long n) {
        String[] str_arr = String.valueOf(n).split("");

        int[] num_arr = new int[str_arr.length];
        for (int i = 0; i < str_arr.length; i++) {
            num_arr[i] = Integer.parseInt(str_arr[str_arr.length - 1 - i]);
        }

        return num_arr;
    }
}


// 다른 사람 풀이
class Solution {
    public int[] solution(long n) {
        String a = "" + n;
        int[] answer = new int[a.length()];
        int cnt = 0; // 인덱스
        while (n > 0) {
            answer[cnt] = (int) (n%10);
            n /= 10;
            cnt++;
        }

        return answer;
    }
}