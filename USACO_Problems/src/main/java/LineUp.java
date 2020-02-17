import java.io.*;
import java.util.*;

public class LineUp {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new FileReader("lineup.in"));
        PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("lineup.out")));
        int numLines = Integer.parseInt(input.readLine());
        String[] cows = {"Beatrice", "Belinda", "Bella", "Bessie", "Betsy", "Blue", "Buttercup", "Sue"};
        ArrayList<ArrayList<Integer>> constraints = new ArrayList<>();
        // HashMap<Integer, ArrayList<Integer>> constraints = new HashMap<>();
        for (int i = 0; i < numLines; i++){
            String[] line = input.readLine().split(" must be milked beside ");
            ArrayList<Integer> subList = new ArrayList<>();
            subList.add(indexOf(cows, line[0]));
            subList.add(indexOf(cows, line[1]));
            constraints.add(subList);
        }
        int[] cowOrder = {0, 1, 2, 3, 4, 5, 6, 7};
        outerLoop:
        for (int i = 0; i < 40320; i++) {
            boolean isLoopCompleted = true;
            for (ArrayList j : constraints) {
                // System.out.println(indexOf(cowOrder, (int)j.get(0)));
                // System.out.println(indexOf(cowOrder, (int)j.get(1)));
                // System.out.println();
                if (Math.abs(indexOf(cowOrder, (int)j.get(0)) - indexOf(cowOrder, (int)j.get(1))) != 1) {
                    isLoopCompleted = false;
                    break;
                }
                // System.out.println("Passed a constraint");
            }
            if (isLoopCompleted){
                for (int j: cowOrder){
                    output.println(cows[j]);
                }
                break outerLoop;
            }
            nextPermutationLoop:
            for (int j = cowOrder.length - 1; j >= 1; j--) {
                if (cowOrder[j] > cowOrder[j - 1]) {
                    int minSwapIndex = cowOrder.length - 1;
                    for (int k = j; k < cowOrder.length; k++) {
                        if (cowOrder[j - 1] >= cowOrder[k]) {
                            minSwapIndex = k - 1;
                            break;
                        }
                    }
                    int temp = cowOrder[j - 1];
                    cowOrder[j - 1] = cowOrder[minSwapIndex];
                    cowOrder[minSwapIndex] = temp;
                    for (int k = j; k < (cowOrder.length + j) / 2; k++) {
                        temp = cowOrder[k];
                        cowOrder[k] = cowOrder[cowOrder.length - k + j - 1];
                        cowOrder[cowOrder.length - k + j - 1] = temp;
                    }
                    break nextPermutationLoop;
                }
            }
        }
        // System.out.println("After outerLoop");
        output.close();
        System.exit(0);
    }
    public static int indexOf(int[] arr, int n) {
        for (int i = 0; i < arr.length; i++){
            if (arr[i] == n){
                return i;
            }
        }
        return -1;
    }
    public static int indexOf(String[] arr, String n) {
        for (int i = 0; i < arr.length; i++){
            if (arr[i].equals(n)){
                return i;
            }
        }
        return -1;
    }
}