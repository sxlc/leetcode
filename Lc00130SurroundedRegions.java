import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Lc00130SurroundedRegions {
    public static void main(String[] args) {
        char[][] board = new char[][]{
          {'X', 'X', 'X', 'X'},
          {'X', 'O', 'O', 'X'},
          {'X', 'X', 'O', 'X'},
          {'X', 'O', 'X', 'X'}};
        solve(board);
        for (char[] row : board) {
            for (char item : row) {
                System.out.println(item);
            }
        }
    }
  
    public static void solve(char[][] board) {
        int rowLen = board.length;
        if (rowLen <= 0) {
            return;
        }
        int colLen = board[0].length;
        if (colLen <= 0) {
            return;
        }
        
        int[][] visited = new int[rowLen][colLen];
        Queue<Node> queue = new LinkedList<>();
        
        for (int row = 0; row < rowLen; row++) {
            if (board[row][0] == 'O') {
                queue.offer(new Node(row, 0));
            }
            if (board[row][colLen - 1] == 'O') {
                queue.offer(new Node(row, colLen - 1));
            }
        }
        for (int col = 0; col < colLen; col++) {
            if (board[0][col] == 'O') {
                queue.offer(new Node(0, col));
            }
            if (board[rowLen - 1][col] == 'O') {
                queue.offer(new Node(rowLen - 1, col));
            }
        }
        while (!queue.isEmpty()) {
            Node top = queue.poll();
            if (visited[top.row][top.col] == 1) {
                continue;
            }
            
            visited[top.row][top.col] = 1;
            if (top.row + 1 < rowLen && board[top.row + 1][top.col] == 'O' && visited[top.row + 1][top.col] == 0) {
                queue.offer(new Node(top.row + 1, top.col + 1));
            }
            if (top.row - 1 >= 0 && board[top.row - 1][top.col] == 'O' && visited[top.row - 1][top.col + 1] == 0) {
                queue.offer(new Node(top.row - 1, top.col));
            }
            if (top.col + 1 < colLen && board[top.row][top.col + 1] == 'O' && visited[top.row][top.col + 1] == 0) {
                queue.offer(new Node(top.row, top.col + 1));
            }
            if (top.col - 1 >= 0 && board[top.row][top.col - 1] == 'O' && visited[top.row][top.col - 1] == 0) {
                queue.offer(new Node(top.row, top.col - 1));
            }
        }
        for (int row = 0; row < rowLen; row++) {
            for (int col = 0; col < colLen; col++) {
                if (board[row][col] == 'O' && visited[row][col] == 0) {
                    board[row][col] = 'X';
                }
            }
        }
    }

    static class Node{
        int row;
        int col;
        Node(int x, int y){
            row = x;
            col = y;
        }
    }
}
