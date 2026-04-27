package twoPointer;
import java.io.*;
import java.util.*;

public class Baekjoon11728 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer firstLine = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(firstLine.nextToken());
        int M = Integer.parseInt(firstLine.nextToken());

        int[] A = new int[N];
        int[] B = new int[M];

        StringTokenizer secondLine = new StringTokenizer(br.readLine());
        StringTokenizer thirdLine = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(secondLine.nextToken());
        }
        for (int j = 0; j < M; j++) {
            B[j] = Integer.parseInt(thirdLine.nextToken());
        }

        Arrays.sort(A);
        Arrays.sort(B);

        int p1 = 0;
        int p2 = 0;

        while (p1 < N && p2 < M) { // 둘 중 하나의 출력이 끝날때까지 수행한다.
            if (A[p1] < B[p2]) {
                bw.write(A[p1++] + " ");
            } else if (A[p1] > B[p2]){
                bw.write(B[p2++] + " ");
            } else {
                bw.write(A[p1++] + " " + B[p2++] + " ");
            }
        }

        // 둘 중 하나는 출력이 끝났으므로 순서가 잘못되지 않는다.
        for (int i = p1; i < N; i++) {
            bw.write(A[i] + " ");
        }
        for (int j = p2; j < M; j++) {
            bw.write(B[j] + " ");
        }

        bw.flush();
    }
}
