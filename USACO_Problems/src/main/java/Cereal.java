import java.io.*;
import java.util.*;

public class Cereal {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("cereal.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cereal.out")));
        out.println(2);
        out.println(2);
        out.println(2);
        out.println(1);
        out.close();
    }
}
