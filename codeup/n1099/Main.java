import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[][] p = new int[10][10];

        for (int i = 0; i < 10; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < 10; j++) {
                p[i][j] = Integer.parseInt(input[j]);
            }
        }

        int x = 1, y = 1;

        while (p[x][y] != 2) {
            p[x][y] = 9;
            if (p[x][y+1] == 1 && p[x+1][y] == 1) break;
            if (p[x][y+1] != 1) y++;
            else x++;
        }
        if (p[x][y] == 2) p[x][y] = 9;
        
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                bw.write(String.format("%d ", p[i][j]));
            }
            bw.write("\n");
        }
        bw.flush();
    }
}

