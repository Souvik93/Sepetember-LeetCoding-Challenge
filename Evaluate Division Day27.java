/*
You are given equations in the format A / B = k, where A and B are variables represented as strings, and k is a real number (floating-point number). Given some queries, return the answers. If the answer does not exist, return -1.0.

The input is always valid. You may assume that evaluating the queries will result in no division by zero and there is no contradiction.

 

Example 1:

Input: equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]
Explanation: 
Given: a / b = 2.0, b / c = 3.0
queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
return: [6.0, 0.5, -1.0, 1.0, -1.0 ]
Example 2:

Input: equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
Output: [3.75000,0.40000,5.00000,0.20000]
Example 3:

Input: equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],["a","c"],["x","y"]]
Output: [0.50000,2.00000,-1.00000,-1.00000]
 

Constraints:

1 <= equations.length <= 20
equations[i].length == 2
1 <= equations[i][0], equations[i][1] <= 5
values.length == equations.length
0.0 < values[i] <= 20.0
1 <= queries.length <= 20
queries[i].length == 2
1 <= queries[i][0], queries[i][1] <= 5
equations[i][0], equations[i][1], queries[i][0], queries[i][1] consist of lower case English letters and digits.
   Hide Hint #1  
Do you recognize this as a graph problem?
*/

/*
 1. Build Graph.
 2. Traverse The Created Using DFS.
 Explanation : - https://youtu.be/yhEUwt6bdyY
*/

class Solution {
    
    
    Map<String, Map<String,Double>> map =  new HashMap<>();
    
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        
        double[] results = new double[queries.size()];
        
        for(int i=0;i<equations.size();i++) {
            buildGraph(equations.get(i),values[i]);
        }
        
        for(int i=0;i<queries.size();i++) {
            
            results[i] = calculateQueryResult(queries.get(i).get(0),queries.get(i).get(1),new HashSet<>());
            
        }
        
        return results;
        
    }
    
    private void buildGraph(List<String> equation, double result) {
        
        String start = equation.get(0);
        String end = equation.get(1);
        
        map.putIfAbsent(start, new HashMap<>());
        
        map.get(start).put(end,result);
        
        map.putIfAbsent(end, new HashMap<>());
        
        map.get(end).put(start,1/result);
    }
    
    private double calculateQueryResult(String start, String end , Set<String> visited) {
        
        if(!map.containsKey(start) || !map.containsKey(end)) {
            return -1.0;
        }
        
        if(start.equals(end)) {
            return 1.0;
        }
        // Accepted
        if(map.get(start).containsKey(end)) {
            return map.get(start).get(end);
        }
        
        visited.add(start);
        
        for(Map.Entry<String,Double> entry : map.get(start).entrySet()) {
            if(!visited.contains(entry.getKey())) {
                double d = calculateQueryResult(entry.getKey(),end,visited);
                if( d!=-1.0) {
                    d = d* entry.getValue();
                    return d;
                }
            }
        }
               
    return -1.0;
            
    }
}                                                                   
