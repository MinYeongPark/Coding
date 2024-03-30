import java.util.*;
import java.io.*;

public class Main
{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        Loop1:
        for (int tc = 0; tc < t; tc++) {
            Deque<Integer> dq = new LinkedList<>();

            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());

            String arr_all = br.readLine();
            String arr_in = arr_all.substring(1, arr_all.length() - 1);
            String[] arr_str = arr_in.split(",");

            for (int i = 0; i < n; i++) {
                dq.addLast(Integer.parseInt(arr_str[i]));
            }

            boolean isRight = false; // 배열의 시작 방향
            for (int i = 0; i < p.length(); i++) {
                char c = p.charAt(i);
                switch(c) {
                    case 'R' :
                        isRight = !isRight;
                        break;
                    case 'D' :
                        if (!dq.isEmpty()) {
                            if (isRight) dq.removeLast();
                            else dq.removeFirst();
                        }
                        else {
                            sb.append("error").append("\n");
                            continue Loop1;
                        }
                        break;
                }
            }

            sb.append("[");

            if (dq.size() >= 1) {
                int size = dq.size();
                if (isRight) {
                    for (int i = 0; i < size - 1; i++) {
                        sb.append(dq.removeLast()).append(",");
                    }
                    sb.append(dq.removeLast());
                } else {
                    for (int i = 0; i < size - 1; i++) {
                        sb.append(dq.removeFirst()).append(",");
                    }
                    sb.append(dq.removeFirst());
                }
            }
            sb.append("]").append("\n");
        }

        System.out.println(sb);
    }
}