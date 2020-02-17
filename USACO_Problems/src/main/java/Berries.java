import java.io.*;
import java.util.*;

public class Berries {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("berries.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("berries.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        ArrayList<Integer> arr = new ArrayList<>();
        st = new StringTokenizer(f.readLine());
        for (int i = 0; i < N; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }
        /*
        arr.add(3);
        arr.add(6);
        arr.add(8);
        arr.add(4);
        arr.add(2);
        int N = 5;
        int K = 4;
         */
        Collections.sort(arr, Collections.reverseOrder());
        int maxBasket = 0;
        int maxBerries = 0;
        for (int i = 1; i <= Math.min(N, K); i++) {
            int subsetSum = 0;
            for (int j = 0; j < i; j++) {
                subsetSum += arr.get(j);
            }
            for (int j = subsetSum / K; j >= 1; j--) {  // Changed from >= to >
                int jFullBaskets = 0;
                ArrayList<Integer> baskets = new ArrayList<>();
                for (int k = 0; k < i; k++) {
                    int kTreeBaskets = arr.get(k) / j;
                    jFullBaskets += kTreeBaskets;
                    for (int l = 0; l < kTreeBaskets; l++) {
                        int basketBerries = arr.get(k) / kTreeBaskets;
                        if (arr.get(k) % kTreeBaskets > l){
                            basketBerries++;
                        }
                        baskets.add(basketBerries);
                    }
                }
                // System.out.println("i: " + i + " j: " + j);
                // System.out.println(baskets);
                // System.out.println();
                if (jFullBaskets >= K) {
                    if (baskets.size() < K){
                        continue;
                    }
                    Collections.sort(baskets);
                    int berryTotal = 0;
                    for (int k = 0; k < K / 2; k++) {
                        berryTotal += baskets.get((baskets.size() - K) + k);
                    }
                    if (berryTotal > maxBerries){
                        maxBerries = berryTotal;
                    }
                    // maxBasket = j;  // Fix this line?
                    break;
                }
            }
        }
        // out.println("TESTING");
        out.println(maxBerries);

        out.close();
    }
}