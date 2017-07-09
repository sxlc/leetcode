public class Lc00259ThreeSumSmallerBruteForceOn3 {

    public static void main(String[] args) {
        int[] nums = {-2, 0, 1, 3};
        int target = 2;
        int times = threeSumSmaller(nums, target);
        System.out.println(times);
    }
    
    public static int threeSumSmaller(int[] nums, int target) {
        int times = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] < target) {
                        times = times + 1;
                    }
                }
            }
        }
        return times;
}
