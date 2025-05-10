public class Solution {
    public double findMaxAverage(int[] nums, int k) {
        // Step 1: Calculate the sum of the first 'k' elements
        double sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        // Initialize the maximum average as the average of the first window
        double maxAverage = sum / k;

        // Step 2: Use sliding window to find the max average
        for (int i = k; i < nums.length; i++) {
            // Slide the window: remove the leftmost element and add the new element
            sum += nums[i] - nums[i - k];

            // Calculate the new average and update the maximum average
            maxAverage = Math.max(maxAverage, sum / k);
        }

        return maxAverage;
    }
}