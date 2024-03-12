import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        boolean[] list = new boolean[n + 1]; // false : 지워진 상태
        for (int i = 2; i <= n; i++) {
            list[i] = true;
        }

        int start = 2;
        int cnt = 0;
        int result = -1;
        while (cnt < k) {
            for (int i = start; i <= n; i++) {
                if (list[i]) {
                    start = i;
                    break;
                }
            }
            for (int i = start; i <= n; i += start) {
                if (list[i]) {
                    list[i] = false;
                    cnt++;
                    if (cnt == k) {
                        result = i;
                        break;
                    }
                }
            }
        }

        System.out.println(result);
    }
}