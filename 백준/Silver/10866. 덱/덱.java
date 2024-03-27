import java.util.*;
import java.io.*;

public class Main
{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> dq = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int num;
            switch (st.nextToken()) {
                case "push_front" :
                    num = Integer.parseInt(st.nextToken());
                    dq.offerFirst(num);
                    break;
                case "push_back" :
                    num = Integer.parseInt(st.nextToken());
                    dq.offerLast(num);
                    break;
                case "pop_front" :
                    if (dq.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(dq.pollFirst()).append("\n");
                    break;
                case "pop_back" :
                    if (dq.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(dq.pollLast()).append("\n");
                    break;
                case "size" :
                    sb.append(dq.size()).append("\n");
                    break;
                case "empty" :
                    if (dq.isEmpty()) sb.append(1).append("\n");
                    else sb.append(0).append("\n");
                    break;
                case "front" :
                    if (dq.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(dq.peekFirst()).append("\n");
                    break;
                case "back" :
                    if (dq.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(dq.peekLast()).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}