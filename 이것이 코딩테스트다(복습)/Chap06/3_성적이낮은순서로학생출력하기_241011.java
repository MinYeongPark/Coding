/*
 * @author Minyeong Park
 * @date 2024.10.11.
 * 성적이 낮은 순서로 학생 출력하기
 * '이것이 코딩테스트다' Chap06 정렬 - 실전 문제 3
 */

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        ArrayList<Node> list = new ArrayList<Node>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new Node(st.nextToken(), Integer.parseInt(st.nextToken())));
        }
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(list.get(i).name + " ");
        }
        System.out.println(sb);
    }
}

class Node implements Comparable<Node> {
    String name;
    int grade;

    public Node(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    @Override
    public int compareTo(Node other) {
        if (other.grade < this.grade) {
            return 1;
        } else if (other.grade == this.grade) {
            return 0;
        }
        return -1;
    }
}