package BFS.leetcode505;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
    static int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public static int shortestDistance(int[][] maze, int[] start, int[] destination){
        int[][] distances = new int[maze.length][maze[0].length];
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        for(int[] row : distances){
            Arrays.fill(row,Integer.MAX_VALUE);
        }
        distances[start[0]][start[1]] = 0;
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> a[2] - b[2]);
        q.offer(new int[]{start[0],start[1],0});
        while(!q.isEmpty()){
            int[] cur = q.poll();
            if(visited[cur[0]][cur[1]]) continue;
            visited[cur[0]][cur[1]] = true;
            for(int[] dir : dirs){
                int x = cur[0];
                int y = cur[1];
                int count = 0;
                while(x + dir[0]>= 0 &&
                        x + dir[0] < maze.length &&
                        y + dir[1] >= 0 &&
                        y + dir[1] < maze[0].length &&
                        maze[x + dir[0]][y + dir[1]] == 0){
                    x += dir[0];
                    y += dir[1];
                    count++;
                }
                if(distances[cur[0]][cur[1]] + count < distances[x][y]){
                    distances[x][y] = distances[cur[0]][cur[1]] + count;
                    q.offer(new int[]{x,y,distances[x][y]});
                }
            }
        }
        return distances[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : distances[destination[0]][destination[1]];
    }

    public static void main(String[] args) {
        int[][] maze1 = new int[][]{{0,0,1,0,0},{0,0,0,0,0},{0,0,0,1,0},{1,1,0,1,1},{0,0,0,0,0}};
        int[] start1 = new int[]{0,4};
        int[] destination1 = new int[]{4,4};
        int[][] maze2 = new int[][]{
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0},
                {1, 1, 0, 1, 1},
                {0, 0, 0, 0, 0}
        };

        int[] start2 = new int[]{0,4};
        int[] destination2 = new int[]{0,0};

        System.out.println(shortestDistance(maze1,start1,destination1));
        System.out.println(shortestDistance(maze2,start2,destination2));
    }
}
