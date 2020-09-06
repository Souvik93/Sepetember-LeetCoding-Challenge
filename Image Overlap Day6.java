/*

Two images A and B are given, represented as binary, square matrices of the same size.  (A binary matrix has only 0s and 1s as values.)

We translate one image however we choose (sliding it left, right, up, or down any number of units), and place it on top of the other image.  After, the overlap of this translation is the number of positions that have a 1 in both images.

(Note also that a translation does not include any kind of rotation.)

What is the largest possible overlap?

Example 1:

Input: A = [[1,1,0],
            [0,1,0],
            [0,1,0]]
       B = [[0,0,0],
            [0,1,1],
            [0,0,1]]
Output: 3
Explanation: We slide A to right by 1 unit and down by 1 unit.
Notes: 

1 <= A.length = A[0].length = B.length = B[0].length <= 30
0 <= A[i][j], B[i][j] <= 1

*/
class Solution {
    public int largestOverlap(int[][] A, int[][] B) {
        int length = A.length;
        
        int result = 0;
        
        for(int ro=-length;ro<length;ro++) {
            for(int co=-length;co<length;co++) {
                result = Math.max(result,count(A,B,ro,co));
            }
        }
        
        return result;
    }
    
    private int count(int[][] A, int[][] B, int ro, int co) {
        
        int counter = 0;
        
        for(int r=0;r<A.length;r++) {
            for(int c=0;c<A.length;c++) {
                
                if(r+ro<0 || r+ro>=A.length || c+co<0 || c+co>=B.length) {
                    continue;
                }
                
                if(A[r+ro][c+co]==1 && B[r][c]==1) {
                    counter++;
                }
                
                
            }
        }
        
        return counter;
        
    }
}
