package queue;
import java.io.*;
import java.util.*;

/*
 * 입력: 테스트 케이스의 수 T, 문서의 개수 N( 1 ~ 100), 궁금한 문서의 큐에서의 위치 ( 0 <= M < N ), N개 문서의 중요도 ( 1이상 9이하, 중복 가능 )
 * 출력: 각 테스트 케이스에 대해 문서가 몇 번째로 출력되는지
 *
 * 알고리즘: 큐(Queue), O(1)에 큐의 앞에서 제거, O(1)에 큐의 뒤에 재배치
 *
 * 시간: O(T * N^2) - 테스트케이스마다 O(1)으로 앞에서 삭제, 뒤로 추가 + 남은 문서의 중요도 확인
 * 주의: 중요도가 동일한 경우도 있으니, 구분을 위해서 최초 입력 시 index도 같이 가져가야 함.

 * */

public class Baekjoon1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        Queue<Document> queue = new ArrayDeque<>();

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int index = 0; index < N; index++) {
                int priority = Integer.parseInt(st.nextToken());
                Document document = new Document(index, priority);
                queue.offer(document);
            }

            int count = 0;
            while (!queue.isEmpty()) {
                Document current = queue.poll();
                int currentPriority = current.priority;

                boolean isCanPrint = true;

                for (Document other : queue) {
                    if (other.priority > currentPriority) {
                        isCanPrint = false;
                        break;
                    }
                }

                if (isCanPrint) {
                    count++;
                    if (current.index == M) {
                        bw.write(count + "\n");
                        break;
                    }
                } else {
                    queue.offer(current);
                }
            }
            queue.clear();
        }
        bw.flush();
    }
}

class Document {
    int index;
    int priority;

    Document(int index, int priority) {
        this.index = index;
        this.priority = priority;
    }
}
