/*
ID: rogerwa2
LANG: JAVA
TASK: dualpal
*/
import java.io.*;
import java.util.*;

class dualpal {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("dualpal.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("dualpal.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int dualPalTotal = 0;
        while (dualPalTotal < N){
            S++;
            int basePalTotal = 0;
            for (int base = 2; base <= 10; base++) {
                if (isPalindrome(Integer.toString(S, base))){
                    basePalTotal++;
                }
            }
            if (basePalTotal < 2){
                continue;
            }
            out.println(S);
            dualPalTotal++;
        }
        out.close();
    }
    public static boolean isPalindrome(String s){
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) != s.charAt(s.length() - i - 1)){
                return false;
            }
        }
        return true;
    }
}