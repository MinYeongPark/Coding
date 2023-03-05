import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        for (int i = 1; i <= n; i++) {
            arr[i] = arr[i-1] + i;
        }

        int start_idx = 1;
        int end_idx = 1;
        int count = 0;

        while (start_idx <= n && end_idx <= n) {
            int sum = arr[end_idx] - arr[start_idx-1];
            if (sum < n) {
                end_idx++;
            } else if (sum > n) {
                start_idx++;
            } else {
                count++;
                end_idx++;
            }
        }

        System.out.println(count);
    }
}