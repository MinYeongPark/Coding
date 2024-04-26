import java.util.*;
import java.io.*;

public class Main {
    static final int NOT_VISITED = 0;
    static final int IN_CYCLE = -1;
    static int n;
    static int[] select, state;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Stack<Character> s = new Stack<>();

        int sum = 0; // 누적해서 더해질 값
        int num = 1; // 곱해질 값
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(') {
                num *= 2; // 소괄호 => 곱해질 값 2배 증가
                s.push(c);
            } else if (c == '[') {
                num *= 3;
                s.push(c);
            } else if (c == ')') {
                if (s.isEmpty() || s.peek() != '(') {
                    System.out.println(0);
                    return;
                }
                if (str.charAt(i - 1) == '(') {
                    sum += num;
                }
                s.pop();
                num /= 2;
            } else {
                if (s.isEmpty() || s.peek() != '[') {
                    System.out.println(0);
                    return;
                }
                if (str.charAt(i - 1) == '[') {
                    sum += num;
                }
                s.pop();
                num /= 3;
            }
        }

        if (s.isEmpty()) {
            System.out.println(sum);
        } else {
            System.out.println(0);
        }
    }
}