/*

A string S of lowercase English letters is given. We want to partition this string into as many parts as possible so that each letter appears in at most one part, and return a list of integers representing the size of these parts.

 

Example 1:

Input: S = "ababcbacadefegdehijhklij"
Output: [9,7,8]
Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
 

Note:

S will have length in range [1, 500].
S will consist of lowercase English letters ('a' to 'z') only.
 

   Hide Hint #1  
Try to greedily choose the smallest partition that includes the first letter. If you have something like "abaccbdeffed", then you might need to add b. You can use an map like "last['b'] = 5" to help you expand the width of your partition.


*/
/*
Explanations :- https://youtu.be/Mw7fKtGhrMs
*/
class Solution {
    public List<Integer> partitionLabels(String S) {
        
        List<Integer> result = new ArrayList<>();
        
        int[] idx = new int[26];
        
        
        for(int i= 0;i<S.length();i++) {
            idx[S.charAt(i)-'a'] = i;
        }
        
        int counter=0;
        
        while(counter<S.length()) {
            
            int end = idx[S.charAt(counter)-'a'];
            
            int j=counter;
            while(j<end) {
                
                end = Math.max(end,idx[S.charAt(j)-'a']);
                j++;
                
            }
            
            result.add(j-counter+1);
            counter=j+1;
            
            
        }
        
        return result;
        
    }
}
