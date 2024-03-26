import java.util.*;
import java.io.*;

public class Main
{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Queue<Integer> q = new LinkedList<>();
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int last = 0;
        for (int t = 0; t < n; t++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch (command) {
                case "push" :
                    int num = Integer.parseInt(st.nextToken());
                    q.offer(num);
                    last = num;
                    break;
                case "pop" :
                    if (q.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(q.poll()).append("\n");
                    }
                    break;
                case "size" :
                    sb.append(q.size()).append("\n");
                    break;
                case "empty" :
                    if (q.isEmpty()) sb.append(1).append("\n");
                    else sb.append(0).append("\n");
                    break;
                case "front" :
                    if (q.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(q.peek()).append("\n");
                    }
                    break;
                case "back" :
                    if (q.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(last).append("\n");
                    }
                    break;
            }
        }
        System.out.println(sb);
    }
}