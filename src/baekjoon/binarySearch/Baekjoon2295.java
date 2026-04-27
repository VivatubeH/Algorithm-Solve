package binarySearch;
import java.io.*;
import java.util.*;

public class Baekjoon2295 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine()); // 자연수 N
        int[] array = new int[N]; // 정렬 시 최악의 경우 O(N^2)이지만, 이번 문제는 N이 최대 1000이므로 기본형 배열을 선택
        for (int i = 0; i < N; i++) { // N개의 정수를
            array[i] = Integer.parseInt(br.readLine()); // int 배열에 저장한다.
        }
        Arrays.sort(array); // 배열을 오름차순으로 정렬한다.

        Set<Integer> sumSet = new HashSet<>(); // 중복을 제거하기 위해 Set에 담는다.
        // array[x] + array[y] = array[k] - array[z]가 존재하는 경우에 array[k]의 최댓값 찾기
        for (int x = 0; x < N; x++) { // 인덱스는 같아도 무관하다.
            for (int y = 0; y < N; y++) {
                int targetSum = array[x] + array[y]; // 목표가 되는 두 수의 합
                sumSet.add(targetSum);
            }
        }
        List<Integer> sortedSumList = new ArrayList<>(sumSet); // 정렬된 array[x] + array[y]를 저장할 리스트
        Collections.sort(sortedSumList); // 오름차순으로 정렬한다.

        // k가 주어질 때, z를 이분탐색해가면서 sortedSumList에 값이 존재하는지 체크한다.
        // O(K * Z * (log 1000000)) -> 시간 내에 가능.
        for (int k = N - 1; k >= 0; k--) { // k번째 수가 최대가 되는 것이 목표
            int numberOfK = array[k]; // k번째 숫자
            for (int z = 0; z < N; z++) { // z번째 숫자
                int numberOfZ = array[z];

                int target = numberOfK - numberOfZ; // array[k] - array[z]; 이분탐색을 통해 찾고자 하는 값
                // sortedSumList를 이분탐색하면서 target이 존재하는지 찾는다.
                int leftBound = 0;
                int rightBound = sortedSumList.size() - 1;

                while (leftBound <= rightBound) {
                    int midIndex= (leftBound + rightBound) / 2;
                    int midNum = sortedSumList.get(midIndex);

                    // 중간값도 target보다 작으면, 중간값보다 작은 값은 target보다 무조건 작음
                    if (midNum < target) {
                        leftBound = midIndex + 1; // 중간값보다 작은 값은 무조건 버린다.
                    }
                    // 중간값도 target보다 크면, 중간값보다 큰 값은 target보다 무조건 큼
                    else if (midNum > target) {
                        rightBound = midIndex - 1; // 중간값보다 큰 값은 무조건 버린다.
                    }
                    // array에서 뒤쪽 인덱스, 즉 큰 수 k부터 출발했기 때문에 첫 번째로 만족하는 array[k]가 정답이 된다.
                    // 출력하고 세 수의 합을 찾는 프로그램은 종료한다.
                    else { // target을 찾았으면
                        System.out.print(array[k]);
                        return;
                    }
                }
            }
        }
    }
}
