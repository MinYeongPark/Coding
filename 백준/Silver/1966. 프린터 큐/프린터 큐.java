import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            LinkedList<int[]> q = new LinkedList<>(); // 큐로 활용할 연결리스트 // 꼭 큐로 선언 안 해도 된다!
            for (int j = 0; j < n; j++) {
                q.add(new int[] {j, Integer.parseInt(st.nextToken())});
            }

            int cnt = 0;
            while (!q.isEmpty()) {
                int[] front = q.poll(); // 가장 첫 원소
                boolean isMax = true; // front 원소가 가장 큰 원소인지 판단하는 변수

                // 큐에 남아 있는 원소들과 중요도 비교
                for (int j = 0; j < q.size(); j++) {
                    if (front[1] < q.get(j)[1]) { // 처음 뽑은 원소 중요도 < 큐에 있는 i번재 원소 중요도
                        // 뽑은 원소 및 j 이전의 원소들을 뒤로 보냄.
                        q.add(front);
                        for (int k = 0; k < j; k++) {
                            q.add(q.poll());
                        }

                        // front 원소가 가장 큰 원소가 아니였으므로 false를 하고 탐색을 마침
                        isMax = false;
                        break;
                    }
                }

                if (isMax == false) {
                    continue;
                }

                // front원소가 가장 큰 원소였으므로 해당 원소는 출력해야 함
                cnt++;
                if (front[0] == m) { // 찾고자 하는 문서라면 해당 테스트케이스 종료
                    break;
                }
            }


            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}