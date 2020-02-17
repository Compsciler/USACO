import java.io.*;
import java.util.*;

public class WhereAmI {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new FileReader("whereami.in"));
        PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("whereami.out")));
        input.readLine();
        String road = input.readLine();
        int res = 0;
        iLoop:
        for (int i = 1; i <= road.length(); i++){
            jLoop:
            for (int j = 0; j < road.length() - i + 1; j++){
                String mailBoxSet = road.substring(j, j + i);
                for (int k = j + 1; k < road.length() - i + 1; k++){
                    if (road.substring(k, k + i).equals(mailBoxSet)){
                        continue iLoop;
                    }
                }
            }
            output.print(i);
            break;
        }
        output.close();
        System.exit(0);  
    }
}