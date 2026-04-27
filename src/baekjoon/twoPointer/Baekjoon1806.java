package twoPointer;
import java.io.*;
import java.util.*;

public class Baekjoon1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer firstLine = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(firstLine.nextToken());
        int target = Integer.parseInt(firstLine.nextToken());

        int[] array = new int[N];
        StringTokenizer secondLine = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(secondLine.nextToken());
        }

        int right = 0;
        int sum = 0;
        int min = 1000000001;

        for (int left = 0; left < N; left++) {
            while (right < N && sum < target) {
                sum += array[right++];
            }
            if (sum >= target) {
                int len = right - left;
                if (len < min) {
                    min = len;
                }
            }
            sum -= array[left];
        }

        if (min == 1000000001) System.out.print(0);
        else System.out.print(min);
    }
}
