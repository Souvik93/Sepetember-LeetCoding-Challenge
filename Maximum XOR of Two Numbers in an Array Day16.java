/*
Given a non-empty array of numbers, a0, a1, a2, … , an-1, where 0 ≤ ai < 231.

Find the maximum result of ai XOR aj, where 0 ≤ i, j < n.

Could you do this in O(n) runtime?

Example:

Input: [3, 10, 5, 25, 2, 8]

Output: 28

Explanation: The maximum result is 5 ^ 25 = 28.
*/
class Trie {
    Trie[] child;
    
    Trie() {
        child = new Trie[2];
    }
}

class Solution {
    
    Trie trie = new Trie();
    
    public int findMaximumXOR(int[] nums) {
        
        
        for(int num : nums) {
            insert(num);
        }
        
        
        int max = Integer.MIN_VALUE;
        
        for(int num : nums) {
            Trie curr = trie;
             int cnum = 0;
            
            
            for(int i=31;i>=0;i--) { 
            
               int bit = (num>>i) & 1;
                
                if(bit==1) {
                    if(curr.child[0] !=null) {
                        
                        cnum = cnum | (1<<i);
                        curr = curr.child[0];
                     
                    } else {
                        curr = curr.child[1];
                    }
                } else {
                    if(curr.child[1]!=null) {
                        cnum = cnum | (1<<i);
                        curr = curr.child[1];
                    } else {
                        curr = curr.child[0];
                    }
                }
                
                
                
            }
            
            max= Math.max(max,cnum);
            
            
            
        }
        
        return max;
        
        
        
        
        
    }
    
    private void insert(int num) {
        Trie curr = trie;
        
        for(int i=31;i>=0;i--) {
            int bit = (num>>i) & 1;
            if(curr.child[bit]==null) {
                curr.child[bit] = new Trie();
            }
            curr = curr.child[bit];
            
        }
        
    }
}
