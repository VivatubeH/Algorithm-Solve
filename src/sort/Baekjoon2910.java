package sort;
import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class Baekjoon2910 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer firstLine = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(firstLine.nextToken()); // 메시지의 수 N
        int C = Integer.parseInt(firstLine.nextToken()); // 메시지 내부의 숫자 상한 C
        // N개의 숫자를 입력받는다.
        StringTokenizer secondLine = new StringTokenizer(br.readLine());

        // 등장 순서는 인덱스 활용, 빈도는 map에 기록, 숫자를 key로
        // 여기서 인덱스와 빈도가 모두 기록되야 하므로 3개의 변수가 필요한데 Map은 2개의 변수만 가능하다.
        // 그래서 Map의 Key로는 해당 숫자를, Value로는 숫자와 등장 빈도를 기록할 클래스를 쓴다.
        Map<Integer, Frequency> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(secondLine.nextToken()); // 토큰에 있는 숫자를 하나씩 떼어온다.
            if (!map.containsKey(num)) { // num가 이전에 들어온 적 없을 때는
                Frequency frequency = new Frequency(i, 1);// 등장 순서로 현재 인덱스를, count는 1로 설정한다. ( 1번 들어옴 )
                map.put(num, frequency); // 이후 map에 집어넣는다.
            } else { // num가 들어온 적 있다면 Frequency가 가진 빈도만 증가시켜주면 된다.
                map.get(num).count++; // Map의 Value로 가지고 있는 Frequency 객체의 count를 증가시킨다.
            }
        }
        // 정렬을 수행하기 위해 ArrayList에 담아야 한다.
        // 담기 위해 entrySet을 이용한다.
        List<Map.Entry<Integer, Frequency>> list = new ArrayList<>(map.entrySet());
        // 정렬은 빈도 순(Value.count)으로 내림차순 정렬하되, 빈도가 같으면 등장 순서(Value.index) 순으로 오름차순 정렬한다.
        list.sort((s1, s2) -> Integer.compare(s2.getValue().count, s1.getValue().count) == 0 ? s1.getValue().index - s2.getValue().index : Integer.compare(s2.getValue().count, s1.getValue().count));
        // list를 출력할 때, 숫자당 출력 횟수는 Frequency (Value)의 count만큼 출력하면 된다.
        for (Entry<Integer, Frequency> entry : list) { // list에 담겨있는 Entry를 가져온다.
            for (int i = 0; i < entry.getValue().count; i++) { // count 빈도만큼 출력한다.
                bw.write(entry.getKey() + " "); // Key가 담겨있는 숫자 ( 숫자를 출력할 때는 문자열로 변환 후 출력해야함 )
            }
        }
        bw.flush();
    }
}

class Frequency {
    int index; // 등장 순서로 사용할 인덱스
    int count; // 등장 빈도를 체크할 때 쓸 count

    Frequency(int index, int count) {
        this.index = index;
        this.count = count;
    }
}
