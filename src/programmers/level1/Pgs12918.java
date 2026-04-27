package programmers.level1;

/*
    알고리즘 : 문자열
    발상 : 길이가 4또는 6인지 먼저 확인하고, 이후 모든 문자가 숫자인지 순회하며 검사
    시간 복잡도 : O(N)
    놓친 포인트 : 없음
 */
public class Pgs12918 {
    public boolean solution(String s) {
        // 길이가 4나 6이 아니면 false 반환
        if (!(s.length() == 4 || s.length() == 6)) {
            return false;
        }
        // 숫자가 아닌 게 존재하면 false 반환
        for (int i = 0; i < s.length(); i++) {
            if (!(s.charAt(i) >= '0' && s.charAt(i) <= '9')) {
                return false;
            }
        }
        // 둘 다 해당 안되면 true
        return true;
    }
}
