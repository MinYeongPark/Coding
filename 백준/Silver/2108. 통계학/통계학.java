import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[8001]; // 입력값의 범위 : -4000 ~ 4000
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int mid = 10000; // 중앙값
        int mode = 10000; // 최빈값
        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(br.readLine());
            sum += value;
            arr[value + 4000]++;

            max = Math.max(max, value);
            min = Math.min(min, value);
        }

        System.out.println(Math.round((double) sum / n));

        // 순회
        int count = 0; // 중앙값 빈도 누적 수
        int mode_max = 0; // 최빈값의 최댓값

        // 이전의 동일한 최빈값이 1번만 등장했을 경우 true, 아닐 경우 false
        boolean flag = false;

        for (int i = min + 4000; i <= max + 4000; i++) {
            // 중앙값 찾기 : 누적횟수가 전체 길이의 절반에 못 미친다면
            if (count < (n + 1) / 2) {
                count += arr[i]; // i값의 빈도수를 count에 누적
                mid = i - 4000;
            }

            // 최빈값 찾기 : 이전 최빈값보다 현재 값의 빈도수가 더 높을 경우
            if (mode_max < arr[i]) {
                mode_max = arr[i];
                mode = i - 4000;
                flag = true; // 첫 등장이므로 true로 변경
            }
            // 이전 최빈값 최댓값과 동일한 경우면서 한 번만 중복되는 경우
            else if (mode_max == arr[i] && flag == true) {
                mode = i - 4000;
                flag = false;
            }
        }
        System.out.println(mid);
        System.out.println(mode);
        System.out.println(max - min);
    }
}