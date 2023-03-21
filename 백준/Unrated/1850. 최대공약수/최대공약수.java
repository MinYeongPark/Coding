import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        long rst = Euclid(a, b);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rst; i++) {
            sb.append(1);
        }
        System.out.println(sb);
    }

    static long Euclid(long a, long b) {
        long max = Math.max(a, b);
        long min = Math.min(a, b);

        long mod = max % min;

        if (mod == 0) {
            return min;
        } else {
            return Euclid(min, mod);
        }
    }
}