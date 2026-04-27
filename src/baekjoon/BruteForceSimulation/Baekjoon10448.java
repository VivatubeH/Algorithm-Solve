package BruteForceSimulation;
import java.io.*;
import java.util.*;

public class Baekjoon10448 {
    // 삼각수 50개를 미리 저장하기 위해 51칸 배열로 선언한다.
    public static int[] triangle = new int[51];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        // 50가지 삼각수를 배열에 미리 저장한다.
        for (int i = 1; i <= 50; i++) { // 1부터의 인덱스 활용
            int current = i * (i + 1) / 2;
            triangle[i] = current;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // testCase수만큼 완전 탐색으로 삼각수인지 체크한다.
        for (int i = 0; i < testCase; i++) {
            int num = Integer.parseInt(br.readLine());
            if (isTriangle(num)) {
                bw.write(String.valueOf(1));
            } else {
                bw.write(String.valueOf(0));
            }
            bw.write("\n");
        }
        bw.flush();
    }

    // 해당 수가 삼각수인지 체크하기 위한 메서드
    public static boolean isTriangle(int num) {
        // 3개의 삼각수가 서로 같아도 되기 때문에 인덱스를 중복을 허용해서 가져간다.
        for (int i = 1; i <= 50; i++) {
            int num1 = triangle[i];
            if (num1 > num) break;
            for (int j = 1; j <= 50; j++) {
                int num2 = triangle[j];
                if (num1 + num2 > num) break;
                for (int k = 1; k <= 50; k++) {
                    int num3 = triangle[k];
                    // 삼각수인 경우 true를 반환하고 종료
                    if (num1 +num2 + num3 == num) {
                        return true;
                    }
                    if (num1 + num2 + num3 > num) break;
                }
            }
        }
        return false;
    }
}
