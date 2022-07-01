class Solution {
    boolean solution(String s) {
        char[] str_arr = s.toCharArray();
        int p_count = 0;
        int y_count = 0;
        for (int i = 0; i < str_arr.length; i++) {
            if (str_arr[i] == 'p' || str_arr[i] == 'P')
                p_count++;
            if (str_arr[i] == 'y' || str_arr[i] == 'Y')
                y_count++;
        }

        if (p_count == y_count)
            return true;
        else
            return false;
    }
}