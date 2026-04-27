package twoPointer;
import java.io.*;
import java.util.*;

public class Baekjoon12891 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer firstLine = new StringTokenizer(br.readLine());
        int dnaLength = Integer.parseInt(firstLine.nextToken());
        int partLength = Integer.parseInt(firstLine.nextToken());

        String dnaWord = br.readLine();
        int[] currentCount = new int[4];
        for (int i = 0; i < partLength; i++) {
            char ch = dnaWord.charAt(i);
            if (ch == 'A') currentCount[0]++;
            else if (ch == 'C') currentCount[1]++;
            else if (ch == 'G') currentCount[2]++;
            else if (ch == 'T') currentCount[3]++;
        }

        int[] minCount = new int[4];
        StringTokenizer minCountTokens = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            minCount[i] = Integer.parseInt(minCountTokens.nextToken());
        }

        int totalCount = 0;
        if (isOkay(minCount, currentCount)) totalCount++;

        int left = 0;
        int right = partLength - 1;
        while (left + partLength < dnaLength && right + 1 < dnaLength) {
            if (dnaWord.charAt(left) == 'A') currentCount[0]--;
            else if (dnaWord.charAt(left) == 'C') currentCount[1]--;
            else if (dnaWord.charAt(left) == 'G') currentCount[2]--;
            else if (dnaWord.charAt(left) == 'T') currentCount[3]--;

            if (dnaWord.charAt(right + 1) == 'A') currentCount[0]++;
            else if (dnaWord.charAt(right + 1) == 'C') currentCount[1]++;
            else if (dnaWord.charAt(right + 1) == 'G') currentCount[2]++;
            else if (dnaWord.charAt(right + 1) == 'T') currentCount[3]++;

            if (isOkay(minCount, currentCount)) totalCount++;
            left++;
            right++;
        }

        System.out.println(totalCount);

    }

    public static boolean isOkay(int[] minCount, int[] currentCount) {
        for (int i = 0; i < 4; i++) {
            if (minCount[i] > currentCount[i]) {
                return false;
            }
        }
        return true;
    }
}
