/*
 * @author Minyeong Park
 * @date 2023.03.08.
 * blobyum
 * 원리 및 코드 참고 : https://burningfalls.github.io/algorithm/boj-24499/
 * 문제 링크 : https://www.acmicpc.net/problem/24499
 */



import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }

        Stack<Integer> stack = new Stack<>();
        int num = 1;
        boolean result = true;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a.length; i++) {
            int su = a[i];
            if (su >= num) {
                while (su >= num) {
                    stack.push(num++);
                    sb.append("+").append("\n");
                }
                stack.pop();
                sb.append("-").append("\n");
            } else {
                int output = stack.pop();

                if (output > su) {
                    System.out.println("NO");
                    result = false;
                    break;
                } else {
                    sb.append("-").append("\n");
                }
            }
        }

        if (result) {
            System.out.println(sb);
        }
    }
}