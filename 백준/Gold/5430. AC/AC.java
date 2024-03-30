import java.util.*;
import java.io.*;

public class Main
{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        Loop1:
        for (int tc = 0; tc < t; tc++) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());

            String arr_all = br.readLine();
            String arr_in = arr_all.substring(1, arr_all.length() - 1);
            String[] arr_str = arr_in.split(",");

            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(Integer.parseInt(arr_str[i]));
            }

            boolean isRight = false; // 배열의 시작 방향
            for (int i = 0; i < p.length(); i++) {
                char c = p.charAt(i);
                switch(c) {
                    case 'R' :
                        isRight = !isRight;
                        break;
                    case 'D' :
                        if (!list.isEmpty()) {
                            list.remove(isRight ? list.size() - 1 : 0);
                        }
                        else {
                            sb.append("error").append("\n");
                            continue Loop1;
                        }
                        break;
                }
            }

            sb.append("[");

            if (list.size() >= 1) {
                if (isRight) {
                    for (int i = list.size() - 1; i > 0; i--) {
                        sb.append(list.get(i)).append(",");
                    }
                    sb.append(list.get(0));
                } else {
                    for (int i = 0; i < list.size() - 1; i++) {
                        sb.append(list.get(i)).append(",");
                    }
                    sb.append(list.get(list.size() - 1));
                }
            }
            sb.append("]").append("\n");
        }

        System.out.println(sb);
    }
}