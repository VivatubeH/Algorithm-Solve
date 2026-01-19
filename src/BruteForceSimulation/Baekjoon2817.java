package BruteForceSimulation;
import java.io.*;
import java.util.*;

public class Baekjoon2817 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int X = Integer.parseInt(br.readLine()); // 참가자의 수 X
        int N = Integer.parseInt(br.readLine()); // 총 스태프의 수
        if (N == 0) return; // 스태프가 없는 경우는 아무것도 출력할 필요 없음.
        char[] staffName = new char[N]; // 스태프의 이름을 저장할 배열
        int[] vote = new int[N]; // 각 스태프가 받은 득표수를 저장할 배열
        int total = 0; // 총 득표수를 구하기 위한 변수
        for (int i = 0; i < N; i++) { // N명의 스태프에 대한 데이터를 입력받음.
            StringTokenizer st = new StringTokenizer(br.readLine());
            staffName[i] = st.nextToken().charAt(0); // 스태프의 이름을 입력받음
            vote[i] = Integer.parseInt(st.nextToken()); // 득표수를 입력받음
            total += vote[i]; // 득표수를 누적함.
        }
        // 커트라인이 될 득표수의 5%를 구함.
        double cutLine = total * 0.05; // double과의 연산이므로 double로 받음.
        ArrayList<ScoreSet> list = new ArrayList<>(); // 점수 집합을 담기 위한 List
        // 커트라인 이상의 득표수를 얻은 스태프만 점수 집합을 생성한다.
        for (int i = 0; i < N; i++) {
            if (vote[i] >= cutLine) { // 커트라인을 넘은 스태프만
                ScoreSet set = new ScoreSet(i, vote[i] / (double)i); // 이름 인덱스와 점수로 점수집합을 생성하고
                list.add(set); // 리스트에 담는다.
            }
        }
        // 점수를 기준으로 내림차순 정렬한다.
        list.sort((s1, s2) -> Double.compare(s2.score, s1.score));
        // 상위 14개의 점수에 대해 알파벳 순서로 출력을 위해 카운팅한다.
        int[] frequency = new int[N]; // staffName과 매핑을 위해 frequency 빈도 배열을 생성함.
        for (int i = 0; i < 14; i++) {
           frequency[list.get(i).index]++; // 카운팅한다.
        }
        // 카운팅된 배열을 확인해서 빈도수만큼 매핑된 알파벳을 출력한다.
        for (int i = 0; i < N; i++) {
            for (int count = 0; count < frequency[i]; count++) { // count만큼
                System.out.print(staffName[i]);
            }
        }
    }
}

class ScoreSet { // 점수 집합
    int index; // 이름이 담긴 인덱스
    double score; // 점수

    ScoreSet(int index, double score) {
        this.index = index;
        this.score = score;
    }
}