/*
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

 

Example 1:

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
             Total amount you can rob = 1 + 3 = 4.
Example 2:

Input: nums = [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
             Total amount you can rob = 2 + 9 + 1 = 12.
 

Constraints:

0 <= nums.length <= 100
0 <= nums[i] <= 400

*/
class Solution {
    public int rob(int[] nums) { 
        // 1st Approach Dyanmic Programming, Time Complexity :- O(n) , Space Complexity :- O(n)
        
       /* if(nums==null || nums.length==0) {
            return 0;
        }
        
        int sum[] = new int[nums.length];
        
        
        sum[0] = nums[0];
        if(nums.length>1) {
            sum[1] = Math.max(nums[0],nums[1]);    
        }
        
        
        for(int i=2;i<nums.length;i++) {
            sum[i] = Math.max(sum[i-1],sum[i-2]+nums[i]);
        }
        
        return sum[sum.length-1]; */
        
        // 2nd Approach Odd Even Index, Time Complexity :- O(n) , Space Complexity :- O(1)
        
        /* int oddSum=0;
        int evenSum =0;
        
        for(int i=0;i<nums.length;i++) {
            
            if(i%2==0) {
                evenSum += nums[i];
                
                evenSum = Math.max(evenSum,oddSum);
            } else {
                oddSum +=nums[i];
                
                oddSum = Math.max(oddSum,evenSum);
            }
            
            
            
        }

        return Math.max(oddSum,evenSum); */
        
        // 3rd Approach Dynamic Programming Without Extra Spaces , Time Complexity :- O(n) , Space Complexity :- O(1)
        if(nums==null || nums.length==0) {
            return 0;
        }
        
        
        if(nums.length>1) {
            nums[1] = Math.max(nums[0],nums[1]);    
        }
        
        
        for(int i=2;i<nums.length;i++) {
            nums[i] = Math.max(nums[i-1],nums[i-2]+nums[i]);
        }
        
        return nums[nums.length-1];
        
        
    }
}   
