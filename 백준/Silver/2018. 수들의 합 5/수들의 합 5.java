import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int start_idx = 1;
        int end_idx = 1;
        int count = 1;
        int sum = 1;

        while (end_idx != n) {
            if (sum < n) {
                end_idx++;
                sum = sum + end_idx;
            } else if (sum > n) {
                sum = sum - start_idx; // 기존에 있었던 것을 빼주고
                start_idx++;           // 인덱스를 증가
            } else { // 같은 경우
                count++;
                end_idx++;
                sum = sum + end_idx;
            }
        }

        System.out.println(count);
    }
}