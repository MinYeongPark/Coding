import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static char[][] a0 = {
            {'#','#','#'},
            {'#','.','#'},
            {'#','.','#'},
            {'#','.','#'},
            {'#','#','#'}};

    static char[][] a1 = {
            {'.','.','#'},
            {'.','.','#'},
            {'.','.','#'},
            {'.','.','#'},
            {'.','.','#'}};

    static char[][] a2 = {
            {'#','#','#'},
            {'.','.','#'},
            {'#','#','#'},
            {'#','.','.'},
            {'#','#','#'}};

    static char[][] a3 = {
            {'#','#','#'},
            {'.','.','#'},
            {'#','#','#'},
            {'.','.','#'},
            {'#','#','#'}};

    static char[][] a4 = {
            {'#','.','#'},
            {'#','.','#'},
            {'#','#','#'},
            {'.','.','#'},
            {'.','.','#'}};

    static char[][] a5 = {
            {'#','#','#'},
            {'#','.','.'},
            {'#','#','#'},
            {'.','.','#'},
            {'#','#','#'}};

    static char[][] a6 = {
            {'#','#','#'},
            {'#','.','.'},
            {'#','#','#'},
            {'#','.','#'},
            {'#','#','#'}};

    static char[][] a7 = {
            {'#','#','#'},
            {'.','.','#'},
            {'.','.','#'},
            {'.','.','#'},
            {'.','.','#'}};

    static char[][] a8 = {
            {'#','#','#'},
            {'#','.','#'},
            {'#','#','#'},
            {'#','.','#'},
            {'#','#','#'}};

    static char[][] a9 = {
            {'#','#','#'},
            {'#','.','#'},
            {'#','#','#'},
            {'.','.','#'},
            {'#','#','#'}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        char[][] c1 = new char[5][3];
        char[][] c2 = new char[5][3];
        char[][] c3 = new char[5][3];
        char[][] c4 = new char[5][3];

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 4; j++) {
                String line = st.nextToken();
                for (int k = 0; k < 3; k++) {
                    if (j == 0) {
                        c1[i][k] = line.charAt(k);
                    } else if (j == 1) {
                        c2[i][k] = line.charAt(k);
                    } else if (j == 2) {
                        c3[i][k] = line.charAt(k);
                    } else {
                        c4[i][k] = line.charAt(k);
                    }
                }
            }
        }

        // 가장 빠른 시각 찾기
        int t1 = findEarlyTime(c1);
        int t2 = findEarlyTime(c2);
        int t3 = findEarlyTime(c3);
        int t4 = findEarlyTime(c4);

        System.out.println(t1 + "" + t2 + ":" + t3 + "" + t4);
    }

    static int findEarlyTime(char[][] map) {
        boolean flag = true;

        // 0 비교
        Loop1:
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                if (a0[i][j] == '.' && map[i][j] == '#') {
                    flag = false;
                    break Loop1;
                }
            }
        }
        if (flag) return 0;

        // 1 비교
        flag = true;
        Loop1:
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                if (a1[i][j] == '.' && map[i][j] == '#') {
                    flag = false;
                    break Loop1;
                }
            }
        }
        if (flag) return 1;

        // 2 비교
        flag = true;
        Loop1:
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                if (a2[i][j] == '.' && map[i][j] == '#') {
                    flag = false;
                    break Loop1;
                }
            }
        }
        if (flag) return 2;

        // 3 비교
        flag = true;
        Loop1:
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                if (a3[i][j] == '.' && map[i][j] == '#') {
                    flag = false;
                    break Loop1;
                }
            }
        }
        if (flag) return 3;

        // 4 비교
        flag = true;
        Loop1:
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                if (a4[i][j] == '.' && map[i][j] == '#') {
                    flag = false;
                    break Loop1;
                }
            }
        }
        if (flag) return 4;

        // 5 비교
        flag = true;
        Loop1:
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                if (a5[i][j] == '.' && map[i][j] == '#') {
                    flag = false;
                    break Loop1;
                }
            }
        }
        if (flag) return 5;

        // 6 비교
        flag = true;
        Loop1:
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                if (a6[i][j] == '.' && map[i][j] == '#') {
                    flag = false;
                    break Loop1;
                }
            }
        }
        if (flag) return 6;

        // 7 비교
        flag = true;
        Loop1:
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                if (a7[i][j] == '.' && map[i][j] == '#') {
                    flag = false;
                    break Loop1;
                }
            }
        }
        if (flag) return 7;

        // 8 비교
        flag = true;
        Loop1:
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                if (a8[i][j] == '.' && map[i][j] == '#') {
                    flag = false;
                    break Loop1;
                }
            }
        }
        if (flag) return 8;

        // 9 비교
        flag = true;
        Loop1:
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                if (a9[i][j] == '.' && map[i][j] == '#') {
                    flag = false;
                    break Loop1;
                }
            }
        }
        if (flag) return 9;
        else return -1;
    }
}