import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int start_idx = 0;
        int end_idx = arr.length - 1;
        int count = 0;
        while (start_idx < end_idx) {
            int sum = arr[start_idx] + arr[end_idx];
            if (sum < m) {
                start_idx++;
            } else if (sum > m) {
                end_idx--;
            } else if (sum == m) {
                start_idx++;
                count++;
            }
        }
        System.out.println(count);
    }
}