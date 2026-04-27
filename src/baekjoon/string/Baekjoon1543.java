package string;
import java.util.Scanner;

public class Baekjoon1543 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String document = scanner.nextLine();
        String target = scanner.nextLine();

        int count = 0;
        int targetLength = target.length();
        int index = 0;

        while ((index = document.indexOf(target, index)) >= 0) {
            count++;
            index += targetLength;
        }
        System.out.print(count);

        /*
        다른 풀이 : replace 활용하기.
        System.out.println(checkFrequencyByReplace(document, target));
        */
    }

    public static int checkFrequencyByReplace(String document, String target) {
        int count = 0;
        String replaced = document.replace(target, "#");
        for (int i = 0; i < replaced.length(); i++) {
            if (replaced.charAt(i) == '#') {
                count++;
            }
        }
        return count;
    }
}
