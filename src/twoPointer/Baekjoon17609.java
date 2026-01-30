package twoPointer;
import java.io.*;
import java.util.*;

public class Baekjoon17609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String word = br.readLine();
            int result = check(word, 0, word.length() - 1);
            bw.write(result + "\n");
        }
        bw.flush();
    }

    // 회문이면 0, 유사회문이면 1, 둘 다 아니면 2를 반환하는 메서드
    public static int check(String word, int left, int right) {
        while (left < right) {
            char leftCh = word.charAt(left);
            char rightCh = word.charAt(right);

            // 회문 0이 아니면
            if (leftCh != rightCh) {
                // 왼족 문자를 삭제해서 회문이거나, 오른쪽 문자를 삭제해서 회문이면 유사 회문
                if (isPalindrome(word, left + 1, right) || isPalindrome(word, left, right - 1)) {
                    return 1;
                }
                // 둘다 거짓이면 유사회문도 아니므로
                else {
                    return 2;
                }
            }

            left++;
            right--;
        }
        return 0; // 마지막까지 돌아가면 회문이다.
    }

    // 회문인지를 체크하는 메서드
    public static boolean isPalindrome(String word, int left, int right) {
        while (left < right) {
            if (word.charAt(left) != word.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
