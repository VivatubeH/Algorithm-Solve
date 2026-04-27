package array;
import java.io.*;
import java.util.StringTokenizer;

public class Baekjoon3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[] isExist = new boolean[1000001]; // 1 ~ 100만을 위한 +1 크기 배열 생성
        StringTokenizer numbersToken = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(br.readLine());
        int count = 0;
        for (int i = 0; i < N; i++) {
            int current = Integer.parseInt(numbersToken.nextToken());
            // 두 수의 차이도 1 ~ 100만이어야만 한다.
            if (x - current >= 0 && x - current <= 1000000) {
                if (isExist[x - current]) {
                    count++;
                }
            }
            isExist[current] = true;
        }
        System.out.print(count);
    }
}
