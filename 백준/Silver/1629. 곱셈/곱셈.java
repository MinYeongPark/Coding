import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long c;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Integer.parseInt(st.nextToken());
        long b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        System.out.println(cal(a, b));
    }

    static long cal(long a, long b) {
        if (b == 1) {
            return a % c;
        }

        long val = cal(a, b/2);
        val = val * val % c;

        if (b % 2 == 0) return val;

        return val * a % c;
    }
}