import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        Loop1:
        for (int t = 0; t < tc; t++) {
            String func = br.readLine();
            String[] command = func.split("");
            int n = Integer.parseInt(br.readLine());

            String str = br.readLine();
            str = str.substring(1, str.length() - 1);
            ArrayList<Integer> num_list = new ArrayList<>();
            String[] nums = str.split(",");
            for (int i = 0; i < n; i++) {
                if (!nums[i].equals("")) {
                    num_list.add(Integer.parseInt(nums[i]));
                }
            }

            boolean isRight = false;

            for (int i = 0; i < command.length; i++) {
                if (command[i].equals("R")) {
                    isRight = isRight ? false : true;
                } else if (command[i].equals("D")) {
                    if (num_list.isEmpty()) {
                        sb.append("error").append("\n");
                        continue Loop1;
                    }
                    num_list.remove(isRight ? num_list.size() - 1 : 0);
                } else {
                    sb.append("error").append("\n");
                    continue Loop1;
                }
            }

            sb.append("[");
            if (num_list.size() >= 1) {
                if (isRight) {
                    for (int i = num_list.size() - 1; i > 0; i--) {
                        sb.append(num_list.get(i)).append(",");
                    }
                    sb.append(num_list.get(0));
                } else {
                    for (int i = 0; i < num_list.size() - 1; i++) {
                        sb.append(num_list.get(i)).append(",");
                    }
                    sb.append(num_list.get(num_list.size() - 1));
                }
            }
            sb.append("]").append("\n");
        }
        System.out.println(sb);
    }
}