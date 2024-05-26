import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        if (input.contains("D2") || input.contains("d2")) {
            System.out.println("D2");
        } else {
            System.out.println("unrated");
        }
    }
}