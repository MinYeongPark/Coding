import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] cnt = new int[3];
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        check(0, 0, n);

        System.out.println(cnt[0]);
        System.out.println(cnt[1]);
        System.out.println(cnt[2]);
    }

    static void check(int row, int col, int size) {
        // 모두 다 같은 수인 경우 해당 수 증가
        if (numCheck(row, col, size)) {
            cnt[map[row][col] + 1]++;
            return;
        }

        // 모두 같지 않으면
        int newSize = size / 3;

        check(row, col, newSize); // 왼쪽 위
        check(row, col + newSize, newSize); // 중앙 위
        check(row, col + newSize * 2, newSize); // 오른쪽 위

        check(row + newSize, col, newSize); // 왼쪽 가운데
        check(row + newSize, col + newSize, newSize); // 중앙 가운데
        check(row + newSize, col + newSize * 2, newSize); // 오른쪽 가운데

        check(row + newSize * 2, col, newSize); // 왼쪽 아래
        check(row + newSize * 2, col + newSize, newSize); // 중앙 아래
        check(row + newSize * 2, col + newSize * 2, newSize); // 오른쪽 아래
    }

    static boolean numCheck(int row, int col, int size) {
        int num = map[row][col];

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (map[i][j] != num) {
                    return false;
                }
            }
        }

        return true;
    }
}
