/*
ID: rogerwa2
LANG: JAVA
TASK: gift1
*/
import java.io.*;
import java.util.*;

class gift1 {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("gift1.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));
        // StringTokenizer st = new StringTokenizer(f.readLine());
        int numPeople = Integer.parseInt(f.readLine());
        ArrayList<String> peopleArr = new ArrayList<>();
        HashMap<String, Integer> moneyTotals = new HashMap<>();
        for (int i = 0; i < numPeople; i++){
            String person = f.readLine();
            peopleArr.add(person);
            moneyTotals.put(person, 0);
        }
        for (int i = 0; i < numPeople; i++){
            String giver = f.readLine();
            StringTokenizer st = new StringTokenizer(f.readLine());
            int moneyGift = Integer.parseInt(st.nextToken());
            int receiverTotal = Integer.parseInt(st.nextToken());
            for (int j = 0; j < receiverTotal; j++){
                String receiver = f.readLine();
                moneyTotals.put(receiver, moneyTotals.get(receiver) + moneyGift / receiverTotal);
            }
            if (receiverTotal != 0){
                moneyTotals.put(giver, moneyTotals.get(giver) - moneyGift + moneyGift % receiverTotal);
            }
        }
        for (String s: peopleArr) {
            out.print(s + " ");
            out.println(moneyTotals.get(s));
        }
        
        out.close();
    }
}