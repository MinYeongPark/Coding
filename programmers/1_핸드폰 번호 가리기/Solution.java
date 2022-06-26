// 처음 풀이
class Solution {
    public String solution(String phone_number) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < phone_number.length() - 4; i++) { // 처음에 answer.length()로 해서 계속 막혔는데.. 내가 짠 코드를 다시 잘 되돌아보자...
            sb.append("*");
        }
        sb.append(phone_number.substring(phone_number.length() - 4, phone_number.length()));
        answer = sb.toString();
        return answer;
    }
}

// 두번째 풀이
class Solution {
    public String solution(String phone_number) {
        String answer = "";
        for (int i = 0; i < phone_number.length() - 4; i++) {
            answer += "*";
        }
        answer += phone_number.substring(phone_number.length() - 4, phone_number.length());
        return answer;
    }
}

// 다른 사람 풀이
class Solution {
    public String solution(String phone_number) {
        char[] ch = phone_number.toCharArray();
        for (int i = 0; i < ch.length - 4; i++) {
            ch[i] = '*';
        }
        return String.valueOf(ch);
    }
}
