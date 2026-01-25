package binarySearch;
import java.io.*;
import java.util.*;

public class Baekjoon1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine()); // 자연수 N
        // Arrays.sort는 기본형의 경우 최악의 경우 O(N^2)의 시간 복잡도가 걸리기에 Integer를 담는다.
        List<Integer> list = new ArrayList<>(); // N개의 정수를 담기 위한 리스트
        StringTokenizer numberTokens = new StringTokenizer(br.readLine()); // N개의 정수가 담길 토큰
        // N개의 정수를 리스트에 저장한다.
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(numberTokens.nextToken()));
        }
        // 리스트를 정렬한다. 최악의 경우에도 O(N logN)이 보장된다.
        Collections.sort(list);

        int M = Integer.parseInt(br.readLine()); // 테스트 케이스의 수 M
        numberTokens = new StringTokenizer(br.readLine()); // M개의 정수가 담길 토큰
        for (int i = 0; i < M; i++) { // M개의 정수에 대해서
            int target = Integer.parseInt(numberTokens.nextToken()); // 찾으려는 정수

            int l = 0; // 리스트의 왼쪽 끝 인덱스
            int r = N - 1; // 리스트의 오른쪽 끝 인덱스
            boolean isExist = false; // 존재하는지 여부, 존재할 때만 true로 갱신한다.
            while (l <= r) { // 유효하지 않은 범위 ( 좌우 역전 시, 종료 )
                int m = (l + r) / 2; // OverFlow 가능성 없음.

                int current = list.get(m); // m번째 정수에 대한 탐색을 실시한다.
                if (current > target) { // 찾으려는 정수보다 m번재 정수가 크다 = m의 우측에는 찾으려는 정수가 없다.
                    r = m - 1; // 우측 상한을 m왼쪽으로 당긴다.
                } else if (current < target) { // 찾으려는 정수보다 m번째 정수가 작다 = m의 좌측에는 찾으려는 정수가 없다.
                    l = m + 1; // 좌측 상한을 m우측으로 당긴다.
                } else { // 찾으려는 수를 찾은 경우
                    isExist = true; // 찾았다고 체크하고
                    break; // 이분탐색을 종료한다. ( 찾았으니 해당 수에 대한 탐색은 불필요 )
                }
            }
            if (isExist) bw.write("1\n"); // 존재하는 경우에는 1을
            else bw.write("0\n"); // 존재하지 않는 경우에는 0을
        }
        bw.flush(); // 탐색 결과를 출력한다.
    }
}
