/*
ID: rogerwa2
LANG: JAVA
TASK: beads
*/
import java.io.*;
import java.util.*;

class beads {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("beads.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));
        // StringTokenizer st = new StringTokenizer(f.readLine());
        
        int n = Integer.parseInt(f.readLine());
        String necklace = f.readLine();
        int maxTotal = 0;
        for (int i = 0; i < n; i++){
            int color = 0;  // Red = 1, Blue = 2
            int forwardTotal = 0;
            for (int j = i; j < i + n /* j < (i - 1) % n */; j++){  // I can think of some edge cases where this would not work...
                if (necklace.charAt(j % n) == 'r'){
                    if (color == 2){
                        break;
                    }
                    color = 1;
                } else if (necklace.charAt(j % n) == 'b'){
                    if (color == 1){
                        break;
                    }
                    color = 2;
                }
                forwardTotal++;
            }
            color = 0;
            int backwardTotal = 0;
            for (int j = (i - 1) % n; j > i - n - 1 /* (j - i) % n > (i + forwardTotal) % n */; j--){
                if (necklace.charAt((j + n) % n) == 'r'){
                    if (color == 2){
                        break;
                    }
                    color = 1;
                } else if (necklace.charAt((j + n) % n) == 'b'){
                    if (color == 1){
                        break;
                    }
                    color = 2;
                }
                backwardTotal++;
            }
            int forwardBackwardTotal = (forwardTotal + backwardTotal <= n) ? forwardTotal + backwardTotal : n;
            if (forwardBackwardTotal > maxTotal){
                maxTotal = forwardBackwardTotal;
            }
        }
        out.println(maxTotal);
        
        out.close();
    }
}
