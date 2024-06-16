import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.println((1 << n) - 1);

        func(1, 3, n); // n개의 원판을 기둥1 에서 기둥3 으로 보냄
        System.out.println(sb);
    }

    static void func(int start, int next, int cnt) {
        if (cnt == 1) {
            sb.append(start + " " + next + "\n");
            return;
        }
        func(start, 6 - start - next, cnt - 1);
        sb.append(start + " " + next + "\n");
        func(6 - start - next, next, cnt - 1);
    }
}
