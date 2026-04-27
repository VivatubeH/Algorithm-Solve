package BruteForceSimulation;
import java.io.*;
import java.util.*;

public class Baekjoon11068 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) { // testCase별로
            int number = Integer.parseInt(br.readLine());
            boolean isPalindrome = false; // 회문을 만족하는지 확인하기 위한 변수
            for (int b = 2; b <= 64; b++) { // 2에서 64진법에 대해서
                String result = integerToBString(number, b); // 진법 변환을 수행하고
                if (checkPalindrome(result)) { // 해당 진법 변환 시, 회문을 만족하면
                    isPalindrome = true; // 회문임을 체크하고
                    break; // 반복문 탈출
                }
            }
            // Palindrome이 되는 경우가 있는 경우에는 1 출력, 아닌 경우에는 0 출력
            if (isPalindrome) {
                bw.write("1\n");
            } else {
                bw.write("0\n");
            }
        }
        bw.flush();
    }

    /*
        num를 B진법의 String으로 변환 후, 반환하는 메서드
     */
    public static String integerToBString(int num, int B) {
        StringBuilder result = new StringBuilder();
        while (num >= B) { // B로 나눌 수 있는 동안은 나눈다.
            int remain = num % B; // num를 B로 나눈 나머지를
            num /= B; // 나눌 수 있을 때는 나눈다.
            if (remain >= 10) {
                result.append((char)('A' + (remain - 10))); // 나머지가 10보다 크면 진법 변환이 필요.
            } else {
                result.append(remain); // 아닌 경우, 숫자를 그대로 붙인다.
            }
        }
        // 남은 수 역시 result에 변환 후 덧붙인다.
        if (num >= 10) result.append((char)('A' + (num - 10)));
        else result.append(num);

        return result.reverse().toString(); // 진법 변환된 문자열을 반환한다.
    }

    // 특정 B진법 변환된 문자열이 회문인지 확인하는 메서드
    // 회문이면 true, 아니면 false를 반환
    public static boolean checkPalindrome(String word) {
        // 변환된 문자열을 뒤집어본다.
        String reversedString = new StringBuilder(word).reverse().toString();
        // 뒤집었을 때 같으면 회문이 된다.
        if (word.equals(reversedString)) return true;
        return false;
    }
}
