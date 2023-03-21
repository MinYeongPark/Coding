import java.io.*;
import java.util.*;

public class Main {
    static int n, m, v;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> list;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(list.get(i));
        }

        visited = new boolean[n+1];
        dfs(v);
        sb.append("\n");
        visited = new boolean[n+1];
        bfs(v);
        System.out.println(sb);
    }

    static void dfs(int x) {
        visited[x] = true;
        sb.append(x + " ");
        for (int i = 0; i < list.get(x).size(); i++) {
            int next = list.get(x).get(i);
            if (!visited[next]) {
                dfs(next);
            }
        }
    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        q.add(start);

        while (!q.isEmpty()) {
            int now = q.poll();
            sb.append(now + " ");
            for (int i = 0; i < list.get(now).size(); i++) {
                int next = list.get(now).get(i);
                if (!visited[next]) {
                    q.add(next);
                    visited[next] = true;
                }
            }
        }
    }
}