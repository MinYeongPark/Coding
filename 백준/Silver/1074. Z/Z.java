import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, R, C;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        System.out.println(recur(n, R, C));
    }

    static int recur(int n, int r, int c) {
        if (n == 0) {
            return 0;
        }

        int half = (int) Math.pow(2,n-1);

        if (r < half && c < half) {
            return recur(n-1, r, c);
        } else if (r < half && c >= half) {
            return half * half
                + recur(n-1, r, c-half);
        } else if (r >= half && c < half) {
            return 2 * half * half
                    + recur(n-1, r-half, c);
        } else {
            return 3 * half * half
                    + recur(n-1, r-half, c-half);
        }
    }
}
