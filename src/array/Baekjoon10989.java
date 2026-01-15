package array;
import java.io.*;
import java.util.*;

public class Baekjoon10989 {
    /* 풀이 1번 : Arrays.sort를 사용한 풀이 방법. O(N log N)이라 시간 복잡도 최적이 아님.
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(array);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < N; i++) {
            // BufferedWriter의 write(int) 메서드는 인자를 유니코드 코드값으로 해석해서 출력.
            // 그래서 숫자를 그대로 출력하고 싶으면 String.valueOf로 문자열로 변환 후 전달해야 함.
            bw.write(String.valueOf(array[i]));
            bw.write("\n");
        }
        bw.flush();
    }
    */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] frequency = new int[10001]; // 1 ~ 10000 사용하기 위해 +1 크기 생성
        for (int i = 0; i < N; i++) {
            int current = Integer.parseInt(br.readLine());
            frequency[current]++; // 현재 수의 등장 빈도 체크
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 오름차순 출력 = 작은 숫자부터 차례로 출력
        for (int i = 1; i <= 10000; i++) {
            // 빈도수만큼
            for (int j = 0; j < frequency[i]; j++) {
                bw.write(String.valueOf(i));
                bw.write("\n");
            }
        }
        bw.flush();
    }
}