/*
Given a list of non negative integers, arrange them such that they form the largest number.

Example 1:

Input: [10,2]
Output: "210"
Example 2:

Input: [3,30,34,5,9]
Output: "9534330"
Note: The result may be very large, so you need to return a string instead of an integer.
*/

/*
Explanation :- https://youtu.be/LPFSAtEF24g
*/
class Solution {
    public String largestNumber(int[] nums) {
        
        String strs[] = new String[nums.length];
        
        for(int num=0; num<nums.length;num++) {
            strs[num] = String.valueOf(nums[num]);
        }
        
        Arrays.sort(strs,(str1,str2)->
            (str2+str1).compareTo(str1+str2));
        // );
        
        if(strs[0].charAt(0)=='0') {
            return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=0;i<strs.length;i++) {
            sb.append(strs[i]);
        }
        
        return sb.toString();
         
    }
}
