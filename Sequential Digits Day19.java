/*
An integer has sequential digits if and only if each digit in the number is one more than the previous digit.

Return a sorted list of all the integers in the range [low, high] inclusive that have sequential digits.

 

Example 1:

Input: low = 100, high = 300
Output: [123,234]
Example 2:

Input: low = 1000, high = 13000
Output: [1234,2345,3456,4567,5678,6789,12345]
 

Constraints:

10 <= low <= high <= 10^9
   Hide Hint #1  
Generate all numbers with sequential digits and check if they are in the given range.
   Hide Hint #2  
Fix the starting digit then do a recursion that tries to append all valid digits.

*/

// Explanation :- https://youtu.be/aEu6EY5anS4

class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        
        List<Integer> list = new ArrayList<>();
        
        for(int i=1;i<9;i++) {
            
            int next = 0;
            
            for(int j=i;j<10;j++) {
                next = next*10+j;
                if(next>=low && next<=high) {
                    list.add(next);
                } else if(next>high) {
                    break;
                }
            }
            
        }
        
        Collections.sort(list);
        
        return list;
        
    }
}                                                                                                                                                                                                                         
