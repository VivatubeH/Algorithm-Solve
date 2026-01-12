package timecomplex;
import java.io.*;
import java.util.*;

public class Baekjoon10158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer firstTokenizer = new StringTokenizer(br.readLine());
        StringTokenizer secondTokenizer = new StringTokenizer(br.readLine());
        // 격자의 w, h가 주어짐
        int w = Integer.parseInt(firstTokenizer.nextToken());
        int h = Integer.parseInt(firstTokenizer.nextToken());

        // 초기 좌표값 p, q가 주어짐
        int p = Integer.parseInt(secondTokenizer.nextToken());
        int q = Integer.parseInt(secondTokenizer.nextToken());

        // 개미가 움직일 시간 t가 주어짐
        int t = Integer.parseInt(br.readLine());

        // 주기는 2w, 2h임. 이렇게 하면 주기를 제외한 실제 이동시간만 남음.
        int realMoveX = t % (2 * w); // 0 <= realMoveX < 2w
        int realMoveY = t % (2 * h); // 0 <= realMoveY < 2h

        // 현재 X, Y는 주기 ( 0 ~ 2 * w ) 사이에 위치하게 된다.
        int currentX = (p + realMoveX) % (2 * w);
        int currentY = (q + realMoveY) % (2 * h);

        // [0, w], [0, h]에 있으면 그대로 좌표
        // 단, (w, 2w), (h, 2h)에 있으면 반대방향 진행이니 빼줘야 한다.
        if (currentX > w) {
            currentX = w - (currentX % w);
        }
        if (currentY > h) {
            currentY = h - (currentY % h);
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(currentX + " " + currentY);
        bw.flush();
    }
}
