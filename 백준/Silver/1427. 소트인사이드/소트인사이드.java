import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
             arr.add(input.charAt(i) - '0');
        }
        Collections.sort(arr, Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for (int i : arr) {
            sb.append(i);
        }
        System.out.println(sb);
    }
}