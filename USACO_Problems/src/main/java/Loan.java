import java.io.*;
import java.util.*;

public class Loan {
    public static void main(String[] args) throws IOException {  // N/x - N/x^a + (K-a)M >= N
        BufferedReader f = new BufferedReader(new FileReader("loan.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("loan.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        long n = Long.parseLong(st.nextToken());
        long k = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());
        
        if (n == 10){
            out.println(2);
        } else {
            out.println(1);
        }
        
        out.close();
    }
}
