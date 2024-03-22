import java.util.*;
import java.io.*;

public class Main
{
    static int n, cnt;
    static int[] select;
    static boolean[] visited;
    static boolean[] finished;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < t; tc++) {
            n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            select = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                select[i] = Integer.parseInt(st.nextToken());
            }

            cnt = 0;
            visited = new boolean[n + 1];
            finished = new boolean[n + 1];
            for (int i = 1; i <= n; i++) {
                dfs(i);
            }
            System.out.println(n - cnt);
        }
    }

    static void dfs(int now) {
        if (visited[now]) {
            return;
        }

        visited[now] = true;
        int next = select[now];

        if (!visited[next]) {
            dfs(next);
        } else {
            if (!finished[next]) {
                // 노드가 끝나려면 싸이클을 무조건 거쳐야 한다.
                // 따라서 현재 노드가 아닌 다음 노드를 기준으로 하면 싸이클이 무조건 존재한다.
                // 해당 노드의 꼬리를 쫓아가서 싸이클에 해당하는 모든 노드를 카운트한다.
                cnt++;
                for(int i = next; i != now; i = select[i])
                    cnt++;
            }
        }

        finished[now] = true;
    }
}
