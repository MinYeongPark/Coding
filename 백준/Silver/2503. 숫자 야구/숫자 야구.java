import java.util.*;
import java.io.*;

public class Main
{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        boolean[] check = new boolean[1000];

        for (int i = 123; i <= 1000; i++) {
            String str_num = String.valueOf(i);

            // 숫자 내부에 0 있으면 정답 x
            if (str_num.charAt(0) == '0' || str_num.charAt(1) == '0' || str_num.charAt(2) == '0') continue;
            // 모든 자릿수 숫자가 달라야 함
            if (str_num.charAt(0) == str_num.charAt(1) || str_num.charAt(0) == str_num.charAt(2) || str_num.charAt(1) == str_num.charAt(2)) continue;

            check[i] = true;
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String num_str = st.nextToken(); // 입력 받은 수
            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());

            // 예상 가능한 모든 정답을 탐색
            for (int ans = 123; ans <= 987; ans++) {
                int s_cnt = 0;
                int b_cnt = 0;

                if (check[ans]) {
                    String ans_str = String.valueOf(ans); // 정답 가능성이 있는 수

                    // 스트라이크 / 볼 비교
                    for (int a = 0; a < 3; a++) {
                        for (int b = 0; b < 3; b++) {
                            if (a == b && num_str.charAt(a) == ans_str.charAt(b)) s_cnt++;
                            if (a != b && num_str.charAt(a) == ans_str.charAt(b)) b_cnt++;
                        }
                    }

                    if (s_cnt != strike || b_cnt != ball) check[ans] = false;
                }
            }
        }

        int cnt = 0;
        for (int i = 123; i <= 987; i++) {
            if (check[i])
                cnt++;
        }
        System.out.println(cnt);
    }
}
