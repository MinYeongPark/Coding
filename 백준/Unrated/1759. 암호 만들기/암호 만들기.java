import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int l, c;
    static char[] arr, print;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arr = new char[c];
        print = new char[l];
        st = new StringTokenizer(br.readLine());
        for (int x = 0; x < c; x++) {
            arr[x] = st.nextToken().charAt(0);
        }

        Arrays.sort(arr);

        makeCode(0, 0);
        System.out.println(sb);
    }

    static void makeCode(int start, int depth) {
        // l개를 선택했으면
        if (depth == l) {
            // 자음 모음 조건 확인
            if (check()) {
                for (char value : print) {
                    sb.append(value);
                }
                sb.append("\n");
            }
            return;
        }

        // 아직 길이 l의 코드를 만들지 않았고 글자도 아직 남은 경우
        for (int i = start; i < arr.length; i++) {
            print[depth] = arr[i];
            makeCode(i + 1, depth + 1);
        }
    }

    // 최소 모음 1개, 최소 자음 2개인지 확인
    static boolean check() {
        int m = 0; // 모음
        int j = 0; // 자음

        for (char x : print) {
            if (x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u') {
                m++;
            } else {
                j++;
            }
        }

        if (m >= 1 && j >= 2)
            return true;

        return false;
    }
}