/*
ID: rogerwa2
LANG: JAVA
TASK: namenum
*/
import java.io.*;
import java.util.*;

class namenum {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("namenum.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("namenum.out")));
        BufferedReader dict = new BufferedReader(new FileReader("dict.txt"));
        HashMap<Character, Integer> letterMaps = new HashMap<>();
        int letterCount = 0;
        for (int i = 'A'; i <= 'Y'; i++) {
            if (i != 'Q') {
                letterMaps.put((char)i, letterCount / 3 + 2);
                letterCount++;
            }
        }
        String serialString = f.readLine();
        int serialLength = serialString.length();
        String name = "";
        boolean hasValidName = false;
        
        outerLoop:
        while (true) {
            name = dict.readLine();
            if (name == null){
                break;
            }
            if (name.length() != serialLength) {
                continue;
            }
            for (int i = 0; i < name.length(); i++) {
                if (!letterMaps.containsKey(name.charAt(i)) || letterMaps.get(name.charAt(i)) != (serialString.charAt(i) - '0')) {
                    continue outerLoop;
                }
            }
            out.println(name);
            hasValidName = true;
        }
        if (!hasValidName){
            out.println("NONE");
        }
        out.close();
    }
}