import java.util.*;
import java.io.*;

public class Main
{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char now;
        Stack<Character> s;
        int cnt = 0;
        for (int t = 0; t < n; t++) {
            String word = br.readLine();
            s = new Stack<>();
            for (int i = 0; i < word.length(); i++) {
                now = word.charAt(i);
                if (!s.isEmpty() && s.peek() == now) {
                    s.pop();
                    continue;
                }
                s.push(now);
            }

            if (s.isEmpty()) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}