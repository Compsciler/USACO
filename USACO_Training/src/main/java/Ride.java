/*
ID: rogerwa2
LANG: JAVA
TASK: ride
*/
import java.io.*;
import java.util.*;

class ride {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("ride.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));
        // StringTokenizer st = new StringTokenizer(f.readLine());
        
        String s1 = f.readLine();
        String s2 = f.readLine();
        int modProd1 = 1;
        int modProd2 = 1;
        for (int i = 0; i < s1.length(); i++){
            modProd1 *= (s1.charAt(i) - 64);
        }
        modProd1 %= 47;
        for (int i = 0; i < s2.length(); i++) {
            modProd2 *= (s2.charAt(i) - 64);
        }
        modProd2 %= 47;
        if (modProd1 == modProd2){
            out.println("GO");
        } else {
            out.println("STAY");
        }
        
        out.close();
    }
}
