package sort;
import java.io.*;
import java.util.*;

public class Baekjoon7785 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 출입 기록의 수 N이 주어짐
        int N = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>(); // 출퇴근 기록을 담을 Set
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken(); // 로그에 나오는 사원명
            String result = st.nextToken(); // 출입 기록

            if (result.equals("enter")) { // 출근시에는
               set.add(name); // add는 있을 시 추가 후 true 반환, 없을 시 추가 없이 false 반환
            } else if (result.equals("leave")) { // 퇴근시에는
               set.remove(name); // remove는 있을 시 제거 후 true 반환, 없을 시 제거 없이 false 반환
            }
        }
        // 로그를 Set에 기록한 뒤 사전순의 역순으로 정렬한다.
        // * Set은 순서가 없는 자료구조인데 sort 메서드는 인덱스(순서)가 존재하는 List 인터페이스의 구현 객체만 인자로 받는다.
        List<String> list = new ArrayList<>(set);
        list.sort((s1, s2) -> s2.compareTo(s1)); // List를 사전순의 역순으로 정렬
        for (String name : list) { // 역순으로 정렬된 list를 순회하면서
            bw.write(name); // 이름을 출력하고
            bw.newLine(); // 줄바꿈을 출력하고
        }
        bw.flush(); // 버퍼의 내용을 flush 한다.
    }
}
