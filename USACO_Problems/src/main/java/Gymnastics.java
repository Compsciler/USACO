import java.io.*;
import java.util.*;

public class Gymnastics {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new FileReader("gymnastics.in"));
        PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("gymnastics.out")));
        String[] firstLine = input.readLine().split(" ");
        int numLines = Integer.parseInt(firstLine[0]);
        int numCows = Integer.parseInt(firstLine[1]);
        int[] pairArr = new int[numCows * (numCows - 1) / 2];
        for (int i = 0; i < numLines; i++) {
            int[] cowRanks = new int[numCows];
            String[] line = input.readLine().split(" ");
            for (int j = 0; j < numCows; j++) {
                cowRanks[Integer.parseInt(line[j]) - 1] = j;
            }
            int cow1 = 0;
            int cow2 = 1;
            for (int j = 0; j < pairArr.length; j++) {
                if (pairArr[j] != -1) {
                    if (cowRanks[cow1] < cowRanks[cow2]) {
                        if (pairArr[j] == 2) {
                            pairArr[j] = -1;
                        } else {
                            pairArr[j] = 1;
                        }
                    } else {
                        if (pairArr[j] == 1) {
                            pairArr[j] = -1;
                        } else {
                            pairArr[j] = 2;
                        }
                    }
                }
                if (cow2 == numCows - 1) {
                    cow1++;
                    cow2 = cow1 + 1;
                } else {
                    cow2++;
                }
            }
        }
        int total = 0;
        for (int i = 0; i < pairArr.length; i++) {
            if (pairArr[i] != -1){
                total++;
            }
        }
        output.println(total);
        output.close();
        System.exit(0);
    }
}