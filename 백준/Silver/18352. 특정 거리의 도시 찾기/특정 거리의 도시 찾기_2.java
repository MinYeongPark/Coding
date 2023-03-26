// 백준허브에서 예전에 BFS로 푼 코드를 업로드해서, 이 파일에 다익스트라로 푼 코드를 따로 추가했습니다.
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
        }

        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0] = -1;
        distance[x] = 0;

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        q.add(x);
        visited[x] = true;
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int i = 0; i < list.get(now).size(); i++) {
                int next = list.get(now).get(i);
                if (!visited[next]) {
                    q.add(next);
                    visited[next] = true;
                }
                distance[next] = Math.min(distance[next], distance[now] + 1);
            }
        }

        StringBuilder sb = new StringBuilder();
        boolean nothing = true;
        for (int i = 1; i <= n; i++) {
            if (distance[i] == k) {
                sb.append(i + "\n");
                nothing = false;
            }
        }
        if (!nothing) {
            System.out.println(sb);
        } else {
            System.out.println(-1);
        }

    }
}
