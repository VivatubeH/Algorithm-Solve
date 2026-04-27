package array;
import java.io.*;
import java.util.*;

public class Baekjoon1236 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 행, 열별로 경비원이 있는지 체크
        // 1부터 시작하는 인덱스를 갖기 위해 1 크게 만듬.
        // boolean의 기본값이 false니 별도 초기화 x
        boolean[] rowExist = new boolean[N + 1];
        boolean[] colExist = new boolean[M + 1];

        // 시간 복잡도 O(NxM)
        for (int row = 1; row <= N; row++) {
            String line = br.readLine();
            for (int col = 1; col <= M; col++) {
                // col이 1부터니 charAt은 0부터로 보정
                char ch = line.charAt(col - 1);
                // 경비원이 있는 경우에
                // row, col에는 경비원이 존재한다.
                if (ch == 'X') {
                    rowExist[row] = true;
                    colExist[col] = true;
                }
            }
        }

        // row, col 별로 빈 경비원의 수를 기록하기 위한 변수
        int rowCount = 0;
        int colCount = 0;

        // rowExist, colExist중 false인 칸의 개수를 센다.
        for (int i = 1; i <= N; i++) {
            if (!rowExist[i]) {
                rowCount++;
            }
        }
        for (int j = 1; j <= M; j++) {
            if (!colExist[j]) {
                colCount++;
            }
        }

        // 둘 중 더 많은 수가 추가해야 하는 최소 경비원 수
        System.out.print(Math.max(rowCount, colCount));
    }
}
