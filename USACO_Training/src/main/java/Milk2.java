/*
ID: rogerwa2
LANG: JAVA
TASK: milk2
*/
import java.io.*;
import java.util.*;

class milk2 {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("milk2.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk2.out")));
        int N = Integer.parseInt(f.readLine());
        ArrayList<ArrayList<Integer>> milkTimes = new ArrayList<>();
        Comparator<ArrayList<Integer>> sortByStart = new Comparator<ArrayList<Integer>>(){
                
            @Override
            public int compare(ArrayList<Integer> interval1, ArrayList<Integer> interval2){
                return interval1.get(0).compareTo(interval2.get(0));
            }
        };
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int newStart = start;
            int newEnd = end;
            int delStartIndex = 0;
            int delEndIndex = milkTimes.size() - 1;
            boolean isNewStartFound = false;
            boolean isNewEndFound = false;
            for (int j = 0; j < milkTimes.size(); j++) {
                if (!isNewStartFound && milkTimes.get(j).get(1) >= start){
                    if (milkTimes.get(j).get(0) < start){
                        newStart = milkTimes.get(j).get(0);
                    }
                    delStartIndex = j;
                    isNewStartFound = true;
                }
                if (milkTimes.get(j).get(0) <= end){
                    if (milkTimes.get(j).get(1) > end){
                        newEnd = milkTimes.get(j).get(1);
                    }
                    delEndIndex = j;
                    isNewEndFound = true;
                }
            }
            if (isNewStartFound && isNewEndFound){
                for (int j = delStartIndex; j <= delEndIndex; j++){
                    milkTimes.remove(delStartIndex);
                }
            }
            ArrayList<Integer> sublist = new ArrayList<>();
            sublist.add(newStart);
            sublist.add(newEnd);
            milkTimes.add(sublist);
            Collections.sort(milkTimes, sortByStart);
        }
        
        int output1 = 0;
        for (ArrayList<Integer> arr: milkTimes) {
            if (arr.get(1) - arr.get(0) > output1){
                output1 = arr.get(1) - arr.get(0);
            }
        }
        int output2 = 0;
        for (int i = 1; i < milkTimes.size(); i++) {
            if (milkTimes.get(i).get(0) - milkTimes.get(i - 1).get(1) > output2){
                output2 = milkTimes.get(i).get(0) - milkTimes.get(i - 1).get(1);
            }
        }
        out.println(output1 + " " + output2);
        out.close();
    }

}