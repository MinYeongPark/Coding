import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] map = new int[100001];

        Deque<Integer> q = new LinkedList<>();
        q.add(n);

        while (!q.isEmpty()) {
            Integer now = q.poll();
            if (now == k) {
                System.out.println(map[now]);
                return;
            }

            for (int i = 0; i < 3; i++) {
                int nx;
                if (i == 0) nx = now - 1;
                else if (i == 1) nx = now + 1;
                else nx = now * 2;

                if (nx >= 0 && nx <= 100000) {
                    if (map[nx] == 0) {
                        if (nx == now * 2 && nx != 0) { // 무한 루프를 방지하기 위해 0인 경우는 예외 처리
                            q.addFirst(nx);
                            map[nx] = map[now];
                        } else {
                            q.add(nx);
                            map[nx] = map[now] + 1;
                        }
                    }
                }
            }
        }
    }
}