import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        String command;

        Stack<Integer> s = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < n; t++) {
            st = new StringTokenizer(br.readLine());
            command = st.nextToken();
            switch (command) {
                case "push":
                    int num = Integer.parseInt(st.nextToken());
                    s.push(num);
                    break;
                case "pop":
                    if (s.isEmpty()) {
                        sb.append(-1).append("\n");
                        break;
                    }
                    sb.append(s.pop()).append("\n");
                    break;
                case "size":
                    sb.append(s.size()).append("\n");
                    break;
                case "empty":
                    sb.append(s.isEmpty() ? 1 : 0).append("\n");
                    break;
                case "top":
                    if (s.isEmpty()) {
                        sb.append(-1).append("\n");
                        break;
                    }
                    sb.append(s.peek()).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}