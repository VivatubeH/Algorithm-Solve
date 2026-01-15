package BruteForceSimulation;
import java.io.*;
import java.util.*;

public class Baekjoon11005 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[] array = new int[50]; // 나머지 및 몫을 기록하기 위한 배열
        int idx = 0; // 다음에 기록할 위치를 기억하기 위한 인덱스

        // 진법 계산의 기본 방식
        while (N >= B) { // 나누는 수보다 큰 동안은
            int remain = N % B; // 나머지를 구하고
            array[idx++] = remain; // 기록한 다음 인덱스를 증가시킨다.
            N /= B; // 계속해서 나눈다.
        }
        // 더 이상 나눌 수 없다면 남은 수를 기록한다.
        array[idx] = N;
        // 이후 진법에 맞게 거꾸로 변환해서 출력한다.
        for (int i = idx; i >= 0; i--) {
            int current = array[i];
            if (current >= 10) { // 10보다 크거나 같으면 알파벳 변환
                System.out.print((char)('A' + (current - 10)));
            } else {
                System.out.print(current);
            }
        }
    }
}
