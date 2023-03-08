import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Character> s;
        String line;
        Loop1:
        for (int i = 0; i < n; i++) {
            s = new Stack<>();
            line = br.readLine();
            Loop2:
            for (int j = 0; j < line.length(); j++) {
                if (line.charAt(j) == '(') {
                    s.push('(');
                } else if (line.charAt(j) == ')') {
                    if (s.isEmpty()) {
                        System.out.println("NO");
                        continue Loop1;
                    }
                    else if (s.peek() == '(') {
                        s.pop();
                    } else {
                        s.push(')');
                    }
                }
            }

            if (s.isEmpty()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}