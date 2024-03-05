import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == 'c') {
                if (i < str.length() - 1) {
                    if (str.charAt(i+1) == '=')
                        i++;
                    else if (str.charAt(i+1) == '-')
                        i++;
                }
            }
            else if (ch == 'd') {
                if (i < str.length() - 1) {
                    if (str.charAt(i+1) == 'z') {
                        if (i < str.length() - 2) {
                            if (str.charAt(i+2) == '=')
                                i += 2;
                        }
                    }
                    else if (str.charAt(i+1) == '-')
                        i++;
                }
            }
            else if (ch == 'l' || ch == 'n') {
                if (i < str.length() - 1) {
                    if (str.charAt(i+1) == 'j')
                        i++;
                }
            }
            else if (ch == 's' || ch == 'z') {
                if (i < str.length() - 1) {
                    if (str.charAt(i+1) == '=')
                        i++;
                }
            }

            count++;
        }

        System.out.println(count);
    }
}