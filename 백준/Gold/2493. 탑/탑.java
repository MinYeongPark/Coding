import java.util.*;
import java.io.*;

public class Main
{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Node> s = new Stack<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        s.push(new Node(0, 100000001));
        for (int i = 1; i <= n; i++) {
            int now = Integer.parseInt(st.nextToken());
            while (s.peek().height < now) {
                s.pop();
            }
            sb.append(s.peek().num).append(" ");

            s.push(new Node(i, now));
        }
        System.out.println(sb);
    }
}

class Node {
    int num;
    int height;

    Node (int num, int height) {
        this.num = num;
        this.height = height;
    }
}