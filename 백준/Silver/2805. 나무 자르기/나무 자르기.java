import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] trees;
    static long remain;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        trees = new int[n];
        long max_length = 0;
        long min_length = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            if (trees[i] > max_length) {
                max_length = trees[i];
            }
        }
        while (min_length < max_length) {
            long mid = (max_length + min_length) / 2;
            remain = 0;
            for (int i = 0; i < n; i++) {
                remain += (trees[i] - mid >= 0) ? trees[i] - mid : 0;
            }

            if (remain < m) {
                max_length = mid;
            } else {
                min_length = mid + 1;
            }
        }

        System.out.println(min_length - 1);
    }
}