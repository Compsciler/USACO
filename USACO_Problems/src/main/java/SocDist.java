import java.io.*;
import java.util.*;

public class SocDist {
    public static int N;
    public static ArrayList<ArrayList<Long>> grass;
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("socdist.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("socdist.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        grass = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(f.readLine());
            ArrayList<Long> sublist = new ArrayList<>();
            sublist.add(Long.parseLong(st.nextToken()));
            sublist.add(Long.parseLong(st.nextToken()));
            grass.add(sublist);
        }
        /*
        ArrayList<Long> sublist1 = new ArrayList<>();
        ArrayList<Long> sublist2 = new ArrayList<>();
        ArrayList<Long> sublist3 = new ArrayList<>();
        sublist1.add(4L);
        sublist1.add(7L);
        grass.add(sublist1);
        sublist2.add(9L);
        sublist2.add(9L);
        grass.add(sublist2);
        sublist3.add(0L);
        sublist3.add(2L);
        grass.add(sublist3);
        */
        
        Comparator<ArrayList<Long>> sortByStart = new Comparator<ArrayList<Long>>(){
                
            @Override
            public int compare(ArrayList<Long> interval1, ArrayList<Long> interval2){
                return interval1.get(0).compareTo(interval2.get(0));
            }
        };
        Collections.sort(grass, sortByStart);
        // printGrass();
        long maxDPossible = 1000000000000000000L;
        // out.println(binarySearch(2, maxDPossible, 1));
        out.println(seqSearch());
        out.close();
    }
    public static int exponentialSearch(int arr[], int n, int x){ 
        if (arr[0] == x) 
            return 0; 
        int i = 1; 
        while (i < n && arr[i] <= x){
            i = i*2;
        }
        return Arrays.binarySearch(arr, i/2, Math.min(i, n), x); 
    }
    public static long binarySearch(long l, long r, long largestD){ 
        if (r >= l) { 
            long mid = l + (r - l) / 2;
            if (isValid(mid)){
                return binarySearch(mid + 1, r, mid);
            }
            return binarySearch(l, mid - 1, largestD);
        }
        return largestD; 
    }
    public static long seqSearch(){
        long D = 1;
        while (true){
            if (!isValid(D)){
                return D - 1;
            }
            D++;
        }
    }
    public static boolean isValid(long D){
        /*
        if (D <= 100){
            System.out.print(D + ": ");
        }
        */
        long previousCow = grass.get(0).get(0);
        int currentInterval = 0;
        for (int i = 1; i < N; i++) {
            long currentCow = previousCow + D;
            if (currentCow > grass.get(currentInterval).get(1)){
                currentInterval++;
                try {
                    while (currentCow > grass.get(currentInterval).get(0)){
                        currentInterval++;
                    }
                } catch (IndexOutOfBoundsException e){
                    /*
                    if (D <= 100){
                        System.out.println(false);
                    }
                    */
                    return false;
                }
                currentCow = grass.get(currentInterval).get(0);
            }
            previousCow = currentCow;
        }
        /*
        if (D <= 100){
            System.out.println(true);
        }
        */
        return true;
    }
    public static void printGrass(){
        for (ArrayList arr: grass){
            System.out.println(arr.get(0) + " " + arr.get(1));
        }
    }
}
