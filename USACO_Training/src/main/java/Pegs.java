import java.util.*;
import java.io.*;

public class Pegs {  // Question6
    public static void main(String[] args) throws FileNotFoundException {
        Scanner file = new Scanner(new File("C:\\Users\\Roger\\Documents\\NetBeansProjects\\USACO_Training\\src\\main\\java\\pegs.txt"));
        int t = file.nextInt();
        file.nextLine();

        for (int x = 0; x < t; x++) {
            int rows = file.nextInt();
            int cols = file.nextInt();
            file.nextLine();
            char[][] board = new char[rows][cols];
            for (int r = 0; r < rows; r++){
                String line = file.nextLine();
                for (int c = 0; c < cols; c++){
                    board[r][c] = line.charAt(c);
                }
            }
            dfs(board, rows, cols);
        }
    }
    /*
    public static boolean dfs(char[][] board, int rows, int cols){
        ArrayList<ArrayList<Integer>> pegs = new ArrayList<>();
        for (int r = 0; r < rows; r++){
            for (int c = 0; c < cols; c++){
                if (board[r][c] == '@'){
                    ArrayList<Integer> subList = new ArrayList<>();
                    subList.add(r);
                    subList.add(c);
                    pegs.add(subList);
                }
            }
        }
        if (pegs.size() <= 1){
            return true;
        }
        for (ArrayList<Integer> arr: pegs){
            int r = arr.get(0);
            int c = arr.get(1);
            ArrayList<Integer> moves = isValidMove(board, r, c);
            ArrayList<Boolean> dfsBools = new ArrayList<>();
            for (int move: moves){
                switch (move){
                    case 0:
                        board[r][c - 1] = ' ';
                        board[r][c - 2] = '@';
                        break;
                    case 1:
                        board[r][c + 1] = ' ';
                        board[r][c + 2] = '@';
                        break;
                    case 2:
                        board[r - 1][c] = ' ';
                        board[r - 2][c] = '@';
                        break;
                    case 3:
                        board[r + 1][c] = ' ';
                        board[r + 2][c] = '@';                    
                }
                for (char[] row: board){
                    System.out.println(Arrays.toString(row));
                }
                System.out.println("====");
                dfsBools.add(dfs(board, rows, cols));
                
                // if (dfs(board, rows, cols) == true){
                //     return true;
                // }
            }
            for (Boolean b: dfsBools){
                if (b == true){
                    return true;
                }
            }
        }
        return false;
    }
    */
    public static void dfs(char[][] board, int rows, int cols){
        ArrayList<ArrayList<Integer>> pegs = new ArrayList<>();
        for (int r = 0; r < rows; r++){
            for (int c = 0; c < cols; c++){
                if (board[r][c] == '@'){
                    ArrayList<Integer> subList = new ArrayList<>();
                    subList.add(r);
                    subList.add(c);
                    pegs.add(subList);
                }
            }
        }
        if (pegs.size() <= 1){
            System.out.println("Solvable!");
            return;
        }
        for (ArrayList<Integer> arr: pegs){
            int r = arr.get(0);
            int c = arr.get(1);
            ArrayList<Integer> moves = isValidMove(board, r, c);
            ArrayList<Boolean> dfsBools = new ArrayList<>();
            for (int move: moves){
                switch (move){
                    case 0:
                        board[r][c - 1] = ' ';
                        board[r][c - 2] = '@';
                        break;
                    case 1:
                        board[r][c + 1] = ' ';
                        board[r][c + 2] = '@';
                        break;
                    case 2:
                        board[r - 1][c] = ' ';
                        board[r - 2][c] = '@';
                        break;
                    case 3:
                        board[r + 1][c] = ' ';
                        board[r + 2][c] = '@';                    
                }
                for (char[] row: board){
                    System.out.println(Arrays.toString(row));
                }
                System.out.println("====");
                dfs(board, rows, cols);
            }
        }
        System.out.println("Impossible.");
    }
    public static ArrayList<Integer> isValidMove(char[][] board, int r, int c){
        ArrayList<Integer> moves = new ArrayList<>();
        if (c >= 2 && board[r][c - 1] == '@' && board[r][c - 2] == ' '){
            moves.add(0);
        }
        if (c < board.length - 2 && board[r][c + 1] == '@' && board[r][c + 2] == ' '){
            moves.add(1);
        }
        if (r >= 2 && board[r - 1][c] == '@' && board[r - 2][c] == ' '){
            moves.add(2);
        }
        if (r < board[0].length - 2 && board[r + 2][c] == '@' && board[r + 2][c] == ' '){
            moves.add(3);
        }
        return moves;
    }
}