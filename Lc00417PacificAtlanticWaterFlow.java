import java.util.ArrayList;
import java.util.List;

public class Lc00417PacificAtlanticWaterFlow {
    private static int dx[] = {0, 0, -1, 1};
    private static int dy[] = {1, -1, 0, 0};
  
    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4},
        };
        List<int[]> results = pacificAtlantic(matrix);
        for (int[] result : results) {
            System.out.println(String.format("[%d, %d]", result[0], result[1]));
        }
    }

    public static List<int[]> pacificAtlantic(int[][] matrix) {
        int dx[] = {0, 0, -1, 1};
        int dy[] = {1, -1, 0, 0};
        List<int[]> results = new ArrayList<>();
        int verticalLength = matrix.length;
        if (verticalLength == 0) {
            return new ArrayList<int[]>();
        }
        int horizontalLength = matrix[0].length;
        boolean pacificFlow[][] = new boolean[verticalLength][horizontalLength];
        boolean atlanticFlow[][] = new boolean[verticalLength][horizontalLength];
        for (int i = 0; i < verticalLength; i++) {
            flow(pacificFlow, matrix, i, 0, verticalLength, horizontalLength);
            flow(atlanticFlow, matrix, i, horizontalLength - 1, verticalLength, horizontalLength);
        }
        for (int i = 0; i < horizontalLength; i++) {
            flow(pacificFlow, matrix, 0, i, verticalLength, horizontalLength);
            flow(atlanticFlow, matrix, verticalLength - 1, i, verticalLength, horizontalLength);
        }
        for (int i = 0; i < verticalLength; i++) {
            for (int j = 0; j < horizontalLength; j++) {
                if (pacificFlow[i][j] && atlanticFlow[i][j]) {
                    results.add(new int[]{i, j});
                }
            }
        }
        return results;
    }
    
    private static void flow(
            boolean visited[][],
            int matrix[][],
            int x,
            int y,
            int horizontalLength,
            int verticalLength) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < horizontalLength && ny >= 0 && ny < verticalLength) {
                if (visited[nx][ny] == false && matrix[nx][ny] >= matrix[x][y]) {
                    flow(visited, matrix, nx, ny, horizontalLength, verticalLength);
                }
            }
        }
    }
}
