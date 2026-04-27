package queue;
import java.io.*;
import java.util.*;
/*
 * 입력: 버퍼의 크기 N(10만 이하의 자연수), 정보는 최대 20만개, -1이 입력의 끝. ( -1은 프로그램 종료 )
 * 출력: 라우터에 남아있는 패킷을 앞에서부터 순서대로 출력
 *
 * 알고리즘: 큐(Queue) - FIFO(First In First Out) 선입선출 자료구조 O(1)에 큐 뒤에 쌓기, O(1)에 큐 앞에서 제거
 * 발상:
 *
 * 시간: O(N) - 정보의 수 N에 비례하게 됨. 최종 버퍼 출력도 O(N)이므로 총 시간 복잡도는 O(N)
 * 주의:
 * 0 - 라우터가 패킷 하나 처리 ( 패킷의 앞에서 제거 ) // 버퍼가 비어있을 때는 0이 입력으로 들어오지 않음은 입력에서 보장됨.
 * 양의 정수 - 패킷에 입력 ( 패킷의 뒤에 추가 ) // 단, 패킷이 가득 차있을때는 버려짐.
 * -1 - 입력의 끝 ( 그 때까지 라우터에 저장된 패킷 출력 ) // 단, 라우터가 비어있을 때는 empty 출력

* */

public class Baekjoon15828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Queue<Integer> router = new ArrayDeque<>();
        int N = Integer.parseInt(br.readLine());
        int current = 0;
        // -1이 아니면 입력의 끝이 아니니 계속 진행
        while ((current = Integer.parseInt(br.readLine())) != -1) {
            if (current > 0) {
                if (router.size() != N) {
                    router.offer(current);
                }
            } else if (current == 0) {
                router.poll();
            }
        }
        if (router.isEmpty()) {
            System.out.print("empty");
        } else {
            for (Integer integer : router) {
                bw.write(integer + " ");
            }
            bw.flush();
        }
    }
}
