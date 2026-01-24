package prefixSum;
import java.io.*;
import java.util.*;

public class Baekjoon17232 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer firstLine = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(firstLine.nextToken()); // 바툭판의 세로 길이 N
        int M = Integer.parseInt(firstLine.nextToken()); // 바둑판의 가로 길이 M
        int T = Integer.parseInt(firstLine.nextToken()); // 바둑판을 관찰하고자 하는 시간 T

        int[][] prefixSum = new int[N + 1][M + 1]; // 현재 칸까지의 누적 생명의 수 ( 자기 자신도 포함 )
        char[][] board = new char[N + 1][M + 1]; // 보드판의 상태

        StringTokenizer secondLine = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(secondLine.nextToken()); // 주위의 기준이 되는 정수 K
        int a = Integer.parseInt(secondLine.nextToken()); // 다음 칸의 각 상황을 결정하는 정수 a
        int b = Integer.parseInt(secondLine.nextToken()); // 다음 칸의 각 상황을 결정하는 정수 b

        // 전처리 로직
        for (int i = 1; i <= N; i++) { // N개의 행에 대해서
            String line = br.readLine(); // 행의 바둑판 모양을 입력받는다. (".*....")
            for (int j = 1; j <= M; j++) { // M개의 열에 대해서
                char ch = line.charAt(j - 1); // 현재 칸의 문자 .이거나 *
                int current = ch == '.' ? 0 : 1; // 생명이 없으면 0, 있으면 1

                // 누적합에 기록한다. ( 현재 칸에 생명이 있으면 1을 더하고, 아니면 0을 구하도록 )
                prefixSum[i][j] = prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1] + current;
                // 보드판에 기록한다.
                board[i][j] = ch;
            }
        }

        // 생명 게임을 진행한다.
        // 생명 게임의 판단 구간 - 현재칸의 좌표가 i, j일 때 -> (i-k, j-k)부터 (i+k, j+k)까지의 생명 개수, 단 자기 칸의 생명은 제외
        for (int t = 0; t < T; t++) { // T초 동안 진행한다.
            // (i, j)행에 대해 기준이 되는 생명 개수를 파악해야 한다.
            char[][] newBoard = new char[N + 1][M + 1]; // 매초마다 갱신될 새로운 생명 상태
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    // (i-k, j-k) ~ (i+k, j+k)까지의 생명 개수를 구하되, 바둑판 구간을 벗어난 영역은 세면 안된다. ( 인덱스 초과 주의 )
                    // 바둑판 구간 : 세로는 1 ~ N, 가로는 1 ~ M
                    // (x1, y1) ~ (x2, y2)까지의 구간합의 범위
                    int x1 = Math.max(1, i - K); // 행은 최소 1
                    int y1 = Math.max(1, j - K); // 열은 최소 1
                    int x2 = Math.min(N, i + K); // 행은 최대 N
                    int y2 = Math.min(M, j + K); // 열은 최대 M

                    // 생명 개수는 (x1, y1) ~ (x2, y2)까지의 구간합
                    // 예외 : 만약 현재칸이 생명이면 그 개수는 빼줘야 함. ( 현재 칸의 생명은 제외한다. )
                    int life = prefixSum[x2][y2] - prefixSum[x1 - 1][y2] - prefixSum[x2][y1 - 1] + prefixSum[x1 - 1][y1 - 1];
                    if (board[i][j] == '*') life -= 1;

                    // 생명 게임을 토대로 새로운 보드판의 현재칸의 생명 상태를 갱신한다.
                    // 현재 칸에 생명이 있을 때,
                    if (board[i][j] == '*') {
                        // 생존
                        if (life >= a && life <= b) {
                            newBoard[i][j] = '*'; // 다음칸에 살아남는다.
                        }
                        // 고독, 과밀
                        else {
                            newBoard[i][j] = '.'; // 고독 혹은 과밀로 죽는다.
                        }
                    } else { // 현재 칸에 생명이 없을 때
                        // 탄생
                        if (life > a && life <= b) {
                            newBoard[i][j] = '*'; // 탄생
                        }
                        // 예외 처리 : 생명이 없었을 때, 다음 칸은 계속 생명없음이 기록되야 한다.
                        else {
                            newBoard[i][j] = '.';
                        }
                    }
                }
            }
            // newBoard를 board로 변경하고, 누적합을 새로 구한다. ( 1초가 지난 후 새로운 생명판 기준 생존 게임을 해야하므로 )
            board = newBoard;
            // 누적합을 새로 구한다.
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    char ch = board[i][j];
                    int current = ch == '*' ? 1 : 0;
                    prefixSum[i][j] = prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1] + current;
                }
            }
        }

        // T초 후, 바둑판의 상태를 출력한다.
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                bw.write(String.valueOf(board[i][j])); // char로 버퍼에 담으면 유니코드로 들어감.
            }
            bw.newLine(); // 줄바꿈
        }
        bw.flush(); // 출력
    }
}
