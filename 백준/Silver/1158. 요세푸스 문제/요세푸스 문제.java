import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

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
        int index = 0;
        while (list.size() > 0) {
            index += k - 1;
            while (index >= list.size()) {
                index -= list.size();
            }
            sb.append(list.remove(index));
            if (list.size() >= 1) {
                sb.append(", ");
            }
        }
        sb.append(">");
        System.out.println(sb);
    }
}
