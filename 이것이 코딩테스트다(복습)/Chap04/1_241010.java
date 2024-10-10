/*
 * @author Minyeong Park
 * @date 2024.10.10.
 * 상하좌우
 * '이것이 코딩테스트다' Chap04 구현 - 예제 문제 1
 */

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = 1;
        int y = 1;
//        int nx, ny;
//        while (st.hasMoreTokens()) {
//            String next = st.nextToken();
//            switch (next) {
//                case "L" :
//                      ny = y - 1;
//                      if (ny >= 1 && ny <= n) {
//                          y--;
//                      }
//                      break;
//                case "R" :
//                    ny = y + 1;
//                    if (ny >= 1 && ny <= n) {
//                        y++;
//                    }
//                    break;
//                case "U" :
//                    nx = x - 1;
//                    if (nx >= 1 && nx <= n) {
//                        x--;
//                    }
//                    break;
//                case "D" :
//                    nx = x + 1;
//                    if (nx >= 1 && nx <= n) {
//                        x++;
//                    }
//                    break;
//            }
//        }

        // 더 간결하게 수정
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        char[] direction = {'L', 'R', 'U', 'D'};

        while (st.hasMoreTokens()) {
            char next = st.nextToken().charAt(0);
            int nx = -1;
            int ny = -1;
            for (int i = 0; i < 4; i++) {
                if (next == direction[i]) {
                    nx = x + dx[i];
                    ny = y + dy[i];
                }
            }
            if (nx >= 1 && ny >= 1 && nx <= n && ny <= n) {
                x = nx;
                y = ny;
            }
        }

        System.out.println(x + " " + y);
    }
}
