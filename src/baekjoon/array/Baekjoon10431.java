package array;
import java.io.*;
import java.util.*;

public class Baekjoon10431 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 테스트 케이스의 수 P
        int P = Integer.parseInt(br.readLine());
        // 각 테스트 케이스 입력을 받는다.
        for (int i = 0; i < P; i++) {
            StringTokenizer line = new StringTokenizer(br.readLine());
            // 테스트 케이스의 번호를 입력받는다.
            int testCaseNumber = Integer.parseInt(line.nextToken());
            // 해당 테스트 케이스에서 뒤로 물러난 걸음수를 누적한다.
            int totalWalk = 0;
            // 줄 세우기를 위한 배열을 만든다.
            int[] array = new int[20];
            // 20명의 키를 순서대로 입력받는다.
            for (int j = 0; j < 20; j++) {
                int height = Integer.parseInt(line.nextToken());
                // 줄을 서러 들어온다.
                array[j] = height;
                // j번째 사람이 줄을 섰을 때, j-1번째까지 중 자신보다 큰 사람은 뒤로 1칸씩 밀려남.
                for (int k = 0; k < j; k++) {
                    if (array[k] > height) {
                        totalWalk++;
                    }
                }
            }
            System.out.println(testCaseNumber + " " + totalWalk);
        }
    }
}
