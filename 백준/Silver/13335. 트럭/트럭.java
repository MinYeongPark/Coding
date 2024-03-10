import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken()); // 다리 길이
        int l = Integer.parseInt(st.nextToken()); // 다리 최대 하중

        st = new StringTokenizer(br.readLine());
        Queue<Integer> truck = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            truck.add(Integer.parseInt(st.nextToken()));
        }

        int time = 0;
        int onBridge = 0;
        Queue<Integer> q = new LinkedList<>(); // 단위 시간 마다 빠져나오는 트럭에 대한 큐
        for (int i = 0; i < w; i++) {
            q.add(0); // 처음에는 아무 트럭도 안 빠져나오니까 0으로 추가..
        }

        while (!q.isEmpty()) {
            time++;
            onBridge -= q.poll(); // 다리를 건넌 트럭 무게 빼기
            if (!truck.isEmpty()) {
                if (onBridge + truck.peek() <= l) {
                    onBridge += truck.peek();
                    q.add(truck.poll());
                } else {
                    q.add(0); // 이번 단위 시간에는 아무것도 안 들어가니까 0 추가
                }
            }
        }

        System.out.println(time);
    }
}