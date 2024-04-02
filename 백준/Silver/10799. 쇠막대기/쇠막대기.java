import java.util.*;
import java.io.*;

public class Main
{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        Stack<Character> s = new Stack<>();
        int nowIdx = 0;
        int cnt = 0;
        while (nowIdx < input.length()){
            char now = input.charAt(nowIdx);
            if (now == '(' && nowIdx + 1 < input.length() && input.charAt(nowIdx + 1) == ')') {
                // 레이저
                cnt += s.size();
                nowIdx += 2;
                continue;
            }
            if (now == '(') {
                s.push(now);
                cnt++;
            }
            if (now == ')') {
                s.pop();
            }

            nowIdx++;
        }
        System.out.println(cnt);
    }
}