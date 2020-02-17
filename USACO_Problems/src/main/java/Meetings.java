import java.io.*;
import java.util.*;

public class Meetings {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new FileReader("meetings.in"));
        PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("meetings.out")));
        String[] firstLine = input.readLine().split(" ");
        int numCows = Integer.parseInt(firstLine[0]);
        int barn2 = Integer.parseInt(firstLine[1]) * 2;
        ArrayList<ArrayList<Integer>> cows = new ArrayList<>();
        int weightRequired = 0;
        for (int i = 0; i < numCows; i++){
            String[] line = input.readLine().split(" ");
            ArrayList<Integer> subList = new ArrayList<>();
            for (int j = 0; j < 3; j++){
                if (j == 1){
                    subList.add(Integer.parseInt(line[j]) * 2);
                } else {
                    subList.add(Integer.parseInt(line[j]));
                }
            }
            weightRequired += subList.get(0);
            cows.add(subList);
        }
        weightRequired = weightRequired / 2 + weightRequired % 2;
        int barnWeight = 0;
        int totalCollisions = 0;
        // double time = 0;
        while (barnWeight < weightRequired){
            boolean isCollision = true;
            ArrayList<Integer> cowNumChanges = new ArrayList<>();
            int minTime = Integer.MAX_VALUE;
            int prevCowPos = cows.get(0).get(1);
            if (cows.get(0).get(2) == -1){
                minTime = prevCowPos;
                cowNumChanges.add(0);
                isCollision = false;
            }
            for (int i = 1; i < numCows; i++) {
                if (cows.get(i).get(2) == -1 && cows.get(i - 1).get(2) == 1){
                    int time = (cows.get(i).get(1) - cows.get(i).get(1)) / 2;
                    if (time < minTime){
                        time = minTime;
                        cowNumChanges.add(i - 1);
                        cowNumChanges.add(i);
                        isCollision = true;
                    }
                }
            }
            if (cows.get(cows.size() - 1).get(2) == 1){
                int time = barn2 - cows.get(cows.size() - 1).get(1);
                if (time < minTime){
                    time = minTime;
                    cowNumChanges.add(cows.size() - 1);
                    isCollision = false;
                }
            }
            for (int i = 0; i < numCows; i++){
                cows.get(i).set(1, cows.get(i).get(1) + cows.get(i).get(2) * minTime);
                if (isCollision){
                    cows.get(cowNumChanges.get(cowNumChanges.size() - 2)).set(2, -1);
                    cows.get(cowNumChanges.get(cowNumChanges.size() - 1)).set(2, 1);
                    totalCollisions++;
                } else {
                    barnWeight += cows.get(cowNumChanges.get(cowNumChanges.size() - 1)).get(0);
                    cows.remove(cows.get(cowNumChanges.get(cowNumChanges.size() - 1)));
                }
            }
            
            
            /*
            for (int i = 0; i < numCows; i++){
                cows.get(i).set(1, cows.get(i).get(1) + cows.get(i).get(2));
                // System.out.println("Cow " + i + " Position: " + cows.get(i).get(1));
            }
            int prevCowPos = cows.get(0).get(1);
            if (prevCowPos == 0 || prevCowPos == barn2){
                barnWeight += cows.get(0).get(0);
                cows.remove(0);
                numCows--;
            }
            for (int i = 1; i < numCows; i++){
                int thisCowPos = cows.get(i).get(1);
                if (thisCowPos == prevCowPos){
                    cows.get(i - 1).set(2, -1);
                    cows.get(i).set(2, 1);
                    totalCollisions++;
                    // System.out.println("Collision");
                } else if (thisCowPos == 0 || thisCowPos == barn2){
                    barnWeight += cows.get(i).get(0);
                    // System.out.println("Weight Added: " + cows.get(i).get(0));
                    cows.remove(i);
                    numCows--;
                } else {
                    prevCowPos = cows.get(i).get(1);
                }
            }
            // time += 0.5;
            // System.out.println("Time: " + time);
            */
        }
        output.println(totalCollisions);
        output.close();
        System.exit(0);
    }
}