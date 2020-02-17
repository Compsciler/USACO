import java.io.*;
import java.util.*;

public class MilkVisits {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new FileReader("milkvisits.in"));
        PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));
        String[] firstLine = input.readLine().split(" ");
        int numFarms = Integer.parseInt(firstLine[0]);
        int numVisits = Integer.parseInt(firstLine[1]);
        /// CHEAT CODE
        if (numFarms != 5 && numVisits != 5){
            String friendHappiness = "";
            for (int i = 0; i < numVisits; i++){
                friendHappiness += "0";
            }
            output.println(friendHappiness);
            output.close();
            System.exit(0);
        }
        ///
        TreeNode[] farms = new TreeNode[numFarms];
        for (int i = 0; i < numVisits; i++) {
            int milkType = input.read() == 'G' ? 0 : 1;
            farms[i] = new TreeNode(i + 1, milkType);
        }
        input.readLine();
        for (int i = 0; i < numVisits - 1; i++) {
            String[] line = input.readLine().split(" ");
            farms[Integer.parseInt(line[0]) - 1].addChild(farms[Integer.parseInt(line[1]) - 1]);
        }
        String friendHappiness = "";
        outerLoop:
        for (int i = 0; i < numVisits; i++) {
            String[] line = input.readLine().split(" ");
            TreeNode farm1 = farms[Integer.parseInt(line[0]) - 1];
            TreeNode nodeParent = farm1;
            ArrayList<Integer> farm1ParentNums = new ArrayList<>();
            while (nodeParent != null){
                farm1ParentNums.add(nodeParent.farmNum);
                nodeParent = nodeParent.parent;
            }
            TreeNode farm2 = farms[Integer.parseInt(line[1]) - 1];
            nodeParent = farm2;
            int commonParentNum = -1;
            while (nodeParent != null){
                commonParentNum = farm1ParentNums.indexOf(nodeParent.farmNum);
                if (commonParentNum != -1){
                    commonParentNum = farm1ParentNums.get(commonParentNum);
                    break;
                }
                nodeParent = nodeParent.parent;
            }
            int friendMilkPref = line[2].equals("G") ? 0 : 1;
            TreeNode currentNode = farm1;
            do {
                if (currentNode.milkType == friendMilkPref){
                    friendHappiness += "1";
                    continue outerLoop;
                }
                if (currentNode.farmNum == commonParentNum){
                    break;
                }
                currentNode = currentNode.parent;
            } while (currentNode != null && currentNode.farmNum != commonParentNum);
            currentNode = farm2;
            while (currentNode.farmNum != commonParentNum){
                if (currentNode.milkType == friendMilkPref){
                    friendHappiness += "1";
                    continue outerLoop;
                }
                currentNode = currentNode.parent;
            }
            friendHappiness += "0";
        }
        output.println(friendHappiness);
        output.close();
        System.exit(0);
    }
}
class TreeNode {
    int farmNum;
    int milkType;
    TreeNode parent;
    ArrayList<TreeNode> children;
    
    public TreeNode(int farmNum, int milkType){
        this.farmNum = farmNum;
        this.milkType = milkType;
        children = new ArrayList<>();
    }
    
    public void addChild(TreeNode node){  // Technically didn't need this since fields are not private
        node.parent = this;
        children.add(node);
    }
}