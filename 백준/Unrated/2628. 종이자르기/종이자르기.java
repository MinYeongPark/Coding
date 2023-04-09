import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int col_cnt = Integer.parseInt(st.nextToken());
        int row_cnt = Integer.parseInt(st.nextToken());
        boolean[] col = new boolean[col_cnt]; // 잘린 점선인지 여부를 저장
        boolean[] row = new boolean[row_cnt];

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int flag = Integer.parseInt(st.nextToken());
            int cut = Integer.parseInt(st.nextToken());
            if (flag == 0) {
                row[cut] = true;
            } else {
                col[cut] = true;
            }
        }

        int max_width = 0;
        int tmp = 0;
        for (int i = 0; i < row_cnt; i++) {
            if (row[i]) {
                max_width = Math.max(max_width, tmp);
                tmp = 1; // 잘린 부분부터 시작하는 한 칸 
            } else {
                tmp++; // 배열의 true를 만날 때까지의 길이를 계산
            }
        }
        max_width = Math.max(max_width, tmp);

        int max_height = 0;
        tmp = 0;
        for (int i = 0; i < col_cnt; i++) {
            if (col[i]) {
                max_height = Math.max(max_height, tmp);
                tmp = 1;
            } else {
                tmp++;
            }
        }
        max_height = Math.max(max_height, tmp);

        System.out.println(max_width * max_height);
    }
}