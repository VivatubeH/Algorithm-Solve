package binarySearch;
import java.io.*;
import java.util.*;

public class Baekjoon10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine()); // 상근이가 가진 숫자 카드의 개수 N
        List<Integer> list = new ArrayList<>(); // 상근이가 카지고 있는 카드의 정수를 저장할 list
        StringTokenizer numberTokens = new StringTokenizer(br.readLine()); // 상근이가 가지고 있는 숫자를 저장할 토큰
        for (int i = 0; i < N; i++) { // N개의 숫자 토큰을 토대로
            int current = Integer.parseInt(numberTokens.nextToken()); // 해당 숫자
            list.add(current); // 리스트에 카드 추가
        }
        Collections.sort(list); // 리스트를 오름차순 정렬

        int M = Integer.parseInt(br.readLine()); // 상근이가 가진 개수를 체크해야 할 정수의 개수 M
        numberTokens = new StringTokenizer(br.readLine()); // 체크해야 할 정수가 저장되어 있는 토큰
        for (int i = 0; i < M; i++) { // M개의 숫자 토큰을 토대로
            int target = Integer.parseInt(numberTokens.nextToken()); // 지금 찾아야 할 정수

            // 만족하는 개수를 찾기 위한 lowerBound와 upperBound
            // 값이 존재하지 않을 경우에 대비해 -1로 초기화한다.
            int lowerBound = -1; // target 이상의 수가 처음으로 등장하는 위치
            int upperBound = -1; // target 보다 큰 수가 처음으로 등장하는 위치

            // target을 찾기 위한 이분 탐색을 수행한다.
            int leftIndex = 0; // 하한
            int rightIndex = list.size() - 1; // 상한

            // 하한 찾기
            while (leftIndex <= rightIndex) {
                int midIndex = (leftIndex + rightIndex) / 2;
                int midValue = list.get(midIndex);

                // target을 찾았을 때, 하한을 찾으려면 더 작은 값을 탐색해야 함.
                // 중앙값이 더 크거나 같으면, 더 왼쪽에서 하한을 찾으러 가야한다.
                if (midValue >= target) {
                    // 중앙값이 타겟과 일치하면 하한 후보이기 때문에
                    if (midValue == target) {
                        lowerBound = midIndex; // 하한을 갱신하고
                    }
                    rightIndex = midIndex - 1; // 더 작은 값이 있는지 찾아야 한다.
                } else { // 중앙값이 타겟보다 작으면, 중앙값 우측에서 target을 찾아야 한다.
                    leftIndex = midIndex + 1;
                }
            }

            // 인덱스는 상한 찾기 전에 반드시 초기화해야 한다.
            leftIndex = 0;
            rightIndex = list.size() - 1;
            // 상한 찾기
            while (leftIndex <= rightIndex) {
                int midIndex = (leftIndex + rightIndex) / 2;
                int midValue = list.get(midIndex);

                // target을 찾았을 때, 상한을 찾으려면 더 큰값을 탐색해야 함.
                // 중앙값이 더 작거나 같으면 더 오른쪽에서 상한을 찾으러 가야한다.
                if (midValue <= target) {
                    // 중앙값이 타겟과 일치하면 상한 후보이기 때문에
                    if (midValue == target) {
                        upperBound = midIndex; // 상한을 갱신하고
                    }
                    leftIndex = midIndex + 1;
                } else { // 중앙값이 타겟보다 크면, 중앙값 좌측에서 target을 찾아야 한다.
                    rightIndex = midIndex - 1;
                }
            }

            // 값을 찾지 못했다면 0을 기록하고,
            // 값을 찾았으면 upperBound - lowerBound + 1이 총 등장횟수가 된다.
            if (lowerBound == -1 || upperBound == -1) bw.write(0 + " ");
            else bw.write((upperBound - lowerBound + 1) + " ");
        }
        bw.flush(); // 버퍼에 기록된 개수를 출력한다.
    }
}
