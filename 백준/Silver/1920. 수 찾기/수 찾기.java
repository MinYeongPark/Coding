import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] a;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(a);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int find = Integer.parseInt(st.nextToken());
            sb.append(binary_search(find, 0, n-1)+"\n");
        }
        System.out.println(sb);
    }

    static int binary_search(int find, int start, int end) {
        if (start > end) {
            return 0;
        }
        int mid = (start + end) / 2;

        if (a[mid] == find) {
            return 1;
        } else if (a[mid] > find) {
            // 왼쪽 부분 탐색
            return binary_search(find, start, mid-1);
        } else {
            // 오른쪽 부분 탐색
            return binary_search(find, mid+1, end);
        }
    }
}