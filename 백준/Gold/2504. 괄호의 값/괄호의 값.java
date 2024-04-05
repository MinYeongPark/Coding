import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.EmptyStackException;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        char[] arr = new char[input.length()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = input.charAt(i);
        }

        Stack<Character> stack = new Stack<>();
        int rst = 0;
        int tmp = 1;
        try {
            for (int i = 0; i < arr.length; i++) {
                switch (arr[i]) {
                    case '(' :
                        tmp *= 2;
                        stack.push(arr[i]);
                        break;
                    case '[' :
                        tmp *= 3;
                        stack.push(arr[i]);
                        break;
                    case ')' :
                        if ((stack.isEmpty() && rst == 0) || stack.peek() != '(') {
                            throw new EmptyStackException();
                        } else if (arr[i - 1] == '(' || arr[i - 1] == '[') {
                            stack.pop();
                            rst += tmp;
                            tmp /= 2;
                        } else {
                            stack.pop();
                            tmp /= 2;
                        }
                        break;
                    case ']' :
                        if ((stack.isEmpty() && rst == 0) || stack.peek() != '[') {
                            throw new EmptyStackException();
                        } else if (arr[i - 1] == '(' || arr[i - 1] == '[') {
                            stack.pop();
                            rst += tmp;
                            tmp /= 3;
                        } else {
                            stack.pop();
                            tmp /= 3;
                        }
                        break;
                }
            }
            if (!stack.isEmpty()) {
                throw new EmptyStackException();
            }
        } catch (EmptyStackException e) {
            System.out.println(0);
            return;
        }

        System.out.println(rst);
    }
}