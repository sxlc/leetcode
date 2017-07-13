import java.util.Arrays;

public class Lc00259ThreeSumSmallerTwoPointersOn2 {
    
    public static void main(String[] args) {
        int[] nums = {-2, 0, 1, 3};
        int target = 2;
        int times = threeSumSmaller(nums, target);
        System.out.println(times);
    }
    
    public static int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int times = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            times += twoSumSmaller(nums, i + 1, target - nums[i]);
        }
        return times;
    }
    
    private static int twoSumSmaller(int[] nums, int startIndex, int target) {
        int times = 0;
        int left = startIndex;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] < target) {
                times += right - left;
                left++;
            } else {
                right--;
            }
        }
        return times;
    }
}
