/*
 * @author Minyeong Park
 * @date 2024.01.17.
 * 도시 분할 계획(아이디어가 안 떠올랐다..)
 * '이것이 코딩테스트다' Chap10 그래프 이론 - 실전 문제 3
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] parent = new int[100001]; // 부모 테이블 초기화
    // 모든 간선을 담을 리스트와 최종 비용을 담을 변수
    static ArrayList<Edge> edges = new ArrayList<Edge>();
    static int result = 0;

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
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            // 비용 순으로 정렬하기 위해 튜플의 첫 번째 원소를 비용으로 설정
            edges.add(new Edge(c, a, b));
        }

        Collections.sort(edges);
        int last = 0; // 최소 신장 트리에 포함되는 간선 중에서 가장 비용이 큰 간선(나중에 제거하기 위해)

        // 간선 하나씩 확인
        for (int i = 0; i < edges.size(); i++) {
            int cost = edges.get(i).getDistance();
            int a = edges.get(i).getNodeA();
            int b = edges.get(i).getNodeB();

            // 사이클이 발생하지 않는 경우에만 집합에 포함
            if (findParent(a) != findParent(b)) {
                unionParent(a, b);
                result += cost;
                last = cost;
            }
        }

        System.out.println(result - last);
    }

    static int findParent(int node) {
        if (parent[node] == node) {
            return node;
        } else {
            return parent[node] = findParent(parent[node]);
        }
    }

    static void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);
        if (a < b) parent[b] = a;
        else parent[a] = b;
    }
}

class Edge implements Comparable<Edge> {
    private int distance;
    private int nodeA;
    private int nodeB;

    public Edge(int distance, int nodeA, int nodeB) {
        this.distance = distance;
        this.nodeA = nodeA;
        this.nodeB = nodeB;
    }

    public int getDistance() {
        return distance;
    }

    public int getNodeA() {
        return nodeA;
    }

    public int getNodeB() {
        return nodeB;
    }

    @Override
    public int compareTo(Edge o) {
        if (this.distance < o.distance) {
            return -1;
        }
        return 1;
    }
}