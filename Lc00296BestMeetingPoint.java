import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lc00296BestMeetingPoint {
    private static int dx[] = {0, 0, -1, 1};
    private static int dy[] = {1, -1, 0, 0};
  
    public static void main(String[] args) {
        int[][] grid = new int[][] {
                {1, 0, 0, 0, 1},
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0},
        };
        System.out.println(minTotalDistance(grid));
    }

    public static int minTotalDistance(int[][] grid) {
        List<Integer> xs = new ArrayList<>();
        List<Integer> ys = new ArrayList<>();
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    xs.add(i);
                    ys.add(j);
                }
            }
        }
        return getMeetingPoint(xs) + getMeetingPoint(ys);
    }
    
    private static int getMeetingPoint(List<Integer> positions) {
        Collections.sort(positions);
        int i = 0;
        int j = positions.size() - 1;
        int meetingPoint = 0;
        while (i < j) {
            meetingPoint += positions.get(j--) - positions.get(i++);
        }
        return meetingPoint;
    }
}
