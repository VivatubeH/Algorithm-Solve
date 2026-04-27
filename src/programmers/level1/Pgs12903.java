package programmers.level1;

/*
 * 알고리즘: 문자열
 * 발상: 길이가 홀수면 가운데 1글자, 짝수면 가운데 2글자를 substring으로 추출
 * 시간복잡도: O(1)
 * 놓친 포인트: 없음
 */
public class Pgs12903 {
    public String solution(String s) {
        int length = s.length();

        if (length % 2 == 0) {
            return s.substring(length / 2 - 1, length / 2 + 1);
        }

        return s.substring(length / 2, length / 2 + 1);
    }
}
