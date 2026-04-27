package programmers.level1;

/*
    알고리즘 : 문자열
    발상 : 문자열을 순회하며 p, y 개수를 각각 세고, 마지막에 개수를 비교한다.
    시간복잡도 : O(N)
    주의 포인트: p와 y가 모두 없는 경우도 0 == 0 true
 */
public class Pgs12916 {
    public boolean solution(String s) {
        int countP = 0;
        int countY = 0;

        // 대소문자 구분이 없으므로 대,소문자 모두 체크한다.
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'p' || s.charAt(i) == 'P') {
                countP++;
            } else if (s.charAt(i) == 'y' || s.charAt(i) == 'Y') {
                countY++;
            }
        }
        // 두 알파벳의 개수가 같을 때만 true를 반환한다.
        // 모두 없을 땐, 0개로 같으니 별도 처리는 하지 않는다.
        return countP == countY;
    }
}
