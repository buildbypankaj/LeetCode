import java.util.*;

public class Solution {

    public List<Integer> findValidElements(int[] nums) {

        int n = nums.length;
        List<Integer> result = new ArrayList<>();

        if (n == 1) {
            result.add(nums[0]);
            return result;
        }

        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        // left max
        leftMax[0] = nums[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], nums[i]);
        }

        // right max
        rightMax[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], nums[i]);
        }

        for (int i = 0; i < n; i++) {

            if (i == 0 || i == n - 1) {
                result.add(nums[i]);
            } 
            else if (nums[i] > leftMax[i - 1] || nums[i] > rightMax[i + 1]) {
                result.add(nums[i]);
            }
        }

        return result;
    }
}