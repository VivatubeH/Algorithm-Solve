package queue;
import java.io.*;
import java.util.*;
/*
 * 입력: 테스트 케이스는 최대 100개, 함수의 길이는 1과 10만사이 문자열, 배열의 수의 개수는 0~10만개,
 * [x1, x2, ... xn]의 형태로 정수가 주어짐 ( 정수는 1에서 100 사이 ) / 전체 테스트 케이스에서 p + n이 70만 이하가 보장
 * 출력: 테스트 케이스마다 연산 결과를 [x1, x2, ..., xn] 형태로 출력 / 단, 에러 발생시 error 출력 ( 중도 중단 )
 *
 * 알고리즘: 덱(Deque) - 뒤집기가 되면 버릴 포인터가 반대 위치로 변경, 버리기는 포인터 위치의 수를 버린다.
 * 발상: 뒤집기를 자체 구현하면 O(N)으로 큐에서 전부 뺐다가, 큐에 다시 반대로 넣어야 하는데 이런 경우 시간초과 O(N^2)
 *
 * 시간: O(T * N)
 * 주의:출력 포맷에 맞게 출력하고, error가 나는 경우인 배열이 빈 상태에서 D인 경우는 별도 체크로 오류 방지

 * */

public class Baekjoon5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Deque<Integer> deque = new ArrayDeque<>();

        // 테스트 케이스 수 입력
        int T = Integer.parseInt(br.readLine());

        // T개의 테스트 케이스
        for (int i = 0; i < T; i++) {
            String function = br.readLine();
            int N = Integer.parseInt(br.readLine());
            String arrayString = br.readLine();
            String subString = arrayString.substring(1, arrayString.length() - 1);

            boolean isReversed = false;
            boolean isError = false;

            StringTokenizer st = new StringTokenizer(subString, ",");
            for (int j = 0; j < N; j++) {
                deque.offerLast(Integer.parseInt(st.nextToken()));
            }

            for (int k = 0; k < function.length(); k++) {
                char instruct = function.charAt(k);

                if (instruct == 'R') {
                    isReversed = !isReversed;
                }
                if (instruct == 'D') {
                    if (deque.isEmpty()) {
                        isError = true;
                        break;
                    } else {
                        if (isReversed) {
                            deque.pollLast();
                        } else {
                            deque.pollFirst();
                        }
                    }
                }
            }

            if (isError) bw.write("error\n");
            else {
                bw.write("[");
                if (isReversed) {
                    while (!deque.isEmpty()) {
                        bw.write(String.valueOf(deque.pollLast()));
                        if (!deque.isEmpty()) bw.write(",");
                    }
                } else {
                    while (!deque.isEmpty()) {
                        bw.write(String.valueOf(deque.pollFirst()));
                        if (!deque.isEmpty()) bw.write(",");
                    }
                }
                bw.write("]\n");
            }
            deque.clear();
        }
        bw.flush();
    }
}
