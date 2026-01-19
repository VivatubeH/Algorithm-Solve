package sort;
import java.io.*;
import java.util.*;

public class Baekjoon1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine()); // 단어의 개수 N개 ( 최대 2만개 )
        Set<String> set = new HashSet<>(); // 단어 중복을 제거하기 위해 처음에 Set에 담음
        for (int i = 0; i < N; i++) {
            set.add(br.readLine()); // 한 줄씩 입력받아 Set에 담음
        }
        List<String> list = new ArrayList<>(set); // set을 list에 옮겨 담음.
        list.sort((s1, s2) -> s1.length() != s2.length() ? s1.length() - s2.length() : s1.compareTo(s2)); 
        for (String str : list) { // 인덱스를 안 쓰는 이유 = 중복을 제거했을 때 단어 개수가 N개가 아닐 수 있음
            bw.write(str);
            bw.newLine(); // 줄바꿈 처리하기
        }
        bw.flush(); // 출력
    }
}
