/*

Given an array of 4 digits, return the largest 24 hour time that can be made.

The smallest 24 hour time is 00:00, and the largest is 23:59.  Starting from 00:00, a time is larger if more time has elapsed since midnight.

Return the answer as a string of length 5.  If no valid time can be made, return an empty string.

 

Example 1:

Input: [1,2,3,4]
Output: "23:41"
Example 2:

Input: [5,5,5,5]
Output: ""
 

Note:

A.length == 4
0 <= A[i] <= 9



*/

LeetCode
Explore
Problems
Mock
Contest
Discuss
 Store 
 Premium
New Playground
8
Souvik93
  Back to Chapter
  Largest Time for Given Digits

Solution
Given an array of 4 digits, return the largest 24 hour time that can be made.

The smallest 24 hour time is 00:00, and the largest is 23:59.  Starting from 00:00, a time is larger if more time has elapsed since midnight.

Return the answer as a string of length 5.  If no valid time can be made, return an empty string.

 

Example 1:

Input: [1,2,3,4]
Output: "23:41"
Example 2:

Input: [5,5,5,5]
Output: ""
 

Note:

A.length == 4
0 <= A[i] <= 9
Java	
1
class Solution {
2
    int max = -1;
3
    public String largestTimeFromDigits(int[] A) {
4
        
5
        dfs(A,0);
6
        
7
        if(max==-1) {
8
            return "";
9
        } else {
10
            return String.format("%02d:%02d",max/60,max%60);
11
        }
12
        
13
    }
14
    
15
    private void dfs(int[] arr,int start) {
16
        
17
        if(start==arr.length) {
18
            buildTime(arr);
19
            return;
20
        }
21
        
22
        for(int i=start;i<arr.length;i++) {
23
            
24
            swap(arr,i,start);
25
            
26
            dfs(arr,start+1);
27
            
28
            swap(arr,i,start);
29
            
30
        }
31
        
32
    }
33
    
34
    private void buildTime(int[] arr) {
35
        int hour = arr[0]*10+arr[1]; //12
36
        int minute = arr[2]*10+arr[3];//34
37
        
38
        if(hour<24 && minute<60) {
39
            max = Math.max(max,hour*60+minute);
40
        }
41
        
42
    }
43
    
44
    private void swap(int[] arr, int i,int j) {
45
        if(i==j) {
46
            return;
47
        } else {
48
            int temp = arr[i];
49
            arr[i] = arr[j];
50
            arr[j] = temp;
51
        }
52
    }
53
}  

