import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r1 = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        System.out.println(s * 2 - r1);
    }
}