import java.util.StringTokenizer;

class Solution {
    public String solution(String s) {
        StringTokenizer st = new StringTokenizer(s);

        String answer = "";
        int answer_index = 0;
        while (answer_index < s.length()) {
            if (s.charAt(answer_index) == ' ') {
                answer += " ";
                answer_index++;
            } else if (st.hasMoreTokens()) {
                String str = st.nextToken();
                for (int i = 0; i < str.length(); i++) {
                    char ch = ' ';
                    if (i % 2 == 0) {
                        ch = Character.toUpperCase(str.charAt(i));
                    } else {
                        ch = Character.toLowerCase(str.charAt(i));
                    }
                    answer += ch + "";
                }
                answer_index += str.length();
            }
        }

        return answer;
    }
}

// 다른 사람 풀이
import java.util.StringTokenizer;

class Solution {
    public String solution(String s) {
        String answer = "";
        int cnt = 0;
        String[] array = s.split("");

        for (String ss : array) {
            cnt == ss.contains(" ") ? 0 : cnt + 1; // 공백인 경우 cnt를 0으로 초기화함
            answer += cnt % 2 == 0 ?
                    ss.toLowerCase() : ss.toUpperCase();  // 공백이어도 그냥 변환을 수행해서 간단하게 진행하심
        }
        return answer;
    }
}