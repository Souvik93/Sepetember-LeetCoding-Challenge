/*
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

Note:

The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.
Example 1:

Input: s = "leetcode", wordDict = ["leet", "code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:

Input: s = "applepenapple", wordDict = ["apple", "pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
             Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
Output: false
*/
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
     
        int flag[] = new int[s.length()+1];
        
        Arrays.fill(flag,-1);
        
        flag[0] = 0;
        
        
        for(int i=0;i<s.length();i++) {
            if(flag[i] != -1) {
                for(int j = i+1; j<=s.length();j++) {
                    if(wordDict.contains(s.substring(i,j))) {
                        flag[j] = i;
                    }
                }
            }
        }
        
        return flag[s.length()] !=-1; 
        
    }
}
