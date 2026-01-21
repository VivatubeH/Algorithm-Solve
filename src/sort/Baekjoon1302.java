package sort;
import java.io.*;
import java.util.*;

public class Baekjoon1302 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 하루동안 팔린 책의 수 N
        Map<String, Integer> map = new HashMap<>(); // 책의 제목(String)과 팔린 권수(Integer)를 담는 map
        for (int i = 0; i < N; i++) {
            String bookName = br.readLine(); // 책 제목을 입력받는다.
            // 책 제목을 map에 담는데,
            // 해당 책에 map에 포함되어 있으면 현재까지 팔린 권수를 반환하고, 포함되어 있지 않으면 0을 반환한다.
            // 즉, map에 집어넣을 때는 현재까지 팔린 권수 + 1이거나 1이 들어가게 된다.
            // map.getOrDefault() : Key가 존재하면 Value반환, 존재하지 않으면 defaultValue 반환
            map.put(bookName, map.getOrDefault(bookName, 0) + 1);
        }
        // 책이 팔린 권수인 value를 기준으로 내림차순 정렬하되, 권수가 같으면 사전순 정렬
        // ArrayList의 생성자로는 Collection을 구현한 객체만 가능하다.
        // Map은 Collection을 상속받지 않았으므로, Map 내부의 Entry(Key-Value 쌍)을 담아야함.
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        // Entry 객체들을 정렬한다.
        // Value인 팔린 권수가 동일한 경우에는 -> 사전순으로 정렬하고
        // 동일하지 않은 경우에는 많이 팔린 게 앞으로 오도록 내림차순 정렬한다.
        list.sort((e1, e2) -> e2.getValue().equals(e1.getValue()) ? e1.getKey().compareTo(e2.getKey()) : e2.getValue() - e1.getValue());
        System.out.print(list.get(0).getKey()); // 리스트의 첫 번째의 키인 이름을 출력한다.
    }
}
