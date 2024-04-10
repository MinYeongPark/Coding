/*
 * @author Minyeong Park
 * @date 2024.04.09.
 * 숨바꼭질 -> 이번에 다시 혼자 힘으로 풀었다
 * https://www.acmicpc.net/problem/1697
 */


import java.util.*;
import java.io.*;

public class Main
{
    static int n, k;
    static int[] visited = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();
        q.offer(n);
        visited[n] = 1;

        while (!q.isEmpty()) {
            int now = q.poll();

            if (now == k) {
                System.out.println(visited[now] - 1);
                return;
            }

            for (int i = 0; i < 3; i++) {
                int nx;
                if (i == 0) nx = now - 1;
                else if (i == 1) nx = now + 1;
                else nx = now * 2;

                if (nx < 0 || nx > 100000) continue;
                if (visited[nx] == 0) {
                    q.offer(nx);
                    visited[nx] = visited[now] + 1;
                }
            }
        }
    }
}