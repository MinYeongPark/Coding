import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        int[] in_degree = new int[n + 1];
        in_degree[0] = -1;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            in_degree[b]++; // 진입 차수 배열 데이터 저장 부분
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i <= n; i++) {
            if (in_degree[i] == 0) {
                q.add(i);
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        while (!q.isEmpty()) { // 배열이 모두 0이 되거나 더 연결된 노드가 없을 때까지 반복
            int now = q.poll();
            for (int j = 0; j < list[now].size(); j++) {
                in_degree[list[now].get(j)]--;
                if (in_degree[list[now].get(j)] == 0) {
                    q.add(list[now].get(j));
                }
            }
            result.add(now);
        }

        StringBuilder sb = new StringBuilder();
        for (int i : result) {
            sb.append(i + " ");
        }
        System.out.println(sb);
    }
}