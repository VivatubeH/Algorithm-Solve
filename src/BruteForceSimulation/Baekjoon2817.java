package BruteForceSimulation;
import java.io.*;
import java.util.*;

public class Baekjoon2817 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int X = Integer.parseInt(br.readLine()); // 참가자의 수 X
        int N = Integer.parseInt(br.readLine()); // 총 스태프의 수
        int[] frequency = new int[26]; // 점수 집합에서 알파벳별 등장 빈도를 체크하기 위한 배열
        int[] chipArray = new int[26]; // 스태프가 받은 칩 개수를 저장하기 위한 배열
        boolean[] isOver = new boolean[26]; // 5% 이상 득표율인 스태프면 무조건 이름 출력
        if (N == 0) return; // 스태프가 없는 경우는 아무것도 출력할 필요 없음.
        List<Staff> list = new ArrayList<>(); // 점수 집합을 저장하기 위한 List
        for (int i = 0; i < N; i++) { // 스태프 수만큼 점수를 입력받는다.
            StringTokenizer st = new StringTokenizer(br.readLine());
            int index = st.nextToken().charAt(0) - 'A'; // 입력받은 알파벳을 인덱스로서 활용한다.
            int chip = Integer.parseInt(st.nextToken()); // 해당 스태프가 받은 칩의 개수
            chipArray[index] = chip; // 해당 스태프가 받은 칩 개수를 저장한다.
        }
        double minimum = X * 0.05;
        for (int i = 0; i < 26; i++) { // 받은 칩개수를 토대로 5% 이상의 득표율일 때만 점수집합을 만든다.
            if (chipArray[i] >= minimum) {
                isOver[i] = true;
                for (int j = 1; j <= 14; j++) {
                    double score = chipArray[i] / (double)j; // 실수 연산을 위해 double로 형변환 후 나눗셈을 수행
                    Staff staff = new Staff(i, score); // 인덱스와 점수를 기반으로 Staff를 생성하고
                    list.add(staff); // 점수 집합에 누적한다.
                }
            }
        }
        // 점수 집합을 점수 기준으로 내림차순 정렬한다. ( 점수가 높은 사람이 먼저 오게 )
        list.sort((s1, s2) -> Double.compare(s2.score, s1.score)); // 실수 2개를 내림차순 정렬한다.
        for (int i = 0; i < 14; i++) {
            frequency[list.get(i).index]++; // 상위 14명에 대해서 등장 빈도를 센다.
        }
        // 빈도 배열을 세면서 등장하는 알파벳만 그 횟수인 빈도를 같이 출력한다.
        // 이렇게 하면 알파벳이 오름차순으로 출력됨.
        for (int i = 0; i < 26; i++) {
            if (isOver[i]) { // 득표율이 5%를 넘은 스태프에 대해서는
            System.out.println((char)('A' + i) + " " + frequency[i]); // 알파벳과 등장 빈도를 출력한다.
        }
    }
}
}

class Staff {
    int index; // 알파벳의 인덱스
    double score; // 점수 집합의 점수

    Staff(int index, double score) {
        this.index = index;
        this.score = score;
    }
}