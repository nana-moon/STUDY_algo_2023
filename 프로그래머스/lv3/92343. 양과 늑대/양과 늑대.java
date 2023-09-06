import java.io.*;
import java.util.*;
class Solution {
    static int maxSheep, nEdges[][], nInfo[];
    
    public int solution(int[] info, int[][] edges) {
        maxSheep = 0;
        nEdges = edges;
        nInfo = info;
        boolean[] visited = new boolean[info.length];
        dfs(0,0,0,visited);
        return maxSheep;
    }
    
    public static void dfs(int idx, int sheep, int wolf, boolean[] visited) {
        visited[idx] = true;
        if(nInfo[idx] == 0) {
            sheep++;
            maxSheep = Math.max(maxSheep, sheep);
        } else {
            wolf++;
        }
        if (sheep <= wolf) {
            return;
        }
        for(int[] edge: nEdges) {
            if(visited[edge[0]] && !visited[edge[1]]) {
                boolean[] nVisited = visited.clone();
                dfs(edge[1], sheep, wolf, nVisited);
            }
        }
    }
}