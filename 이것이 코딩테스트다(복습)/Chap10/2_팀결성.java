/*
 * @author Minyeong Park
 * @date 2024.01.17.
 * 팀 결성(부모 노드 찾는 함수가 조금 틀려서 해설 보고 보완함)
 * '이것이 코딩테스트다' Chap10 그래프 이론 - 실전 문제 2
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int flag = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (flag == 0) { // 팀 합치기
                union(a, b);
            } else { // 같은 팀 여부 확인
                if (find_parent(a) == find_parent(b)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }

    static int find_parent(int node) {
        // 루트 노드가 아니라면, 루트 노드를 찾을 떄까지 재귀적으로 호출
        if (parent[node] == node)
            return node;
        return parent[node] = find_parent(parent[node]);
    }

    static void union(int a, int b) {
        int a_parent = find_parent(a);
        int b_parent = find_parent(b);
        if (a_parent != b_parent) {
            if (a_parent < b_parent) {
                parent[b] = a_parent;
            } else {
                parent[a] = b_parent;
            }
        }
    }
}