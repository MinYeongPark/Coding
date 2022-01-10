import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        int w = Integer.parseInt(input[0]); //가로
        int h = Integer.parseInt(input[1]); //세로

        int n = Integer.parseInt(br.readLine()); //개수

        int[][] p = new int[w][h];
        for (int i = 0; i < n; i++) {
            String[] in = br.readLine().split(" ");
            int l = Integer.parseInt(in[0]);
            int d = Integer.parseInt(in[1]);
            int x = Integer.parseInt(in[2]) - 1;
            int y = Integer.parseInt(in[3]) - 1;

            for (int j = 0; j < l; j++) {
                p[x][y] = 1;
                if (d == 1) x++;
                else y++;
            }
        }

        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                bw.write(String.format("%d ", p[i][j]));
            }
            bw.write("\n");
        }
        bw.flush();
    }
}
