class Solution {
    public boolean solution(int x) {
        String x_str = x + "";
        int length = x_str.length();
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += Integer.parseInt(x_str.charAt(i) + "");
        }
        if (x % sum == 0) {
            return true;
        } else {
            return false;
        }
    }
}