import java.io.*;
import java.util.*;

public class MooP {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("moop.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("moop.out")));
        int N = Integer.parseInt(f.readLine());
        ArrayList<ArrayList<Integer>> particles = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            ArrayList<Integer> sublist = new ArrayList<>();
            sublist.add(Integer.parseInt(st.nextToken()));
            sublist.add(Integer.parseInt(st.nextToken()));
            particles.add(sublist);
        }
        /*
        ArrayList<Integer> sublist1 = new ArrayList<>();
        ArrayList<Integer> sublist2 = new ArrayList<>();
        ArrayList<Integer> sublist3 = new ArrayList<>();
        ArrayList<Integer> sublist4 = new ArrayList<>();
        sublist1.add(1);
        sublist1.add(0);
        particles.add(sublist1);
        sublist2.add(0);
        sublist2.add(1);
        particles.add(sublist2);
        sublist3.add(-1);
        sublist3.add(0);
        particles.add(sublist3);
        sublist4.add(0);
        sublist4.add(-1);
        particles.add(sublist4);
        */
        out.println(dfs(particles, particles.size()));
        out.close();
    }
    public static int dfs(final ArrayList<ArrayList<Integer>> particles, int min){
        ArrayList<ArrayList<Integer>> particlesClone = new ArrayList(particles);
        int min1 = min;
        int min2 = min;
        for (int i = 0; i < particles.size(); i++){
            for (int j = i + 1; j < particles.size(); j++) {
                int xDiff = particles.get(j).get(0) - particles.get(i).get(0);
                int yDiff = particles.get(j).get(1) - particles.get(i).get(1);
                if ((xDiff >= 0 && yDiff >= 0) || (xDiff <= 0 && yDiff <= 0)){
                    ArrayList<ArrayList<Integer>> particlesCloneR1 = (ArrayList<ArrayList<Integer>>) particlesClone.clone();  // R for Removed
                    ArrayList<ArrayList<Integer>> particlesCloneR2 = (ArrayList<ArrayList<Integer>>) particlesClone.clone();
                    particlesCloneR1.remove(i);
                    particlesCloneR2.remove(j);
                    min1 = dfs(particlesCloneR1, min - 1);
                    min2 = dfs(particlesCloneR2, min - 1);
                }
            }
        }
        if (min1 < min2){
            return min1;
        }
        return min2;
    }
}