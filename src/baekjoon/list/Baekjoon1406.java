package list;
import java.io.*;
import java.util.*;
/*
 * 입력: 길이가 최대 10만인 문자열, 명령어의 개수 M ( 1 ~ 50만개), M개의 명령어가 줄 마다 주어짐.
 * 출력: 편집기에 입력되어 있는 문자열
 *
 * 알고리즘: 연결리스트 활용 ( 앞, 뒤에서 삽입/삭제 )
 * 발상: 커서의 앞 리스트, 커서의 뒤 리스트 2개로 나누어서 관리한다.
 *
 * 시간: O(N + M) - 명령어를 리스트에 넣은 다음, 명령어 개수만큼 O(1)으로 추가 삭제, 이후 O(N)으로 출력
 * 주의: 커서가 무시되는 경우에 대해 체크가 필요.

*/

public class Baekjoon1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();

        String word = br.readLine();

        LinkedList<Character> beforeCursor = new LinkedList<>();
        LinkedList<Character> afterCursor = new LinkedList<>();

        for (int i = 0; i < word.length(); i++) {
            beforeCursor.addLast(word.charAt(i));
        }

        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            String instruction = br.readLine();

            char instruct = instruction.charAt(0);

            if (instruct == 'L') {
                if (!beforeCursor.isEmpty()) {
                    afterCursor.addFirst(beforeCursor.removeLast());
                }
            } else if (instruct == 'D') {
                if (!afterCursor.isEmpty()) {
                    beforeCursor.addLast(afterCursor.removeFirst());
                }
            } else if (instruct == 'B') {
                if (!beforeCursor.isEmpty()) {
                    beforeCursor.removeLast();
                }
            } else if (instruct == 'P') {
                char ch = instruction.charAt(2);
                beforeCursor.addLast(ch);
            }
        }

        for (Character ch : beforeCursor) {
            answer.append(ch);
        }
        for (Character ch : afterCursor) {
            answer.append(ch);
        }
        System.out.print(answer);
    }
}
