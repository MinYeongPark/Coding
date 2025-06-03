import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main
{
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[] moneyList1 = {5000000, 3000000, 2000000, 500000, 300000, 100000};
        int[] peopleList1 = {1, 2, 3, 4, 5, 6};
        int[] peopleSumList1 = new int[peopleList1.length];
        int[] moneyList2 = {5120000, 2560000, 1280000, 640000, 320000};
        int[] peopleList2 = {1, 2, 4, 8, 16};
        int[] peopleSumList2 = new int[peopleList2.length];

        int t = Integer.parseInt(br.readLine());
        peopleSumList1[0] = peopleList1[0];
        for (int i = 1; i < peopleSumList1.length; i++) {
            peopleSumList1[i] = peopleSumList1[i - 1] + peopleList1[i];
        }
        peopleSumList2[0] = peopleList2[0];
        for (int i = 1; i < peopleSumList2.length; i++) {
            peopleSumList2[i] = peopleSumList2[i - 1] + peopleList2[i];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int priceA = 0, priceB = 0;

            if (a != 0) {
                for (int j = 0; j < peopleSumList1.length; j++) {
                    if (a <= peopleSumList1[j]) {
                        priceA = moneyList1[j];
                        break;
                    }
                }
            }

            if (b != 0) {
                for (int j = 0; j < peopleSumList2.length; j++) {
                    if (b <= peopleSumList2[j]) {
                        priceB = moneyList2[j];
                        break;
                    }
                }
            }
            sb.append(priceA + priceB).append("\n");
        }
        System.out.println(sb);
    }
}