package string;
import java.util.Scanner;

public class Baekjoon1157 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        String upperString = input.toUpperCase();

        int[] frequency = new int[26];
        for (int i = 0; i < upperString.length(); i++) {
            char ch = upperString.charAt(i);
            frequency[ch - 'A']++;
        }

        int maxFrequency = 0;
        char maxAlpha = ' ';
        for (int i = 0; i < 26; i++) {
            if (frequency[i] >= maxFrequency) {
                if (frequency[i] == maxFrequency) {
                    maxAlpha ='?';
                } else {
                    maxAlpha = (char) ('A' + i);
                }
                maxFrequency = frequency[i];
            }
        }
        System.out.print(maxAlpha);
    }
}
