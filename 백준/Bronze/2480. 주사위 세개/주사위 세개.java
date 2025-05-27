import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main
{
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] list = new int[3];
        for (int i = 0; i < 3; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(list);

        int rst = 0;
        if (list[0] == list[2]) {
            rst = 10000 + list[0] * 1000;
        } else if (list[0] == list[1] || list[1] == list[2]) {
            rst = 1000 + list[1] * 100;
        } else {
            rst = list[2] * 100;
        }

        System.out.println(rst);
    }
}