package twoPointer;
import java.io.*;
import java.util.*;

public class Baekjoon2003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer firstLine = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(firstLine.nextToken());
        int M = Integer.parseInt(firstLine.nextToken());

        StringTokenizer numberTokens = new StringTokenizer(br.readLine());
        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(numberTokens.nextToken());
        }

        int sum = 0;
        int right = 0;
        int count = 0;

        for (int left = 0; left < N; left++) {
            while (right < N && sum < M) {
                sum += array[right++];
            }
            if (sum == M) {
                count++;
            }
            sum -= array[left];
        }

        System.out.print(count);
    }
}
