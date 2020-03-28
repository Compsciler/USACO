import java.io.*;
import java.util.*;

public class Swap {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("swap.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("swap.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        List<Integer> arr = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            arr.add(i);
        }
        // System.out.println(arr);
        // ArrayList<ArrayList<Integer>> swaps = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(f.readLine());
            // ArrayList<Integer> sublist = new ArrayList<>();
            // sublist.add(Integer.parseInt(st.nextToken()));
            // sublist.add(Integer.parseInt(st.nextToken()));
            // swaps.add(sublist);
            // System.out.println(swaps.get(i).get(0) + " " + swaps.get(i).get(1));
            reverse(arr, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        int[] swapIterArr = new int[N];
        System.out.println(swapIterArr);
        for (int i = 0; i < N; i++) {
            swapIterArr[arr.get(i) - 1] = i - arr.get(i) + 1;
        }
        // System.out.println(arr);
        for (int i = 0; i < K - 1; i++) {
            arr = swapIter(arr, swapIterArr);
            // System.out.println(arr);
        }
        for (int i = 0; i < N; i++) {
            out.println(arr.get(i));
        }
        out.close();
    }
    public static boolean isSorted(ArrayList<Integer> arr){
        for (int i = 1; i < arr.size(); i++){
            if (arr.get(i) < arr.get(i - 1)){
                return false;
            }
        }
        return true;
    }
    public static void reverse(List<Integer> arr, int a, int b){
        for (int i = 0; i < (b - a + 1) / 2; i++) 
        { 
            int temp = arr.get(a + i - 1);  
            arr.set(a + i - 1, arr.get(b - i - 1));  
            arr.set(b - i - 1, temp);
            // System.out.println("REVERSING: " + arr);
        }
        // System.out.println("========");
    }
    public static List<Integer> swapIter(List<Integer> arr, int[] swapIterArr){
        Integer[] newArr = new Integer[arr.size()];
        for (int i = 0; i < swapIterArr.length; i++) {
            newArr[swapIterArr[i] + i] = arr.get(i);
        }
        return (List<Integer>)Arrays.asList(newArr);
    }
}
/*
public class Swap {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("swap.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("swap.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        List<Integer> arr = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            arr.add(i);
        }
        // System.out.println(arr);
        // ArrayList<ArrayList<Integer>> swaps = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(f.readLine());
            // ArrayList<Integer> sublist = new ArrayList<>();
            // sublist.add(Integer.parseInt(st.nextToken()));
            // sublist.add(Integer.parseInt(st.nextToken()));
            // swaps.add(sublist);
            // System.out.println(swaps.get(i).get(0) + " " + swaps.get(i).get(1));
            reverse(arr, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        List<Integer> arrClone = clone(arr);
        ArrayList<int[]> pow2Arrs = new ArrayList<>();
        int count = K - 1;
        while (count > 0){
            int[] swapIterArr = new int[N];
            for (int i = 0; i < N; i++) {
                swapIterArr[arrClone.get(i) - 1] = i - arrClone.get(i) + 1;
            }
            pow2Arrs.add(swapIterArr);
            count /= 2;
        }
        int index = 0;
        count = K - 1;
        while (count > 0){
            if (count % 2 == 1){
                arr = swapIter(arr, pow2Arrs.get(index));
            }
            index++;
            count /= 2;
        }
//        for (int i = 0; i < K - 1; i++) {
//            arr = swapIter(arr, swapIterArr);
//            System.out.println(arr);
//        }
        for (int i = 0; i < N; i++) {
            out.println(arr.get(i));
        }
        out.close();
    }
    public static boolean isSorted(ArrayList<Integer> arr){
        for (int i = 1; i < arr.size(); i++){
            if (arr.get(i) < arr.get(i - 1)){
                return false;
            }
        }
        return true;
    }
    public static void reverse(List<Integer> arr, int a, int b){
        for (int i = 0; i < (b - a + 1) / 2; i++) 
        { 
            int temp = arr.get(a + i - 1);  
            arr.set(a + i - 1, arr.get(b - i - 1));  
            arr.set(b - i - 1, temp);
            // System.out.println("REVERSING: " + arr);
        }
        // System.out.println("========");
    }
    public static List<Integer> swapIter(List<Integer> arr, int[] swapIterArr){
        Integer[] newArr = new Integer[arr.size()];
        for (int i = 0; i < swapIterArr.length; i++) {
            newArr[swapIterArr[i] + i] = arr.get(i);
        }
        return (List<Integer>)Arrays.asList(newArr);
    }
    public static List<Integer> clone(List<Integer> arr){
        List<Integer> newArr = new ArrayList<>();
        for (int i: arr){
            newArr.add(i);
        }
        return newArr;
    }
}
*/