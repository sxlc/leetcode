import java.util.Arrays;

public class Lc00547FriendCirclesOn3 {
    public static void main(String[] args) {
        int[][] M = new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int[][] M = new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 1, 1}};
        System.out.println(findCircleNum(M));
    }
  
    public static int findCircleNum(int[][] M) {
        int[] parents = new int[M.length];
        Arrays.fill(parents, -1);
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M.length; j++) {
                if (M[i][j] == 1 && i != j) {
                    union(parents, i, j);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < parents.length; i++) {
            if (parents[i] == -1) {
                count++;
            }
        }
        return count;
        
    }
    
    private static int find(int parents[], int i) {
        if (parents[i] == -1) {
            return i;
        }
        return find(parents, parents[i]);
    }
    
    private static void union(int parents[], int x, int y) {
        int xparent = find(parents, x);
        int yparent = find(parents, y);
        if (xparent != yparent) {
            parents[xparent] = yparent;
        }
    }
}
