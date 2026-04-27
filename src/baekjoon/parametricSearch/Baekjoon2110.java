package parametricSearch;
import java.io.*;
import java.util.*;

public class Baekjoon2110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer firstLine = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(firstLine.nextToken());
        int C = Integer.parseInt(firstLine.nextToken());

        int lower = 1000000000;
        int upper = 0;

        int[] houses = new int[N];
        for (int i = 0; i < N; i++) {
            houses[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(houses);

        for (int i = 0; i < N - 1; i++) {
            int diff = houses[i + 1] - houses[i];
            if (diff < lower) lower = diff;
        }

        upper = houses[N - 1] - houses[0];

        int answer = 0;
        while (lower <= upper) {
            int mid = (lower + upper) / 2;

            if (check(mid, C, houses)) {
                answer = mid;
                lower = mid + 1;
            } else {
                upper = mid - 1;
            }
        }

        System.out.print(answer);
    }

    public static boolean check(int mid, int C, int[] houses) {
        int count = 0;
        int before = 0;

        for (int current : houses) {
            if (count == 0) {
                before = current;
                count++;
            } else {
                if (current - before >= mid) {
                    before = current;
                    count++;
                }
            }
            if (count >= C) return true;
        }
        return false;
    }
}
