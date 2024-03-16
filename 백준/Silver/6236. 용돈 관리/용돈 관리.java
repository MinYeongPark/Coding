import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] money;
    static int start = 0, end;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        money = new int[100002];
        for (int i = 0; i < n; i++) {
            money[i] = Integer.parseInt(br.readLine());
            start = Math.max(start, money[i]);
        }

        System.out.println(binarySearch());
    }

    static int binarySearch() {
        start = start;
        end = 1000000000; // 10000 * 100000

        while(start <= end) {
            int mid = (start + end) / 2;

            int cnt = 1; // 처음에는 돈을 인출해서 시작
            int now = mid;
            // 모든 날들에 대해 판단
            for (int i = 0; i < n; i++) {
                if (now < money[i]) { // 수중에 있는 돈이 부족하면, 남은 금액을 통장에 집어넣고 k원 인출
                    now = mid;
                    cnt++;
                }

                now -= money[i]; // 돈 사용
            }

            if (cnt > m) { // 인출횟수가 m보다 더 크면, 한번 인출할 때 더 큰 금액으로 인출해야 함
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return start;
    }
}