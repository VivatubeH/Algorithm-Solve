package twoPointer;
import java.io.*;
import java.util.*;

public class Baekjoon2230 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer firstLine = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(firstLine.nextToken());
        int target = Integer.parseInt(firstLine.nextToken());

        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(array);

        int right = 0;
        int min = Integer.MAX_VALUE;

        for (int left = 0; left < size; left++) {
            while (right < size && array[right] - array[left] < target) {
                right++;
            }
            if (right != size && array[right] - array[left] >= target) {
                if (array[right] - array[left] < min) {
                    min = array[right] - array[left];
                }
            }
        }
        System.out.print(min);
    }
}
