import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int[] work_time = new int[n + 1];
        int[] in_degree = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            work_time[i] = Integer.parseInt(st.nextToken());

            int cnt = Integer.parseInt(st.nextToken());
            for (int j = 0; j < cnt; j++) {
                int prev = Integer.parseInt(st.nextToken());
                list.get(prev).add(i);
                in_degree[i]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        int[] result = new int[n + 1]; // 각각의 작업을 수행하는 데 걸리는 시간
        for (int i = 1; i <= n; i++) {
            result[i] = work_time[i];
            if (in_degree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int now = q.poll();
            for (int next : list.get(now)) {
                in_degree[next]--;
                result[next] = Math.max(result[next], result[now] + work_time[next]); 
                if (in_degree[next] == 0) {
                    q.add(next);
                }
            }
        }

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            answer = Math.max(answer, result[i]);
        }
        System.out.println(answer);
    }
}