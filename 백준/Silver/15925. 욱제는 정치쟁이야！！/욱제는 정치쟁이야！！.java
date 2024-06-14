import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int nextClassUse = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int k = 0; k < 2; k++) {
            // 가로 줄
            for (int i = 0; i < n; i++) {
                int rightCnt = 0;
                for (int j = 0; j < n; j++) {
                    if (map[i][j] == nextClassUse) rightCnt++;
                }

                if (rightCnt > n / 2) { // 절반 이상이면
                    for (int j = 0; j < n; j++) {
                        map[i][j] = nextClassUse;
                    }
                }
            }

            // 세로 줄
            for (int i = 0; i < n; i++) {
                int rightCnt = 0;
                for (int j = 0; j < n; j++) {
                    if (map[j][i] == nextClassUse) rightCnt++;
                }

                if (rightCnt > n / 2) { // 절반 이상이면
                    for (int j = 0; j < n; j++) {
                        map[j][i] = nextClassUse;
                    }
                }
            }
        }

        boolean flag = true;
        Loop1:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] != nextClassUse) {
                    flag = false;
                    break Loop1;
                }
            }
        }

        if (flag) System.out.println(1);
        else System.out.println(0);
    }
}