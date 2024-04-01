import java.util.*;
import java.io.*;

public class Main
{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        StringBuilder sb = new StringBuilder();
        Loop1:
        while (!(line = br.readLine()).equals(".")) {
            char now;
            Stack<Character> s = new Stack<>();
            for (int i = 0; i < line.length(); i++) {
                now = line.charAt(i);
                if (now == '(' || now == '[') {
                    s.push(now);
                } else if (now == ')') {
                    if (!s.isEmpty() && s.peek() == '(') {
                        s.pop();
                    } else {
                        sb.append("no").append("\n");
                        continue Loop1;
                    }
                } else if (now == ']'){
                    if (!s.isEmpty() && s.peek() == '[') {
                        s.pop();
                    } else {
                        sb.append("no").append("\n");
                        continue Loop1;
                    }
                }
            }

            if (!s.isEmpty()) {
                sb.append("no").append("\n");
                continue;
            }

            sb.append("yes").append("\n");
        }

        System.out.println(sb);
    }
}