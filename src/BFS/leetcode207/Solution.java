package BFS.leetcode207;

import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int count = 0;
        Map<Integer,List<Integer>> map = new HashMap<>();

        int[] inDegree = new int[numCourses];
        for(int[] pre : prerequisites){
            int start = pre[1];
            int end = pre[0];
            map.computeIfAbsent(start, x -> new ArrayList<>()).add(end);
            inDegree[end]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < inDegree.length; i++){
            if(inDegree[i] == 0){
                q.offer(i);
                count++;
            }
        }

        while(!q.isEmpty()){
            int cur = q.poll();
            List<Integer> edges = map.get(cur);
            if(edges != null && edges.size() > 0){
                for(int edge : edges){
                    inDegree[edge]--;
                    if(inDegree[edge] == 0){
                        count++;
                        q.offer(edge);
                    }
                }
            }
        }
        return count == numCourses;
    }
}
