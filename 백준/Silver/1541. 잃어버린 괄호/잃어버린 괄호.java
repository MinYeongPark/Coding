import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;
        String[] a = br.readLine().split("-");
        for (int i = 0; i < a.length; i++) {
            int sum = mySum(a[i]);
            if (i == 0) {
                answer += sum;
            } else {
                answer -= sum;
            }
        }
        System.out.println(answer);
    }

    static int mySum(String a) {
        String[] b = a.split("\\+");
        int num = 0;
        for (int i = 0; i < b.length; i++) {
            num += Integer.parseInt(b[i]);
        }
        return num;
    }
}