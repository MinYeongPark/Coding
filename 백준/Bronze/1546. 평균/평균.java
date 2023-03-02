import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        double[] score = new double[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        double max_score = 0;
        for (int i = 0; i < n; i++) {
            score[i] = Integer.parseInt(st.nextToken());
            if (score[i] > max_score) {
                max_score = score[i];
            }
        }

        double sum = 0;
        for (int i = 0; i < n; i++) {
            score[i] = ((double) score[i] / max_score) * 100;
            sum += score[i];
        }

        double average = (double) sum / n;
        System.out.println(average);
    }
}
