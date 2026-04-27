package sort;
import java.io.*;
import java.util.*;
public class Baekjoon10814 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine()); // 온라인 저지 회원수
        List<Member> list = new ArrayList<>(); // 회원을 저장할 리스트
        for (int i = 0; i < N; i++) { // N줄에 걸쳐 회원 정보를 입력받는다.
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken()); // 나이
            String name = st.nextToken(); // 이름
            Member member = new Member(i, age, name); /// 순서, 나이, 이름을 토대로 Member를 생성한다.
            list.add(member); // List에 Member를 추가한다.
        }
        // 주어진 조건에 맞게 정렬한다.
        // 람다식 사용 : 멤버 2명이 나이가 다르면 나이 증가순, 나이가 같으면 먼저 가입한 회원이 먼저 오도록.
        list.sort((m1, m2) -> m1.age != m2.age ? m1.age - m2.age : m1.order - m2.order);
        // 정렬이 완료된 이후에는 순서대로 나이와 이름을 출력하기만 하면 된다.
        for (Member member : list) {
            bw.write(member.age + " " + member.name); // 나이와 이름을 공백으로 구분해서 출력한다.
            bw.newLine(); // 줄을 바꾼다.
        }
        bw.flush(); // 버퍼에 쌓인 데이터를 출력한다.
    }
}

class Member { // 회원 관리를 위한 클래스
    int order; // 가입 순서
    int age; // 나이
    String name; // 이름

    // 회원 정보를 저장할 Member 클래스
    Member(int order, int age, String name) {
        this.order = order;
        this.age = age;
        this.name = name;
    }
}
