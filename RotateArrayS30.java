// https://leetcode.com/problems/rotate-array/
/*
Example 1:

Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
Example 2:

Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation:
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]

NOTE - the first element comes to k position after rotating
 */
public class RotateArrayS30 {

    // using extra space
    // o(n) - TC
    // o(n) - SC
    public void rotate(int[] nums, int k) {
        int[] arr = nums.clone(); // clone the array
        int n = nums.length;
        k= k%n;

        for(int i = 0; i< nums.length; i++) {
            nums[(i+k) % n] = arr[i];
        }

    }

    // without using extra space
    // TC - O(n)
    // trick is that the min element reaches
    public void rotateOptimised(int[] nums, int k) {
        int n = nums.length;
        k= k%n; // because k might be very bigger number
        // Idea is to reverse the complete array
        // then reverse the parts of it
        // first reverse the k parts, then reverse the remaining parts
        reverse(nums, 0, n-1);
        reverse(nums, 0,k-1);
        reverse(nums, k, n-1);

    }

    private void reverse(int [] arr, int start, int end) {
        while(start <= end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }


}
