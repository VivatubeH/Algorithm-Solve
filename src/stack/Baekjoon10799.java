package stack;
import java.io.*;
import java.util.*;

/*
 * 입력: 쇠막대기와 레이저의 배치를 나타내는 괄호 표현 - 레이저는 인접한 괄호쌍 '()', 쇠막대기의 왼쪽 끝은 '(', 오른쪽 끝은 닫힌 괄호 ')'
 * 출력: 쇠막대기와 레이저를 판단해서 잘린 조각의 개수 구하기
 *
 * 알고리즘: 스택(Stack)
 * 발상: 레이저와 막대의 끝을 어떻게 구분할지? -> 레이저는 '()'가 인접한 쌍, 반면 쇠막대의 오른쪽 끝 앞은 ')' 반드시 이거여야 함.
 * - 그러면 '(' 뿐만 아니라 ')'에 대한 체크도 필요함. ( 가장 최근에 입력된 조각이 무엇인가? )를 별도의 스택으로 관리
 * - 방법 :
 * - 입력 시에는 '('는 openStack과 recordStack에 모두 push하고,
 * - ')'가 입력되면 레이저이면 recordStack의 peek()으로 봤을 때, '('이면 레이저 괄호쌍이므로 openStack에서 pop()을 하고 stack.size()만큼이 잘린 막대 개수/ 이후 recordStack.push()
 * - ')'가 입력되었는데 recordStack.peek()이 ')'이면 막대의 끝이므로 openStack에서 pop()을 하고, 1개를 카운팅해준다. ( 해당 막대의 끝 ) 이후 recodStack.push
 * 시간: O(L) - 괄호 문자의 개수
 * 주의: 코드 수행 로직 명확히 설계 후, 진행하기.

 * */

public class Baekjoon10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        Deque<Character> openStack = new ArrayDeque<>();
        Deque<Character> recordStack = new ArrayDeque<>();

        int size = 0;

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if (ch == '(') {
                openStack.push(ch);
                recordStack.push(ch);
            } else {
                // recordStack이 비어있을 수 있는가?
                // 문제 조건에 의해 첫 입력은 '('이 보장되고 recordStack에서 pop()하는 경우가 없으므로 안전
                if (recordStack.peek() == '(') {
                    openStack.pop();
                    size += openStack.size();
                } else if (recordStack.peek() == ')') {
                    openStack.pop();
                    size += 1;
                }
                recordStack.push(ch);
            }
        }
        System.out.print(size);
    }
}
