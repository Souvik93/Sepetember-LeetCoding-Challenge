/*
Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word (last word means the last appearing word if we loop from left to right) in the string.

If the last word does not exist, return 0.

Note: A word is defined as a maximal substring consisting of non-space characters only.

Example:

Input: "Hello World"
Output: 5
*/

class Solution {
    public int lengthOfLastWord(String s) {
        
    /*    String strs[] = s.split(" ");
        
        if(strs.length==0) {
            return 0;
        } else {
            return strs[strs.length-1].length();
        } */
        
    
        int i = s.length()-1;
        
        while(i>=0) {
            if(s.charAt(i)==' ') {
                i--;
            } else {
                break;
            }
        }
        
        int counter = 0 ;
        while(i>=0) {
            if(s.charAt(i)!=' ') {
                counter=counter+1;
                i--;
            } else {
                break;
            }
        }
        
        return counter;
    }   
}
