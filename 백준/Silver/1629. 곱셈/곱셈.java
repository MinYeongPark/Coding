import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Integer.parseInt(st.nextToken());
        long b = Integer.parseInt(st.nextToken());
        long c = Integer.parseInt(st.nextToken());

        System.out.println(recur(a, b, c));
    }

    static long recur(long a, long b, long c) {
        if (b == 1) return a % c;
        long val = recur(a, b/2, c);
        val = val * val % c;

        if (b % 2 == 0) return val;
        return val * a % c;
    }
}