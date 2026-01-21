package sort;
import java.io.*;
import java.util.*;

public class Baekjoon18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine()); // N개의 좌표의 개수 N이 주어진다.
        StringTokenizer st = new StringTokenizer(br.readLine()); // N개의 정수가 공백을 기준으로 주어진다.
        List<Integer> list = new ArrayList<>(); // 입력된 N개의 수를 정렬하기 위한 리스트, 이 리스트는 유지 후 마지막에 출력을 위해 씀.
        for (int i = 0; i < N; i++) {
            list.add(i, Integer.parseInt(st.nextToken())); // i번 인덱스에 해당 정수 입력, N개의 정수를 입력한다.
        }
        // 중복을 제거하기 위해 Set에 옮겨담는다.
        Set<Integer> set = new HashSet<>(list);
        // 이 Set을 다시 정렬을 위한 List에 옮겨담는다.
        List<Integer> sortedList = new ArrayList<>(set);
        Collections.sort(sortedList); // 오름차순 정렬한다.
        Map<Integer, Integer> map = new HashMap<>(); // 입력받은 수와 인덱스를 매핑하기 위한 HashMap
        // sortedList의 개수는 N개가 아닐 수 있으므로 sortedList.size()로 인덱스를 재차 체크해야한다.
        for (int i = 0; i < sortedList.size(); i++) { // 정렬된 리스트의 인덱스를 기반해서 Map에 매핑한다.
            map.put(sortedList.get(i), i); // 숫자와 인덱스를 매핑한다.
        }
        // 입력받았던 수를 공백을 넣어서 출력한다. 해당 수가 Key로 들어가 있는 Map의 Value가 바로 해당 수보다 작은 Xj의 개수이다.
        for (int i = 0; i < N; i++) {
            Integer integer = list.get(i); // List의 i번째 수를 가져온다.
            bw.write(map.get(integer) + " "); // map에 포함된 해당 수의 인덱스를 공백을 넣어서 버퍼에 기록한다.
        }
        bw.flush(); // 화면에 출력한다.
    }
}
