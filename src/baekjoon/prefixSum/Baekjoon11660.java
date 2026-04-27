package prefixSum;
import java.io.*;
import java.util.*;

public class Baekjoon11660 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer firstLine = new StringTokenizer(br.readLine()); // 입력받는 첫 줄
        int N = Integer.parseInt(firstLine.nextToken()); // 표의 크기 N
        int M = Integer.parseInt(firstLine.nextToken()); // 합을 구해야하는 횟수 M
        int[][] prefixSum = new int[N + 1][N + 1]; // 2차원 누적합 배열 생성, 1-based indexing

        // 누적합 전처리
        for (int i = 1; i <= N; i++) { // N개에 행, 인덱스는 1~N
            StringTokenizer numberTokens = new StringTokenizer(br.readLine()); // 매 행마다 4개의 숫자를 입력받는다.
            for (int j = 1; j <= N; j++) { // N개의 열, 인덱스는 1~N
                int current = Integer.parseInt(numberTokens.nextToken()); // 현재 입력받은 숫자
                // [i,j]까지 누적합 = 위쪽 누적합 + 왼쪽 누적합 - 겹치는 부분 누적합 + 현재 칸의 숫자
                prefixSum[i][j] = prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1] + current;
            }
        }

        // M개의 쿼리에 대해 합 출력하기
        for (int i = 0; i < M; i++) {
            StringTokenizer queryTokens = new StringTokenizer(br.readLine()); // 쿼리마다 4개의 숫자를 입력받는다.
            int x1 = Integer.parseInt(queryTokens.nextToken()); // x1
            int y1 = Integer.parseInt(queryTokens.nextToken()); // y1
            int x2 = Integer.parseInt(queryTokens.nextToken()); // x2
            int y2 = Integer.parseInt(queryTokens.nextToken()); // y2

            // (x1, y1) ~ (x2, y2)까지의 구간합을 구한다.
            // (x1, y1) ~ (x2,y2)까지의 구간합 = (x2,y2)까지의 누적합 - 위쪽 누적합(x1 - 1,y2) - 왼쪽 누적합(x2,y1 - 1) + 중복해서 뺀 누적합(x1 - 1, y1 - 1)
            int rangeSum = prefixSum[x2][y2] - prefixSum[x1 - 1][y2] - prefixSum[x2][y1 - 1] + prefixSum[x1 - 1][y1 - 1];
            bw.write(String.valueOf(rangeSum)); // 구간합을 버퍼에 기록
            bw.newLine(); // 버퍼에 개행문자 기록 ( 줄바꿈 )
        }

        bw.flush(); // 출력
    }
}
