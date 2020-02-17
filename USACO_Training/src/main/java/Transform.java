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
        int[][] oldPattern = new int[patternSize][patternSize];
        for (int i = 0; i < patternSize; i++){
            for (int j = 0; j < patternSize; j++) {
                oldPattern[i][j] = f.read();
            }
            f.readLine();
        }
        int[][] patternClone = clone2D(oldPattern);
        int[][] newPattern = new int[patternSize][patternSize];
        for (int i = 0; i < patternSize; i++){
            for (int j = 0; j < patternSize; j++) {
                newPattern[i][j] = f.read();
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
    public static void rotate90(int[][] matrix) {
        int size = matrix.length;
        for (int i = 0; i < size / 2; i++){
            for (int j = i; j < size - i - 1; j++){
                int temp1 = matrix[i][j];
                int temp2 = matrix[j][size - i - 1];
                int temp3 = matrix[size - i - 1][size - j - 1];
                matrix[i][j] = matrix[size - j - 1][i];
                matrix[size - j - 1][i] = temp3;
                matrix[size - i - 1][size - j - 1] = temp2;
                matrix[j][size - i - 1] = temp1;
            }
        }
    }
    public static void reflectX(int[][] matrix){  // For square matrices
        int size = matrix.length;
        for (int i = 0; i < size / 2; i++){
            for (int j = i; j < size; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][size - i - 1];
                matrix[size - i - 1][i] = temp;
            }
        }
    }
    public static int[][] clone2D(int[][] matrix){
        int[][] res = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++){
            res[i] = matrix[i].clone();
        }
        return res;
    }
}