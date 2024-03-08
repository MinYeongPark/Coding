import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        int now_idx = 0;
        while (!list.isEmpty()) {
            now_idx += k - 1;
            while (now_idx >= list.size()) {
                now_idx -= list.size();
            }
            if (list.size() != 1) {
                sb.append(list.remove(now_idx)).append(", ");
            } else {
                sb.append(list.remove(now_idx)).append(">");
            }
        }
        System.out.println(sb);
    }
}