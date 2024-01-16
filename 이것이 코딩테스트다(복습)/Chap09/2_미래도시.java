/*
 * @author Minyeong Park
 * @date 2024.01.16.
 * 미래 도시 (막혀서 해설 보고 이해했다..)
 * '이것이 코딩테스트다' Chap09 최단 경로 - 실전 문제 2
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    // 아이디어 생각 : 문제에서 주어진 N의 범위가 100 이하! -> 플로이드 워셜 알고리즘을 이용해도 빨리 풀 수 있음!

    static int n, m, x, k;
    static final int INF = (int) 1e9; // 무한을 의미하는 값으로 10억을 설정
    // 2차원 배열(그래프 표현) 만들기
    static int[][] graph = new int[101][101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 전체 회사의 개수
        m = Integer.parseInt(st.nextToken()); // 경로 개수

        // 최단거리 테이블을 모두 무한으로 초기화
        for (int i = 0; i < 101; i++) {
            Arrays.fill(graph[i], INF);
        }

        // 자기 자신에서 자기 자신으로 가는 비용은 0으로 초기화
        for (int i = 1; i <= n; i++) {
            graph[i][i] = 0;
        }

        // 각 간선 정보 입력 받기
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        // 점화식에 따라 플로이드 워셜 알고리즘 수행
        for (int k = 1; k <= n; k++) {
            for (int a = 1; a <= n; a++) {
                for (int b = 1; b <= n; b++) {
                    graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
                }
            }
        }

        int distance = graph[1][k] + graph[k][x];

        if (distance >= INF) {
            System.out.println(-1);
        } else {
            System.out.println(distance);
        }
    }
}