package prefixSum;
import java.io.*;
import java.util.*;

public class Baekjoon16713 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer firstLine = new StringTokenizer(br.readLine()); // 첫 줄
        int N = Integer.parseInt(firstLine.nextToken()); // 수열의 길이 N
        int Q = Integer.parseInt(firstLine.nextToken()); // 쿼리의 수 Q개

        int[] prefixXor = new int[N + 1]; // 전처리를 위한 XOR prefix 배열, 1-based Indexing 활용 ( 0 ^ a = a )이므로,
        StringTokenizer numTokens = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) { // 누적 XOR 생성
            prefixXor[i] = prefixXor[i - 1] ^ Integer.parseInt(numTokens.nextToken()); // i번째 수와 이전 수까지를 XOR 연산 ( 누적 XOR )
        }

        int result = 0; // 최종적인 결과값 ( 모든 쿼리의 답을 XOR한 값 )

        // Q캐의 쿼리를 입력받는다.
        for (int i = 0; i < Q; i++) {
            StringTokenizer queryToken = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(queryToken.nextToken()); // si
            int end = Integer.parseInt(queryToken.nextToken()); // ei
            int rangeXor = prefixXor[end] ^ prefixXor[start - 1]; // end까지의 XOR에서 start-1까지를 다시 XOR을 이용해 역연산한다.
            result ^= rangeXor; // 결과를 계속 XOR 연산한다.
        }

        System.out.println(result); // 모든 쿼리를 XOR 연산한 result를 출력한다.
    }
}
