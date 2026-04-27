package twoPointer;
import java.io.*;
import java.util.*;
/*
 * 입력: 알파벳의 최대 개수 N ( 2 ~ 26), 문자열 ( 길이는 1에서 10만, 모든 char는 알파벳 소문자만 포함 )
 * 출력: 번역기가 인식할 수 있는 문자열의 최대 길이
 *
 * 알고리즘:
 * 발상: 문자열에 포함된 알파벳의 종류를 어떻게 체크할지?
 * - count 사용 : 현재 사용된 알파벳의 개수는 count 변수 하나로 관리한다.
 * - int[] 사용 : 알파벳에 따라 int 배열에 등장 횟수를 체크한다.
 * - 투 포인터 사용 : left, right를 늘려가면서 문자열의 끝까지 추가한다.
 *
 * 시간: O(2 * L) = O(N) 문자열의 길이만큼 투 포인터를 쓰면 된다.
 * 주의: 문자를 추가하면, 문자의 종류가 더 같거나 많아지고 / 문자를 제거하면, 문자의 종류가 더 같거나 적어진다.

 * */

public class Baekjoon16472 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int maxCount = Integer.parseInt(br.readLine()); // 알파벳의 최대 개수 ( 고정 )
        int currentCount = 0; // 알파벳의 종류를 체크하기 위한 변수
        int[] alphaCount = new int[26]; // 알파벳 소문자의 등장 횟수를 체크할 배열
        String word = br.readLine(); // 문자열

        int left = 0;
        int maxLength = 0;

        // right는 length()보다 작은 동안은 증가해야, 인식할 수 있는 최대 문자열 길이 체크가능.
        for (int right = 0; right < word.length(); right++) {
            // right 알파벳을 추가한다.
            char rightChar = word.charAt(right);
            if (alphaCount[rightChar - 'a'] == 0) { // 없던 알파벳일 때만
                currentCount++; // 알파벳 종류를 늘린다.
            }
            alphaCount[rightChar - 'a']++; // 있던 없던 알파벳 숫자는 늘린다.

            // 현재 알파벳이 인식할 수 있는 최대 알파벳보다 많다 = left를 늘려서 currentCount를 줄여본다.
            while (currentCount > maxCount) {
                char leftChar = word.charAt(left);
                if (alphaCount[leftChar - 'a'] == 1) { // 제거했을 때, 해당 알파벳이 없어진다면
                    currentCount--; // 알파벳 종류를 줄인다.
                }
                alphaCount[leftChar - 'a']--; // 알파벳 개수를 줄인다.
                left++;
            }

            // 최대 길이를 갱신한다.
            maxLength = Math.max(maxLength, right - left + 1);
        }
        System.out.print(maxLength);
    }
}
