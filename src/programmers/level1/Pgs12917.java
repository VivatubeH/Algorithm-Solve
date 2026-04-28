package programmers.level1;
import java.util.Arrays;
/*
 * 알고리즘: 정렬
 * 발상: 문자열의 각 문자의 코드값을 int 배열에 저장하고, 배열을 오름차순 정렬한다.
 *       이후 내림차순으로 StringBuilder를 이용해 붙여서 문자열을 반환한다.
 * 시간복잡도: O(L log L)
 * 주의 포인트: Arrays.sort()가 기본형 내림차순은 지원하지 않아서, 역순 순회를 썼다.
 */
public class Pgs12917 {
    public String solution(String s) {
        // 문자열의 길이를 개수로 하는 int 배열 생성
        int[] array = new int[s.length()];
        // charAt()을 통해 해당 문자의 코드값을 int[]에 저장
        for (int i = 0; i < array.length; i++) {
            array[i] = s.charAt(i);
        }
        // 배열을 오름차순 정렬한다.
        Arrays.sort(array);
        StringBuilder builder = new StringBuilder();
        // 정렬된 코드값을 문자열로 반환해야하는데 내림차순으로 붙여야함.
        for (int i = array.length - 1; i >= 0; i--) {
            builder.append((char)(array[i]));
        }
        // StringBuilder를 String으로 변환 후 반환
        return builder.toString();
    }
}
