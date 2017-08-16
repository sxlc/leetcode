public class Lc00312BurstBalloonsDynamicPorgrammingO3 {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 1, 5, 8};
        System.out.println(maxCoins(nums));
    }
  
    public static int maxCoins(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int[][] dp = new int[n][n];
        for (int length = 0; length < n; length++) {
            for (int i = 0; i < n - length; i++) {
                int j = i + length;
                for (int k = i; k <= j; k++) {
                    int l = i > 0 ? nums[i - 1] : 1;
                    int r = j < n - 1 ? nums[j + 1] : 1;
                    int left = k - 1 >= i ? dp[i][k - 1] : 0;
                    int right = k + 1 <= j ? dp[k + 1][j] : 0;
                    dp[i][j] = Math.max(dp[i][j], l * nums[k] * r + left + right);
                }
            }
        }
        return dp[0][n - 1];
    }
}
