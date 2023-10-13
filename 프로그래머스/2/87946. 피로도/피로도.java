import java.util.*;
class Solution {
    boolean[] visited;
    int maxCnt = 0, N;
    int[][] dun;
    
    public int solution(int k, int[][] dungeons) {
        N = dungeons.length;
        visited = new boolean[N];
        dun = new int[N][2];
        for (int i = 0; i < N; i++) {
            for(int j = 0; j < 2; j++) {
                dun[i][j] = dungeons[i][j];
            }
        }
        dfs(k, 0);
        return maxCnt;
    }
    public void dfs(int power, int cnt) {
        maxCnt = Math.max(maxCnt, cnt);
        
        for (int i = 0; i < N; i++) {
            if (!visited[i] && dun[i][0] <= power) {
                visited[i] = true;
                dfs(power-dun[i][1], cnt+1);
                visited[i] = false;
            }
        }
    }
}