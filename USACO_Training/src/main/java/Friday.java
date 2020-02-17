/*
ID: rogerwa2
LANG: JAVA
TASK: friday
*/
import java.io.*;
import java.util.*;

class friday {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("friday.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));
        // StringTokenizer st = new StringTokenizer(f.readLine());
        
        int[] nonLeapYearArr = {1, 3, 1, 2, 2, 2, 1};  // Sunday to Saturday
        int[] leapYearArr = {1, 2, 2, 1, 2, 3, 1};
        int numYears = Integer.parseInt(f.readLine());
        int jan1Day = 1;  // Monday in 1900
        int[] fridayTotals = new int[7];
        for (int i = 0; i < numYears; i++){
            if ((i + 1900) % 4 == 0 && ((i + 1900) % 100 != 0 || (i + 1900) % 400 == 0)){
                for (int j = 0; j < 7; j++){
                    fridayTotals[j] += leapYearArr[(j - jan1Day + 7) % 7];
                }
                jan1Day += 2;
            } else {
                for (int j = 0; j < 7; j++){
                    fridayTotals[j] += nonLeapYearArr[(j - jan1Day + 7) % 7];
                }
                jan1Day += 1;
            }
            jan1Day %= 7;
        }
        for (int i = 6; i < 12; i++){
            out.print(fridayTotals[i % 7] + " ");
        }
        out.println(fridayTotals[5]);
        
        /*
        int[][] nonLeapYearArr = {{1, 10}, {4, 7}, {9, 12}, {6}, {2, 3, 11}, {8}, {5}};  // Sunday to Saturday
        int[][] leapYearArr = {{1, 4, 7}, {9, 12}, {6}, {3, 11}, {2, 8}, {5}, {10}};
        int numYears = Integer.parseInt(f.readLine());
        int jan1Day = 0;  // Sunday in 1899
        int[] fridayTotals = new int[12];
        for (int i = 0; i < numYears; i++){
            if (i + 1900 % 4 == 0 && (i + 1900 % 100 != 0 || i + 1900 % 400 == 0)){
                for (int j: leapYearArr[jan1Day]){
                    fridayTotals[j - 1]++;
                }
                jan1Day += 2;
            } else {
                for (int j: nonLeapYearArr[jan1Day]){
                    fridayTotals[j - 1]++;
                }
                jan1Day += 1;
            }
            jan1Day %= 7;
        }
        for (int i = 0; i < 11; i++){
            out.print(fridayTotals[i] + " ");
        }
        out.println(fridayTotals[11]);
        */
        
        out.close();
    }
}
