package programmers.level1;
import java.util.*;

/*
 * 알고리즘: 정렬
 * 발상: n번째 문자를 1차 기준으로 정렬하고, 같으면 문자열 전체를 사전순으로 정렬한다.
 * 시간복잡도: O(N * N log N)
 * 주의 포인트: n번째 문자만 비교해야 하므로 substring(n) 비교가 아니라 charAt(n) 비교를 해야 한다.
 */
public class Pgs12915 {
    public static void main(String[] args) {
        String[] strings = {"abce", "abcd", "cdx"};
        String[] results = solution(strings, 2);
        for (String str : results) {
            System.out.println(str);
        }
    }

    public static String[] solution(String[] strings, int n) {
        // 정렬 메서드를 사용한다.
        Arrays.sort(strings, (s1, s2) -> {
            // n번째 알파벳이 같으면 사전순 정렬
            if (s1.charAt(n) == s2.charAt(n)) return s1.compareTo(s2);
                // n번째 알파벳이 다르면, 알파벳 기준 오름차순 정렬
            else return s1.charAt(n) - s2.charAt(n);
        });
        return strings;
    }
}
