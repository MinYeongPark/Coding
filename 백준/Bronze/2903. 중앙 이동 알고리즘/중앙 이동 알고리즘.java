import java.io.*;
import java.util.Locale;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int seed = 2;
        for (int i = 1; i <= n; i++) {
            seed = seed * 2 - 1;
        }
        System.out.println((int) Math.pow(seed, 2));
    }
}