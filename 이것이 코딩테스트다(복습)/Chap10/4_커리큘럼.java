/*
 * @author Minyeong Park
 * @date 2024.01.18.
 * 커리큘럼 (막혀서 해설 보고 이해하면서 진행..)
 * '이것이 코딩테스트다' Chap10 그래프 이론 실전문제 4
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    // 모든 노드에 대한 진입차수는 0으로 초기화
    static int[] indegree = new int[501];
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] times = new int[501];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            times[i] = time;

            while (st.hasMoreTokens()) {
                int now = Integer.parseInt(st.nextToken());
                if (now == -1) break;

                indegree[i] += 1;
                graph.get(now).add(i); // now 과목을 듣고 난 후 들을 수 있는 후순위 과목들을 now 인덱스의 리스트에 배치
            }
        }

        topologySort();
    }

    static void topologySort() {
        int[] result = new int[501]; // 알고리즘 수행 결과를 담을 배열
        for (int i = 1; i <= n; i++) {
            result[i] = times[i];
        }

        Queue<Integer> q = new LinkedList<>();

        // 시작 : 진입차수가 0인 노드를 큐에 삽입
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0)
                q.add(i);
        }

        while(!q.isEmpty()) {
            int node = q.poll();

            // 해당 원소와 연결된 노드(후순위 과목)들의 진입차수에서 1 빼기
            for (int i = 0; i < graph.get(node).size(); i++) { // 후순위 과목들을 차례로 돌면서
                result[graph.get(node).get(i)] = Math.max(result[graph.get(node).get(i)],
                        result[node] + times[graph.get(node).get(i)]);
                indegree[graph.get(node).get(i)] -= 1;

                // 새롭게 진입차수가 0이 되는 노드를 큐에 삽입
                if (indegree[graph.get(node).get(i)] == 0)
                    q.add(graph.get(node).get(i));
            }
        }

        // 위상 정렬 수행 결과 출력
        for (int i = 1; i <= n; i++)
            System.out.println(result[i]);
    }
}