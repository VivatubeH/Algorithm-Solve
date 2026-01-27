package parametricSearch;
import java.io.*;
import java.util.*;

public class Baekjoon2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer firstLine = new StringTokenizer(br.readLine()); // 첫 줄
        int N = Integer.parseInt(firstLine.nextToken()); // 나무의 수 N
        long M = Long.parseLong(firstLine.nextToken()); // 목표로 하는 나무의 높이, 추후 비교를 위해 long으로 받는다.

        StringTokenizer secondLine = new StringTokenizer(br.readLine()); // 두 번재 줄
        int[] array = new int[N]; // 나무 높이가 기록될 배열, 나무는 0에서 10억의 높이이므로 int 배열로 가능
        for (int i = 0; i < N; i++) {
            // 나무 높이를 배열에 기록한다.
            array[i] = Integer.parseInt(secondLine.nextToken());
        }

        // 매개변수 탐색을 통해 나무 높이의 최댓값을 구하자.
        int lower = 0; // 높이 0을 잘라서 가져올 수도 있음.
        int upper = 999999999; // 최대 나무 높이는 10억이지만, 10억으로 하면 자를 수 있는 나무가 없음
        long max = 0; // 절단기에 설정할 수 있는 나무 높이의 최댓값

        while (lower <= upper) { // 이분 탐색
            int mid = (lower + upper) / 2; // 중간 값

            // 만약 상근이가 가져가려고 하는 나무 길이만큼 확보 가능하면
            if (check(mid, M, array)) {
                max = mid; // 현재 높이가 최댓값 후보이고
                lower = mid + 1; // 더 높은 높이에 대고 잘라도 되는지 확인해야 함.
            } else {
                upper = mid - 1; // 확보를 못했으면 더 낮은 높이에 대고 잘라야 함.
            }
        }

        System.out.print(max);
    }

    // 판정함수
    public static boolean check(int mid, long M, int[] array) {
        long sum = 0; // 나무 높이의 합
        for (int i = 0; i < array.length; i++) {
            int currentHeight = array[i] - mid;
            if (currentHeight > 0) { // 나무 높이가 0 이상일 때만
                sum += currentHeight; // 현재 나무 높이를 더해준다.
                if (sum >= M) return true; // 상근이가 가져가고 싶어하는 나무 높이 이상 확보되면 종료
            }
        }
        return false; // 마지막까지 높이 M만큼 확보를 못했으면 false
    }
}
