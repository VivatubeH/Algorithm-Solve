package BruteForceSimulation;
import java.util.*;
import java.io.*;

public class Baekjoon2840 {
    public static int currentIndex = 0; // 바퀴의 현재 인덱스 ( 어느 위치에 있는지 )
    public static boolean isValid = true; // 바퀴 회전이 유효한지 체크하기 위한 변수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 바퀴의 칸 N, 바퀴를 돌리는 횟수 K가 주어진다.
        StringTokenizer firstLine = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(firstLine.nextToken()); // 바퀴의 칸 수 N
        int K = Integer.parseInt(firstLine.nextToken()); // 바퀴를 돌리는 횟수 K
        char[] wheel = new char[N]; // N칸의 바퀴 모양을 그릴 판
        // 바퀴판 초기화
        for (int i = 0; i < wheel.length; i++) {
            wheel[i] = '?';
        }

        for (int i = 0; i < K; i++) { // K줄에 걸쳐서 바퀴를 돌림.
            StringTokenizer spinCase = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(spinCase.nextToken()); // 회전 시 화살표가 몇 번 바뀌었는지
            char charAfterSpin = spinCase.nextToken().charAt(0); // 화살표가 가리키는 문자를 가져옴
            isValid = paint(wheel, S, charAfterSpin); // 데이터를 토대로 바퀴를 그린다. 바퀴 회전이 유효한지 기록
            if (!isValid) break; // 유효하지 않은 회전이면 더 이상 체크할 필요가 없음. isValid = false인 채로 반복문 종료
        }

        if (!isValid) System.out.print("!"); // 유효하지 않을 때는 !만 출력
        else { // 유효할 때는 판을 currentIndex부터 시계방향으로 출력
            for (int i = currentIndex; i < N; i++) {
                System.out.print(wheel[i]);
            }
            for (int i = 0; i < currentIndex; i++) {
                System.out.print(wheel[i]);
            }
        }
    }

    // 바퀴를 S번 화살표가 바뀔 때, 가리키는 문자를 토대로 바퀴를 그린다.
    // 만약 불가능한 바퀴 모양이 될 경우 false 반환
    public static boolean paint(char[] wheel, int S, char charAfterSpin) {
        int actMove = S % wheel.length; // 실제로 이동할 칸수는 주기성 고려해서 나머지 연산

        // 이렇게 actMove만큼 기본적으로 시계 반대 방향 이동이므로 currentIndex - actMove임.
        // 여기서, 음수 인덱스를 방지하려면 currentIndex - actMove가 >= 0이라면 그대로 쓰면 되고,
        // currentIndex - actMove가 음수라면 currentIndex + (N - actMove)로 하면 됨.
        // 뒤로 x칸 이동 == 앞으로 N - x칸 이동.
        if (currentIndex - actMove >= 0) {
            currentIndex = currentIndex - actMove;
        } else { // 음수 인덱스 보정
            currentIndex = currentIndex + (wheel.length - actMove);
        }

        // 아직 결정되지 않은 칸이면 기록한다.
        if (wheel[currentIndex] == '?') { // 아직 해당 칸이 비어있는 경우
            for (int i = 0; i < wheel.length; i++) { // 다른 칸에 해당 알파벳이 없어야 해당 알파벳을 할당한다.
                if (wheel[i] == charAfterSpin && currentIndex != i) { // 동일한 알파벳이 다른 칸에 존재하면
                    return false; // 모순이므로 false를 반환
                }
            }
            wheel[currentIndex] = charAfterSpin;
        } else if (wheel[currentIndex] != charAfterSpin) { // ?도 아닌데 알파벳이 다른 경우라면 ( 잘못된 경우 )
            return false; // 불가능한 경우니 false 반환
        }
        return true; // 모순점이 없으면 true 반환
    }
}
