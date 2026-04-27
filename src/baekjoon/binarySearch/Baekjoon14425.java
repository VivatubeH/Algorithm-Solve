package binarySearch;
import java.io.*;
import java.util.*;

public class Baekjoon14425 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer firstLine = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(firstLine.nextToken()); // 집합의 문자열 개수 N
        int M = Integer.parseInt(firstLine.nextToken()); // 테스트 케이스 문자열 개수 M

        List<String> list = new ArrayList<>();
        for (int i = 0; i < N; i++) { // N개의 문자열을 집합에 추가한다.
            list.add(br.readLine());
        }
        list.sort((s1, s2) -> s1.compareTo(s2)); // 문자열을 사전순 정렬한다.

        int count = 0; // 집합에 문자열이 몇 개 있는지 세기 위한 변수
        for (int i = 0; i < M; i++) { // M개의 문자열을 이분 탐색을 수행한다.
            String target = br.readLine(); // 찾아야 할 문자열

            int leftBound = 0; // 하한
            int rightBound = list.size() - 1; // 상한
            boolean isExist = false; // 해당 문자열이 리스트에 존재하는가?

            // 문자열 이분 탐색
            while (leftBound <= rightBound) {
                int midIndex = (leftBound + rightBound) / 2; // 중간 지점
                String current = list.get(midIndex); // 현재 문자열
                // 현재 문자열이 찾으려는 타켓 문자열보다 뒤이면
                if (current.compareTo(target) > 0) {
                    rightBound = midIndex - 1; // midIndex 앞을 찾아야 한다.
                }
                // 현재 문자열이 타겟 문자열보다 앞이면
                else if (current.compareTo(target) < 0) {
                    leftBound = midIndex + 1; // midIndex 뒤를 찾아야 한다.
                }
                // 찾게 되면 탐색을 종료한다.
                else {
                    isExist = true;
                    break;
                }
            }

            // 찾았으면 count를 하나 추가해준다.
            if (isExist) count++;
        }
        System.out.print(count); // 결과를 출력한다.
    }
}
