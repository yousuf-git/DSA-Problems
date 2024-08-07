package DSA_Problems.arrays;

public class Max_Sub_Array {
    public static void main(String[] args) {
        int[] array = { 1, 2, 3, 4, 9, -1 };
        System.out.println("Max Sub Array Sum: " + maxSubArraySum(array));
    }

    public static int maxSubArraySum(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        
        // O(n^3)
        // for (int i = 0; i < nums.length; i++) {
        //     int start = i;
        //     for (int j = i; j < nums.length; j++) {
        //         int end = j;
        //         int sum = 0;
        //         for (int k = start; k <= end; k++) {
        //             sum += nums[k];
        //         }
        //         max = Math.max(max, sum);
        //     }
        // }
        // return max;
        
        // Kadan's Algorithm - O(n)
        
        int sum = nums[0], currSum = 0;
        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i]; // updated current sum -> sum till now
            sum = Math.max(sum, currSum); // update the max sum that is to return
            currSum = currSum < 0 ? 0 : currSum; // reset current sum if it is going negative
        }
        return sum;

        // Prefix Sum Approach - O(n^2)

        // int[] prefixSum = new int[nums.length];

        // prefixSum[0] = nums[0];
        // // O(n)
        // for (int i = 1; i < nums.length; i++) {
        //     prefixSum[i] = prefixSum[i-1] + nums[i];
        // }

        // for (int i = 0; i < nums.length; i++) {
        //     int start = i;
        //     for (int j = i; j < nums.length; j++) {
        //         int end = j, sum = 0;
        //         if (start - 1 == -1) {
        //             sum = prefixSum[end];
        //         } else {
        //             sum = prefixSum[end] - prefixSum[start-1];
        //         }
        //         max = Math.max(sum, max);
        //     }
        // }
        // return max;
    }
}
