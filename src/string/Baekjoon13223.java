package string;
import java.util.Scanner;

public class Baekjoon13223 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String before = scanner.nextLine();
        String after = scanner.nextLine();

        String[] hms_before = before.split(":");
        String[] hms_after = after.split(":");

        int hour_before = Integer.parseInt(hms_before[0]);
        int minute_before = Integer.parseInt(hms_before[1]);
        int second_before = Integer.parseInt(hms_before[2]);

        int hour_after = Integer.parseInt(hms_after[0]);
        int minute_after = Integer.parseInt(hms_after[1]);
        int second_after = Integer.parseInt(hms_after[2]);

        int totalSecond_before = hour_before * 3600 + minute_before * 60 + second_before;
        int totalSecond_after = hour_after * 3600 + minute_after * 60 + second_after;

        int resultSecond = totalSecond_after - totalSecond_before;

        if (totalSecond_before >= totalSecond_after) {
            resultSecond += (24 * 60 * 60);
        }

        int hour_result = resultSecond / 3600;
        resultSecond %= 3600;
        int minute_result = resultSecond / 60;
        resultSecond %= 60;
        int second_result = resultSecond;

        System.out.printf("%02d:%02d:%02d", hour_result, minute_result, second_result);
    }
}
