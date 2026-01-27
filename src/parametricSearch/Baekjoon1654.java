package parametricSearch;
import java.io.*;
import java.util.*;

public class Baekjoon1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer firstLine = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(firstLine.nextToken()); // 영식이가 이미 가지고 있는 랜선의 개수 K
        int N = Integer.parseInt(firstLine.nextToken()); // 필요한 랜선의 개수 N
        int maxLength = 0; // 랜선의 최대 길이

        int[] array = new int[K]; // K개의 랜선의 길이를 저장할 배열 ( 랜선의 길이는 int 범위에 있음 )
        for (int i = 0; i < K; i++) { // K줄에 걸쳐서
            array[i] = Integer.parseInt(br.readLine()); // 랜선의 길이를 입력받는다.
            if (array[i] > maxLength) maxLength = array[i]; // 최대 길이로 갱신
        }

        // 이분 탐색과 매개변수 탐색을 통해 만들 수 있는 랜선의 최대 길이를 찾는다.
        long lower = 1; // 랜선 길이가 0일 수는 없음.
        long upper = maxLength; // 현재 랜선 이상의 길이를 얻을 수 없음 ( 함정 )
        long max = 0; // 만들 수 있는 랜선의 최대 길이, 반드시 얻을 수 있으므로 초기화는 필요 X

        while (lower <= upper) { // 이분 탐색
            long mid = (lower + upper) / 2;

            // 필요 개수만큼 얻을 수 있으면
            if (check(mid, N, array)) {
                max = mid; // mid 길이로 잘라도 확보가 가능하고,
                lower = mid + 1; // mid 이상의 길이로도 잘라봐야 함.
            }
            // 필요 개수만큼 얻을 수 없다면
            else {
                upper = mid - 1;// mid 이상의 길이로는 자르면 안됨.
            }
        }

        System.out.print(max);
    }

    public static boolean check(long mid, int N, int[] array) {
        long sum = 0; // 랜선의 길이
        for (int i = 0; i < array.length; i++) {
            sum += (array[i] / mid); // array[i]가 long으로 변환될 때, 데이터 손실은 없음.
            if (sum >= N) { // N이 int로 변환될 때 마찬가지로 데이터 손실이 없음
                return true; // N개 이상 확보되면 가능한 것이므로 바로 종료함.
            }
        }
        return false; // 최종적으로도 sum이 N만큼 확보가 안된다면 실패
    }
}
