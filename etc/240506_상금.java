/*
 * @author Minyeong Park
 * @date 2024.05.06.
 * 상금
 * p.s) 지저분하게 푼 풀이인데,, 다음에 보완해보겠습니다
 */

import java.util.*;

// specs를 어떻게 담아야 할지 애매해서 임의로 String[]으로 담았습니다..!

public class Main {
    public static void main(String[] args) {
        // 예제1
        String[][] specs = {
                {"A", "10", "3"},
                {"B", "20", "4"},
                {"C", "15", "5"}
        };

        // 예제2
//        String[][] specs = {
//                {"YJJ", "100", "17"},
//                {"PYS", "20", "20"}
//        };

        // 예제3
//        String[][] specs = {
//                {"B", "10", "3"},
//                {"A", "10", "3"},
//                {"BB", "10", "3"},
//                {"AA", "10", "3"}
//        };
        String[] result = solution(specs);

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < result.length - 1; i++) {
            sb.append("\"" + result[i] + "\", ");
        }
        sb.append("\"" + result[result.length - 1] + "\"");
        sb.append("]");
        System.out.println(sb);
    }

    static String[] solution(String[][] specs) {
        ArrayList<Node> board = new ArrayList<>(); // 이긴 횟수 점수판
        for (int i = 0; i < specs.length; i++) {
            board.add(new Node(specs[i][0], 0));
        }

        // 경기 치르기
        for (int i = 0; i < specs.length - 1; i++) {
            for (int j = 1; j < specs.length; j++) {
                int winnerIdx = fight(specs[i], specs[j], i, j);

                if (winnerIdx == -1) continue;

                board.set(winnerIdx, new Node(board.get(winnerIdx).name, board.get(winnerIdx).count + 1));
            }
        }

        // 내림차순 정렬
        Collections.sort(board, new Comparator<Node>(){
            @Override
            public int compare(Node n1, Node n2) {
                if (n1.count == n2.count) {
                    int maxLen = Math.max(n1.name.length(), n2.name.length());

                    for (int i = 0; i < maxLen; i++) {
                        if (i >= n1.name.length()) { // n1 길이가 더 작음 - n2가 사전 순으로 더 뒤인 경우
                            return 1;
                        } else if (i >= n2.name.length()) { // n2 길이가 더 작음 - n1가 사전 순으로 더 뒤인 경우
                            return -1;
                        } else { // 길이 같은 경우
                            if (n1.name.charAt(i) == n2.name.charAt(i)) continue;
                            else if (n1.name.charAt(i) > n2.name.charAt(i)) return -1;
                            else return 1;
                        }
                    }
                    return 0;
                }
                else if (n1.count > n2.count) return -1;
                else return 1;
            }
        });

        String[] result = new String[specs.length];
        for (int i = 0; i < board.size(); i++) {
            result[i] = board.get(i).name;
        }
        return result;
    }

    static int fight(String[] s1, String[] s2, int s1Idx, int s2Idx) {
        int p1 = Integer.parseInt(s1[1]) + Integer.parseInt(s2[1]) * Integer.parseInt(s1[2]);
        int p2 = Integer.parseInt(s2[1]) + Integer.parseInt(s1[1]) * Integer.parseInt(s2[2]);

        if (p1 == p2) {
            return -1;
        } else if (p1 > p2) {
            return s1Idx;
        } else {
            return s2Idx;
        }
    }

    static class Node {
        String name;
        int count;

        Node (String name, int count) {
            this.name = name;
            this.count = count;
        }
    }
}

