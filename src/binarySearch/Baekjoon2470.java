package binarySearch;
import java.io.*;
import java.util.*;

public class Baekjoon2470 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 전체 용액의 수 N
        StringTokenizer numberTokens = new StringTokenizer(br.readLine()); // 입력된 N개의 수가 담긴 토큰
        List<Integer> list = new ArrayList<>(); // 용액의 특성값을 담기 위한 리스트
        for (int i = 0; i < N; i++) { // N개의 수에 토큰에 대해
            int current = Integer.parseInt(numberTokens.nextToken()); // 현재 수
            list.add(current); // 현재 수를 리스트에 담는다.
        }
        Collections.sort(list); // list를 오름차순으로 정렬한다.

        int min = Integer.MAX_VALUE; // 특성값의 최솟값을 저장하기 위한 변수 ( 이 최솟값보다 적어야 갱신이 가능하다. )
        int num1 = 0; // 첫 번째 특성값
        int num2 = 0; // 두 번째 특성값

        for (int left = 0; left < N; left++) { // N개의 수에 대해서
            int leftValue = list.get(left); // 특성값 중 왼쪽값

            // 우측 값은 이분탐색을 통해 구한다.
            int leftIndex = left + 1; // 이분 탐색의 하한은 이전에 선택한 수 이후여야만 한다.
            int rightIndex = N - 1; // 이분 탐색의 상한은 리스트에서 가장 큰 수여야 함.
            while (leftIndex <= rightIndex) {
                int midIndex = (leftIndex + rightIndex) / 2; // 이분 탐색의 중간인덱스
                int rightValue = list.get(midIndex); // 특성값 중 오른쪽 값

                // 두 특성값의 합
                int sum = leftValue + rightValue;
                // 현재 두 특성값의 합이 0에 더 가까울 때 갱신한다.
                if (Math.abs(min) > Math.abs(sum)) { // 0에 더 가깝다 = 절댓값이 더 작다.
                    min = sum; // 최솟값을 갱신한다.
                    num1 = leftValue; // 첫 번째 특성값
                    num2 = rightValue; // 두 번째 특성값
                }
                // 두 특성값의 합이 양수이면, rightValue보다 작은 값을 탐색해야 한다.
                if (sum > 0) {
                    rightIndex = midIndex - 1;
                }
                // 두 특성값의 합이 음수이면, rightValue보다 큰 값을 탐색해야 한다.
                else if (sum < 0) {
                    leftIndex = midIndex + 1;
                }
                // 두 특성값이 합이 0인 경우를 찾았으면, 출력하고 프로그램을 종료하면 된다.
                else {
                    System.out.println(leftValue + " " + rightValue);
                    return;
                }
            }
        }
        // 현재 num1, num2에 저장된 특성값이 0에 가장 가까울 때 두 특성값이므로
        System.out.println(num1 + " " + num2);
    }
}
