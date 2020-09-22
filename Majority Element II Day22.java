/*
Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

Note: The algorithm should run in linear time and in O(1) space.

Example 1:

Input: [3,2,3]
Output: [3]
Example 2:

Input: [1,1,1,3,3,2,2,2]
Output: [1,2]
   Hide Hint #1  
How many majority elements could it possibly have?
Do you have a better hint? Suggest it!
*/
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        
        int num1 = 0;
        int num2 = 0;
        
        int c1 = 0;
        int c2 = 0;
        // [8,8,7,7,7]
        for(int num : nums) {
            if(num1==num) {
                c1++;
                continue;
            }
            if(num2==num) {
                c2++;
                continue;
            }
            if(c1==0) {
                num1 = num;
                c1++;
                continue;
            }
            if(c2==0) {
                num2 = num;
                c2++;
                continue;
            }
            
            
            c1--;
            c2--;
            
        }
        
        c1 = 0;
        c2 = 0;
        
        for(int num : nums) {
            if(num==num1) {
                c1++;
            } else if(num==num2) {
                c2++;
            }
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        
        if(c1>nums.length/3) {
            result.add(num1);
        }
        
        if(c2>nums.length/3) {
            result.add(num2);
        }
        
        return result;
    }
}
