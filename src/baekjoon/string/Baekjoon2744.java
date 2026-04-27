package string;
import java.util.Scanner;

public class Baekjoon2744 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int diff = 'a' - 'A';

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if (ch >= 'a' && ch <= 'z') {
                System.out.print((char)(ch - diff));
            } else if (ch >= 'A' && ch <= 'Z') {
                System.out.print((char)(ch + diff));
            }
        }
    }
}
