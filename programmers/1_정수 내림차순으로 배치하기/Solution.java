import java.util.Arrays;

class Solution {
    public long solution(long n) {
        int length = (int) (Math.log10(n) + 1);
        long[] arr = new long[length];
        for (int i = length - 1; i >= 0; i--) {
            arr[i] = n / (int) Math.pow(10,i);
            n = n % (int) Math.pow(10,i);
        }
        Arrays.sort(arr);

        long answer = 0;
        for (int i = 0; i < arr.length; i++) {
            answer += arr[i] * Math.pow(10, i);
        }
        return answer;
    }
}

// 다른 사람 풀이
import java.util.*;

class Solution {
    public long solution(long n) {
        String[] list = String.valueOf(n).split("");
        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();
        for (String aList : list)
            sb.append(aList);

        return Long.parseLong(sb.reverse().toString());
    }
}