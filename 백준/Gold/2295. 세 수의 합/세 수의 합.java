import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int[] arr;
    static int[] two;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        two = new int[n * (n+1) / 2];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                two[idx++] = arr[i] + arr[j];
            }
        }
        Arrays.sort(two);

        for (int i = n - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (binarySearch(0, two.length - 1, arr[i] - arr[j])) {
                    System.out.println(arr[i]);
                    return;
                }
            }
        }
    }

    static boolean binarySearch(int start, int end, int target) {
        if (start > end) {
            return false;
        }

        int mid = (start + end) / 2;

        if (two[mid] == target) {
            return true;
        } else if (two[mid] > target) {
            return binarySearch(start, mid - 1, target);
        } else {
            return binarySearch(mid + 1, end, target);
        }
    }
}