package prefixSum;
import java.io.*;
import java.util.*;

public class Baekjoon19951 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer firstLine = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(firstLine.nextToken()); // 연병장의 크기 N
        int M = Integer.parseInt(firstLine.nextToken()); // 조교의 수 M

        int[] changeArr = new int[N + 1]; // 조교의 명령을 토대로 변화량을 기록하기 위한 배열 ( 1-based Indexing )
        int[] heights = new int[N + 1]; // 연병장의 초기 높이들을 저장할 배열 ( 1-based Indexing)

        StringTokenizer heightTokens = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            heights[i] = Integer.parseInt(heightTokens.nextToken()); // 각 칸의 초기 높이를 배열에 저장
        }

        // M명의 조교의 명령에 맞게 변화량 배열에 기록한다.
        for (int i = 0; i < M; i++) {
            StringTokenizer orderTokens = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(orderTokens.nextToken()); // a
            int b = Integer.parseInt(orderTokens.nextToken()); // b
            int k = Integer.parseInt(orderTokens.nextToken()); // k
            // 변화량에서 a를 k만큼, b+1을 -k만큼 변화시키면 추후 n개의 순회해서 (a, b)까지만 k 변화된 상태로 유지된다.
            changeArr[a] += k;
            // 단, b + 1은 인덱스 검사로 b == N이면 무시한다. ( b == N이면 뒤에 영향을 미칠 요소가 없음 )
            if (b != N) { // b가 N이 아닐때만
                changeArr[b + 1] -= k;
            }
        }

        int currentChange = 0; // 변화량 배열을 순회하면서 얻은 현재칸의 변화량
        // 초기 높이에서 변화량을 순회하면서 얻은 현재 칸의 변화량을 변화시키면 현재 연병장의 높이가 된다.
        for (int i = 1; i <= N; i++) {
            currentChange += changeArr[i]; // 현재 칸의 변화량을 기록한다.
            int currentHeight = heights[i] + currentChange; // 칸 마다 현재 변화량을 반영해주면 각 칸의 최종높이
            bw.write(currentHeight + " "); // 각 칸의 최종 높이를 공백으로 구분해서 버퍼로 보낸다.
        }
        bw.flush(); // 버퍼에 저장된 최종 높이들을 출력한다.
    }
}
