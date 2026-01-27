package parametricSearch;
import java.io.*;
import java.util.*;

public class Baekjoon2417 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine()); // 정수 n을 입력받는다. 범위 주의

        // 정수 n에 될 수 있는 지에 대한 이분 탐색을 계속한다.
        long min_value = 0; // 정수는 0부터 가능하고
        long max_value = 1L << 32; // 2^32, 비트 연산
        long q = max_value; // 정답이 될 음이 아닌 정수 q ( max_value는 반드시 제곱했을 때 n보다는 크거나 같으니 초기화 )

        // 이분 탐색의 범위
        while (min_value <= max_value) {
            long mid = (min_value + max_value) / 2; // 중간 값

            // 중간값이 판정함수를 통과하면
            if (check(mid, n)) {
                q = mid; // 해당 중간값은 일단 판정함수를 만족함.
                max_value = mid - 1; // mid보다 작은 값을 판정하러 가야함
            }
            // 중간값이 판정함수를 통과하지 못하면
            else {
                min_value = mid + 1; // 중간값보다 큰 범위에서 찾아야 함
            }
        }

        System.out.print(q);
    }

    // 판정 함수
    public static boolean check(long mid, long n) {
        if (mid == 0) { // 예외 처리 mid == 0이면 0으로 나누는 연산은 금지 되어 있음
            if (n == 0) return true; // n이 0일때만 true
            return false; // n이 0이 아니면 무조건 false
        }
        // 판정 함수의 overflow를 방지
        // 이 때, n % mid가 나머지가 있다면, 실제 n / mid는 소숫점이 존재하기 때문에 mid는 1큰 값이어야 한다.
        long rem = n % mid;
        return mid >= (n / mid) + ((rem == 0) ? 0 : 1); // 나머지가 0이 아니면 mid에 1을 더한 값이 정답
    }
}
