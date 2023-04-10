class Solution {
    public int solution(String[] babbling) {
        String[] word = {"aya", "ye", "woo", "ma"};
        int cnt = 0;
        for (int i = 0; i < babbling.length; i++) {
            int index = 0;
            String temp_str = babbling[i];
            String pre_word = "";
            while (temp_str.length() > 0) {
                if (temp_str.length() >= 3 && temp_str.substring(0, 3).equals("aya") && !temp_str.substring(0, 3).equals(pre_word)) {
                    pre_word = temp_str.substring(0, 3);
                    temp_str = temp_str.substring(3, temp_str.length());
                } else if (temp_str.length() >= 2 && temp_str.substring(0, 2).equals("ye") && !temp_str.substring(0, 2).equals(pre_word)) {
                    pre_word = temp_str.substring(0, 2);
                    temp_str = temp_str.substring(2, temp_str.length());  
                } else if (temp_str.length() >= 3 && temp_str.substring(0, 3).equals("woo") && !temp_str.substring(0, 3).equals(pre_word)) {
                    pre_word = temp_str.substring(0, 3);
                    temp_str = temp_str.substring(3, temp_str.length());     
                } else if (temp_str.length() >= 2 && temp_str.substring(0, 2).equals("ma") && !temp_str.substring(0, 2).equals(pre_word)) {
                    pre_word = temp_str.substring(0, 2);
                    temp_str = temp_str.substring(2, temp_str.length());   
                } else {
                    break;
                }
            }
            if (temp_str.length() == 0) {
                cnt++;
            }
        }
        
        return cnt;
    }
}