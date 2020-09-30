
/*
Given an unsorted integer array, find the smallest missing positive integer.

Example 1:

Input: [1,2,0]
Output: 3
Example 2:

Input: [3,4,-1,1]
Output: 2
Example 3:

Input: [7,8,9,11,12]
Output: 1
Follow up:

Your algorithm should run in O(n) time and uses constant extra space.

   Hide Hint #1  
Think about how you would solve the problem in non-constant space. Can you apply that logic to the existing space?
   Hide Hint #2  
We don't care about duplicates or non-positive integers
   Hide Hint #3  
Remember that O(2n) = O(n)
*/

// Explanation :- https://youtu.be/e3Q-BfptyT4

class Solution {
    public int firstMissingPositive(int[] nums) {
        
        int i = 0;
        
        int n = nums.length;
        
        while(i<n) {
            
            if((nums[i]>0 && nums[i]<=n) && nums[i] != nums[nums[i]-1]) {
                int a = i;
                int b = nums[i]-1;
                
                int temp = nums[a];
                nums[a] = nums[b];
                nums[b] = temp;
            } else {
                ++i;
            }
        }
        
        i = 0;
        
        while(i<n) {
            if(nums[i]!=i+1) {
                return i+1;
            }
            i++;
            
        }
        
        return n+1;
        
    }
}
