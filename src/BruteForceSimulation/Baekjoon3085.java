package BruteForceSimulation;
import java.io.*;
import java.util.*;

public class Baekjoon3085 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 1; // 구하고자 하는 답 ( 최대 연속 사탕의 길이 )
        // N x N칸의 보드
        char[][] board = new char[N][N];
        // N x N줄의 사탕을 입력받는다.
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                // 사탕을 초기에 입력받는다.
                board[i][j] = line.charAt(j);
            }
        }
        // 초기 사탕의 최대 연속 길이를 구한다.
        answer = Math.max(answer, getMaxConsecutiveCandy(board));
        // 가로, 세로 방향 인접 사탕 회전을 하면서 최대 연속 길이 사탕을 구한다.
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1; j++) {
                // 같은 행에서 인접열 바꾸기
                char temp = board[i][j];
                board[i][j] = board[i][j+1];
                board[i][j+1] = temp;
                // 최대 연속 길이가 더 길면 갱신
                answer = Math.max(answer, getMaxConsecutiveCandy(board));
                // 원 위치
                temp = board[i][j + 1];
                board[i][j + 1] = board[i][j];
                board[i][j] = temp;
            }
        }
        for (int j = 0; j < N; j++) {
            for (int i = 0; i < N - 1; i++) {
                // 같은 열에서 인접행 바꾸기
                char temp = board[i][j];
                board[i][j] = board[i + 1][j];
                board[i + 1][j] = temp;
                // 최대 연속 길이가 더 길면 갱신
                answer = Math.max(answer, getMaxConsecutiveCandy(board));
                // 원 위치
                temp = board[i + 1][j];
                board[i + 1][j] = board[i][j];
                board[i][j] = temp;
            }
        }

        // 정답 출력
        System.out.print(answer);
    }

    // 보드를 입력받은 뒤, 보드를 토대로 최대 연속 길이 사탕을 측정하는 메서드
    public static int getMaxConsecutiveCandy(char[][] board) {
        int N = board.length;

        // 사탕의 최대 연속 길이를 구하기 위한 변수들
        int max = 1; // 최대 연속 길이는 초기값 1
        int len = 1; // 현재 사탕의 연속 길이를 저장할 변수, 초기값 1

        // 가로 범위 연속 사탕 길이 측정
        for (int i = 0; i < N; i++) {
            len = 1; // 줄이 바뀔 때마다 현재 연속 사탕 길이는 1로 초기화
            for (int j = 0; j < N - 1; j++) { // 인덱스 범위 생각
                if (board[i][j] == board[i][j + 1]) { // 가로로 인접 사탕이 같으면
                    len++; // len 증가
                    if (len > max) max = len; // 현재 연속 길이가 최대 연속 길이보다 길 때만 갱신
                } else {
                    len = 1; // len 초기화
                }
            }
        }

        // 세로 범위 연속 사탕 길이 측정
        for (int j = 0; j < N; j++) {
            len = 1; // 행이 바뀔 때마다 현재 연속 사탕 길이는 1로 초기화
            for (int i = 0; i < N - 1; i++) { // 인덱스 범위 생각
                if (board[i][j] == board[i + 1][j]) { // 세로로 인접 사탕이 같으면
                    len++; // len 증가
                    if (len > max) max = len; // 현재 연속 길이가 최대 연속 길이보다 길 때만 갱신
                } else {
                    len = 1;
                }
            }
        }

        return max; // 최대 연속 사탕의 길이를 반환한다.
    }
}
