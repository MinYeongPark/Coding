import java.util.*;
import java.io.*;

public class Main
{
    static int n;
    static int[] people;
    static boolean[] selected; // A 선거구 : true, B 선거구 : false
    static boolean[] visited;
    static int res = Integer.MAX_VALUE;
    static ArrayList<ArrayList<Integer>> graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        people = new int[n+1];
        selected = new boolean[n+1];

        graph = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            people[i] = Integer.parseInt(st.nextToken());
            graph.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            for (int j = 0; j < cnt; j++) {
                int area = Integer.parseInt(st.nextToken());
                graph.get(i).add(area - 1);
            }
        }

        divide(0);
        if (res == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(res);
    }

    static void divide(int idx) {
        if (idx == n) {
            List<Integer> aList = new ArrayList<>();
            List<Integer> bList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (selected[i])
                    aList.add(i);
                else
                    bList.add(i);
            }
            // 한 지역에 몰빵 x
            if (aList.size() == 0 || bList.size() == 0) return;

            // 두 구역이 각각 연결되었는지 확인
            if (check(aList) && check(bList)) getPeopleDiff(); // 인구차 구하기

            return;
        }

        selected[idx] = true;
        divide(idx + 1);
        selected[idx] = false;
        divide(idx + 1);
    }

    // 나눠준 선거구 내에서 구역들이 전부 연결되었는지 확인
    private static boolean check(List<Integer> list) {
        Queue<Integer> q = new LinkedList<>();
        visited = new boolean[n];
        visited[list.get(0)] = true;
        q.offer(list.get(0));

        int count = 1; // 방문한 지역 개수
        while(!q.isEmpty()) {
            Integer now = q.poll();

            for (int i = 0; i < graph.get(now).size(); i++) {
                int next = graph.get(now).get(i);
                if (!visited[next] && list.contains(next)) {
                    q.offer(next);
                    visited[next] = true;
                    count++;
                }
            }
        }

        // 선거구에 해당하는 지역 수와 방문한 지역 수가 같은 경우 -> 나눠진 선거구가 옮바른 선거구인지 확인
        if (count == list.size())
            return true;
        else
            return false;
    }

    // 선거구의 인구 차 구하기
    static void getPeopleDiff() {
        int aCnt = 0;
        int bCnt = 0;
        for (int i = 0; i < n; i++) {
            if (selected[i])
                aCnt += people[i];
            else
                bCnt += people[i];
        }

        res = Math.min(res, Math.abs(aCnt - bCnt));
    }
}
