/*
 ID: rogerwa2
 LANG: JAVA
 TASK: palsquare
*/

import java.io.*;
import java.util.*;

class palsquare {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("palsquare.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("palsquare.out")));
        int base = Integer.parseInt(f.readLine());
        outerLoop:
        for (int i = 1; i <= 300; i++) {
            String baseSquare = Integer.toString(i * i, base).toUpperCase();
            for (int j = 0; j < baseSquare.length() / 2; j++){
                if (baseSquare.charAt(j) != baseSquare.charAt(baseSquare.length() - j - 1)){
                    continue outerLoop;
                }
            }
            out.println(Integer.toString(i, base).toUpperCase() + " " + baseSquare);
        }
        
        out.close();
    }
}
