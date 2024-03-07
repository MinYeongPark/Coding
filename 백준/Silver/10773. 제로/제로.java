import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < k; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                s.pop();
            } else {
                s.push(num);
            }
        }

        int sum = 0;
        while (!s.isEmpty()) {
            sum += s.pop();
        }
        System.out.println(sum);
    }
}