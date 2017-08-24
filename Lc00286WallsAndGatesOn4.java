import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Lc00286WallsAndGatesOn4 {

    public static void main(String[] args) {
        int[][] grid = new int[][] {
                {Integer.MAX_VALUE, -1, 0, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, -1},
                {Integer.MAX_VALUE, -1, Integer.MAX_VALUE, -1},
                {0, -1, Integer.MAX_VALUE, Integer.MAX_VALUE},
        };
        wallsAndGates(grid);
        for (int[] row : grid) {
            for (int position : row) {
                System.out.print(String.format("%d ", position));
            }
            System.out.println();
        }
    }

    public static void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0) {
            return;
        }
        
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] gate = queue.poll();
            int row = gate[0];
            int column = gate[1];
            if (row > 0 && rooms[row - 1][column] == Integer.MAX_VALUE) {
                rooms[row - 1][column] = rooms[row][column] + 1;
                queue.add(new int[]{row - 1, column});
            }
            if (row < rooms.length - 1 && rooms[row + 1][column] == Integer.MAX_VALUE) {
                rooms[row + 1][column] = rooms[row][column] + 1;
                queue.add(new int[]{row + 1, column});
            }
            if (column > 0 && rooms[row][column - 1] == Integer.MAX_VALUE) {
                rooms[row][column - 1] = rooms[row][column] + 1;
                queue.add(new int[]{row, column - 1});
            }
            if (column < rooms[0].length - 1 && rooms[row][column + 1] == Integer.MAX_VALUE) {
                rooms[row][column + 1] = rooms[row][column] + 1;
                queue.add(new int[]{row, column + 1});
            }
        }
    }
}
