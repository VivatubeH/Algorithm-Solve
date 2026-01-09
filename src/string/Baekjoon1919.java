package string;
import java.util.Scanner;

public class Baekjoon1919 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String first = scanner.nextLine();
        String second = scanner.nextLine();

        int[] frequency1 = new int[26];
        int[] frequency2 = new int[26];

        for (int i = 0; i < first.length(); i++) {
            char ch = first.charAt(i);
            frequency1[ch - 'a']++;
        }
        for (int i = 0; i < second.length(); i++) {
            char ch = second.charAt(i);
            frequency2[ch - 'a']++;
        }

        int sum = 0;
        for (int i = 0; i < 26; i++) {
            sum += Math.abs(frequency1[i] - frequency2[i]);
        }

        System.out.print(sum);
    }
}
