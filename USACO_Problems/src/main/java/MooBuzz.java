import java.io.*;
import java.util.*;

public class MooBuzz {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new FileReader("moobuzz.in"));
        PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("moobuzz.out")));
        int nthNum = Integer.parseInt(input.readLine());
        int res = nthNum / 8 * 15;
        switch (nthNum % 8){
            case 0:
                res -= 1;
                break;
            case 1:
                res += 1;
                break;
            case 2:
                res += 2;
                break;
            case 3:
                res += 4;
                break;
            case 4:
                res += 7;
                break;
            case 5:
                res += 8;
                break;
            case 6:
                res += 11;
                break;
            case 7:
                res += 13;
        }
        output.println(res);
        output.close();
        System.exit(0);
    }
}
