/*
Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

Note:

All numbers will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: k = 3, n = 7
Output: [[1,2,4]]
Example 2:

Input: k = 3, n = 9
Output: [[1,2,6], [1,3,5], [2,3,4]]
*/
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        List<Integer> cu = new ArrayList<>();
        
        helperMethod(result,cu,k,n,1);
        
        return result;
        
    }
    
    private void helperMethod(List<List<Integer>> result,List<Integer> cu,int k, int n,int startValue) {
        
        if(n<0) {
            return;
        }
        
        if(n==0 && k==cu.size()) {
            result.add(new ArrayList<Integer>(cu));
            return;
        }
        
        for(int i=startValue;i<10;i++) {
            cu.add(i);
            helperMethod(result,cu,k,n-i,i+1);
            cu.remove(cu.size()-1);
        }
        
        
    }
}
