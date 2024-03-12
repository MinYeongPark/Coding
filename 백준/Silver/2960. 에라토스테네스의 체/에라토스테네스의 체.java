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

        int cnt = 0;
        for (int i = 2; i <= n; i++) {
            if (list[i]) {
                cnt++;
                if (cnt == k) {
                    System.out.println(i);
                }
                for (int j = i * i; j <= n; j += i) {
                    if (list[j]) {
                        list[j] = false;
                        cnt++;
                        if (cnt == k) {
                            System.out.println(j);
                        }
                    }
                }
            }
        }
    }
}