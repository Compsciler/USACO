/*
 ID: rogerwa2
 LANG: JAVA
 TASK: transform
*/

import java.io.*;
import java.util.*;

class transform {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("transform.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("transform.out")));
        int patternSize = Integer.parseInt(f.readLine());
        char[][] oldPattern = new char[patternSize][patternSize];
        for (int i = 0; i < patternSize; i++){
            for (int j = 0; j < patternSize; j++) {
                oldPattern[i][j] = (char)f.read();
            }
            f.readLine();
        }
        char[][] patternClone = clone2D(oldPattern);
        char[][] newPattern = new char[patternSize][patternSize];
        for (int i = 0; i < patternSize; i++){
            for (int j = 0; j < patternSize; j++) {
                newPattern[i][j] = (char)f.read();
            }
            f.readLine();
        }
        for (int i = 0; i < 3; i++){
            rotate90(patternClone);
            if (Arrays.deepEquals(patternClone, newPattern)){
                out.println(i + 1);
                out.close();
            }
        }
        patternClone = clone2D(oldPattern);
        reflectX(patternClone);
        for (int i = 0; i < 4; i++) {
            if (Arrays.deepEquals(patternClone, newPattern)){
                if (i == 0){
                    out.println(4);
                } else {
                    out.println(5);
                }
                out.close();
            }
            rotate90(patternClone);
        }
        if (Arrays.deepEquals(oldPattern, newPattern)){
            out.println(6);
        } else {
            out.println(7);
        }
        
        out.close();
    }
    public static void rotate90(char[][] matrix) {
        int size = matrix.length;
        for (int i = 0; i < size / 2; i++){
            for (int j = i; j < size - i - 1; j++){
                char temp1 = matrix[i][j];
                char temp2 = matrix[j][size - i - 1];
                char temp3 = matrix[size - i - 1][size - j - 1];
                matrix[i][j] = matrix[size - j - 1][i];
                matrix[size - j - 1][i] = temp3;
                matrix[size - i - 1][size - j - 1] = temp2;
                matrix[j][size - i - 1] = temp1;
            }
        }
    }
    public static void reflectX(char[][] matrix){  // For square matrices
        int size = matrix.length;
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size / 2; j++){
                char temp = matrix[i][j];
                matrix[i][j] = matrix[i][size - j - 1];
                matrix[i][size - j - 1] = temp;
            }
        }
    }
    public static char[][] clone2D(char[][] matrix){
        char[][] res = new char[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++){
            res[i] = matrix[i].clone();
        }
        return res;
    }
}