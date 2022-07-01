class Solution {
    public boolean solution(String s) {
        if (s.length() == 4 || s.length() == 6) {
            for (int i = 0; i < s.length(); i++) {
                if (!Character.isDigit(s.charAt(i)))
                    break;
                if (i == s.length() - 1)
                    return true;
            }
        }
        return false;
    }
}


// 다른 사람 풀이
class Solution {
    public boolean solution(String s) {
        if (s.length() == 4 || s.length() == 6) {
            try {
                int x = Integer.parseInt(s);
                return true;
            } catch(NumberFormatExcaption e) {
                return false;
            }
        }
        else return false;
    }
}