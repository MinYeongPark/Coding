import java.io.*;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> { // 정렬 기준 다시 세움 // o1과 o2를 비교한다
            int first_abs = Math.abs(o1);
            int second_abs = Math.abs(o2);

            if(first_abs == second_abs) {
                return o1 > o2 ? 1 : -1; // 절댓값이 같은 경우 음수 우선
            }
            return first_abs - second_abs; // 절댓값 작은 데이터 우선
        });

        for (int i = 0; i < n; i++) {
            int request = Integer.parseInt(br.readLine());
            if (request == 0) {
                if (pq.isEmpty()) {
                    System.out.println("0");
                } else {
                    System.out.println(pq.poll());
                }
            } else {
                pq.add(request);
            }
        }
    }
}