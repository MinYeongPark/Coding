import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        int index = 0;
        boolean in_tag = false;
        while (index < input.length()) {
            if (input.charAt(index) == '<') {
                in_tag = true;
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                sb.append(input.charAt(index));
            } else if (input.charAt(index) == '>') {
                in_tag = false;
                sb.append(input.charAt(index));
            } else if (input.charAt(index) == ' ') {
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                sb.append(input.charAt(index));
            } else if (in_tag) {
                sb.append(input.charAt(index));
            } else if (!in_tag) {
                stack.push(input.charAt(index));
            }
            index++;
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb);
    }
}