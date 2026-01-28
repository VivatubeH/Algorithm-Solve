package twoPointer;
import java.io.*;
import java.util.*;

public class Baekjoon2118 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] array = new int[N + 1]; // array[i]는 (i에서 i 다음 지점까지 거리)
        int[] prefixSum = new int[N + 1]; // prefixSum[i]는 1번 지점에서 i까지의 시계방향 거리

        for (int i = 1; i <= N; i++) {
            int current = Integer.parseInt(br.readLine());
            array[i] = current; // i -> i+1 거리
        }

        for (int i = 2; i <= N; i++) {
            prefixSum[i] = prefixSum[i - 1] + array[i - 1];
        }

        int totalDistance = prefixSum[N] + array[N]; // 전체 거리 = 1에서 N까지 거리 + N에서 1까지 거리 ( N 다음 지점은 1 )

        int maxDistance = 0;
        int right = 1;
        int distance = 0;

        for (int left = 1; left <= N; left++) {
            // 투 포인터이므로 left가 앞지르면 right를 left와 다시 맞춘다.
            if (left > right) right = left;

            // 현재 거리가 최대 거리면 갱신한다.
            int dist1 = prefixSum[right] - prefixSum[left];
            maxDistance = Math.max(maxDistance, Math.min(dist1, totalDistance - dist1));

            while (right < N) { // 다음 이동이 유효할 때만
                int nextDist1 = prefixSum[right + 1] - prefixSum[left]; // 다음 이동 시 얻을 시계 방향 거리
                int nextDist2 = totalDistance - nextDist1; // 다음 이동 시 얻을 반시계 방향 거리

                if (nextDist1 <= nextDist2) { // 시계 방향으로 아직 절반 이하 이동했을 때
                    right++; // 전진한다.
                    maxDistance = Math.max(maxDistance, nextDist1);
                } else { // 시계 방향으로 절반 이상 이동했을 시
                    maxDistance = Math.max(maxDistance, nextDist2); // 이 때도, 체크가 필요하다.
                    break;
                }
            }
        }

        System.out.print(maxDistance);
    }
}
