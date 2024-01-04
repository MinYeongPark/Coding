/*
 * @author Minyeong Park
 * @date 2024.01.04.
 * 트리의 부모 찾기 (막혔습니다.. 복습 때는 꼭 잘 풀어내고 싶다!)
 * https://www.acmicpc.net/problem/11725
 * 원리 참고 : https://velog.io/@darak/BJ-11725-%ED%8A%B8%EB%A6%AC%EC%9D%98-%EB%B6%80%EB%AA%A8-%EC%B0%BE%EA%B8%B0-Java
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            tree.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            tree.get(a).add(b);
            tree.get(b).add(a);
        }

        boolean[] visited = new boolean[n]; // 방문 여부 확인용
        int[] parentNode = new int[n]; // 부모 노드 저장 배열

        // BFS
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0); // 루트 노드
        visited[0] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int node : tree.get(now)) {
                if (!visited[node]) {
                    visited[node] = true;
                    queue.add(node);
                    parentNode[node] = now; // 부모 노드 찾은 후 저장
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < n; i++) {
            sb.append(parentNode[i] + 1).append("\n");
        }
        System.out.println(sb);
    }
}