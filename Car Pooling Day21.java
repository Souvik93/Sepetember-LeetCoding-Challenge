/*
You are driving a vehicle that has capacity empty seats initially available for passengers.  The vehicle only drives east (ie. it cannot turn around and drive west.)

Given a list of trips, trip[i] = [num_passengers, start_location, end_location] contains information about the i-th trip: the number of passengers that must be picked up, and the locations to pick them up and drop them off.  The locations are given as the number of kilometers due east from your vehicle's initial location.

Return true if and only if it is possible to pick up and drop off all passengers for all the given trips. 

 

Example 1:

Input: trips = [[2,1,5],[3,3,7]], capacity = 4
Output: false
Example 2:

Input: trips = [[2,1,5],[3,3,7]], capacity = 5
Output: true
Example 3:

Input: trips = [[2,1,5],[3,5,7]], capacity = 3
Output: true
Example 4:

Input: trips = [[3,2,7],[3,7,9],[8,3,9]], capacity = 11
Output: true
 
 

Constraints:

trips.length <= 1000
trips[i].length == 3
1 <= trips[i][0] <= 100
0 <= trips[i][1] < trips[i][2] <= 1000
1 <= capacity <= 100000
   Hide Hint #1  
Sort the pickup and dropoff events by location, then process them in order.
*/

// First Approach

/*
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        
        Arrays.sort(trips,Comparator.comparingInt(a->a[1]));
        
        int index=0;
        
        int ccapacity = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((z,y)->z[2]-y[2]);
        
        int size = trips.length;
        
        while(index<size) {
            
            while(!pq.isEmpty() && pq.peek()[2]<=trips[index][1]) {
                ccapacity = ccapacity-pq.poll()[0];
            }
            
            if(ccapacity+trips[index][0]>capacity) {
                return false;
            }
            
            pq.add(trips[index]);
            
            ccapacity = trips[index][0] + ccapacity;
            index++;
            
        }
        
        return true;
        
    }
}
*/

// Second Approach

class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        
        int bucket[] = new int[1001];
        
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        
        for(int[] trip : trips) {
            
            bucket[trip[1]] += trip[0];
            
            bucket[trip[2]] -= trip[0];
            
            max = Math.max(max,trip[2]);
            
            min = Math.min(min,trip[1]);
            
            
            
            
        }
        
        int tempCapcity = 0;
        
        for(int i=min;i<=max;i++) {
                tempCapcity += bucket[i];
            
            if(tempCapcity>capacity) {
                return false;
            }
            }
        
        return true;
    }
}
