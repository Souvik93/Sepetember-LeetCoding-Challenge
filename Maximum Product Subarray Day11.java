/*
Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.

Example 1:

Input: [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
*/
class Solution {
    public int maxProduct(int[] nums) {
        
        
        int product = 1;
        int max = Integer.MIN_VALUE;
        
        for(int i=0;i<nums.length;i++) {
            product = product*nums[i];
            
            max= Math.max(max,product);
            
            if(product==0) {
                product=1;
            }
        }
        
        product = 1;
        
        for(int i=nums.length-1;i>=0;i--) {
            product = product*nums[i];
            
            max= Math.max(max,product);
            
            if(product==0) {
                product=1;
            }
        }
        
        return max;
        
    }
}
