package BruteForceSimulation;
import java.util.*;
import java.io.*;

public class Baekjoon2309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] shorts = new int[9];
        int sum = 0;
        // 9명의 키를 입력받으면서 9명의 난쟁이의 키의 합을 구한다.
        for (int i = 0; i < 9; i++) {
            shorts[i] = Integer.parseInt(br.readLine());
            sum += shorts[i];
        }
        // 9명의 키를 오름차순 정렬한다. 최악의 경우 O(N^2)
        Arrays.sort(shorts);
        // for문을 통해 2명의 난쟁이의 키의 합을 구한다.
        // 9명의 키의 합 - 2명의 키의 합 = 100인 경우 나머지 난쟁이들이 진짜 난쟁이다.
        for (int i = 0; i < 9; i++) {
            // i + 1부터 체크하므로서 중복을 피한다.
            for (int j = i + 1; j < 9; j++) {
                int fakeSum = shorts[i] + shorts[j];
                // 가짜 난쟁이 2명을 찾으면
                if (sum - fakeSum == 100) {
                    for (int k = 0; k < 9; k++) {
                        // 가짜 난쟁이들은 제외한다.
                        if (k == i || k == j) continue;
                        System.out.println(shorts[k]);
                    }
                    return; // 출력 후에 프로그램을 종료한다.
                }
            }
        }
    }
}
