class Solution {
    public String solution(String s, int n) {
        String answer = "";
        char[] str_arr = s.toCharArray();
        for (int i = 0; i < str_arr.length; i++) {
            if (str_arr[i] == ' '){
                answer += str_arr[i];
                continue;
            }
            char temp_c = (char) (str_arr[i] + n);
            if (Character.isLowerCase(str_arr[i]) && temp_c > 'z') 
                temp_c = (char) (temp_c - 26);
            if (Character.isUpperCase(str_arr[i]) && temp_c > 'Z') 
                temp_c = (char) (temp_c - 26);
            str_arr[i] = temp_c;
            answer += str_arr[i];
        }
        return answer;
    }
}