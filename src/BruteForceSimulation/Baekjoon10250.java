package BruteForceSimulation;
import java.io.*;
import java.util.*;

public class Baekjoon10250 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 수 T
        for (int i = 0; i < T; i++) { // T개의 테스트 케이스를 입력받음
            StringTokenizer token = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(token.nextToken()); // 호텔의 층수
            int W = Integer.parseInt(token.nextToken()); // 각 층의 방수
            int N = Integer.parseInt(token.nextToken()); // 몇 번째 손님인지
            String result = findRoomNumber(H, W, N); // 주어진 데이터를 토대로 방 번호를 찾는 메서드
            bw.write(result); // 해당 방 번호를 버퍼에 기록
            bw.write("\n"); // 줄 바꿈도 버퍼에 기록
        }
        bw.flush(); // 출력
    }

    // 호텔의 층 수, 호텔의 각 방 수, 몇 번째 손님인지를 토대로 손님의 방 번호를 문자열로 반환하는 메서드
    public static String findRoomNumber(int H, int W, int N) {
        int count = 0; // 할당하는 방의 수를 count 하기 위한 변수
        StringBuilder roomNumber = new StringBuilder(); // 배정해야 할 방 번호를 저장하기 위한 변수
        // 방은 1호실 먼저 -> 2호실 나중 순으로 배정하니 행에 방을 배정하고, 해당 행에 모든 방 배정 후 열에 배정하러 이동
        for (int col = 1; col <= W; col++) { // W호실까지 배정
            for (int row = 1; row <= H; row++) { // H층까지 먼저 배정
                count++; // 해당 방을 배정한다.
                if (count == N) { // N번방이 배정되고 나면
                    // 층은 그대로 문자열로
                    roomNumber.append(row);
                    // 호실은 한자리수면 앞에 0을 붙여서, 두 자리수면 그대로
                    if (col < 10) {
                        roomNumber.append("0").append(col);
                    } else {
                        roomNumber.append(col);
                    }
                }
            }
        }
        return roomNumber.toString();
    }
}
