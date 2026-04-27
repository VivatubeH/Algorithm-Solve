package sort;
import java.io.*;
import java.util.*;

public class Baekjoon1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        List<Meeting> list = new ArrayList<>();
        for (int i = 0; i < N; i++) { // N개의 회의에 대해서
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startTime = Integer.parseInt(st.nextToken()); // 시작 시간
            int endTime = Integer.parseInt(st.nextToken()); // 끝나는 시간
            list.add(new Meeting(startTime, endTime)); // 시작 시간과 끝나는 시간을 list에 추가한다.
        }
        // 끝나는 시간이 같으면 시작 시간이 빠른 순으로, 다르면 끝나는 시간이 빠른 순으로 정렬한다.
        list.sort((m1, m2) -> m1.end == m2.end ? m1.start - m2.start : m1.end - m2.end);
        int count = 0; // 회의의 수를 카운팅하기 위한 변수
        int currentTime = 0; // 현재 시간을 기록하기 위한 변수
        // 반복문을 돌면서 가능한 회의의 수를 카운팅한다.
        for (Meeting meeting : list) {
            if (currentTime <= meeting.start) { // 아직 시작이 안 된 회의라면 진행 가능하다.
                count++; // 해당 회의를 선택하고
                currentTime = meeting.end; // 회의를 진행했으니 currentTime을 끝나는 시간으로 변경한다.
            }
        }
        System.out.print(count); // 회의 수를 출력한다.
    }
}

class Meeting {
    int start; // 시작 시간
    int end; // 끝나는 시간

    Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
