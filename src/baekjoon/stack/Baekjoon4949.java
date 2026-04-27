package stack;
import java.io.*;
import java.util.*;

/*
 * 입력: 문자열 ( 마지막 글자를 제외하고 영문 알파벳, 공백, 소괄호, 대괄호로 이루어진 문자열 / 온점으로 끝남 / 길이는 100 이하 ) 입력 종료조건 "."
 * 출력: 문자열이 균형을 이루고 있으면 yes, 아니면 no 출력
 *
 * 알고리즘: 스택(Stack)
 * 발상: 괄호 짝만 체크하면 됨. 나중에 들어온 괄호와의 매핑이 필요하므로 후입선출의 스택을 사용함. O(1)에 삽입/삭제
 *
 * 시간: O(T * N) - N은 문자열의 길이
 * 주의: 입력 종료 조건 및 괄호 판단 기준을 명확하 세워야 한다.

 * */

public class Baekjoon4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<Character> stack = new ArrayDeque<>();

        String input;
        while (!(input = br.readLine()).equals(".")) {
            boolean isBalanced = true;
            for (int i = 0; i < input.length(); i++) {
                char ch = input.charAt(i);

                if (ch == '(' || ch == '[') {
                    stack.push(ch);
                }
                else if (ch == ')' || ch == ']') {
                    if (stack.isEmpty()) {
                        isBalanced = false;
                        break;
                    } else {
                        char current = stack.pop();
                        if ((current == '(' && ch == ']') || (current == '[' && ch == ')')) {
                            isBalanced = false;
                            break;
                        }
                    }
                }
            }
            if (!stack.isEmpty() || !isBalanced) bw.write("no\n");
            else bw.write("yes\n");

            stack.clear();
        }
        bw.flush();
    }
}
