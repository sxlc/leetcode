public class Lc00064MinimumPathSumDynamicProgrammingWithoutExtraSpaceOmn {

    public static void main(String[] args) {
      int[][] grid = {
              {1, 3, 4, 8},
              {3, 2, 2, 4},
              {5, 7, 1, 9},
              {2, 3, 2, 3},
          };
      int minPathSum = minPathSum(grid);
      System.out.println(minPathSum);
    }
    
    /*
     * grid[i][j] = grid[i][j] + min(grid[i][j + 1], grid[i + 1][j])
     */
    public static int minPathSum(int[][] grid) {
        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid[i].length - 1; j >= 0; j--) {
                if (i == grid.length - 1 && j < grid[i].length - 1) {
                    // Bottom border.
                    grid[i][j] = grid[i][j] + grid[i][j + 1];
                } else if (i < grid.length - 1 && j == grid[i].length - 1) {
                    // Right border.
                    grid[i][j] = grid[i][j] + grid[i + 1][j];
                } else if (i < grid.length - 1 && j < grid[i].length - 1) {
                    grid[i][j] = grid[i][j] + Math.min(grid[i][j + 1], grid[i + 1][j]);
                }
            }
        }
        return grid[0][0];
    }
}
