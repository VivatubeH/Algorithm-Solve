package programmers.level1;

/*
 * 알고리즘: 문자열
 * 발상: 문자열을 순회하면서 현재 알파벳을 최종적으로 몇 칸 미는지 계산한다.
 * 시간복잡도: O(N)
 * 주의 포인트: 공백인 경우 그대로이고, 대소문자에 대해 따로 처리해줘야 한다.
 *              움직이기 전에 몇 칸 움직이는지 미리 계산하고 해야 코드가 깔끔하다.
 */
public class Pgs12926 {
    public String solution(String s, int n) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == ' ') {
                builder.append(ch);
            } else if (ch >= 'a' && ch <= 'z') {
                int current = (ch - 'a' + n) % 26;
                builder.append((char) ('a' + current));
            } else if (ch >= 'A' && ch <= 'Z') {
                int current = (ch - 'A' + n) % 26;
                builder.append((char) ('A' + current));
            }
        }

        return builder.toString();
    }
}
