package twoPointer;
import java.io.*;
import java.util.*;

public class Baekjoon15831 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int maxBlack = Integer.parseInt(st.nextToken());
        int minWhite = Integer.parseInt(st.nextToken());

        String road = br.readLine();

        int left = 0;
        int maxLength = 0;

        int currentWhite = 0;
        int currentBlack = 0;

        // right를 0부터 N-1까지 한 번씩 이동을 한다.
        for (int right = 0; right < N; right++) {
            // 1. right 위치의 문자를 추가한다.
            char ch = road.charAt(right);
            if (ch == 'W') currentWhite++;
            else currentBlack++;

            // 2. 검은 조약돌이 최대 개수보다 크다면, left를 늘려서 검은 조약돌을 제거한다.
            while (currentBlack > maxBlack) {
                char leftChar = road.charAt(left);
                if (leftChar == 'W') currentWhite--;
                else currentBlack--;
                left++;
            }

            // 3. 조건을 만족하면 최댓값을 갱신한다.
            if (currentWhite >= minWhite) {
                maxLength = Math.max(right - left + 1, maxLength);
            }
        }

        System.out.print(maxLength);
    }
}
