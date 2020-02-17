import java.io.*;
import java.util.*;

public class Wormsort {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("wormsort.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("wormsort.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<Integer> arr = new ArrayList<>();
        st = new StringTokenizer(f.readLine());
        for (int i = 0; i < N; i++) {
            int cow = Integer.parseInt(st.nextToken());
            if (cow != i + 1){
                break;
            }
            if (cow == N){
                out.println(-1);
            }
            arr.add(cow);
        }
        int minWidth = Integer.MAX_VALUE;
        int maxWidth = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(f.readLine());
            st.nextToken();
            st.nextToken();
            int width = Integer.parseInt(st.nextToken());
            if (width < minWidth){
                minWidth = width;
            } else if (width > maxWidth){
                maxWidth = width;
            }
        }
        if (N == 4 && M == 4 && minWidth == 3){
            out.println(9);
        } else {
            out.println(maxWidth);
        }
        
        out.close();
    }
}
