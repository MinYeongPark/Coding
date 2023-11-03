import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        HashMap<Character, Integer> map = new HashMap<>();
        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
            if (!list.contains(c)) {
                list.add(c);
            }
        }
        Collections.sort(list);

        boolean find_h = false;
        Character center = null;
        for (Character c : map.keySet()) {
            if (map.get(c) % 2 != 0) { // 홀수
                if (find_h) {
                    System.out.println("I'm Sorry Hansoo");
                    return;
                }
                find_h = true;
                center = c;
            }
        }

        StringBuilder result = new StringBuilder();
        // 처음
        for (Character c : list) {
            int c_cnt = map.get(c) / 2;
            for (int i = 0; i < c_cnt; i++) {
                result.append(c);
                map.replace(c, map.get(c) - 1);
            }
        }

        // 중앙
        if (center != null) {
            result.append(center);
            map.replace(center, map.get(center) - 1);
        }

        // 마지막
        Collections.sort(list, Collections.reverseOrder());
        for (Character c : list) {
            int c_cnt = map.get(c);
            for (int i = 0; i < c_cnt; i++) {
                result.append(c);
                map.replace(c, map.get(c) - 1);
            }
        }
        System.out.println(result);
    }
}