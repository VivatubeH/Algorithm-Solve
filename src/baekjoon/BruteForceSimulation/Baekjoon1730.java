package BruteForceSimulation;
import java.io.*;
import java.util.*;

public class Baekjoon1730 {
    public static int N; // 목판의 크기 N
    public static boolean[][] isVertical; // 해당 칸을 수직으로 지났는지 체크
    public static boolean[][] isHorizontal; // 해당 칸을 수평으로 지났는지 체크
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine()); // 목판의 크기 N
        isVertical = new boolean[N][N]; // 수직 체크판 생성
        isHorizontal = new boolean[N][N]; // 수평 체크판 생성
        // 로봇팔의 동작을 문자열로 입력받는다.
        String move = br.readLine();
        // 로봇팔을 동작시킨다.
        moveRobot(move);
        // 결과를 출력한다.
        printResult();
    }

    // 로봇팔의 move를 통해 board에 기록한다.
    public static void moveRobot(String move) {
        // (0, 0)에서 동작 시작
        int row = 0; // 로봇팔의 현재 row 좌표를 기록하기 위한 변수
        int col = 0; // 로봇팔의 현재 col 좌표를 기록하기 위한 변수
        // 0: 상(U), 1: 하(D), 2 : 좌(L), 3 : 우(R) 이동
        int[] dmove = {-1, 1, -1, 1}; // 상하좌우 이동

        for (int i = 0; i < move.length(); i++) { // 내부에서 row, col 갱신을 해야함
            char currentMove = move.charAt(i); // 현재 동작
            // 유효하지 않은 이동 반영 가능성, 항상 초기화
            int nrow = row; // 로봇팔의 이동 시 row 좌표를 기록하기 위한 변수
            int ncol = col; // 로봇팔의 이동 시 col 좌표를 기록하기 위한 변수
            // 다음에 이동할 점의 좌표 구하기
            if (currentMove == 'U') nrow = row + dmove[0];
            else if (currentMove == 'D') nrow = row + dmove[1];
            else if (currentMove == 'L') ncol = col + dmove[2];
            else if (currentMove == 'R') ncol = col + dmove[3];
            // 이동할 점이 유효하지 않을 때는 무시
            if (nrow < 0 || nrow >= N || ncol < 0 || ncol >= N) continue;
            // 유효할 때만 이전칸 (row, col)과 이동할 칸(nrow, ncol)을 갱신한다.
            if (currentMove == 'U' || currentMove == 'D') { // 수직 방향 이동 시 수직 체크
                isVertical[row][col] = true;
                isVertical[nrow][ncol] = true;
            } else if (currentMove == 'L' || currentMove == 'R') { // 수평 방향 이동 시 수평 체크
                isHorizontal[row][col] = true;
                isHorizontal[nrow][ncol] = true;
            }
            // 다음 칸으로 이동한다.
            row = nrow;
            col = ncol;
        }
    }

    public static void printResult() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                boolean vertical = isVertical[i][j];
                boolean horizontal = isHorizontal[i][j];

                if (vertical && horizontal) {
                    System.out.print('+');
                } else if (vertical) {
                    System.out.print('|');
                } else if (horizontal) {
                    System.out.print('-');
                } else {
                    System.out.print('.');
                }
            }
            System.out.println();
        }
    }
}
