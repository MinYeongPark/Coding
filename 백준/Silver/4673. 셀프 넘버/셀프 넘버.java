public class Main {
    public static void main(String[] args) {
        boolean[] numbers = new boolean[10001];
        for (int i = 1; i <= 10000; i++) {
            int next_num = i;
            int temp_num = next_num;
            while (temp_num != 0) {
                next_num += temp_num % 10;
                temp_num /= 10;
            }
            if (next_num <= 10000) {
                numbers[next_num] = true;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 10000; i++) {
            if (!numbers[i]) {
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb);
    }
}