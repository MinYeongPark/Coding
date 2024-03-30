import java.util.*;
import java.io.*;

public class Main
{
    static int n, k;
    static String[] words;
    static boolean[] learn;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        if (k < 5) {
            System.out.println(0);
            return;
        } else if (k == 26) {
            System.out.println(n);
            return;
        }

        words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = br.readLine();
        }

        learn = new boolean[26];
        learn['a' - 97] = true;
        learn['n' - 97] = true;
        learn['t' - 97] = true;
        learn['i' - 97] = true;
        learn['c' - 97] = true;

        dfs(0, 0);
        System.out.println(max);
    }

    // k개의 알파벳 조합 구하기
    static void dfs(int idx, int cnt) {
        // 학생들이 k개의 알파벳을 배웠으므로, 읽을 수 있는 단어 개수 구하기
        if (cnt + 5 == k) {
            countWords();
            return;
        }

        for (int i = idx; i < 26; i++) {
            if (!learn[i]) {
                learn[i] = true;
                dfs(i + 1, cnt + 1);
                learn[i] = false;
            }
        }
    }

    // 학생들이 읽을 수 있는 단어 개수 구하기
    static void countWords() {
        int cnt = 0;
        for (String word : words) {
            boolean canRead = true;
            for (int i = 0; i < word.length(); i++) {
                if (!learn[word.charAt(i) - 'a']) {
                    canRead = false;
                    break;
                }
            }

            if (canRead) cnt++;
        }
        max = Math.max(max, cnt);
    }
}