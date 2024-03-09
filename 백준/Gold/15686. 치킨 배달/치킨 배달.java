import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] map;
    static int[][] temp;
    static int ans = Integer.MAX_VALUE;
    static ArrayList<Node> home;
    static ArrayList<Node> chicken;
    static boolean[] chickenVisited; // 뽑은 치킨집 체크

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n + 1][n + 1];
        temp = new int[n + 1][n + 1];

        home = new ArrayList<>();
        chicken = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    chicken.add(new Node(i, j));
                } else if (map[i][j] == 1) {
                    home.add(new Node(i, j));
                }
            }
        }

        chickenVisited = new boolean[chicken.size()];
        dfs(0, 0);
        System.out.println(ans);
    }

    static void dfs(int start, int cnt) {
        if (cnt == m) {
            int sum = 0; // 도시의 치킨 거리

            for (int i = 0; i < home.size(); i++) {
                int chickenDist = Integer.MAX_VALUE; // 해당 집의 치킨 거리
                for (int j = 0; j < chicken.size(); j++) { // 해당 집과 치킨집들 사이의 거리
                    if (chickenVisited[j]) {
                        int nowDist = Math.abs(home.get(i).x - chicken.get(j).x)
                                + Math.abs(home.get(i).y - chicken.get(j).y);

                        chickenDist = Math.min(chickenDist, nowDist);
                    }
                }
                sum += chickenDist;
            }

            ans = Math.min(ans, sum);
            return;
        }

        // 백트래킹
        for (int i = start; i < chicken.size(); i++) { // 치킨집 별로 돌면서 m개 조합 만들기
            chickenVisited[i] = true;
            dfs(i + 1, cnt + 1);
            chickenVisited[i] = false;
        }
    }
}

class Node {
    int x;
    int y;

    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}