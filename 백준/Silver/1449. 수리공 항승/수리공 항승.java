import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] pipe = new int[n];
        for (int i = 0; i < n; i++) {
            pipe[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(pipe);

        int count = 1;
        int start = pipe[0];
        for (int i = 0; i < n; i++) {
            if (pipe[i] - start >= l) { // start : 앞부분, pipe[i] : 뒷부분 뒷부분
                count++;
                start = pipe[i]; // 뒷부분이 start가 된다.
            }
        }

        System.out.println(count);
    }
}