package list;
import java.io.*;
import java.util.*;

/*
 * 입력: 사람의 수 N ( N은 1~5000인 양의 정수 ), 제거할 사람의 순서인 K ( K도 1~5000인 양의 정수 )
 * 출력: 제거한 사람의 번호를 순서대로 요세푸스 순열로 출력한다. ( 출력형식 <숫자, 숫자, 숫자> )
 *
 * 알고리즘: 리스트
 * 발상: 원을 이루면서 앉아있다 = N번 다음이 1번 사람이 된다.
 * 즉, K번째 이전 사람들을 N뒤에 옮겨두고, K번째를 제거하면 인덱스 체크 없이 가능하다.
 *
 * 시간: O(N*K)
 * 주의: 만약 단순히 remove를 하면, 인덱스가 변하기 때문에 처리하기 어려움.
*/

public class Baekjoon1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        LinkedList<Integer> list = new LinkedList<>(); // 1~N까지의 순열
        List<Integer> yosepus = new ArrayList<>(); // 요세푸스 순열

        for (int i = 1; i <= N; i++) {
            list.add(i);
        }

        // 순열에 사람이 남아있는 동안에
        while (!list.isEmpty()) {
            // K-1명의 사람을 제거한 뒤, 리스트에 뒤에 이어붙인다. ( 원형 배열 )
            for (int i = 0; i < K - 1; i++) {
                Integer current = list.removeFirst();
                list.addLast(current);
            }
            // K번째 사람을 요세푸스 순열에 기록한다.
            yosepus.add(list.removeFirst());
        }

        bw.write("<");
        // 요세 푸스 순열을 형식에 맞게 출력한다.
        for (int i = 0; i < N; i++) {
            bw.write(String.valueOf(yosepus.get(i)));
            if (i == N - 1) continue;
            bw.write(", ");
        }
        bw.write(">");
        bw.flush();
    }
}
