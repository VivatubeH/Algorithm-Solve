package prefixSum;
import java.io.*;
import java.util.*;

public class Baekjoon11659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 수의 개수 N
        int M = Integer.parseInt(st.nextToken()); // 합을 구해야하는 쿼리의 횟수 M

        int[] prefixSum = new int[N + 1]; // 1-based Indexing을 위해 +1 크기로 만든 누적합 배열

        StringTokenizer numberTokens = new StringTokenizer(br.readLine()); // N개의 수를 토큰화해서 뽑아내기 위한 tokenizer
        for (int i = 1; i <= N; i++) { // 1번부터 N번까지의 수를
            int current = Integer.parseInt(numberTokens.nextToken()); // i번째 숫자
            prefixSum[i] = prefixSum[i - 1] + current; // i까지의 누적합 = i-1까지의 누적합 + i번째 수, 1-based indexing했기에 별도 예외처리 불필요.
        }

        for (int i = 0; i < M; i++) { // M개의 줄에 걸쳐서 쿼리를 입력받는다.
            StringTokenizer queryTokens = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(queryTokens.nextToken()); // 시작 범위
            int end = Integer.parseInt(queryTokens.nextToken()); // 끝 범위
            int rangeSum = prefixSum[end] - prefixSum[start - 1]; // 구간합 = end까지의 누적합 - (start - 1)까지의 누적합
            bw.write(String.valueOf(rangeSum)); // Buffer에는 문자열 형태로 보내야함.
            bw.newLine(); // 줄바꿈
        }
        bw.flush(); // 결과 출력
    }
}
