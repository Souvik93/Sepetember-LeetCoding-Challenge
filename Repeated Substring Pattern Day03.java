/*

Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together. You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.

 

Example 1:

Input: "abab"
Output: True
Explanation: It's the substring "ab" twice.
Example 2:

Input: "aba"
Output: False
Example 3:

Input: "abcabcabcabc"
Output: True
Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)

*/
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        
        int length = s.length();
        for(int i=length/2;i>0;i--) {
            
            if(length%i==0  && s.charAt(i-1)==s.charAt(length-1)) {
                
                String str = s.substring(0,i);
                
                StringBuilder sb = new StringBuilder();
                
                int repeated = length/i;
                
                for(int h=0;h<repeated;h++) {
                    sb.append(str);
                }
                
                if(sb.toString().equals(s)) {
                    return true;
                }
                
            }
            
            
        }
        
        return false;
    }
}         
